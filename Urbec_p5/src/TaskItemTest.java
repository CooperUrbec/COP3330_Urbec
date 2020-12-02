import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        //if data is invalid return null
        TaskItem item = TaskItem.getNewTaskItemInstance("task 1", "do this", "2020-nov-06");
        assertNull(item);
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem item = TaskItem.getNewTaskItemInstance("", "do this", "2020-11-06");
        assertNull(item);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem item = TaskItem.getNewTaskItemInstance("task 1", "do this", "2020-11-06");
        assert(null != item);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem item = TaskItem.getNewTaskItemInstance("task 2", "do this", "2020-12-06");
        assert(null != item);
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem item = TaskItem.getNewTaskItemInstance("task 1", " ", "2020-06-07");
        item.editTask("task 1", " ", "2020nov07");
        assert(item.getDate().equals("2020-06-07"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem item = TaskItem.getNewTaskItemInstance("task 1", " ", "2020-06-07");
        item.editTask("task 1", " ", "2020-11-06");
        assert(item.getDate().equals("2020-11-06"));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem item = TaskItem.getNewTaskItemInstance("task 1", " ", "2020-06-07");
        item.editTask("", " ", "2020-11-07");
        assert(item.getTitle() == "task 1");
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem item = TaskItem.getNewTaskItemInstance("task 1", " ", "2020-06-07");
        item.editTask("task 2", " ", "2020-11-07");
        assert(item.getTitle() == "task 2");
    }

}