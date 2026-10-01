import java.util.Scanner;

public class TextEditorCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder textBuffer = new StringBuilder();
        String clipboard = "";

        while (true) {
            System.out.println("\n=== TERMINAL TEXT BUFFER EDITOR ===");
            System.out.println("[Current Document Content]");
            System.out.println(textBuffer.length() == 0 ? "(Empty buffer)" : textBuffer.toString());
            System.out.println("FILE MENU : 1. New / Clear Buffer  | 2. Exit Application");
            System.out.println("EDIT MENU : 3. Append Text         | 4. Copy All to Clipboard | 5. Paste Clipboard");
            System.out.print("Action choice: ");
            int act = sc.nextInt();
            sc.nextLine();

            switch (act) {
                case 1:
                    textBuffer.setLength(0);
                    System.out.println("Buffer cleared.");
                    break;

                case 2:
                    System.out.println("Exiting text editor.");
                    sc.close();
                    return;

                case 3:
                    System.out.print("Enter text to append: ");
                    String line = sc.nextLine();
                    if (textBuffer.length() > 0) textBuffer.append("\n");
                    textBuffer.append(line);
                    break;

                case 4:
                    clipboard = textBuffer.toString();
                    System.out.println("All text copied to clipboard.");
                    break;

                case 5:
                    if (!clipboard.isEmpty()) {
                        if (textBuffer.length() > 0) textBuffer.append("\n");
                        textBuffer.append(clipboard);
                        System.out.println("Pasted content from clipboard.");
                    } else {
                        System.out.println("Clipboard is empty.");
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}