//-----------------------------------------
// CLASS: GreedGame
//
// Author: Felix Vo, 7924848
//
// REMARKS: Concrete implementation of the Greed game. Initializes game-specific
//          components (player, menu items) and configures interactions.
//-----------------------------------------
public class GreedGame extends Game {
    private Player player;

    //------------------------------------------------------
    // GreedGame (Constructor)
    //
    // PURPOSE: Initialize Greed game with logic, board, menu, and player.
    //------------------------------------------------------
    public GreedGame() {
        super(new GameLogic(), new GameBoard(), new Menu());
        this.player = new HumanPlayer(); // Fix: Removed extra space
        setupGame();
    }

    //------------------------------------------------------
    // setupGame
    //
    // PURPOSE: Configure menu items and link game components (logic, board, player).
    //------------------------------------------------------
    private void setupGame() {
        Menu menu = super.getMenu();
        GameBoard board = super.getBoard();
        GameLogic game = super.getLogic();

        // Add menu options
        menu.addMenuItem(new MenuItem("Start Game", () -> menu.setMessage("Game Starting...")));
        menu.addMenuItem(new MenuItem("Quit", () -> System.exit(0)));

        // Link components
        game.setBoard(board);
        game.setPlayer(player);
        menu.setPlayer(player);
    }
}