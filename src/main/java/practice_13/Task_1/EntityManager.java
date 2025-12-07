package practice_13.Task_1;

import java.util.ArrayList;
import java.util.List;

public class EntityManager<T extends User> {

    private final List<T> items = new ArrayList<>();

    public synchronized void add(T item) {
        items.add(item);
    }

    public synchronized boolean remove(T item) {
        return items.remove(item);
    }

    public synchronized ArrayList<T> getAll() {
        return new ArrayList<>(items);
    }

    public synchronized List<T> filterByAge(int minAge, int maxAge) {
        return items.stream()
                .filter(item -> item.getAge() >= minAge && item.getAge() <= maxAge)
                .toList();
    }

    public synchronized List<T> filterByName(String initName) {
        return items.stream()
                .filter(item -> item.getName().equals(initName))
                .toList();
    }

    public synchronized List<T> filterByActive() {
        return items.stream()
                .filter(User::isActive)
                .toList();
    }
}
