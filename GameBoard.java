//-----------------------------------------
// CLASS: GameBoard
//
// Author: Felix Vo, 7924848
//
// REMARKS: Manages the game board state and layout. Handles initialization,
//          updates, and rendering of the ASCII game grid.
//-----------------------------------------
import java.util.Random;

public class GameBoard implements GameBoardable {
    // Data Members
    private char[][] board;       // 2D array representing the game board
    private int rows, cols;       // Board dimensions
    private int playerRows;       // Player's current row position
    private int playerCols;       // Player's current column position

    //------------------------------------------------------
    // GameBoard (Constructor)
    //
    // PURPOSE: Create a default 20x80 game board and initialize it.
    //------------------------------------------------------
    public GameBoard() {
        this.rows = 20;
        this.cols = 80;
        this.board = new char[rows][cols];
        initializeBoard();
    }

    //------------------------------------------------------
    // GameBoard (Overloaded Constructor)
    //
    // PURPOSE: Create a custom-sized game board and initialize it.
    // PARAMETERS:
    //   rows : Number of rows in the board
    //   cols : Number of columns in the board
    //------------------------------------------------------
    public GameBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        initializeBoard();
    }

    //------------------------------------------------------
    // initializeBoard
    //
    // PURPOSE: Populates the board with random numerals (1-9) and places
    //          the player (@) at the center.
    //------------------------------------------------------
    @Override
    public void initializeBoard() {
        Random rand = new Random();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = (char) ('1' + rand.nextInt(9));
            }
        }

        // Place player at center
        playerCols = cols / 2;
        playerRows = rows / 2;
        board[playerRows][playerCols] = '@';
    }

    //------------------------------------------------------
    // updateBoard
    //
    // PURPOSE: Update a specific cell on the board.
    // PARAMETERS:
    //   row    : Row index of the cell
    //   col    : Column index of the cell
    //   symbol : New character to place at (row, col)
    //------------------------------------------------------
    @Override
    public void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    //------------------------------------------------------
    // getCell
    //
    // PURPOSE: Retrieve the character at a specific cell.
    // PARAMETERS:
    //   row : Row index
    //   col : Column index
    // Returns: Character at (row, col) or space if out of bounds.
    //------------------------------------------------------
    @Override
    public char getCell(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return board[row][col];
        }
        return ' ';
    }

    //------------------------------------------------------
    // getRows
    //
    // PURPOSE: Accessor for board row count.
    // Returns: Number of rows in the board.
    //------------------------------------------------------
    @Override
    public int getRows() {
        return rows;
    }

    //------------------------------------------------------
    // getCols
    //
    // PURPOSE: Accessor for board column count.
    // Returns: Number of columns in the board.
    //------------------------------------------------------
    @Override
    public int getCols() {
        return cols;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE: Prints the entire board to System.out.
    //------------------------------------------------------
    @Override
    public void view() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }

    //------------------------------------------------------
    // reset
    //
    // PURPOSE: Reset the board to its initial state.
    //------------------------------------------------------
    public void reset() {
        initializeBoard();
    }
}