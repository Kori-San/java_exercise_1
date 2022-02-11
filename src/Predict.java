import java.util.*;
import java.nio.file.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Predict implements Command {
    public String name() {
        return "predict";
    }

    public boolean run(Scanner scanner) {
        System.out.print("Enter a path: ");
        try {
            String path = scanner.nextLine();
            Path posix = Paths.get(path);
            String texte = Files.readString(posix);
            texte = texte.replaceAll("[.!?,;'\n]", " ").toLowerCase();
            List<String> listMots = List.of(texte.split(" "));
            System.out.print("Enter a word: ");
            String mot = scanner.nextLine().toLowerCase();
            if (!listMots.contains(mot)) {
                System.out.println("The word doesn't exist");
                return true;
            }
            StringJoiner predicat = new StringJoiner(" ");
            predicat.add(mot);
            for (int j = 0; j < 19; j++) {
                List<String> listMotsDroite = new ArrayList<String>();
                for (int i = 0; i < listMots.size() - 1; i++)
                    if (listMots.get(i).equals(mot))
                        listMotsDroite.add(listMots.get(i + 1));
                Map<String, Long> mapFreq = listMotsDroite.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                Map<String, Long> mapFreqRevSort = mapFreq.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (Oe, Ne) -> Oe, LinkedHashMap::new));
                String motPredit = new ArrayList<>(mapFreqRevSort.keySet()).get(0);
                predicat.add(motPredit);
                mot = motPredit;
            }
            System.out.println(predicat);
        } catch (Exception err) {
            System.out.println("Unreadable file: " + err);
        }
        return true;
    }
}
