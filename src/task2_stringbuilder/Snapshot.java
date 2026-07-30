package task2_stringbuilder;

final class Snapshot {
    private final String text;

    Snapshot(String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Snapshot{text='" + text + "'}";
    }
}