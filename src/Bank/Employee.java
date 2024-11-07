package Bank;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private static final double overtimeRate = 1.5;
    private static final int fulltimeHours = 40;

    private final String id;
    private String name;
    private double hourly;
    private final List<Double> bonuses;
    private final List<Double> deductions;
    private int overtimeHours;
    private final List<Payment> payments;
    private final boolean isAdmin;

    public Employee(String id, String name, double hourly, boolean admin) {
        this.id = id;
        this.name = name;
        this.hourly = hourly;
        this.isAdmin = admin;
        bonuses = new ArrayList<>();
        deductions = new ArrayList<>();
        payments = new ArrayList<>();
        overtimeHours = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name, Employee caller) {
        if (!caller.isAdmin() || caller != this) {
            System.out.println("You do not have access privileges");
            return;
        }
        this.name = name;
    }

    public double getHourly(Employee caller) {
        if (!caller.isAdmin() || caller != this) {
            System.out.println("You do not have access privileges");
            return -1;
        }
        return hourly;
    }

    public void setHourly(double hourly, Employee caller) {
        if (!caller.isAdmin() || caller != this) {
            System.out.println("You do not have access privileges");
            return;
        }
        this.hourly = hourly;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public List<Double> getBonuses() {
        return bonuses;
    }

    public void addBonus(double bonus) {
        this.bonuses.add(bonus);
    }

    public List<Double> getDeductions() {
        return deductions;
    }

    public void addDeduction(double deduction) {
        this.deductions.add(deduction);
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void incOvertimeHours(int hours) {
        overtimeHours += hours;
    }

    public double getSalary() {
        double salary = fulltimeHours * hourly;
        salary += hourly * (overtimeHours*overtimeRate);

        for (double bonus : bonuses) {
            salary += bonus;
        }
        for (double deduction : deductions) {
            salary -= deduction;
        }

        return salary;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void displayPaymentHistory() {
        System.out.println(payments);
    }

    public void displayEmployeeDetails(){
        System.out.println("=========================================");
        System.out.println("Hello, " + name + " (ID: " + id + ")");
        System.out.println("Your hourly rate is " + hourly);
        System.out.println("Your overtime hours are " + overtimeHours);
        System.out.println("You put in " + getOvertimeHours() + " overtime hours");
        System.out.println("Your bonuses are: " + getBonuses());
        System.out.println("Your deductions are: " + getDeductions());
        System.out.println("Currently, your salary is " + getSalary());
        System.out.println("You made the following payments: ");
        displayPaymentHistory();
        System.out.println("=========================================");
    }
}
