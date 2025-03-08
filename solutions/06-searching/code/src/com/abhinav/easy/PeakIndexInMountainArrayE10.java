public class PeakIndexInMountainArrayE10 {
  public static int peakIndexInMountainArray(int[] arr) {
    int start = 1;
    int end = arr.length - 2;
    int middle;

    while (start <= end){
      middle = start + (end - start) / 2;
      
      if (arr[middle] > arr [middle - 1] && arr[middle] > arr[middle + 1]){
        return middle;
      }
      //middle could be larger than its previous value, indicating it's on the increasing side
      if (arr[middle - 1] < arr[middle]){
        start = middle + 1;
      } 
      //middle could be smaller than its previous value, indicating it's on the decreasing side
      else if (arr[middle - 1] > arr[middle]){
        end = middle - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {0,2,1,0};
    System.out.println(peakIndexInMountainArray(nums));
  }
}
