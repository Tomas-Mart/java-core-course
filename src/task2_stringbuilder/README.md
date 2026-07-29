# Задание #2: Реализация StringBuilder с паттерном Snapshot

## 📝 Описание

Реализация кастомного `StringBuilder` с поддержкой паттерна **Snapshot (Memento)** и методом `undo()` для отмены операций.

---

## 🎯 Реализованные методы

| Метод | Описание                    |
|-------|-----------------------------|
| `MyStringBuilder(String sb)` | Конструктор с начальной строкой |
| `append(String sb)` | Добавляет строку в конец    |
| `delete(int start, int end)` | Удаляет подстроку от start до end |
| `undo()` | Отменяет последнюю операцию |
| `toString()` | Возвращает текущую строку   |

---

## 🏗️ Архитектура паттерна Snapshot

```text
MyStringBuilder (Originator)
├── String text                 // Текущее состояние
├── Stack<Snapshot> history     // История состояний (Caretaker)
│
├── Snapshot (Memento)          // Внутренний класс
│   └── String text             // Сохранённое состояние
│
├── saveState()                 // Сохраняет состояние
└── undo()                      // Восстанавливает состояние
```

---

## 🚀 Пример использования

```java
MyStringBuilder sb = new MyStringBuilder("Hello")
        .append(" World")   // "Hello World"
        .delete(0, 5)      // "World"
        .undo();           // "Hello World"

System.out.println(sb);    // Результат: Hello World
```

---

## 📁 Структура проекта

```text
src/task2_stringbuilder/
├── Snapshot.java          # Хранит состояние (Memento)
├── MyStringBuilder.java   # Основной класс (Originator)
└── Main.java             # Демонстрация работы
```

---

## 🔑 Как работает паттерн Snapshot

1. **saveState()** — создаёт снимок текущего состояния и сохраняет в историю
2. **undo()** — удаляет последний снимок и восстанавливает предыдущее состояние
3. **История** — хранится в `Stack<Snapshot>`, что позволяет отменять операции в обратном порядке

---

## 🧪 Запуск

```bash
javac src/task2_stringbuilder/*.java
java -cp src task2_stringbuilder.Main
```

### Ожидаемый вывод:

```text
Результат: Hello World
```

---

## ✅ Вывод

- Реализован паттерн **Snapshot (Memento)**
- Добавлен метод **undo()** для отмены операций
- Код минимален, но демонстрирует суть паттерна