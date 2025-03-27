//-----------------------------------------
// NAME        : Felix Vo
// STUDENT NUMBER : 7924848
// COURSE      : COMP 2150
// INSTRUCTOR  : Heather Matheson
// ASSIGNMENT  : Assignment 3
// QUESTION    : N/A
// 
// REMARKS: Entry point for the Greed game. Initializes and launches
//          the game instance.
//
//-----------------------------------------
import java.util.Scanner;

public abstract class Game implements RunnableGame {
        //Variables
        private GameLogic game;
        private GameBoard board;
        private Menu menu;
        private boolean isGamemode;
        //Constructor
        Game(GameLogic gl, GameBoard gb, Menu m){
            game = gl;
            board = gb;
            menu = m;
        }
    //------------------------------------------------------
    // run
    //
    // PURPOSE: Main game loop. Switches between menu and game modes,
    //          updating states and resetting components as needed.
    //------------------------------------------------------
        @Override
        public void run() {
            while (true) {
                menu.view();
                isGamemode = menu.nextState(menu);
                while ( isGamemode ) {
                    game.view();
                    board.view();   
                    isGamemode = game.nextState(board);
                }
                menu.setMessage("Welcome back!");
                menu.reset();
                board.reset();
                game.reset();
            }
        }
        public Menu getMenu()
        {
            return menu;
        }
        public GameBoard getBoard()
        {
            return board;
        }
        public GameLogic getLogic()
        {
            return game;
        }
}
