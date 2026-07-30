package task3_collections;

import java.util.Map;

public final class Main {
    public static void main(String[] args) {

        String[] words = {"hello", "world", "hello", "java", "world", "world"};

        String[] mapped = CollectionUtils.arrayMapping(words, new ToUpperFunction());

        for (String s : mapped) {
            System.out.print(s + " ");
        }

        System.out.println();

        Map<String, Integer> counts = CollectionUtils.countElements(words);
        System.out.println(counts);
    }
}