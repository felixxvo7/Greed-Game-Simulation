import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements Menuable {
    private List<MenuItem> items;
    private String welcomeMessage;
    private boolean startGame; // Exit condition flag

    public Menu() {
        this.items = new ArrayList<>();
        this.welcomeMessage = "Welcome to Greed!";
        this.startGame = false; 
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public boolean nextState(Viewable v) {
        return startGame;
    }

    @Override
    public void reset() {
        startGame = false;
    }

    @Override
    public void setMessage(String message) {
        this.welcomeMessage = message;
    }

    @Override
    public void view() {
        Scanner scanner = new Scanner(System.in);
        boolean exitMenu = false;

        while (!startGame && !exitMenu) { // Loop until exitMenu is set to true
            System.out.println("\n" + welcomeMessage);
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getDescription());
            }
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > items.size()) {
                    System.out.println("Invalid selection. Try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if(items.get(choice - 1).select(null, this)){
                startGame = true;
                exitMenu = true;
            }
            else if (items.get(choice - 1).getDescription().equalsIgnoreCase("Quit")) {
                exitMenu = true;
            }
        }
    }
}

