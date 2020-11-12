import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskList> tasks;

    public TaskList(){

    }

    public TaskList(String filePath){

    }

    public void addTask(String title, String description, String dueDate){

    }

    public void removeTask(int index){

    }

    public void setTaskCompletion(int index, boolean complete){

    }

    public void changeTaskTitle(int index, String newTitle){

    }

    public void changeTaskDescription(int index, String newDescription){

    }

    public void changeTaskDueDate(int index, String newDurDate){

    }

    public String getTaskTitle(int index){
        return "";
    }

    public String getTaskDescription(int index){
        return "";
    }

    public String getTaskDueDate(int index){
        return "";
    }

    public boolean getTaskStatus(int index){
        return false;
    }

    public int getListSize(){
        return 0;
    }

    public void saveList(String filePath){

    }
}
