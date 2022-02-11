import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Freq implements Command {
    public String name() {
        return "freq";
    }

    public boolean run(Scanner scanner) {
        System.out.println("Enter a path:");
        String path = scanner.nextLine();
        Path posix = Paths.get(path);
        try {
            String phrase = Files.readString(posix);
            phrase = phrase.replaceAll("[.!?,;'\n]", " ").toLowerCase();
            Set<String> motsUniq = new HashSet<String>();
            Map<String, Integer> motCount = new HashMap<String, Integer>();
            for (String ch : motsUniq) {
                if (ch.isBlank() == false && motsUniq.contains(ch) == false)
                    motsUniq.add(ch);
            }
            for (String s : motsUniq) {
                if (s.isBlank() == false)
                    motCount.put(s, Collections.frequency(motsUniq, s));
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
        return true;
    }
}
