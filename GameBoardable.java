//-----------------------------------------
// INTERFACE: GameBoardable
//
// REMARKS: Defines requirements for a game board. Extends Viewable
//          to ensure render capability.
//-----------------------------------------
public interface GameBoardable extends Viewable {
    //------------------------------------------------------
    // initializeBoard
    //
    // PURPOSE: Reset the board to a default/initial state.
    //------------------------------------------------------
    void initializeBoard();

    //------------------------------------------------------
    // updateBoard
    //
    // PURPOSE: Modify a specific cell on the board.
    // PARAMETERS:
    //   row    : Row index
    //   col    : Column index
    //   symbol : New symbol to place
    //------------------------------------------------------
    void updateBoard(int row, int col, char symbol);

    //------------------------------------------------------
    // getCell
    //
    // PURPOSE: Retrieve the symbol at a specific cell.
    // PARAMETERS:
    //   row : Row index
    //   col : Column index
    // Returns: Character at the specified position.
    //------------------------------------------------------
    char getCell(int row, int col);

    //------------------------------------------------------
    // getRows
    //
    // PURPOSE: Get total rows in the board.
    // Returns: Row count.
    //------------------------------------------------------
    int getRows();

    //------------------------------------------------------
    // getCols
    //
    // PURPOSE: Get total columns in the board.
    // Returns: Column count.
    //------------------------------------------------------
    int getCols();
}