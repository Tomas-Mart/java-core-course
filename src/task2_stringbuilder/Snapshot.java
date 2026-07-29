package task2_stringbuilder;

/**
 * Снимок состояния (паттерн Memento)
 * Хранит копию строки для восстановления
 */
public class Snapshot {

    /**
     * Сохранённое состояние (строка)
     */
    private final String text;

    /**
     * Конструктор - создаёт снимок текущего состояния
     *
     * @param text строка для сохранения
     */
    public Snapshot(String text) {
        this.text = text;
    }

    /**
     * Геттер - возвращает сохранённую строку
     *
     * @return сохранённый текст
     */
    public String getText() {
        return text;
    }

    /**
     * Возвращает строковое представление объекта
     * Используется для отладки и логирования
     *
     * @return строка с информацией о снимке
     */
    @Override
    public String toString() {
        return "Snapshot{text='" + text + "'}";
    }
}