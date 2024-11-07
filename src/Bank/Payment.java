package Bank;

import java.util.Date;

// Employee payment
public class Payment {
    private Date date;
    private String method;
    private double amount;

    public Payment(Date date, String type, double amount) {
        this.date = date;
        this.method = type;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method.toLowerCase();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "date=" + date +
                ", method='" + method + '\'' +
                ", amount=" + amount +
                '}';
    }
}
