public class RightSearchInBitonicArray {
  public static int findPeak(int[] arr){
    int start = 0;
    int end = arr.length - 1;
    int middle = start + (end-start)/2;
    if (arr.length == 0) {
      return - 1;
    }
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

  public static int orderAgnosticBinarySearch(int target, int[] nums, int start, int end, boolean isAsc){
    int middle = start + (end-start)/2;
    while (start != end){
      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        if (isAsc){
          end = middle;
        } else {
          start = middle + 1;
        }
      } else {
        if (isAsc){
          start = middle + 1;
        } else {
          end = middle;
        }
      }
      middle = start + (end-start)/2;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] myArr = {1,5,1,0};
    int target = 0;

    int peak = findPeak(myArr);
    int firstTry = orderAgnosticBinarySearch(target, myArr, 0, peak + 1, true);
    if (firstTry != -1){
      System.out.println(firstTry);
    } else {
      int secondTry = orderAgnosticBinarySearch(target, myArr, peak + 1, myArr.length, false);
      if (secondTry != -1){
        System.out.println(secondTry);
      } else {
        System.out.println("not found");
      }
    }
  }
}
