package task2_stringbuilder;

import java.util.Stack;

public final class MyStringBuilder {
    private String text;
    private final Stack<Snapshot> history;

    public MyStringBuilder(String text) {
        this.text = text == null ? "" : text;
        this.history = new Stack<>();
        saveState();
    }

    public MyStringBuilder append(String text) {
        this.text += text == null ? "null" : text;
        saveState();
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        validateIndexes(start, end);
        this.text = this.text.substring(0, start) + this.text.substring(end);
        saveState();
        return this;
    }

    public MyStringBuilder undo() {
        if (history.size() > 1) {
            history.pop();
            text = history.peek().getText();
        }
        return this;
    }

    @Override
    public String toString() {
        return text;
    }

    private void validateIndexes(int start, int end) {
        if (start < 0 || end > text.length() || start > end) {
            throw new StringIndexOutOfBoundsException(
                    String.format("start=%d, end=%d, length=%d", start, end, text.length())
            );
        }
    }

    private void saveState() {
        history.push(new Snapshot(text));
    }

    private static final class Snapshot {
        private final String text;

        Snapshot(String text) {
            this.text = text;
        }

        String getText() {
            return text;
        }
    }
}