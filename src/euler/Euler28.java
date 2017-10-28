package euler;

import java.util.Arrays;

/**
 * @author Konstantin Labun
 */
public class Euler28 {

    public static void main(String[] args) {
        int MAX_SIZE = 1001;
        int[][] matrix = createSpiritalMatrix(MAX_SIZE);

        int center = MAX_SIZE / 2;
        int sum = matrix[center][center];
        for (int i = 0; i < MAX_SIZE; i++) {
            if(i==center) continue;
            sum += matrix[i][i];
            sum += matrix[i][MAX_SIZE-i - 1];
        }
        System.out.println(sum);
    }

    private static int[][] createSpiritalMatrix(int MAX_SIZE) {
        int center = MAX_SIZE / 2 + 1;
        int y = center;
        int x = center;
        int size = 1;
        int[][] matrix = new int[MAX_SIZE][MAX_SIZE];
        int counter = 1;
        while (size <= MAX_SIZE) {
            while (x < center + size/2) {
                matrix[y-1][x-1] = counter++;
                x++;
            }
            while (y < center + size / 2) {
                matrix[y-1][x-1] = counter++;
                y++;
            }
            while (x > center - size/2) {
                matrix[y-1][x-1] = counter++;
                x--;
            }
            while (y > center - size/2) {
                matrix[y-1][x-1] = counter++;
                y--;
            }

            size += 2;
        }
        while (x < center + size/2) {
            matrix[y-1][x-1] = counter++;
            x++;
        }
        return matrix;
    }
}
