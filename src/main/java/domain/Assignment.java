package domain;

import utils.Constants;

public class Assignment {
    private int loan_id;
    private int facility_id;

    public Assignment(int id, int facility_id) {
        this.loan_id = id;
        this.facility_id = facility_id;
    }

    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int id) {
        this.loan_id = id;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + loan_id +
                ", facility_id=" + facility_id +
                '}';
    }

    public String asDelimetedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(loan_id);
        sb.append(Constants.DELIMETER);
        sb.append(facility_id != 0 ? facility_id:"");
        return sb.toString();
    }
}
