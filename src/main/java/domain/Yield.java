package domain;

import utils.Constants;

public class Yield {
    private int facility_id;
    private int expected_yield;

    public Yield(int facility_id, int expected_yield) {
        this.facility_id = facility_id;
        this.expected_yield = expected_yield;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public int getExpected_yield() {
        return expected_yield;
    }

    public void setExpected_yield(int expected_yield) {
        this.expected_yield = expected_yield;
    }

    @Override
    public String toString() {
        return "Yield{" +
                "facility_id=" + facility_id +
                ", expected_yield=" + expected_yield +
                '}';
    }

    public String asDelimetedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(facility_id);
        sb.append(Constants.DELIMETER);
        sb.append(expected_yield);
        return sb.toString();
    }
}
