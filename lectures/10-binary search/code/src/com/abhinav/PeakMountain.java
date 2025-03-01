public class PeakMountain {
  public static int findMax(int[] arr){
    if (arr.length == 0) {
      return - 1;
    }
    int start = 0;
    int end = arr.length - 1;
    int middle = start + (end-start)/2;
    while (start != end) {
      if (arr[middle] > arr[middle+1]){
        end = middle;
      } else {
        start = middle + 1;
      }
      middle = start + (end-start)/2;
    }
    return end;
  }

  public static void main(String[] args) {
    int[] myArr = {0, 1, 0, -1};
    // System.out.println(binarySearch(myArr, 5));
    System.out.println(findMax(myArr));
  }
}
