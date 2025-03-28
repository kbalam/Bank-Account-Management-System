import java.util.List;

public class Main {

    static void printOption() {
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Online Banking System! Banking made Easy!!");
        BankService service = new BankService();
        boolean running = true;

        while(running){
            printOption();
            int option = InputUtils.readInt("Enter your option: ");
            switch (option){
                case 1:

                    String name = InputUtils.readString("Enter Account Holder name: ");
                    String accountType = InputUtils.readString("Enter your account type:[Savings or Current]: ");
                    double balance = InputUtils.readDouble("Enter the initial deposit amount: ");
                    Result result = service.createAccount(name, accountType, balance);
                    System.out.println(result.getMessage());
                    break;

                case 2:
                    long depositAccountNo = InputUtils.readLong("Enter your account number: ");
                    double depositAmount = InputUtils.readDouble("Enter Deposit amount: ");
                    Result depositResult = service.deposit(depositAccountNo, depositAmount);
                    System.out.println(depositResult.getMessage());
                    break;

                case 3:
                    long withdrawAccountNo = InputUtils.readLong("Enter your account number: ");
                    double withdrawAmount = InputUtils.readDouble("Enter Withdraw amount: ");
                    Result withdrawResult = service.withdraw(withdrawAccountNo, withdrawAmount);
                    System.out.println(withdrawResult.getMessage());
                    break;

                case 4:
                    long accountNo = InputUtils.readLong("Enter your account number: ");
                    double bankBalance = service.getBalance(accountNo);
                    if (bankBalance != -1) {
                        System.out.printf("Current balance: Rs. %.2f%n", bankBalance);
                    } else {
                        System.out.println("No account found!");
                    }
                    break;

                case 5:
                    long transactionAccID = InputUtils.readLong("Enter your account number: ");
                    List<String> transactions = service.getTransaction(transactionAccID);
                    if(!transactions.isEmpty()){
                        for(String transaction: transactions){
                            System.out.println(transaction);
                        }
                    } else {
                        System.out.println("No Transaction found for this account ID: " + transactionAccID);
                    }
                    break;

                case 6:
                    boolean choice = InputUtils.readYorN("Are you confirm to Exit:");
                    if(choice){
                        System.out.println("Thank you for using our Online Bank!!");
                        System.out.println("Successfully Logged out.");
                        running = false;
                    } else {
                        System.out.println("Returning to your account...");
                    }
                    break;

                default:
                    System.out.println("Invalid choice choose option between 1 to 6.");
                    break;
            }
        }
        InputUtils.closeScanner();
    }
}