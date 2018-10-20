package domain;

//import sun.jvm.hotspot.utilities.Assert;

public class Loan {
    private int id;
    private int amount;
    private float interest_rate;
    private float default_likelihood;
    private String state;

    public Loan(int id, int amount, float interest_rate, float default_likelihood, String state) {
        this.id = id;
        this.amount = amount;
        this.interest_rate = interest_rate;
        this.default_likelihood = default_likelihood;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(float interest_rate) {
//        Assert.that(interest_rate >=0 && interest_rate <= 1, "Invalid Interest rRate Attempted");
        this.interest_rate = interest_rate;
    }

    public float getDefault_likelihood() {
        return default_likelihood;
    }

    public void setDefault_likelihood(float default_likelihood) {
        this.default_likelihood = default_likelihood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", interest_rate=" + interest_rate +
                ", default_likelihood=" + default_likelihood +
                ", state='" + state + '\'' +
                '}';
    }
}
