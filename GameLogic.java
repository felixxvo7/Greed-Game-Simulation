import java.util.Scanner;

public class GameLogic implements GameLogical{
    private GameBoard board;
    private int score;
    private boolean gameOver;
    private boolean returnToMenu;
    private Scanner scanner = new Scanner(System.in);

    public GameLogic()
    {
        this.board = null;
        this.score = 0;
        this.gameOver = false;
    }
    public GameLogic(GameBoard board)
    {
        this.board = board;
        this.score = 0;
        this.gameOver = false;
    }
    @Override
    public void view() {
        System.out.println("Player score: " + score);
    }

    @Override
    public boolean nextState(Viewable v) {

        if (gameOver) return false;

        System.out.print("Enter move option (0 to give up): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                returnToMenu = true;
                return false; // Exit to menu
            } else if (choice < 1 || choice > 9 || choice == 5) {
                System.out.println("Invalid move. Try again.");
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");
            return true;
        }
        view();
        v.view();

        return true;
    }

    @Override
    public void reset() {
        score = 0;
        gameOver = false;
    }
    public void setGameOver(boolean state) {
        gameOver = state;
    }

    public void setBoard(GameBoard board){
        this.board = board;
    }
    
}
