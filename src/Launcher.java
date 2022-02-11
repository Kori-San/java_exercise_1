import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Voici: *un texte de bienvenue*\n");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-> Enter command: ");
            String output = sc.nextLine();
            if (output.equals("quit")) { // @ Quit @
                break;
            } else if (output.equals("fibo")) { // @ Fibo @
                System.out.println("--> Entrer index: ");
                int index = Integer.parseInt(sc.nextLine());
                int nP = 0; // Fb(0)
                int nD = 1; // Fb(1)
                int tmp = 0; // Temp var
                if (index != 0) {
                    for (int n = 2; n <= index; n++) {
                        tmp = nD;
                        nD = nP + nD;
                        nP = tmp;
                    }
                    System.out.println("--> Fb(" + index + ") = " + nD);
                } else {
                    System.out.println("--> Fb(0) = 0");
                }
            } else if (output.equals("freq")) { // @ Freq @
                System.out.println("--> Entrer un chemin:");
                String path = sc.nextLine();
                Path posix = Paths.get(path);
                try {
                    String phrase = Files.readString(posix);
                    phrase = phrase.replaceAll("[.!?,;'\n]", " ").toLowerCase();
                    List<String> mots = new ArrayList<String>(Arrays.asList(phrase.split(" ")));
                    Set<String> motsUniq = new HashSet<String>();
                    Map<String, Integer> motCount = new HashMap<String, Integer>();
                    for (String ch : mots) {
                        if (ch.isBlank() == false && motsUniq.contains(ch) == false)
                            motsUniq.add(ch);
                    }
                    for (String s : motsUniq) {
                        if (s.isBlank() == false)
                            motCount.put(s, Collections.frequency(mots, s));
                    }
                    Map<String, Integer> top = motCount.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(3)
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                    for (String topo : top.keySet())
                        System.out.print(topo + " ");
                    System.out.println("");
                } catch (Exception err) {
                    System.out.println("Unreadable file: " + err);
                }
            } else {
                System.out.println("-> Unknown command");
            }
        }
        sc.close();
    }
}