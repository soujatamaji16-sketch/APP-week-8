import java.util.Scanner;

public class UserLoginCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("       USER LOGIN & PREFERENCES         ");

        System.out.print("Username: ");
        String username = sc.nextLine().trim();

        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        System.out.print("Remember Me? (1 for Yes, 0 for No): ");
        boolean rememberMe = sc.nextInt() == 1;

        System.out.print("Receive Notifications? (1 for Yes, 0 for No): ");
        boolean receiveNotifications = sc.nextInt() == 1;

        System.out.println("\n----------------------------------------");
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("[Error] Username or Password cannot be blank!");
        } else {
            System.out.println("[Login Successful]");
            System.out.println("Welcome, " + username + "!");
            System.out.println("Preference - Remember Me            : " + (rememberMe ? "Enabled" : "Disabled"));
            System.out.println("Preference - Receive Notifications  : " + (receiveNotifications ? "Enabled" : "Disabled"));
        }
        System.out.println("----------------------------------------");

        sc.close();
    }
}