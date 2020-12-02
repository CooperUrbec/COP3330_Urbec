import java.util.Scanner;

public class TaskApp{
    private Scanner scanner = new Scanner(System.in);
    private TaskList list;

    public void mainMenu(){
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
                default :
                    System.out.println("Invalid input.\n");
                    break;
            }

        }
    }

    private void createList(){
        list = new TaskList();
        System.out.println("New task list has been created\n");
        listMenu();

    }

    private void loadList(){
        list = new TaskList();

        System.out.println("Enter the filename to load: ");
        String filePath = scanner.nextLine();

        if(list.loadList(filePath)){
            listMenu();
        }

    }

    private void listMenu(){
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
                    addItem();
                    break;

                case 3: //edit item
                    editItem();
                    break;

                case 4: //remove item
                    removeItem();
                    break;

                case 5: //mark complete
                    markItem(true);
                    break;

                case 6: //unmark complete
                    markItem(false);
                    break;

                case 7: //save list
                    saveList();
                    break;

                case 8: //exit
                    return;
                default :
                    System.out.println("Invalid input.\n");
                    break;
            }

        }
    }

    private void saveList(){
        System.out.printf("\nEnter the filename to save as: ");
        String filepath = scanner.nextLine();

        list.saveList(filepath);
    }

    private void markItem(boolean complete) {
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

    private void removeItem() {
        System.out.printf("\nWhich task will you remove? \n");
        list.printList();
        int index = scanner.nextInt();

        list.removeTask(index);
    }

    private void editItem() {
        System.out.printf("\nWhich task will you edit? \n");
        list.printList();
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("\nEnter a new title for task %d: ", index);
        String newTitle = scanner.nextLine();

        System.out.printf("Enter a new description for task %d: ", index);
        String newDescription = scanner.nextLine();

        System.out.printf("Enter a new due date (YYYY-MM-DD) for task %d: ", index);
        String newDate = scanner.nextLine();

        list.editTask(index, newTitle, newDescription, newDate);

    }

    private void addItem() {

        System.out.printf("\nTask title: ");
        String title = scanner.nextLine();

        System.out.printf("Task description: ");
        String description = scanner.nextLine();

        System.out.printf("Task due date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        list.addTask(title, description, date);
    }

    private void mainMenuOptions(){
        System.out.printf("\nMain Menu");
        System.out.printf("\n---------");
        System.out.printf("\n\n1) create a new list");
        System.out.printf("\n2) load an existing list");
        System.out.printf("\n3) quit\n");
    }

    private void listMenuOptions(){
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
