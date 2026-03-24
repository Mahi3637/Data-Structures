import java.util.Scanner;

public class Rotate{

       public static char[][] rotateOnce(char[][] board) {

        int n = board.length;
        char[][] newBoard = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                newBoard[j][n - 1 - i] = board[i][j];

            }
        }

        return newBoard;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of square matrix (N): ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        System.out.println("Enter board characters:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

       
        for (int i = 1; i <= layers; i++) {

           
            for (int r = 0; r < i; r++) {
                board = rotateOnce(board);
            }
        }

       
        System.out.println("Recovered message:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
        }

      
    }
}