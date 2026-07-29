package task2_stringbuilder;

import java.util.Stack;

/**
 * StringBuilder с undo() и паттерном Snapshot
 */
public class MyStringBuilder {

    private String text;
    private Stack<Snapshot> history;

    /**
     * Конструктор с начальной строкой
     */
    public MyStringBuilder(String sb) {
        this.text = (sb == null) ? "" : sb;
        this.history = new Stack<>();
        saveState();
    }

    /**
     * Добавляет строку в конец
     */
    public MyStringBuilder append(String sb) {
        text += (sb == null) ? "null" : sb;
        saveState();
        return this;
    }

    /**
     * Удаляет подстроку от start до end
     */
    public MyStringBuilder delete(int start, int end) {
        if (start < 0 || end > text.length() || start > end)
            throw new StringIndexOutOfBoundsException();

        text = text.substring(0, start) + text.substring(end);
        saveState();
        return this;
    }

    /**
     * Отменяет последнюю операцию
     */
    public MyStringBuilder undo() {
        if (history.size() > 1)  history.pop();

        text = history.peek().getText();
        return this;
    }

    /**
     * Сохраняет текущее состояние в историю
     */
    private void saveState() {
        history.push(new Snapshot(text));
    }

    /**
     * Возвращает текущую строку
     */
    @Override
    public String toString() {
        return text;
    }
}