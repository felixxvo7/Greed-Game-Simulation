//-----------------------------------------
// CLASS: Menu
//
// Author: Felix Vo, 7924848
//
// REMARKS: Handles menu interactions for the game. Manages menu items,
//          displays options to the user, and processes selections.
//-----------------------------------------
import java.util.ArrayList;
import java.util.List;

public class Menu implements Menuable {
    // Data Members
    private List<MenuItem> items;     // List of available menu options
    private String welcomeMessage;    // Welcome message displayed at the top
    private boolean startGame;        // Flag to track if game mode is active
    private Player player;            // Player interacting with the menu

    //------------------------------------------------------
    // Menu (Constructor)
    //
    // PURPOSE: Initializes the menu with default settings and empty item list.
    //------------------------------------------------------
    public Menu() {
        this.items = new ArrayList<>();
        this.welcomeMessage = "Welcome to Greed!";
        this.startGame = false;
    }

    //------------------------------------------------------
    // addMenuItem
    //
    // PURPOSE: Adds a new menu option to the list.
    // PARAMETERS:
    //   item (MenuItem) : The menu item to add.
    //------------------------------------------------------
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    //------------------------------------------------------
    // nextState
    //
    // PURPOSE: Checks if the game should transition to game mode.
    // PARAMETERS:
    //   v (Viewable) : Unused in this context (interface requirement).
    // Returns: Boolean indicating if game mode is active.
    //------------------------------------------------------
    @Override
    public boolean nextState(Viewable v) {
        return startGame;
    }

    //------------------------------------------------------
    // reset
    //
    // PURPOSE: Resets the menu state to default (non-game mode).
    //------------------------------------------------------
    @Override
    public void reset() {
        startGame = false;
    }

    //------------------------------------------------------
    // setMessage
    //
    // PURPOSE: Updates the welcome message displayed to the user.
    // PARAMETERS:
    //   message (String) : New message to display.
    //------------------------------------------------------
    @Override
    public void setMessage(String message) {
        this.welcomeMessage = message;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE: Displays the menu, processes user input, and handles selections.
    //          Loops until the user exits or starts the game.
    //------------------------------------------------------
    @Override
    public void view() {
        boolean exitMenu = false;

        while (!startGame && !exitMenu) {
            System.out.println("\n" + welcomeMessage);
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getDescription());
            }
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = player.chooseMove();
                if (choice < 1 || choice > items.size()) {
                    System.out.println("Invalid selection. Try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (items.get(choice - 1).select(null, this)) {
                startGame = true;
                exitMenu = true;
            } else if (items.get(choice - 1).getDescription().equalsIgnoreCase("Quit")) {
                exitMenu = true;
            }
        }
    }

    //------------------------------------------------------
    // setPlayer
    //
    // PURPOSE: Links a player to the menu for input handling.
    // PARAMETERS:
    //   player (Player) : The player instance.
    //------------------------------------------------------
    public void setPlayer(Player player) {
        this.player = player;
    }
}