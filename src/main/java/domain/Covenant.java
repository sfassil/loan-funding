package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Float.MAX_VALUE;

public class Covenant {
    private int bank_id;
    private int facility_id = -1; //Default value set to -1 to indicate covenant applies to all bank's facilities
    private Bank bank;
    private List<Facility> facilities = new ArrayList<>();
    private float default_likelihood = MAX_VALUE; //Default value set to MAX_Value of Float meaning there is no max as default
    private String banned_state;

    public Covenant(int bank_id) {
        this.bank_id = bank_id;
    }

    public Covenant(int bank_id, int facility_id, float max_default_likelihood, String banned_state) {
        this.bank_id = bank_id;
        this.facility_id = facility_id;
        this.default_likelihood = max_default_likelihood;
        this.banned_state = banned_state;
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

    public float getDefault_likelihood() {
        return default_likelihood;
    }

    public void setDefault_likelihood(float default_likelihood) {
        this.default_likelihood = default_likelihood;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
        for (Facility facility : facilities) {
            facility.setCovenant(this);
        }
    }

    public String getBanned_state() {
        return banned_state;
    }

    public void setBanned_state(String banned_state) {
        this.banned_state = banned_state;
    }

    @Override
    public String toString() {
        return "Covenant{" +
                "bank_id=" + bank_id +
                ", facility_id=" + facility_id +
                ", max_default_likelihood=" + default_likelihood +
                ", banned_state='" + banned_state + '\'' +
                '}';
    }
}
