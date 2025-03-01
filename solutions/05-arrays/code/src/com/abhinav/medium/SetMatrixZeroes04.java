package abhinav.medium;
import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes04 {
  public static void setZeroes(int[][] matrix){
    ArrayList<Integer> markedRows = new ArrayList<>(3);
    ArrayList<Integer> markedCols = new ArrayList<>(3);

    //identify all the rows and columns to mark for conversion to zero
    for (int i = 0; i < matrix.length; i++){
      for (int j = 0; j < matrix[0].length; j++){
        if (matrix[i][j] == 0){
          //mark the row and column
          markedRows.add(i);
          markedCols.add(j);
        }
      }
    }

    //remove duplicates from the marked rows and columns
    for (int i = 0; i < markedRows.size(); i++){
      for (int j = i+1; j < markedRows.size(); j++) {
        if (markedRows.get(j) == markedRows.get(i)){
          markedRows.remove(j);
        }
      }
    }
    for (int i = 0; i < markedCols.size(); i++){
      for (int j = i+1; j < markedCols.size(); j++) {
        if (markedCols.get(j) == markedCols.get(i)){
          markedCols.remove(j);
        }
      }
    }

    //turn marked rows and columns to zero
    for (int row : markedRows) {
      for (int index = 0; index < matrix[row].length; index++) {
        matrix[row][index] = 0;
      }
    }
    for (int col : markedCols) {
      for (int index = 0; index < matrix.length; index++) {
        matrix[index][col] = 0;
      }
    }
  }
  public static void main(String[] args) {
    int[][] realMatrix = {{1,1,1}, {1,0,1}, {1,1,1}};
    setZeroes(realMatrix);
    for (int[] is : realMatrix) {
      System.out.println(Arrays.toString(is));
    }
  }
}
