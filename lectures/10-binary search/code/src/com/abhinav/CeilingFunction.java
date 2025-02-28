public class CeilingFunction {
  public static int ceiling (int[] arr, int target){
    int start = 0;
    int end = arr.length;
    int middle;
    if (target >= arr[arr.length-1]){
      return Integer.MIN_VALUE;
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
    return arr[start];
  }
  public static void main(String[] args) {
    int target = 19;
    int[] arr = {2,3,5,9,14,16,18};
    //start binary searching here
    int answer = ceiling(arr, target);
    System.out.println("ceiling is " + (answer != Integer.MIN_VALUE ? answer : "not found"));
  }
}