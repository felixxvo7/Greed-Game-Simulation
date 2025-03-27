//-----------------------------------------
// CLASS: MenuItem
//
// Author: Felix Vo, 7924848
//
// REMARKS: Represents a selectable option in a menu. Executes
//          a predefined action when selected.
//-----------------------------------------
public class MenuItem implements Selectable {
    // Data Members
    private String description; // Text displayed for this menu item
    private Runnable action;   // Action to execute when selected

    //------------------------------------------------------
    // MenuItem (Constructor)
    //
    // PURPOSE: Initializes the menu item with a description and action.
    // PARAMETERS:
    //   description (String) : Display text for the item.
    //   action (Runnable)    : Code to run when selected.
    //------------------------------------------------------
    public MenuItem(String description, Runnable action) {
        this.description = description;
        this.action = action;
    }

    //------------------------------------------------------
    // select
    //
    // PURPOSE: Triggers the menu item's action when selected.
    // PARAMETERS:
    //   v (Viewable)   : Unused here (interface requirement).
    //   gl (GameLogical): Unused here (interface requirement).
    // Returns: true if the selection starts the game, false otherwise.
    //------------------------------------------------------
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        action.run();
        return true;
    }

    //------------------------------------------------------
    // getDescription
    //
    // PURPOSE: Returns the display text of the menu item.
    // Returns: Description as a String.
    //------------------------------------------------------
    public String getDescription() {
        return description;
    }
}