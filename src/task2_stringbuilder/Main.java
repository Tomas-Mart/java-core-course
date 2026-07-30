package task2_stringbuilder;

public final class Main {
    public static void main(String[] args) {
        MyStringBuilder builder = new MyStringBuilder("Hello")
                .append(" World")
                .delete(0, 5)
                .undo();

        System.out.println(builder);
    }
}