import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("un texte de bienvenue");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String output = sc.nextLine();
            if (output.equals("quit")) {
                break;
            }
            System.out.println("Unknown command");
        }
        sc.close();
    }
}