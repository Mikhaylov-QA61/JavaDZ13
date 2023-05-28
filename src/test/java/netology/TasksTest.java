package netology;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TasksTest {


    @Test
    public void shouldFindSimpleTaskByRequest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertArrayEquals(new boolean[]{expected}, new boolean[]{actual});
    }

    @Test
    public void shouldFindEpicByRequest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertArrayEquals(new boolean[]{expected}, new boolean[]{actual});
    }

    @Test
    public void shouldFindMeetingByRequest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertArrayEquals(new boolean[]{expected}, new boolean[]{actual});
    }

}
