package search;
import java.util.Map;
import java.util.Set;

public interface QueryStrategy {

    Set<Integer> search(String query, Map<String, Set<Integer>> indexMap, int linesSize);

    default String[] queryToArray(String query) {
        return query.trim().toLowerCase().split(" ");
    }
}
