import Bank.BankSingleton;
import Bank.Employee;
import Bank.Payment;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        BankSingleton bank = BankSingleton.getInstance();

        try {
            bank.createEmployee("000", "Meshal", 9999, true);
            bank.createEmployee("001", "Nora", 111, false);
            bank.createEmployee("002", "Yousef", 444, false);
            bank.createEmployee("003", "Janna", 777, false);
            bank.createEmployee("004", "Abdullah", 888, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Employee nora = bank.getEmployeeById("001");
        nora.addBonus(50);
        nora.addBonus(10);
        nora.addDeduction(9);
        nora.addPayment(new Payment(new Date(), "KNET", 99));
        nora.addPayment(new Payment(new Date(), "Visa", 44));
        nora.displayPaymentHistory();
        nora.incOvertimeHours(5);

        nora.displayEmployeeDetails();
    }
}