//-----------------------------------------
// INTERFACE: Selectable
//
// REMARKS: Marks an object as interactable. Used for menu items
//          and game actions that require user input.
//-----------------------------------------
public interface Selectable {
    //------------------------------------------------------
    // select
    //
    // PURPOSE: Executes logic when the object is selected.
    // PARAMETERS:
    //   v (Viewable)   : A viewable component to update.
    //   gl (GameLogical): Game logic handler to modify state.
    // Returns: Boolean indicating if game mode should activate.
    //------------------------------------------------------
    boolean select(Viewable v, GameLogical gl);
}