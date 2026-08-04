# Java Core Course

## Описание

Репозиторий для выполнения домашних заданий по курсу Java Core.

## Прогресс

- [x] task1-git - Настройка Git репозитория
- [x] task2-stringbuilder - StringBuilder с паттерном Snapshot
- [x] task3-collections - Утилиты для работы с коллекциями
- [x] task4-blocking-queue - Блокирующая очередь с wait/notify
- [x] task5-bank-account - Многопоточный банковский счёт
- [x] task6-completable-future - Асинхронная агрегация с CompletableFuture
- [x] task7-streams-generate - Stream API: генерация чисел (топ-3 продукта)
- [ ] task8-streams-aggregate - Stream API: агрегация и объединение (средние оценки)
- [ ] task9-maven - Maven проект

## Структура проекта

```text
src/
├── task1_git/
│   ├── Main.java
│   └── README.md
├── task2_stringbuilder/
│   ├── Main.java
│   ├── MyStringBuilder.java
│   ├── Snapshot.java
│   └── README.md
├── task3_collections/
│   ├── CollectionUtils.java
│   ├── Main.java
│   ├── ToUpperFunction.java
│   └── README.md
├── task4_concurrency/
│   ├── blocking_queue/
│   │   ├── BlockingQueue.java
│   │   ├── BlockingQueueExample.java
│   │   └── README.md
│   ├── bank/
│   │   ├── BankAccount.java
│   │   ├── ConcurrentBank.java
│   │   ├── ConcurrentBankExample.java
│   │   └── README.md
│   └── completable_future/
│       ├── CompletableFutureExample.java
│       ├── DataAggregator.java
│       ├── ProductInfo.java
│       └── README.md
├── task5_streams/
│   ├── orders/
│   │   ├── Order.java
│   │   ├── OrderProcessor.java
│   │   ├── StreamCollectorsExample.java
│   │   └── README.md
│   └── students/
│       ├── ParallelStreamCollectMapAdvancedExample.java
│       ├── Student.java
│       ├── StudentProcessor.java
│       └── README.md
└── README.md
```

## Технологии

- Java 17+
- Git
- GitHub