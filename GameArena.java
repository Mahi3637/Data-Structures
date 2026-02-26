import java.util.Scanner;

public class GameArena {

    public static String gameResult(int[][] arena) {

        int rows = arena.length;
        int cols = arena[0].length;
        int totalPoints = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (arena[i][j] != 0 && arena[i][j] % 50 == 0) {

                    int count2 = 0;

                    if (i - 1 >= 0) {
                        if (arena[i - 1][j] == 2) {
                            count2++;
                        }
                    }
                    if (i + 1 < rows) {
                        if (arena[i + 1][j] == 2) count2++;
                    }
                    if (j - 1 >= 0 && arena[i][j - 1] == 2) {
                        count2++;
                    }
                    if (j + 1 < cols && arena[i][j + 1] == 2) count2++;

                    int pointsEarned = count2 * count2;
                    totalPoints += pointsEarned;
                }
            }
        }

        String message;
        if (totalPoints >= 10) {
            message = "Points Gained: " + totalPoints + ". Your team has survived the game.";
        } else {
            message = "Points Gained: " + totalPoints + ". Your team is out.";
        }
        return message;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] arena = new int[rows][cols];

        System.out.println("Enter arena matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arena[i][j] = sc.nextInt();
            }
        }

        String result = gameResult(arena);
        System.out.println(result);

        sc.close();
    }
}