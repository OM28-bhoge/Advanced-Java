import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            VowelCounter vc = (VowelCounter) registry.lookup("VowelCounter");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String str = scanner.nextLine();

            int count = vc.countVowels(str);
            System.out.println("Vowel count: " + count);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
