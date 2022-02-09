import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("un texte de bienvenue");
        Scanner sc = new Scanner(System.in);
        String output = sc.nextLine();
        if (!output.equals("quit")) {
            System.out.println("Unknown command");
        }
        sc.close();
    }
}