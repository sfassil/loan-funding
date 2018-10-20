package loanops;

import domain.*;

import java.util.*;
import java.util.stream.Stream;

public class FundingManager {
    private Map<Integer, Bank> bankMap;
    private Map<Integer, Facility> facilityMap;
    private Map<Integer, Covenant> covenantMap;
    private List<Assignment> assignmentList;
    private List<Yield> yieldList;

    public FundingManager(Map<Integer, Bank> bankMap, Map<Integer, Facility> facilityMap, Map<Integer, Covenant> covenantMap) {
        this.bankMap = bankMap;
        this.facilityMap = facilityMap;
        this.covenantMap = covenantMap;
        this.postContruction();
    }

    private void postContruction() {
        facilityMap.values().forEach(this::postContruction);
        covenantMap.values().forEach(this::postContruction);
    }

    private void postContruction(Facility facility) {
        bankMap.get(facility.getBank_id()).getFacilities().add(facility);
    }

    private void postContruction(Covenant covenant) {
        covenant.setBank(getBankMap().get(covenant.getBank_id()));
        if (covenant.getFacility_id() == -1) {
            covenant.setFacilities(covenant.getBank().getFacilities());
        } else
            covenant.setFacilities(Collections.singletonList(facilityMap.get(covenant.getFacility_id())));
    }

    public Map<Integer, Bank> getBankMap() {
        return bankMap;
    }

    public void setBankMap(Map<Integer, Bank> bankMap) {
        this.bankMap = bankMap;
    }

    public Map<Integer, Facility> getFacilityMap() {
        return facilityMap;
    }

    public void setFacilityMap(Map<Integer, Facility> facilityMap) {
        this.facilityMap = facilityMap;
    }

    public Map<Integer, Covenant> getCovenantMap() {
        return covenantMap;
    }

    public void setCovenantMap(Map<Integer, Covenant> covenantMap) {
        this.covenantMap = covenantMap;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public List<Yield> getYieldList() {
        return yieldList;
    }

    public void setYieldList(List<Yield> yieldList) {
        this.yieldList = yieldList;
    }

    @Override
    public String toString() {
        return "FundingManager{" +
                "bankMap=" + bankMap +
                ", facilityMap=" + facilityMap +
                ", covenantMap=" + covenantMap +
                ", assignmentList=" + assignmentList +
                ", yieldList=" + yieldList +
                '}';
    }

    public void fundLoan(Loan loan) {
        Stream<Covenant> possibleCovenants = getCovenantMap().values().stream().filter(cov -> cov.getBanned_state() != loan.getState());

        List<Facility> allFacilities = new ArrayList<>();

        possibleCovenants.map(cov -> allFacilities.addAll(cov.getFacilities()));
        Stream possibleFacilities = allFacilities.stream().filter(facility -> facility.canFund(loan.getAmount()));
        Comparator<Facility> comparator = Comparator.comparing(Facility::getInterest_rate);
        Optional<Facility> optionalFacility = possibleFacilities.min(comparator);
        optionalFacility.ifPresent(facility -> fundLoan(loan, facility));
    }

    private void fundLoan(Loan loan, Facility facility) {
        facility.setAmount(facility.getAmount() - loan.getAmount());
        Covenant covenant = facility.getCovenant();
        float expYield = (1 - covenant.getDefault_likelihood()) * facility.getInterest_rate() * loan.getAmount() -
                covenant.getDefault_likelihood() * loan.getAmount()
                - facility.getInterest_rate() * loan.getAmount();
        getYieldList().add(new Yield(facility.getFacility_id(), Math.round(expYield)));
    }
}
