package netology;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksByRequest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTasksByRequest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingByRequest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(13, "Позвонить родителям");
        SimpleTask simpleTask3 = new SimpleTask(666, "Позвонить родителям");
        Meeting meeting = new Meeting(
                888,
                "Позвонить родителям",
                "Семейный очаг",
                "Внезамедлительно"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(meeting);

        Task[] expected = {simpleTask1, simpleTask2, simpleTask3, meeting};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(13, "Позвонить родителям");
        SimpleTask simpleTask3 = new SimpleTask(666, "Позвонить родителям");
        Meeting meeting = new Meeting(
                888,
                "Позвонить родителям",
                "Семейный очаг",
                "Внезамедлительно"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Семейный очаг");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void noTasksFound() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(13, "Сходить в спорт. зал");
        Meeting meeting = new Meeting(
                888,
                "Собрать мотор",
                "Мотоцикл мечты",
                "В понедельник утром"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Перебрать КПП");
        Assertions.assertArrayEquals(expected, actual);
    }
}
