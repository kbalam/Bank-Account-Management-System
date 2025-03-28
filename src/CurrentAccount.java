public class CurrentAccount extends BankAccount{

    private final double MAX_OVERDRAFT= 100000;
    double currentDraft = MAX_OVERDRAFT;

    public CurrentAccount(String userName, long accountNum, double balance) {
        super(userName, accountNum, balance);
    }

    @Override
    public Result withdraw(double amount) {
        if(amount <= 0){
            return new Result(false, "Invalid amount");
        }

        double totalBalance = getBalance() + currentDraft;

        if (amount > totalBalance){
            return new Result(false, "You are exceeding your overdraft and account balance limit, " +
                    "Try lesser amount");
        }

        if(amount<= getBalance()){
            setBalance(getBalance() - amount);
            addTransaction("Withdraw Rs. " + amount);
        } else {
            double remainingAmount = amount - getBalance();
            setBalance(0);
            currentDraft -= remainingAmount;
        }
        return new Result(true, "Withdraw Successful!");
    }

    @Override
    public Result deposit(double amount) {
        if(amount < 0){
            return new Result(false, "Invalid Amount!");
        }

        double overdraftDeficit = MAX_OVERDRAFT - currentDraft;

        if(amount <= overdraftDeficit){
            currentDraft += amount;
        } else {
            currentDraft = MAX_OVERDRAFT;
            double remainingAmount = overdraftDeficit - amount;
            setBalance(getBalance() + amount);
        }
        addTransaction("Deposited Rs. " + amount);
        return new Result(true, "Amount deposited successfully!");

    }
}
