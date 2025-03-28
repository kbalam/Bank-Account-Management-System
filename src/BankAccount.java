import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {


    private String userName;
    private double accountNum;
    private double balance;
    protected List<String> transactions;

    public BankAccount(String userName, long accountNum, double balance){
        this.userName = userName;
        this.accountNum = accountNum;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    protected void addTransaction(String transaction){
        transactions.add(transaction);
    }

    public List<String> getTransactions(){
        return transactions;
    }

    public String getUserName() {
        return userName;
    }

    public double getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract Result withdraw(double amount);

    public abstract Result deposit(double amount);

}
