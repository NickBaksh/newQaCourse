package practice_13_1.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityManager<T extends Entity> {
    private final List<T> entities = new CopyOnWriteArrayList<>();

    public void add(T entity) {
        entities.add(entity);
    }

    public boolean remove(T entity) {
        return entities.remove(entity);
    }

    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    public List<T> filterByAge(int minAge, int maxAge) {
       return entities.stream()
                .filter(entities -> entities.getAge() >= minAge && entities.getAge() <= maxAge)
                .toList();
    }

    public List<T> filterByName(String name) {
        return  entities.stream()
                .filter(entities -> entities.getName().equals(name))
                .toList();
    }

    public List<T> filterByActive() {
        return entities.stream()
                .filter(Entity::isActive)
                .toList();
    }
}
