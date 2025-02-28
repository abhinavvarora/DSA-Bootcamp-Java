package abhinav.medium;

import java.util.Arrays;

public class SpiralMatrix_III_03_Alternative {
  public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    //begin heading right
    int x = rStart;
    int y = cStart;
    int dx = 0;
    int dy = 1;
    int totalNoOfElements = rows*cols;
    int[][] output = new int[totalNoOfElements][2];
    int count = 0;
    //set up an array with ordered indices of what a right turn means
    int[][] turn = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    int currentNoOfSteps = 0;
    int limNoOfSteps = 1;
    int sameNoOfStepsCount = 0;
    int countTurns = 0;
    //loop until all indices haven't been printed
    while (count<totalNoOfElements) {
      //If index is within grid, add it to output and increase count
      if (-1<y && y<cols && -1<x && x<rows){
        output[count][0] = x;
        output[count][1] = y;
        count++;
      }
      //go forward
      y+=dy;
      x+=dx;
      //note that you've head forward
      currentNoOfSteps++;
      //if you've head forward a limited number of steps, turn
      if (currentNoOfSteps == limNoOfSteps){
        //modulo to choose the right turning direction
        dx = turn[countTurns%4][0];
        dy = turn[countTurns%4][1];
        countTurns++;
        currentNoOfSteps = 0;
        sameNoOfStepsCount++;
        //if you've head forward the same limited number of steps forward 2 times, then increase the limit by 1
        if (sameNoOfStepsCount == 2) {
          sameNoOfStepsCount = 0;
          limNoOfSteps++;
        }
      }
    }
    return output;
  }
  public static void main(String[] args) {
    int[][] result = spiralMatrixIII(3, 3, 0, 2);
    for (int[] index : result) {
      System.out.println(Arrays.toString(index));
    }
  }
}
