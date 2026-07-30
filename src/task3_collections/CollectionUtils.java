package task3_collections;

import java.util.HashMap;
import java.util.Map;

public final class CollectionUtils {

    public static String[] arrayMapping(String[] array, ToUpperFunction function) {
        if (array == null) return null;

        String[] result = new String[array.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = function.apply(array[i]);
        }

        return result;
    }

    public static Map<String, Integer> countElements(String[] array) {
        if (array == null) return new HashMap<>();

        Map<String, Integer> countMap = new HashMap<>();

        for (String element : array) {
            countMap.merge(element, 1, Integer::sum);
        }

        return countMap;
    }
}