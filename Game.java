import java.util.Random;
import java.util.Scanner;

public class Game {

    private int[][] board;

    private int boardSize;

    public int SetStartMode()
    {
        var scanner = new Scanner(System.in);
        System.out.println("Caso deseje selecionar o setup inicial do jogo, digite 1");
        System.out.println("Caso contrario, para inciar de forma randomica, digite 0");
        var mode = scanner.nextInt();

        return mode;
    }

    public int GetNumeroDeCasasASelecionar()
    {
        var scanner = new Scanner(System.in);
        System.out.println("digite quantos numeros deseja marcar pra inicar o jogo");
        var aux = scanner.nextInt();

        return aux;
    }

    public void SetInitialPoints(int totalInput)
    {
        var scanner = new Scanner(System.in);

        for(int i = 0; i< totalInput; i++)
        {
            System.out.println("entre com a coodernada x do " + i + " numero de entrada");
            int x = scanner.nextInt();
            System.out.println("entre com a coodernada y do " + i + " numero de entrada");
            int y = scanner.nextInt();

            try
            {
                var aux = board[x][y];
            }
            catch (Exception e)
            {
                System.out.println("posicoes invalidas.Tente novamente");
                i--;
                continue;
            }
            board[x][y] = 1;
        }
    }

    public void SetGridSize()
    {
        var scanner = new Scanner(System.in);

        System.out.println("Insira o tamanho do tabuleiro desejado.");
        var aux = scanner.nextInt();

        this.boardSize = aux;

    }

    public void SetBoard() {
        this.board = new int[boardSize][boardSize];
        for(int i =0 ; i < this.boardSize; i++)
        {
            for(int j = 0; j < this.boardSize; j++)
            {
                this.board[i][j] = 0;
            }
        }
    }

    public void PopulateBoardRandom()
    {
        var rand = new Random();
        for(int i = 0; i < this.boardSize; i++)
        {
            for(int j =0; j < this.boardSize; j++)
            {
                this.board[i][j] = (rand.nextInt() > 0.5) ? 1 : 0;
            }
        }
    }

    public void play()
    {
        for(int i =0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
            {
                int vizinhos = getVizinhos(i,j);
                if(board[i][j] == 1 && (vizinhos < 2 || vizinhos > 3))
                    board[i][j] = 0;
                if(board[i][j] == 0 && vizinhos == 3)
                    board[i][j] = 1;
            }
        }
    }

    private int getVizinhos(int i, int j){ //alive
        int total = 0; //
        if(i>0 && (board[i-1][j] == 1 || board[i-1][j] == 3)) total++;
        if(i < board.length-1 && (board[i+1][j] == 1 || board[i+1][j] == 3)) total++;
        if(j>0 && (board[i][j-1] == 1 || board[i][j-1] == 3)) total++;
        if(j < board[0].length-1 && (board[i][j+1] == 1 || board[i][j+1] == 3)) total++;
        if(i>0 && j>0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == 3)) total++; //diagonal
        if(i<board.length-1 && j<board[0].length-1 && (board[i+1][j+1] == 1 || board[i+1][j+1] == 3)) total++;
        if(i>0 && j<board[0].length-1 && (board[i-1][j+1] == 1 || board[i-1][j+1] == 3)) total++;
        if(i<board.length-1 && j>0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == 3)) total++;
        return total;
    }

    public void PrintBoard()
    {
        for(int i = 0; i < this.boardSize; i++)
        {
            for(int j = 0; j < this.boardSize; j++)
            {
                if(this.board[i][j] == 1)
                {
                    System.out.print(" 🙂 ");
                }
                else
                {
                    System.out.print(" 💀 ");
                }
            }
            System.out.println("");
        }
        System.out.println("---------");
    }



}
