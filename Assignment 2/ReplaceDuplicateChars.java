import java.util.Scanner;

public class ReplaceDuplicateChars {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String str = input.nextLine();

            // create a StringBuilder object to manipulate the string
            StringBuilder sb = new StringBuilder(str);

            // loop through the string and replace duplicate characters with 'X'
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                for (int j = i + 1; j < sb.length(); j++) {
                    if (c == sb.charAt(j)) {
                        sb.setCharAt(j, 'X');
                    }
                }
            }

            // print the modified string
            System.out.println("Modified string: " + sb.toString());
        }
    }
}
