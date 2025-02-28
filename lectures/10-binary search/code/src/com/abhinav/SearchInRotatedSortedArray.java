public class SearchInRotatedSortedArray {
  public static int findPivot(int[] arr){
    int start, end, middle;
    start = 0;
    end = arr.length;
    while (true){
      middle = start + (end-start)/2;
      if (arr[middle]<arr[middle-1]){
        return middle-1;
      } else if (arr[end-1] < arr[middle]){
        start = middle + 1;
      } else {
        end = middle;
      }
    }
  }

  public static int binarySearch(int target, int[] nums, int start, int end){
    int middle = start + (end-start)/2;
    while (start != end){
      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        end = middle;
      } else {
        start = middle + 1;
      }
      middle = start + (end-start)/2;
    }
    return -1;`
  }

  public static void main(String[] args) {
    //My ideas
    //1. Make it into a normal sorted array, then binary search
    //2. Figure out the pivot, search ahead from there and use a remainder operation to wrap around
    
    //Kunal's idea: Find the pivot
    //1. How to find the pivot? Check if middle is pivot
    //2. Check if middle is bigger than end. If so, the pivot must lie in between, so examine the array ahead of that middle point. Else pivot must lie before that middle point.
    
    int target = 8;
    int[] arr = {9,10,11,1,5,6,7,8};  
    int pivot = findPivot(arr);
    //now just check to the left first, else check right
    int checkLeft = binarySearch(target, arr, 0, pivot + 1);
    if (checkLeft != -1){
      System.out.println(checkLeft);
    } else {
      int checkRight = binarySearch(target, arr, pivot + 1, arr.length);
      if (checkRight != -1){
        System.out.println(checkRight);
      } else {
        System.out.println("target not found");
      }
    }

  }
}
