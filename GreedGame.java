public class GreedGame extends Game {
    public GreedGame() {
        super(new GameLogic(), new GameBoard(), new Menu());
        setupGame();
    }
    private void setupGame(){
        Menu menu = super.getMenu();
        GameBoard board = super.getBoard();
        GameLogic game = super.getLogic();

        menu.addMenuItem(new MenuItem("Start Game", () -> menu.setMessage("Game Starting...")));
        menu.addMenuItem(new MenuItem("Quit", () -> System.exit(0)));
        game.setBoard(board);
    }
}
