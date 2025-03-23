public interface GameBoardable extends Viewable {
    void initializeBoard();
    void updateBoard(int row, int col, char symbol);
    char getCell(int row, int col);
    int getRows();
    int getCols();
}
