package task2_stringbuilder;

public class Main {
    public static void main(String[] args) {

        // Создаёт объект с текстом "Hello"
        MyStringBuilder sb = new MyStringBuilder("Hello")
                // Добавляет " World" в конец → "Hello World"
                .append(" World")
                // Удаляет символы с 0 по 5 с начала "Hello" → "World"
                .delete(0, 5)
                // Отменяет delete → "Hello World"
                .undo();

        System.out.println("Результат: " + sb);
    }
}