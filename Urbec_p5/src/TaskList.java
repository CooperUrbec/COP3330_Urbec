import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList {
    private ArrayList<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();

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

    public void editTask(int index, String newTitle, String newDescription, String newDate){
        if(validIndex(index)){
            tasks.get(index).editTask(newTitle, newDescription, newDate);
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
            return tasks.get(index).getStatus();
        }

        return false;
    }

    public int getListSize(){
        return tasks.size();
    }

    public void saveList(String filePath){

        try(Formatter formatter = new Formatter(filePath)){

            for(TaskItem item : tasks){
                String status;
                if(item.getStatus())
                    status = "T";
                else
                    status = "F";

                formatter.format("%s;%s;%s;%s\n", status, item.getTitle(),
                                                 item.getDescription(), item.getDate());
            }
            System.out.println("List successfully saved.");
        }
        catch(FileNotFoundException e){
            System.out.println("WARNING: file not found.");
        }

    }

    public boolean loadList(String filePath){

        File file = new File(filePath);
        try(Scanner scanner = new Scanner(file)){

            while(scanner.hasNextLine()){
                String[] task = scanner.nextLine().split(";", -2);
                this.addTask(task[1], task[2], task[3]);

                if(task[0].equals("T")) this.setTaskCompletion(tasks.size()-1, true);
            }
            System.out.println("List successfully loaded");
            return true;
        }
        catch(FileNotFoundException e){
            System.out.println("WARNING: file not found.");
            return false;
        }
    }

    private boolean validIndex(int index){
        if(index < tasks.size())
            return true;

        System.out.println("WARNING: Invalid index.");
        return false;
    }

    public void printList(){

        System.out.println("Current tasks");
        System.out.println("---------\n");
        for(int i = 0; i < tasks.size(); ++i){
            if(this.getTaskStatus(i)) {
                System.out.printf("%d) *** %s", i, tasks.get(i).toString());
            }
            else {
                System.out.printf("%d) %s", i, tasks.get(i).toString());
            }
        }
        System.out.println();
    }

    public void printUnmarked(){
        System.out.println("Uncompleted tasks");
        System.out.println("---------\n");
        for(int i = 0; i < tasks.size(); ++i){
            if(!this.getTaskStatus(i)) {
                System.out.printf("%d) %s", i, tasks.get(i).toString());
            }
        }
        System.out.println();
    }

    public void printMarked(){
        System.out.println("Completed tasks");
        System.out.println("---------\n");
        for(int i = 0; i < tasks.size(); ++i){
            if(this.getTaskStatus(i)) {
                System.out.printf("%d) %s", i, tasks.get(i).toString());
            }
        }
        System.out.println();
    }

}
