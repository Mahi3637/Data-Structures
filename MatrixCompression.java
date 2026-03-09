import java.util.Scanner;

public class MatrixCompression {

    public static int[][] compress_matrix(int[][] mat) {
        
        int n = mat.length;  // total number of the rows that is the length of the array for example [(1,2,3), 
        //                                                                                            (4,5,6), 
        //                                                                                            (7,8,9)] which is 0,1,2 downward that is the length is 3
        
        int m = mat[0].length;  //  as a square matrix, the column has to correspond and coincide with the rows..mat[0] means the first row 0..
                               // so column will be equal to the number of elements in first row
        
        int[][] compressed = new int[n / 2][m / 2]; //Since square matrix, the compressed one will be half..row will be half, column half
        
        for (int i = 0; i < n; i += 2) { //if 4*4 matrix then the compressed is 2*2..then each row and col have 2 blocks each..first block i=0, 2nd block i+=2..iteration ocurs in each individually
                                         // that means each iteration covers 2 lines 2 blocks
            for (int j = 0; j < m; j += 2) { //same logic for the column
                
                int topLeft = mat[i][j]; // first block
                int topRight = mat[i][j + 1]; //right side of the first block which is 2nd block
                int bottomLeft = mat[i + 1][j]; // 3rd block ...below the first block
                int bottomRight = mat[i + 1][j + 1]; // 4th block, right to the 3rd
                
                int sum = topLeft + topRight + bottomLeft + bottomRight;
                
                compressed[i / 2][j / 2] = sum;
            }
        }
        
        return compressed;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter rows (even number): ");
        int rows = sc.nextInt();
        
        System.out.print("Enter columns (even number): ");
        int cols = sc.nextInt();
        
        int[][] matrix = new int[rows][cols];
        
        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int[][] result = compress_matrix(matrix);
        
        System.out.println("Compressed Matrix:");
        for (int i = 0; i < result.length; i++) { //result row
            for (int j = 0; j < result[0].length; j++) { // result col
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        
     
    }
}
