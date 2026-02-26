import java.util.Scanner;

public class rowRotation {

    public static int row_rotation(int exam_week, String[][] seat_status) {

        int rows = seat_status.length;
        int cols = seat_status[0].length;

        int currentRow = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seat_status[i][j].equals("AA")) {
                    currentRow = i;
                    break;
                }
            }
        }

        int newRow = (currentRow + (exam_week - 1)) % rows;
        return newRow + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        String[][] seat_status = new String[rows][cols];

        System.out.println("Enter seat matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seat_status[i][j] = sc.next();
            }
        }

        System.out.print("Enter exam week: ");
        int exam_week = sc.nextInt();

        int result = row_rotation(exam_week, seat_status);

        System.out.println("AA will be on row: " + result);

        sc.close();
    }
}