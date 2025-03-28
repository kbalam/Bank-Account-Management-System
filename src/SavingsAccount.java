public class SavingsAccount extends BankAccount{
    
    public double dailyLimit;

    public SavingsAccount(String userName, long accountNum, double balance) {
        super(userName, accountNum, balance);
        this.dailyLimit = 50000;
    }

    @Override
    public Result withdraw(double amount) {

        if(amount <= 0){
            return new Result(false, "Invalid Amount");
        }

        if(amount> dailyLimit){
            return new Result(false, "You are exceeding your daily withdraw limit of Rs. " + dailyLimit);
        }
        if(amount <= getBalance()){
            setBalance(getBalance() - amount);
            addTransaction("Withdraw Rs. " + amount);
            return new Result(true, "Withdraw Successful!");
        } else {
            return new Result(false, "Insufficient funds!");
        }
    }

    @Override
    public Result deposit(double amount) {
        if(amount < 0){
            return new Result(false, "Invalid Amount!");
        }

        if(amount > dailyLimit){
            return new Result(false, "You deposit amount exceeds the daily limit which is " + dailyLimit
                    + " try amount less than this limit.");
        }

        setBalance(getBalance() + amount);
        addTransaction("Deposited Rs. " + amount);
        return new Result(true, "Your amount of Rs. "+ amount + " Deposited successfully!");
    }
}
