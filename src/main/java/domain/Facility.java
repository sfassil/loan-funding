package domain;

public class Facility {
    private int bank_id;
    private int facility_id;
    private float interest_rate;
    private int amount;

    private Covenant covenant;

    public Facility(int bank_id, int facility_id, float interest_rate, int amount) {
        this.bank_id = bank_id;
        this.facility_id = facility_id;
        this.interest_rate = interest_rate;
        this.amount = amount;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Covenant getCovenant() {
        return covenant;
    }

    public void setCovenant(Covenant covenant) {
        this.covenant = covenant;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "bank_id=" + bank_id +
                ", facility_id=" + facility_id +
                ", interest_rate=" + interest_rate +
                ", amount=" + amount +
                ", covenant=" + covenant +
                '}';
    }

    public boolean canFund(int amount) {
        return getAmount() >= amount;
    }
}
