public class Main {
  
  public static void main(String[] args) {
    int n = 123540;
    int rem;
    int product = 1; 
    int sum = 0;
    while (n != 0) {
        rem = n % 10;
        product *= rem;
        sum += rem;
        n /= 10;
    }
    System.out.println(product - sum);
  }
}
