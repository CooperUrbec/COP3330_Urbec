import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        mainMenu();
    }

    public static void mainMenu(){
        int userInput;

        while(true){
            mainMenuOptions();
            userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){
                case 1:
                    createList();
                    break;
                case 2:
                    loadList();
                    break;
                case 3:
                    return;
            }

        }
    }

    private static void createList(){
        TaskList list = new TaskList();
        System.out.println("New task list has been created\n");
        listMenu(list);

    }

    private static void loadList(){
        TaskList list = new TaskList();

        System.out.println("Enter the filename to load: ");
        String filePath = scanner.nextLine();

        if(list.loadList(filePath)){
            listMenu(list);
        }

    }

    private static void listMenu(TaskList list){
        int userInput;

        while(true){
            listMenuOptions();
            userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){

                case 1: //view list
                    list.printList();
                    break;

                case 2: //add item
                    addItem(list);
                    break;

                case 3: //edit item
                    editItem(list);
                    break;

                case 4: //remove item
                    removeItem(list);
                    break;

                case 5: //mark complete
                    markItem(list, true);
                    break;

                case 6: //unmark complete
                    markItem(list, false);
                    break;

                case 7: //save list
                    saveList(list);
                    break;

                case 8: //exit
                    return;
            }

        }
    }

    private static void saveList(TaskList list){
        System.out.printf("\nEnter the filename to save as: ");
        String filepath = scanner.nextLine();

        list.saveList(filepath);
    }

    private static void markItem(TaskList list, boolean complete) {
        int index;

        if(complete){
            list.printUnmarked();
            System.out.printf("\nWhich task will you mark as completed? ");
            index = scanner.nextInt();

            list.setTaskCompletion(index, true);
            return;
        }

        list.printMarked();
        System.out.printf("\nWhich task will you unmark as completed? ");
        index = scanner.nextInt();

        list.setTaskCompletion(index, false);


    }

    private static void removeItem(TaskList list) {
        System.out.printf("\nWhich task will you remove? ");
        int index = scanner.nextInt();

        list.removeTask(index);
    }

    private static void editItem(TaskList list) {
        System.out.printf("\nWhich task will you edit? ");
        int index = scanner.nextInt();

        System.out.printf("\nEnter a new title for task %d: ", index);
        String newTitle = scanner.nextLine();

        System.out.printf("\nEnter a new description for task %d: ", index);
        String newDescription = scanner.nextLine();

        System.out.printf("\nEnter a new due date (YYYY-MM-DD) for task %d: ", index);
        String newDate = scanner.nextLine();

        list.editTask(index, newTitle, newDescription, newDate);

    }

    private static void addItem(TaskList list) {

        System.out.printf("\nTask title: ");
        String title = scanner.nextLine();

        System.out.printf("\nTask description: ");
        String description = scanner.nextLine();

        System.out.printf("\nTask due date (YYY-MM-DD): ");
        String date = scanner.nextLine();

        list.addTask(title, description, date);
    }

    private static void mainMenuOptions(){
        System.out.printf("\nMain Menu");
        System.out.printf("\n---------");
        System.out.printf("\n\n1) create a new list");
        System.out.printf("\n2) load an existing list");
        System.out.printf("\n3) quit\n");
    }

    private static void listMenuOptions(){
        System.out.printf("\nList Operation Menu");
        System.out.printf("\n---------");
        System.out.printf("\n\n1) view the list");
        System.out.printf("\n2) add an item");
        System.out.printf("\n3) edit an item");
        System.out.printf("\n4) remove an item");
        System.out.printf("\n5) mark an item as completed");
        System.out.printf("\n6) unmark an item as completed");
        System.out.printf("\n7) save current list");
        System.out.printf("\n8) exit to main menu\n");


    }
}
