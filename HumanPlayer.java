//-----------------------------------------
// CLASS: HumanPlayer
//
// Author: Felix Vo, 7924848
//
// REMARKS: Handles move selection for a human player via console input.
//-----------------------------------------
import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner scanner;
    private List<Integer> availableMoves;
    private int score;

    //------------------------------------------------------
    // HumanPlayer (Constructor)
    //
    // PURPOSE: Initializes the input scanner.
    //------------------------------------------------------
    public HumanPlayer() {
        this.scanner = new Scanner(System.in);
    }
    
     //------------------------------------------------------
    // chooseMove
    //
    // PURPOSE: Prompts the player for input and validates it.
    // Returns: Validated move choice (0-9).
    // Throws: NumberFormatException if input is non-numeric.
    //------------------------------------------------------
    @Override
    public int chooseMove() {
        return  Integer.parseInt(scanner.nextLine());
    }

    //------------------------------------------------------
    // updateMoves
    //
    // PURPOSE: Updates the list of currently valid moves.
    // PARAMETERS:
    //   newSet (List<Integer>) : Updated list of valid moves
    //------------------------------------------------------
    public void updateMoves(List<Integer> newSet){
        this.availableMoves = newSet;
    }
    //------------------------------------------------------
    // proceedMove
    //
    // PURPOSE: Handles full move selection flow including validation.
    // Returns: true if game should continue, false if quitt
    //------------------------------------------------------
    public boolean proceedMove(){
        int choice;
        System.out.print("Enter move option (0 to give up): ");
        if (availableMoves.isEmpty()) {
            System.out.print("No more moves, give up :");

            try {
                choice = chooseMove();;
                if (choice == 0) {
                    return false; // Exit to menu
                } else if (choice != 0) {
                    System.out.println("Invalid move. Try again.");
                    return true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                System.out.print("No more moves, give up :");
                return true;
            }
            return false;

        }
        else
        {
            try {
                choice = chooseMove();
                if (choice == 0) {
                    return false;
                } else if (choice < 1 || choice > 9 || choice == 5) {
                    System.out.println("Invalid move. Try again.");
                    return true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                return true;
            }

        }

        return true;
    }
}
