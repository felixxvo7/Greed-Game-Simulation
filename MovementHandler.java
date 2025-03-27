//-----------------------------------------
// CLASS: MovementHandler
//
// Author: Felix Vo, 7924848
//
// REMARKS: Manages all player movement logic for the Greed game.
//          Handles validation, execution, and game state updates.
//-----------------------------------------
public class MovementHandler {
    // Data Members
    private GameBoard board;      // Reference to game board
    private int playerRow;       // Current player row position
    private int playerCol;       // Current player column position

    //------------------------------------------------------
    // MovementHandler (Constructor)
    //
    // PURPOSE: Initializes handler with game board reference.
    // PARAMETERS:
    //   board (GameBoard) : The game board to operate on
    //------------------------------------------------------
    public MovementHandler(GameBoard board) {
        this.board = board;
        findPlayerPos();
    }

    //------------------------------------------------------
    // findPlayerPos
    //
    // PURPOSE: Locates the player's (@) position on the board.
    //------------------------------------------------------
    public void findPlayerPos() {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                if (board.getCell(r, c) == '@') {
                    playerCol = c;
                    playerRow = r;
                    return;
                }
            }
        }
    }

    //------------------------------------------------------
    // isValidMove
    //
    // PURPOSE: Validates if a move is legal.
    // PARAMETERS:
    //   newRow       : Target row
    //   newCol       : Target column
    //   moveDistance : Number of spaces to move
    //   rowStep      : Row direction (-1, 0, 1)
    //   colStep      : Column direction (-1, 0, 1)
    // Returns: true if move is valid, false otherwise
    //------------------------------------------------------
    public boolean isValidMove(int newRow, int newCol, int moveDistance, int rowStep, int colStep) {
        for (int i = 1; i <= moveDistance; i++) {
            int stepsRow = playerRow + (i * rowStep);
            int stepsCol = playerCol + (i * colStep);

            if (stepsRow < 0 || stepsRow >= board.getRows() || 
                stepsCol < 0 || stepsCol >= board.getCols()) {
                return false; // Out of bounds
            }

            char cell = board.getCell(stepsRow, stepsCol);
            if (cell == ' ' || cell == '0') {
                return false; // Cannot move through empty spaces
            }
        }
        return true;
    }

    //------------------------------------------------------
    // processMove
    //
    // PURPOSE: Executes a player move and updates game state.
    // PARAMETERS:
    //   moveOption (int) : Numpad direction (1-9)
    // Returns: Score gained from this move (0 if invalid)
    //------------------------------------------------------
    public int processMove(int moveOption) {
        int rowStep = 0, colStep = 0;

        // Map numpad input to movement directions
        switch (moveOption) {
            case 7: rowStep = -1; colStep = -1; break; // Up-Left
            case 8: rowStep = -1; break;               // Up
            case 9: rowStep = -1; colStep = 1; break;  // Up-Right
            case 4: colStep = -1; break;               // Left
            case 6: colStep = 1; break;                // Right
            case 1: rowStep = 1; colStep = -1; break;  // Down-Left
            case 2: rowStep = 1; break;                // Down
            case 3: rowStep = 1; colStep = 1; break;   // Down-Right
            default: return 0; // Invalid move
        }

        // Validate first cell
        int firstRow = playerRow + rowStep;
        int firstCol = playerCol + colStep;
        if (firstRow < 0 || firstRow >= board.getRows() || 
            firstCol < 0 || firstCol >= board.getCols()) {
            System.out.println("Invalid move: Out of bounds.");
            return 0;
        }

        char firstCell = board.getCell(firstRow, firstCol);
        if (firstCell == ' ') {
            System.out.println("Invalid move: Cannot move through empty space.");
            return 0;
        }

        // Calculate full move
        int moveDistance = firstCell - '0';
        int newRow = playerRow + (rowStep * moveDistance);
        int newCol = playerCol + (colStep * moveDistance);

        if (!isValidMove(newRow, newCol, moveDistance, rowStep, colStep)) {
            System.out.println("Invalid move: Path blocked.");
            return 0;
        }

        // Execute move and calculate score
        int scoreGained = 0;
        for (int i = 1; i <= moveDistance; i++) {
            int intermediateRow = playerRow + (i * rowStep);
            int intermediateCol = playerCol + (i * colStep);
            scoreGained += board.getCell(intermediateRow, intermediateCol) - '0';
            board.updateBoard(intermediateRow, intermediateCol, ' ');
        }

        // Update player position
        board.updateBoard(playerRow, playerCol, ' ');
        board.updateBoard(newRow, newCol, '@');
        playerRow = newRow;
        playerCol = newCol;

        return scoreGained;
    }

    //------------------------------------------------------
    // checkGameOver
    //
    // PURPOSE: Determines if no valid moves remain.
    // Returns: true if game should end, false otherwise
    //------------------------------------------------------
    public boolean checkGameOver() {
        int[] rowMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colMoves = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < rowMoves.length; i++) {
            int newRow = playerRow + rowMoves[i];
            int newCol = playerCol + colMoves[i];
            
            if (newRow >= 0 && newRow < board.getRows() && 
                newCol >= 0 && newCol < board.getCols()) {
                char cell = board.getCell(newRow, newCol);
                if (cell >= '1' && cell <= '9') {
                    return false; // Valid move exists
                }
            }
        }
        return true; // No valid moves
    }
}