//-----------------------------------------
// INTERFACE: GameLogical
//
// REMARKS: Defines core game logic operations. Extends Viewable
//          to ensure state visibility.
//-----------------------------------------
public interface GameLogical extends Viewable {
    //------------------------------------------------------
    // nextState
    //
    // PURPOSE: Advance the game to the next state.
    // PARAMETERS:
    //   v : Viewable component to update
    // Returns: false if game should exit to menu, true otherwise
    //------------------------------------------------------
    boolean nextState(Viewable v);

    //------------------------------------------------------
    // reset
    //
    // PURPOSE: Reset the game to its initial state.
    //------------------------------------------------------
    void reset();
}