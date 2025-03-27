//-----------------------------------------
// INTERFACE: Menuable
//
// REMARKS: Defines requirements for a menu system. Extends GameLogical
//          to integrate with game state management.
//-----------------------------------------
public interface Menuable extends GameLogical {
    //------------------------------------------------------
    // setMessage
    //
    // PURPOSE: Sets a message to display in the menu.
    // PARAMETERS:
    //   message (String) : The message to show.
    //------------------------------------------------------
    void setMessage(String message);

    //------------------------------------------------------
    // view
    //
    // PURPOSE: Displays the menu and handles user interaction.
    //------------------------------------------------------
    void view();
}