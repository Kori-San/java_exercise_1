import java.util.Scanner;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo"; // Return name for check
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrer index: ");
        int index = Integer.parseInt(scanner.nextLine());
        int nP = 0; // Fb(0)
        int nD = 1; // Fb(1)
        int tmp = 0; // Temp var
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
        return true;
    }
}
