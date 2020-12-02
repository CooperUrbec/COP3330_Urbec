import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    TaskApp taskApp = new TaskApp();
    ContactApp contactApp = new ContactApp();

    public void mainMenu(){
        int userInput;

        while(true){
            displayMenuOptions();
            userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){
                case 1:
                    taskApp.mainMenu();
                    break;
                case 2:
                    contactApp.mainMenu();
                    break;
                case 3:
                    return;
            }

        }
    }

    public void displayMenuOptions(){
        System.out.printf("\nSelect Your Application");
        System.out.printf("\n-----------------------");
        System.out.printf("\n\n1) task list");
        System.out.printf("\n2) contact list");
        System.out.printf("\n3) quit\n");
    }

    public static void main(String[] argv){
        App app = new App();
        app.mainMenu();
    }
}
