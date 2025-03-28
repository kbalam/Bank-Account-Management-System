import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class BankService {

    private Map<Long, BankAccount> accounts = new HashMap<>();
    private List<String> transactions = new ArrayList<>();
    private static final AtomicLong accountIDGenerator = new AtomicLong(1000);

    public Result createAccount(String name, String accountType, double initialBalance){
        long accountID = accountIDGenerator.incrementAndGet();
        BankAccount bankAccount;
        if(accountType.equalsIgnoreCase("Savings")){
            bankAccount =  new SavingsAccount(name, accountID, initialBalance);
        } else if (accountType.equalsIgnoreCase("Current")) {
            bankAccount = new CurrentAccount(name, accountID, initialBalance);
        } else {
            return new Result(false, "Invalid choice!");
        }
        accounts.put(accountID, bankAccount);
        return new Result(true, "Account Created Successfully! Your Account number is: "+ accountID);
    }

    public Result deposit(long accountID, double amount){
        BankAccount bankAccount = accounts.get(accountID);
        if(bankAccount != null){
            transactions.add("Deposited Rs. "+ amount);
            return bankAccount.deposit(amount);
        } else {
            return new Result(false, "No account found for the "+ accountID);
        }
    }

    public Result withdraw(long accountID, double amount){
        BankAccount bankAccount = accounts.get(accountID);
        if (bankAccount != null){
            transactions.add("Withdraw Rs. "+ amount);
            return bankAccount.withdraw(amount);
        } else {
            return new Result(false, "No account found for the "+ accountID);
        }
    }

    public double getBalance(long accountID){
        BankAccount bankAccount = accounts.get(accountID);
        return (bankAccount!= null)? bankAccount.getBalance(): -1;
    }

    public List<String> getTransaction(long accountID){
        BankAccount bankAccount = accounts.get(accountID);
        if(bankAccount != null){
            return bankAccount.getTransactions();
        } else {
            return Collections.emptyList();
        }
    }

    public boolean closeAccount(long accountID){
        return accounts.remove(accountID) != null;
    }

}
