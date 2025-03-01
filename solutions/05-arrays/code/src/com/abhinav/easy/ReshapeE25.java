import java.util.Arrays;

class Reshape25 {
  public static void main(String[] args) {
    int[][] mat = {{1,2},{3,4}};
    int r = 2;
    int c = 4;
    int noOfElementsInArr = 0;
    for (int[] arr : mat){
      noOfElementsInArr += arr.length;
    }
    int totalNumbers = r*c;
    if (totalNumbers != noOfElementsInArr){
      for (int[] row : mat){
        System.out.println(Arrays.toString(row));
      }
    }
    int[][] output = new int[r][c];
    int rowCount = 0;
    int colCount = 0;
    for (int[] row : mat){
      for (int element : row){
        output[rowCount][colCount] = element;
        colCount++;
        if (colCount == c){
          colCount = 0;
          rowCount++;
        }
      }
    }
    for (int[] row : output){
      System.out.println(Arrays.toString(row));
    }
  }
}