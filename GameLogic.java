//-----------------------------------------
// CLASS: GameLogic
//
// Author: Felix Vo, 7924848
//
// REMARKS: Handles game rules, state transitions, and player interactions.
//          Manages score and game over conditions.
//-----------------------------------------
import java.util.Scanner;

public class GameLogic implements GameLogical {
    // Data Members
    private GameBoard board;          // Reference to the game board
    private MovementHandler movementHandler; // Handles move validation/execution
    private int score;                // Current player score
    private boolean gameOver;         // Game state flag
    private Player player;             // Player instance
    private Scanner scanner;           // Input handler (unused in final implementation)

    //------------------------------------------------------
    // GameLogic (Constructor)
    //
    // PURPOSE: Create a game logic handler with default settings.
    //------------------------------------------------------
    public GameLogic() {
        this.board = null;
        this.movementHandler = null;
        this.score = 0;
        this.gameOver = false;
        this.scanner = new Scanner(System.in);
    }

    //------------------------------------------------------
    // GameLogic (Overloaded Constructor)
    //
    // PURPOSE: Create a game logic handler linked to a specific board.
    // PARAMETERS:
    //   board : Game board to operate on
    //------------------------------------------------------
    public GameLogic(GameBoard board) {
        this.board = board;
        this.movementHandler = new MovementHandler(board);
        this.score = 0;
        this.gameOver = false;
        this.scanner = new Scanner(System.in);
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE: Display current score to the player.
    //------------------------------------------------------
    @Override
    public void view() {
        System.out.println("Player score: " + score);
    }

    //------------------------------------------------------
    // nextState
    //
    // PURPOSE: Process player input, validate moves, and update game state.
    // PARAMETERS:
    //   v : Viewable component (unused here)
    // Returns: false if exiting to menu, true to continue game.
    //------------------------------------------------------
    @Override
    public boolean nextState(Viewable v) {
        if (gameOver) return false;

        int choice;
        System.out.print("Enter move option (0 to give up): ");

        // Handle game-over scenario
        if (movementHandler.checkGameOver()) {
            System.out.print("No more moves, give up: ");
            try {
                choice = player.chooseMove();
                if (choice == 0) {
                    gameOver = true;
                    return false;
                } else {
                    System.out.println("Invalid move. Try again.");
                    return true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                return true;
            }
        }

        // Process valid input
        try {
            choice = player.chooseMove();
            if (choice == 0) {
                gameOver = true;
                return false;
            } else if (choice < 1 || choice > 9 || choice == 5) {
                System.out.println("Invalid move. Try again.");
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");
            return true;
        }

        // Execute move and update score
        int scoreGained = movementHandler.processMove(choice);
        if (scoreGained > 0) {
            score += scoreGained;
        }
        return true;
    }

    //------------------------------------------------------
    // reset
    //
    // PURPOSE: Reset game state for a new session.
    //------------------------------------------------------
    @Override
    public void reset() {
        score = 0;
        gameOver = false;
        movementHandler.findPlayerPos();
    }

    //------------------------------------------------------
    // setBoard
    //
    // PURPOSE: Link a new game board to this logic handler.
    // PARAMETERS:
    //   board : Game board instance
    //------------------------------------------------------
    public void setBoard(GameBoard board) {
        this.board = board;
        this.movementHandler = new MovementHandler(board);
    }

    //------------------------------------------------------
    // setPlayer
    //
    // PURPOSE: Assign a player to interact with the game.
    // PARAMETERS:
    //   player : Player instance
    //------------------------------------------------------
    public void setPlayer(Player player) {
        this.player = player;
    }
}