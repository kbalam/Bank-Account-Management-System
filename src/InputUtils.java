import java.util.Scanner;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static double readDouble(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                double value =  Double.parseDouble(scanner.nextLine().trim());
                if(value <= 1){
                    System.out.println("Amount must be greater than or equal to 1");
                } else {
                    return value;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid Number, Please enter a valid Decimal number");
            }
        }
    }

    public static long readLong(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number,Please enter a valid number.");
            }
        }
    }
    
    public static int readInt(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number,Please enter a valid number.");
            }
        }
    }

    public static boolean readYorN(String prompt){
        while(true) {
            System.out.print(prompt + " [Y/N]-");
            String input = scanner.nextLine().toUpperCase().trim();
            if ("Y".equals(input)) return true;
            if ("N".equals(input)) return false;
            System.out.println("Please enter a valid input, Y or N - ");
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
