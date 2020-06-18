package search;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchNone implements QueryStrategy {

    @Override
    public Set<Integer> search(String query, Map<String, Set<Integer>> indexMap, int linesSize) {

        String[] searchArray = queryToArray(query);

        Set<Integer> indexes = new HashSet<>();

        for (int i = 0; i < linesSize; i++) {
                indexes.add(i);
        }

        for (String word : searchArray) {

            if (indexMap.containsKey(word.toLowerCase())) {
                indexes.removeAll(indexMap.get(word.toLowerCase()));
            }
        }

        return indexes.size() == 0 ? null : indexes;
    }
}
