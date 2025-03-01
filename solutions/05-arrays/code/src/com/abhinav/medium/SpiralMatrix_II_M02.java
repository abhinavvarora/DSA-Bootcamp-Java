package abhinav.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMatrix_II_02 {
  public static void main(String[] args) {
    int n = 3;
    int[][] matrix = new int[n][n];

    //make every element be -1.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = -1;
      }
    }

    //traverse the matrix using x and y
    int x = 0;
    int y = 0;
    int dx = 1;
    int dy = 0;
    int count = 1;

    for (int i = 0; i < n*n; i++) {
      matrix[y][x] = count;
      count += 1;

      //change direction of traversal if the next step will step into invalid territory
      if ( 0 > x + dx || x + dx >= n ||  0 > y + dy || y + dy >= n || matrix[y+dy][x+dx] != -1){
        int temp = dx;
        dx= -dy;
        dy=temp;
      }

      x += dx;
      y += dy;
    }

    //print the output
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }
}
