import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Voici: *un texte de bienvenue*, comme demandé");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command: ");
            String output = sc.nextLine();
            if (output.equals("quit")) {
                break;
            } else if (output.equals("fibo")) {
                System.out.println("Enter index: ");
                int index = Integer.parseInt(sc.nextLine());
                int nP = 0;
                int nD = 1;
                int tmp = 0;
                if (index != 0) {
                    for (int n = 2; n <= index; n++) {
                        tmp = nD;
                        nD = nP + nD;
                        nP = tmp;
                    }
                    System.out.println("Fb(" + index + ") = " + nD);
                } else {
                    System.out.println("Fb(0) = 0");
                }
            } else {
                System.out.println("Unknown command");
            }
        }
        sc.close();
    }
}