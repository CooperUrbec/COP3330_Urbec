import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<TaskItem>();

    }

    public TaskList(String filePath){

    }

    public void addTask(String title, String description, String dueDate){
        TaskItem item = TaskItem.getNewTaskItemInstance(title, description, dueDate);
        tasks.add(item);
    }

    public void removeTask(int index){
        if(validIndex(index)){
            tasks.remove(index);
        }
    }

    public void setTaskCompletion(int index, boolean complete){
        if(validIndex(index)){
            tasks.get(index).setStatus(complete);
        }
    }

    public void changeTaskTitle(int index, String newTitle){
        if(validIndex(index)){
            tasks.get(index).setTitle(newTitle);
        }
    }

    public void changeTaskDescription(int index, String newDescription){
        if(validIndex(index)){
            tasks.get(index).setDescription(newDescription);
        }
    }

    public void changeTaskDueDate(int index, String newDueDate){
        if(validIndex(index)){
            tasks.get(index).setDate(newDueDate);
        }
    }

    public String getTaskTitle(int index){
        if(validIndex(index)){
            return tasks.get(index).getTitle();
        }

        return null;
    }

    public String getTaskDescription(int index){
        if(validIndex(index)){
            return tasks.get(index).getDescription();
        }

        return null;
    }

    public String getTaskDueDate(int index){
        if(validIndex(index)){
            return tasks.get(index).getDate();
        }

        return null;
    }

    public boolean getTaskStatus(int index){
        if(validIndex(index)){
            String status = tasks.get(index).getStatus();

            return status.length() > 0;
        }

        return false;
    }

    public int getListSize(){
        return tasks.size();
    }

    public void saveList(String filePath){

    }

    private boolean validIndex(int index){
        if(index < tasks.size())
            return true;

        System.out.println("WARNING: Invalid index.");
        return false;
    }
}
