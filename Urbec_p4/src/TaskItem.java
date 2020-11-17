import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    private String title;
    private String description;
    private LocalDate date;
    private boolean status;

    public static TaskItem getNewTaskItemInstance(String title, String description, String date){

        if(!isValidTitle(title)){
            System.out.println("WARNING: title must be at least 1 character long; task not created.");
            return null;
        }

        if(!isValidDate(date)){
            System.out.println("WARNING: invalid due date; task not created.");
            return null;
        }

        return new TaskItem(title, description, date);
    }

    private TaskItem(String title, String description, String date){
        this.title = title;
        this.description = description;
        this.date = LocalDate.parse(date);
        this.status = false;
    }

    public void editTask(String newTitle, String newDescription, String newDate){
        if(!isValidTitle(newTitle)){
            System.out.println("WARNING: title must be at least 1 character long; title not changed.");
            return;
        }
        if(!isValidDate(newDate)){
            System.out.println("WARNING: invalid due date; date not changed.");
            return;
        }

        this.title = newTitle;
        this.description = newDescription;
        this.date = LocalDate.parse(newDate);

    }

    public void setStatus(boolean completed){
        this.status = completed;
    }

    private static boolean isValidTitle(String str){

        return str.length() >= 1;
    }

    private static boolean isValidDate(String date){

        try{
            LocalDate newDate = LocalDate.parse(date);
            return true;
        }
        catch(DateTimeParseException ex){
            return false;
        }
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getDate(){
        return this.date.toString();
    }

    public boolean getStatus(){
        return this.status;
    }

    @Override
    public String toString(){

        return "[" + this.date.toString() + "] " + this.title + ": " + this.description;
    }
}
