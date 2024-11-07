package Bank;

public class User {
    private String username;
    private String password;
    private BankAccount account;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.account = new BankAccount(BankAccount.generateAccountNumber());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updatePassword(String password) {
        this.password = password;
    }


    public void displayAccountDetails(){
        System.out.println("Welcome, " + username);
        System.out.println("Your account number is " + account.getAccountNumber());
        System.out.println("Your account balance is " + account.getBalance());
        System.out.println("Here is your most recent transactions:");
        account.displayTransactionHistory();
    }
}
