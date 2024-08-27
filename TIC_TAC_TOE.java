import java.util.Scanner;
public class TIC_TAC_TOE
{
    private static final char EMPTY =' ';
    private final char player_X = 'X';
    private final char player_O = 'O';
    private char[][] board;
    private char curr_player;

    public TIC_TAC_TOE()
    {
        board = new char[3][3];
        initializeBoard();
        curr_player = player_X;
    }

    public void initializeBoard()
    {
        for(int i=0; i<3; i++)
        {
            for(int j =0; j<3; j++ )
            {
                board[i][j] = EMPTY;
            }
        }
    }

    public void print()
    {
        for(int i=0; i<3; i++)
        {
            System.out.print(i+ " ");
            for(int j =0; j<3; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean move(int row, int col)
    {
        if(row>=0&&row<3&&col<3&&col>=0&&board[row][col]==EMPTY)
        {
            board[row][col] = curr_player;
            return true;
        }
        return false;
    }

    public boolean checkwin()
    {
        for(int i =0; i<3; i++)
        {
            if(board[i][0] == curr_player && board[i][1] == curr_player && board[i][2] == curr_player)
            {
                return true;
            }
            if(board[0][i] == curr_player && board[1][i] == curr_player && board[2][i] == curr_player)
            {
                return true;
            }
        }
        if(board[0][0] == curr_player && board[1][1] == curr_player && board[2][2] == curr_player)
            {
                return true;
            }
        if(board[0][2] == curr_player && board[1][1] == curr_player && board[2][0] == curr_player)
            {
                return true;
            }
        return false;
    }
    public boolean checkdraw()
    {
        for(int i=0;i<3;i++)
        {
            for(int j =0; j<3; j++)
            {
                if(board[i][j]==EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void change()
    {
        if(curr_player==player_X)
        {
            curr_player= player_O;
        }
        else if(curr_player==player_O)
        {
            curr_player= player_X;
        }
    }
    public void reset()
    {
        for(int i=0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                board[i][j] = EMPTY;
            }
        }
        
    }
    public void play()
    {
        Scanner in = new Scanner(System.in);
        boolean endgame= false;

        while(!endgame)
        {
            print();
            System.out.println(" Player " + curr_player + " make move (row and column)");
            int row = in.nextInt();
            int col = in.nextInt();

            if(move(row, col))
            {
                if(checkwin())
                {
                    print();
                    System.out.println("Player " + curr_player + " wins");
                    endgame = true;
                }
                else if(checkdraw())
                {
                    print();
                    System.out.println(" It's a draw");
                    endgame = true;
                }
                else
                {
                    change();
                }
            }
            else
            {
                System.out.println(" Invalid move");
            }
        }
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        TIC_TAC_TOE obj = new TIC_TAC_TOE();
        
        while(true)
        {
            System.out.println("1.Play 2.Reset 3.Exit");
            int op = in.nextInt();

            switch(op)
            {
                case 1:
                obj.play();
                break;

                case 2:
                System.out.println("resetting board...");
                obj.reset();
                break;

                case 3:
                System.out.println("GAME HAS ENDED");
                in.close();
                System.exit(0);

                default:
                System.out.println("Invalid token");
                break;
            }
        }
    }

}