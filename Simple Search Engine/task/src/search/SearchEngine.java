package search;
import java.util.*;

public class SearchEngine {
    private QueryStrategy queryStrategy;
    private List<String> people;
    private Map<String, Set<Integer>> indexMap;

    public SearchEngine(List<String> people) {
        this.people = people;
        indexMap = new HashMap<>();
        createIndexMap();
    }

    private void createIndexMap() {

        indexMap.clear();

        for (int i = 0; i < people.size(); i++) {

            for (String word : people.get(i).split(" ")) {

                word = word.toLowerCase();

                if (indexMap.containsKey(word)) {
                    indexMap.get(word).add(i);

                } else {
                    indexMap.put(word, new HashSet<>(Set.of(i)));
                }
            }
        }
    }

    public String search(String query) {

        StringBuilder output = new StringBuilder();
        var indexes = queryStrategy.search(query, indexMap, people.size());

        if (indexes == null) {
            output.append("No matching keywords found");

        } else {

            for (int i : indexes) {
                output.append(people.get(i)).append("\n");
            }
        }

        return output.toString();
    }

    public void setQueryStrategy(QueryStrategy strategy) {
        this.queryStrategy = strategy;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("\n=== " +
                "List of people ===\n");

        for (String line : people) {
            stringBuilder.append(line).append("\n");
        }

        return stringBuilder.toString();
    }
}
