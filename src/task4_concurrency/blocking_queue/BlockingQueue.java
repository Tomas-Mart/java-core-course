package task4_concurrency.blocking_queue;

import java.util.LinkedList;
import java.util.Queue;

public final class BlockingQueue<T> {
    private final Queue<T> queue;
    private final int capacity;
    private final Object lock;

    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.queue = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new Object();
    }

    public void enqueue(T element) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == capacity) {
                lock.wait();
            }
            queue.add(element);
            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (lock) {
            while (queue.isEmpty()) {
                lock.wait();
            }
            T element = queue.poll();
            lock.notifyAll();
            return element;
        }
    }

    public int size() {
        synchronized (lock) {
            return queue.size();
        }
    }
}