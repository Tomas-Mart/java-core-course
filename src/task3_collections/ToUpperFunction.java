package task3_collections;

import java.util.function.Function;

public final class ToUpperFunction implements Function<String, String> {

    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}