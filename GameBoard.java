import java.util.Random;

public class GameBoard implements GameBoardable {
    private char[][] board;
    private int rows, cols;
    private int playerRows, playerCols;

    public GameBoard()
    {
        this.rows = 20;
        this.cols = 80;
        this.board = new char[rows][cols];
        initializeBoard();
    }   
    public GameBoard(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        initializeBoard();
    }    

    @Override
    public void initializeBoard() 
    {
       Random rand = new Random();
       for (int r = 0; r < rows; r++)
       {
            for( int c = 0; c < cols; c++)
            {
                board[r][c] = (char)('1' + rand.nextInt(9));
            }
       }

       playerCols = cols/2;
       playerRows = rows/2;
       board[playerRows][playerCols] = '@';
    }

    @Override
    public void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    @Override
    public char getCell(int row, int col) {
       if(row >= 0 && row < rows && col >= 0 && col < cols)
       {
            return board[row][col];
       }
       return ' ';
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public void view() {
        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }

    public void reset() {
        initializeBoard(); 
    }
}
