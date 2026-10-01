import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CourseEnrollment {
    String studentName;
    String courseName;
    String status;

    public CourseEnrollment(String studentName, String courseName, String status) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.status = status;
    }
}

public class CourseManagementCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CourseEnrollment> records = new ArrayList<>();

        String[] availableCourses = {
            "CS101 - Java Programming",
            "CS102 - Data Structures",
            "CS103 - Database Systems",
            "CS104 - Operating Systems",
            "CS105 - Computer Networks"
        };

        while (true) {
            System.out.println("\n--- COURSE ENROLLMENT SYSTEM ---");
            System.out.println("1. Add Course Registration");
            System.out.println("2. Display Registrations (Table View)");
            System.out.println("3. Remove Course Registration");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine().trim();

                    System.out.println("Available Courses:");
                    for (int i = 0; i < availableCourses.length; i++) {
                        System.out.printf("%d. %s\n", (i + 1), availableCourses[i]);
                    }
                    System.out.print("Select course number (1-5): ");
                    int courseIdx = sc.nextInt() - 1;
                    sc.nextLine();

                    if (courseIdx >= 0 && courseIdx < availableCourses.length) {
                        records.add(new CourseEnrollment(name, availableCourses[courseIdx], "Enrolled"));
                        System.out.println("Registration successfully recorded.");
                    } else {
                        System.out.println("Invalid course selection.");
                    }
                    break;

                case 2:
                    System.out.printf("%-5s | %-20s | %-30s | %-10s\n", "Index", "Student Name", "Course", "Status");
                    if (records.isEmpty()) {
                        System.out.println("No student course registrations found.");
                    } else {
                        for (int i = 0; i < records.size(); i++) {
                            CourseEnrollment e = records.get(i);
                            System.out.printf("%-5d | %-20s | %-30s | %-10s\n", (i + 1), e.studentName, e.courseName, e.status);
                        }
                    }
                    System.out.println("\n");
                    break;

                case 3:
                    if (records.isEmpty()) {
                        System.out.println("No records to remove.");
                        break;
                    }
                    System.out.print("Enter Record Index to remove: ");
                    int removeIdx = sc.nextInt() - 1;
                    if (removeIdx >= 0 && removeIdx < records.size()) {
                        CourseEnrollment removed = records.remove(removeIdx);
                        System.out.println("Removed enrollment for: " + removed.studentName);
                    } else {
                        System.out.println("Invalid record index.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}