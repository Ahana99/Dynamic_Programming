class GfG {
  
    // Function to calculate the nth Fibonacci number using
    // recursion
    static int nthFibonacci(int n, int[] arr){
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }
      if(arr[n]!=0){
        return arr[n];
      }
        // Recursive case: sum of the two preceding
        // Fibonacci numbers
      int sum = nthFibonacci(n - 1,arr) + nthFibonacci(n - 2,arr);
      arr[n]=sum;
        return sum;
    }

    public static void main(String[] args){
        int n = 5;
        int result = nthFibonacci(n, new int[n+1]);
        System.out.println(result);
    }
}