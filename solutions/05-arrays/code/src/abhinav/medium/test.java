package abhinav.medium;

public class test {
  public static int binarySearch(int[] arr, int start, int end, int query){
    int avgIndex = (start+end)/2;
    while (avgIndex != start) {
      avgIndex = (start+end)/2;
      if (arr[avgIndex] == query){
        return avgIndex;
      } else if (arr[avgIndex] < query){
        start = avgIndex;
      } else {
        end = avgIndex;
      }
    }
    if (arr[start] == query){
      return start;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] list = {5,7,7};
    System.out.println(binarySearch(list, 0, list.length, 5));
  }
}
