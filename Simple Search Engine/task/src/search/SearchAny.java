package search;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchAny implements QueryStrategy {

    @Override
    public Set<Integer> search(String query, Map<String, Set<Integer>> indexMap, int linesSize) {

        String[] searchArray = queryToArray(query);

        Set<Integer> indexes = new HashSet<>();

        for (String word : searchArray) {

            if (indexMap.containsKey(word.toLowerCase())) {
                indexes.addAll(indexMap.get(word.toLowerCase()));
            }
        }

        return indexes;
    }
}
