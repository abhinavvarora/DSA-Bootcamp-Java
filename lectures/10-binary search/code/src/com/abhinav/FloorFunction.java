public class FloorFunction {
  public static int floor (int[] arr, int target){
    int start = 0;
    int end = arr.length;
    int middle;
    if (target < arr[0]) {
      return Integer.MAX_VALUE;
    }
    while (start!=end){
      middle = start + (end-start)/2;
      if (arr[middle] == target){
        return target;
      } else if (arr[middle] > target){
        end = middle;
      } else {
        start = middle+1;
      }
    }
    return arr[end-1];
  }
  public static void main(String[] args) {
    int target = 3;
    int[] arr = {2,3,5,9,14,16,18};
    //start binary searching here
    int answer = floor(arr, target);
    System.out.println("floor is " + (answer != Integer.MAX_VALUE ? answer : "not found"));
  }
}