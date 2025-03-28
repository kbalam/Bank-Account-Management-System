public class DisplayService {

    public static void showSuccess(String message) {
        System.out.printf("[SUCCESS]: %s%n", message);
    }

    public static void showError(String message) {
        System.out.printf("[ERROR]: %s%n", message);
    }
}
