import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Voici: *un texte de bienvenue*\n");
        Scanner sc = new Scanner(System.in);
        List<Command> commands = new ArrayList<Command>();
        commands.add(new Quit());
        commands.add(new Fibo());
        commands.add(new Freq());
        commands.add(new Predict());
        boolean test = true;
        while (test) {
            System.out.println("Enter a command: ");
            String output = sc.nextLine();
            Command cmd = commands.stream().filter(writtenCMD -> output.equals(writtenCMD.name())).findAny()
                    .orElse(null);
            if (Objects.isNull(cmd)) {
                System.out.println("Unknown command");
            } else {
                test = cmd.run(sc);
            }
        }
        sc.close();
    }
}