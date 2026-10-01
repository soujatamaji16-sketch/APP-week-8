import java.util.Scanner;

public class StudentRegistrationCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("       STUDENT REGISTRATION SYSTEM      ");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Register Number: ");
        String regNo = sc.nextLine().trim();

        System.out.println("\nSelect Gender:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        System.out.print("Choice (1-3): ");
        int genderChoice = sc.nextInt();
        String gender = switch (genderChoice) {
            case 1 -> "Male";
            case 2 -> "Female";
            default -> "Other";
        };

        System.out.println("\nSelect Department:");
        System.out.println("1. Computer Science");
        System.out.println("2. Information Technology");
        System.out.println("3. Electrical Engineering");
        System.out.println("4. Mechanical Engineering");
        System.out.println("5. Civil Engineering");
        System.out.print("Choice (1-5): ");
        int deptChoice = sc.nextInt();
        String dept = switch (deptChoice) {
            case 1 -> "Computer Science";
            case 2 -> "Information Technology";
            case 3 -> "Electrical Engineering";
            case 4 -> "Mechanical Engineering";
            default -> "Civil Engineering";
        };

        System.out.println("\n--- REGISTRATION CONFIRMATION ---");
        System.out.println("Status        : SUCCESS");
        System.out.println("Student Name  : " + name);
        System.out.println("Register No   : " + regNo);
        System.out.println("Gender        : " + gender);
        System.out.println("Department    : " + dept);
        System.out.println("---------------------------------");

        sc.close();
    }
}