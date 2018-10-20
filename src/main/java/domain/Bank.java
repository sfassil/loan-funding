package domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int bank_id;
    private String bank_name;
    private List<Facility> facilities = new ArrayList<>();

    public Bank(int bank_id, String bank_name) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bank_id=" + bank_id +
                ", bank_name='" + bank_name + '\'' +
                '}';
    }
}
