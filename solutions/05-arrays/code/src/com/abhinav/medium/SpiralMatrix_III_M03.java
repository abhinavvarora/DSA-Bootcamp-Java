package abhinav.medium;

import java.util.Arrays;
import java.util.ArrayList;

public class SpiralMatrix_III_03 {
  public static void main(String[] args) {
    //variables to set up the matrix
    int rows = 3;
    int cols = 3;
    int[][] matrix = new int[rows][cols];
    //set up the matrix
    int count = 1;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = count;
        count++;
      }
    }
    int rStart = 0;
    int cStart = 2;
    int totalNoOfElements = rows*cols;
    int[][] output = new int[totalNoOfElements][2];
    //variables to traverse the matrix
    int x = cStart;
    int y = rStart;
    int dx = 1;
    int dy = 0;
    //ensuring that it loops as many times as needed to cover all the elements
    count = 0;
    while (count<totalNoOfElements){
      //if the index is inside the range of the grid, increase count
      if (0<=x && x<cols && 0<=y && y<rows){
        //only add the coordinates to output when row and column are within the boundaries
        output[count][0] = y;
        output[count][1] = x;
        count += 1;
        matrix[y][x] = -101;
      }

      if (count>1) {
        //condition to change direction of traversal
        int dx2 = -dy;
        int dy2 = dx;
        if (0<=x+dx2 && x+dx2<cols && 0<=y+dy2 && y+dy2<rows){
          if (matrix[y+dy2][x+dx2] != -101){
            dx = dx2;
            dy = dy2;
          }
        } else {
          dx = dx2;
          dy = dy2;
        }
      }
      x += dx;
      y += dy;
    }
    for (int[] arr : output) {
      System.out.println(Arrays.toString(arr));
    }
  }
}
