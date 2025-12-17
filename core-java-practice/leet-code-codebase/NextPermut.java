import java.util.Scanner;

public class NextPermut {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Taking size of array as Input from user
    System.out.printf("Enter the size of an array : ");
    int n = sc.nextInt();

    int[] nums = new int[n];

    // Taking array's elements as input
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    // Calling logic of Next Permutation by creating an object
    NextPermut obj = new NextPermut();
    obj.solve(nums, n);

    // Print result
    System.out.println("Next Permutation:");
    for (int x : nums) {
      System.out.print(x + " ");
    }

  }

  // This method will generate the next permutation of array 
  public void solve(int[] nums, int n) {

    // Step 1: Finding the first right index where nums[i] > nums[i-1]

    int idx = -1;
    for (int i = n - 1; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        idx = i - 1;
        break; // breaking point
      }
    }

    // If we found any such index , swapping will be done
    if (idx != -1) {

      // Step 2: finding the first right element which is greater than nums[idx] element
      int swap_idx = idx;
      for (int j = n - 1; j >= idx + 1; j--) {
        if (nums[j] > nums[idx]) {
          swap_idx = j;
          break;
        }
      }

      // Step 3: swap both elements
      int a = nums[idx];
      nums[idx] = nums[swap_idx];
      nums[swap_idx] = a;
    }

    // Step 4: reverse array from indices idx + 1 to till last n-1 
    // so that smallest possible permutation can be found
    reverse(nums, idx + 1, n - 1);
  }

  // This helper method will reverse one part of an array
  private void reverse(int[] nums, int start, int end) {
    
    // swap elemets till start < end
    while (start <= end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      end--;
      start++;
    }
  }

}
