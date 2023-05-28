package netology;

public class Epic extends Task {
    protected String[] subtask;

    public Epic(int id, String[] subtask) {
        super(id); // вызов родительского конструктора
        this.subtask = subtask; // заполнение своих полей
    }

    public String[] getSubtask() {
        return subtask;
    }

    @Override
    public boolean matches(String query) {
        for (int i = 0; i < subtask.length; i++) {
            if (subtask[i].contains(query)) {
                return true;
            }
        }
        return false;
    }
}
