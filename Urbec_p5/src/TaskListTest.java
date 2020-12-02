import org.junit.jupiter.api.Test;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList list = new TaskList();
        int size = list.getListSize();
        list.addTask("task", "1", "2020-10-06");
        assert(list.getListSize() == size + 1);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        boolean status = list.getTaskStatus(0);
        list.setTaskCompletion(0, true);
        assert(list.getTaskStatus(0) != status);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        boolean status = list.getTaskStatus(0);
        list.setTaskCompletion(3, true);
        assert(list.getTaskStatus(0) == status);
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String description = list.getTaskDescription(0);
        list.editTask(0,"task", "2", "2020-10-06");
        assert(!list.getTaskDescription(0).equals(description));
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String description = list.getTaskDescription(0);
        list.editTask(5,"task", "2", "2020-10-06");
        assert(list.getTaskDescription(0).equals(description));
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String dueDate = list.getTaskDueDate(0);
        list.editTask(0,"task", "1", "2020-11-23");
        assert(!list.getTaskDueDate(0).equals(dueDate));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String dueDate = list.getTaskDueDate(0);
        list.editTask(3,"task", "1", "2020-11-23");
        assert(list.getTaskDueDate(0).equals(dueDate));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String title = list.getTaskTitle(0);
        list.editTask(0,"task1", "1", "2020-10-06");
        assert(!list.getTaskTitle(0).equals(title));
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String title = list.getTaskTitle(0);
        list.editTask(4,"task1", "1", "2020-10-06");
        assert(list.getTaskTitle(0).equals(title));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String description = list.getTaskDescription(3);
        assert(description == null);
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String description = list.getTaskDescription(0);
        assert(description.equals("1"));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String dueDate = list.getTaskDueDate(3);
        assert(dueDate == null);
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String dueDate = list.getTaskDueDate(0);
        assert(dueDate.equals("2020-10-06"));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String title = list.getTaskTitle(3);
        assert(title == null);
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        String title = list.getTaskTitle(0);
        assert(title.equals("task"));
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        assert(list.getListSize() == 0);
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        int size = list.getListSize();
        list.removeTask(0);
        assert(list.getListSize() == size-1);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        int size = list.getListSize();
        list.removeTask(4);
        assert(list.getListSize() == size);
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        String filePath = "test.txt";
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        list.setTaskCompletion(0, true);
        list.printList();
        list.saveList(filePath);

        TaskList list2 = new TaskList();
        list2.loadList(filePath);
        list2.printList();
        assert(list2.getTaskTitle(0).equals(list.getTaskTitle(0)));
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        list.setTaskCompletion(0, true);
        boolean taskStatus = list.getTaskStatus(0);
        list.setTaskCompletion(0, false);
        assert(list.getTaskStatus(0) != taskStatus);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("task", "1", "2020-10-06");
        list.setTaskCompletion(0, true);
        boolean taskStatus = list.getTaskStatus(0);
        list.setTaskCompletion(5, false);
        assert(list.getTaskStatus(0) == taskStatus);
    }
}