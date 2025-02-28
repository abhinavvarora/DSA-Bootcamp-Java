import java.util.ArrayList;

public class SpiralMatrix01 {
  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int row = 0;
    int col = 0;
    int changeInRows = 0;
    int changeInCols = 1;
    int noOfRows = matrix.length;
    int noOfCols = matrix[0].length;
    int totalNoOfElements = noOfRows * noOfCols;
    ArrayList<Integer> output = new ArrayList<>(totalNoOfElements);
    for (int i = 0; i < totalNoOfElements; i++){
      output.add(matrix[row][col]);
      matrix[row][col] = -101;

      if (row + changeInRows == noOfRows || row + changeInRows < 0 || col + changeInCols == noOfCols || col + changeInCols < 0 || matrix[row+changeInRows][col+changeInCols] == -101) {
        int temp = changeInCols;
        changeInCols = -changeInRows;
        changeInRows = temp;
      }

      col += changeInCols;
      row += changeInRows;
    }
    System.out.println(output);
  }
}
