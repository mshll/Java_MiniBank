package Bank;

import java.util.Date;

public class Transaction {
    private Date date;
    private String type;
    private double amount;

    public Transaction(Date date, String type, double amount) {
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (!type.equalsIgnoreCase("deposit") && !type.equalsIgnoreCase("withdrawal")) {
            System.err.println("Invalid transaction type");
            return;
        }
        this.type = type.toLowerCase();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
