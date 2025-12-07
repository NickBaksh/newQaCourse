package practice_13_1.task_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EntityManagerTest {

    public EntityManager<Entity> entityManager;

    @BeforeEach
    public void setUp() {
        entityManager = new EntityManager<>();
    }

    //------------Проверка метода add--------------
    //Тест-кейсы:
    //Проверка добавления пользователя в пустой EntityManager
    //Проверка добавления пользователя в EntityManager с одним пользователем
    //Проверка добавления двух одинаковых пользователей в менеджер

    Stream<Arguments> oneUser() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 15, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("oneUser")
    @DisplayName("Тест проверяет добавление нового пользователя в пустой EntityManager")
    public void shouldReturnAddedUser(Entity user) {
        entityManager.add(user);
        Assertions.assertTrue(entityManager.getAll().contains(user));
    }

    Stream<Arguments> twoUsers() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 17, true),
                        new Entity("Petya", 19, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("twoUsers")
    @DisplayName("Тест проверяет добавление нового пользователя в EntityManager с одним пользователем")
    public void shouldReturnAddedUserInManagerWithOneUser(Entity user1, Entity user2) {
        entityManager.add(user1);
        entityManager.add(user2);
        Assertions.assertTrue(entityManager.getAll().contains(user2));
    }

    Stream<Arguments> twoEqualsUsers() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 17, true),
                        new Entity("Kolya", 17, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("twoEqualsUsers")
    @DisplayName("Тест проверяет добавление двух одинаковых пользователей в EntityManager")
    public void shouldReturnFalseWhenAddEqualsUsers(Entity user1, Entity user2) {
        entityManager.add(user1);
        entityManager.add(user2);
        Assertions.assertNotEquals(user1, user2);
    }


    //--------------Проверка метода remove----------------
    //Тест-кейсы:
    //Проверка удаления пользователя из пустого EntityManager (вернет false)
    //Проверка удаления пользователя из EntityManager где он присутствует (вернет true)
    //Проверка удаления несуществующего пользователя из EntityManager (вернет false)

    Stream<Arguments> oneUserForDeletion() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 17, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("oneUserForDeletion")
    @DisplayName("Тест проверяет удаление пользователя из пустого EntityManager")
    public void shouldReturnFalseForEmptyManager(Entity user1) {
        Assertions.assertFalse(entityManager.remove(user1));
    }

    Stream<Arguments> twoUserInManagerAndOneForDeletion() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 17, true),
                        new Entity("Vanya", 19, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("twoUserInManagerAndOneForDeletion")
    @DisplayName("Тест проверяет удаление одного из пользователей в EntityManager")
    public void shouldReturnTrueForDeletionUserInManager(Entity user1, Entity user2) {
        entityManager.add(user1);
        entityManager.add(user2);
        Assertions.assertTrue(entityManager.remove(user2));
    }

    Stream<Arguments> twoUsersInManagerAndOneNotExist() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 17, true),
                        new Entity("Vanya", 19, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("twoUsersInManagerAndOneNotExist")
    @DisplayName("Тест проверяет удаление несуществующего пользователя в EntityManager")
    public void shouldReturnFalseForDeletionNotExistingUser(Entity user1, Entity user2) {
        entityManager.add(user1);
        Assertions.assertFalse(entityManager.remove(user2));
    }

    //--------------Проверка фильтра filterByAge-----------------
    Stream<Arguments> usersForFilterByAge() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 17, true),
                        new Entity("Olya", 1, true),
                        new Entity("Vanya", 119, false)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("usersForFilterByAge")
    @DisplayName("Тест проверяет наличие пользователей в списке при фильтрации по возрасту")
    public void shouldReturnTrueForUsersFilteredByAge(Entity user1, Entity user2, Entity user3) {
        entityManager.add(user1);
        entityManager.add(user2);
        entityManager.add(user3);
        Assertions.assertTrue(entityManager.filterByAge(17, 18).contains(user1));
        Assertions.assertTrue(entityManager.filterByAge(0, 2).contains(user2));
        Assertions.assertTrue(entityManager.filterByAge(118, 9999).contains(user3));
    }

    Stream<Arguments> userForFilterByAge() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 17, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("userForFilterByAge")
    @DisplayName("Тест проверяет наличие пустого списка если " +
            "ни один из пользователей не попал в фильтр по возрасту")
    public void shouldReturnEmptyListForNotFilteredByAgeUser(Entity user1) {
        entityManager.add(user1);
        Assertions.assertTrue(entityManager.filterByAge(0, 16).isEmpty());
    }

    //---------Проверка фильтра filterByName------------
    Stream<Arguments> userForFilterByName() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 24, false)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("userForFilterByName")
    @DisplayName("Тест проверяет наличие пользователя в списке при фильтрации по имени")
    public void shouldReturnUserForFilterByName(Entity user1) {
        entityManager.add(user1);
        Assertions.assertTrue(entityManager.filterByName("Kolya").contains(user1));
    }


    @ParameterizedTest
    @MethodSource("userForFilterByName")
    @DisplayName("Тест проверяет отсутствие пользователя в списке при фильтрации по имени " +
            "в случе когда пользователь не проходит фильтрацию")
    public void shouldReturnTrueForEmptyList(Entity user1) {
        entityManager.add(user1);
        Assertions.assertFalse(entityManager.filterByName("Vanya").contains(user1));
    }

    //--------------Проверка фильтра filterByActive------------
    Stream<Arguments> usersForFilterByActive() {
        return Stream.of(
                Arguments.of(
                        new Entity("Kolya", 21, true),
                        new Entity("Vanya", 19, true),
                        new Entity("Petya", 95, false)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("usersForFilterByActive")
    @DisplayName("Тест проверяет наличие пользователя в списке при фильтрации по активности")
    public void shouldReturnActiveUsers(Entity user1, Entity user2, Entity user3) {
        entityManager.add(user1);
        entityManager.add(user2);
        entityManager.add(user3);
        Assertions.assertTrue(entityManager.filterByActive().contains(user1));
        Assertions.assertTrue(entityManager.filterByActive().contains(user2));
    }

    @ParameterizedTest
    @MethodSource("usersForFilterByActive")
    @DisplayName("Тест проверяет отсутствие пользователя в списке при фильтрации по активности")
    public void shouldNotReturnInactiveUsers(Entity user1, Entity user2, Entity user3) {
        entityManager.add(user1);
        entityManager.add(user2);
        entityManager.add(user3);
        Assertions.assertFalse(entityManager.filterByActive().contains(user3));
    }
}
