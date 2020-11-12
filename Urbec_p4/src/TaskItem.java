import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    private String title;
    private String description;
    private LocalDate date;
    private String status;

    public static TaskItem getNewTaskItemInstance(String title, String description, String date){

        if(isValidTitle(title) == false){
            System.out.println("WARNING: title must be at least 1 character long; task not created.");
            return null;
        }

        if(isValidDate(date) == false){
            System.out.println("WARNING: invalid due date; task not created.");
            return null;
        }

        TaskItem returnVal = new TaskItem(title, description, date);

        return returnVal;
    }

    private TaskItem(String title, String description, String date){
        this.title = title;
        this.description = description;
        this.date = LocalDate.parse(date);
        this.status = "";
    }

    public void setTitle(String newTitle){

        if(isValidTitle(newTitle)){
            this.title = newTitle;
            return;
        }

        System.out.println("WARNING: title must be at least 1 character long; title not changed.");
    }

    public void setDate(String newDate){

        if(isValidDate(newDate)){
            this.date = LocalDate.parse(newDate);
            return;
        }

        System.out.println("WARNING: invalid due date; date not changed.");
    }

    public void setStatus(boolean completed){
        if(completed){
            this.status = "*** ";
        }

        this.status = "";
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
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

    @Override
    public String toString(){

        return this.status + "[" + this.date.toString() + "] " + this.title + ": " + this.description;
    }
}
