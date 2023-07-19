import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CodeChallenges {

  public static List<Integer> breakingRecords(List<Integer> scores) {
        int minScore = scores.get(0);
        int maxScore = scores.get(0);
        int minScoreTally = 0;
        int maxScoreTally = 0;
        List<Integer> recordArray = new ArrayList<>(List.of(0,0));
        
        for(int score: scores) {
            if(score < minScore){
                minScore = score; 
                minScoreTally++;  
            } 
            if(score > maxScore){
                maxScore = score; 
                maxScoreTally++;
            }
        }
        
        recordArray.set(0, minScoreTally);
        recordArray.set(1, maxScoreTally);
        
        return recordArray;
    }

  public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    List<Integer> appleDistances = new ArrayList<>();
    List<Integer> orangeDistances = new ArrayList<>();
    int appleCount = 0;
    int orangeCount = 0;

    for (int apple : apples) {
        int newDistance = apple + a;
        appleDistances.add(newDistance);
    }

    for (int orange : oranges) {
        int newDistance = orange + b;
        orangeDistances.add(newDistance);
    }

    for (int num : appleDistances) {
        if (num >= s && num <= t) {
            appleCount++;
        }
    }

    for (int num : orangeDistances) {
        if (num >= s && num <= t) {
            orangeCount++;
        }
    }

    System.out.println(appleCount);
    System.out.println(orangeCount);
}


  public static int waysToSplitAnArray(int[] nums){
    // initialize answer variable
    // initialize left section variable
    // initialize total variable

    // add all nums to the total 

    // loop through the nums array
    // add nums at index to the left section 
    // calculate the right section as total minus left section
    // check if the left section is greater than or equal to the right section
    // if so increment the answer variable

    // return the answer 

    int answer = 0;
    int leftSection = 0;
    int total = 0;

    for(int num: nums){
      total += num; 
    }

    for(int i = 0; i < nums.length - 1; i++){
      leftSection = nums[i];
      int rightSection = total - leftSection;
      if(leftSection >= rightSection){
        answer ++; 
      }
    }

    return answer; 
  }


  public static void minMaxSum(List<Integer> arr){
    int minSum = 0;
    int maxSum = 0;

    Collections.sort(arr);

    for(int i = 0; i < arr.size() - 1; i++){
      int value = arr.get(i);
      minSum += value;
    }

    maxSum = minSum - arr.get(0) + arr.get(arr.size() - 1);

    System.out.println("The minimum sum is " + minSum + " and the maximum sum is " + maxSum);

  }



  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b){
    
    List<Integer> aliceScores = a;
    List<Integer> bobScores = b; 
    List<Integer> totals = new ArrayList<>(List.of(0, 0));

    for(int i = 0; i < a.size(); i++){
      if(aliceScores.get(i) > bobScores.get(i)){
         int value = totals.get(0);
         value ++; 
         totals.set(0, value);
      } else {
        int value = totals.get(1);
        value ++; 
        totals.set(1, value);
      }
    }

    return totals;

  }

  public static int diagonalDifference(List<List<Integer>> arr) {
    int diagonalOne = 0;
    int diagonalTwo = 0;
    int index = 0;
    int negIndex = arr.size() - 1; 
    
    while(index < arr.size()){
        diagonalOne += arr.get(index).get(index);
        diagonalTwo += arr.get(index).get(negIndex);
        index ++;
        negIndex --; 
    }
    
    return Math.abs(diagonalOne - diagonalTwo); 
  }
  
  public static int LonelyInteger(List<Integer> arr){

    HashSet<Integer> set = new HashSet<>();
    
    for(Integer num: arr){
      if(set.contains(num)){
        set.remove(num);
      } else {
        set.add(num);
      }
    }

    return set.iterator().next();
  }

  public static String pangram(String sentence){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    sentence = sentence.toLowerCase();
    for(char c: alphabet.toCharArray()){
      if(sentence.indexOf(c) == -1){
        return "not pangram";
      }
    }
    return "pangram";
  }

  public static int[] countingSort(int[] arr){
    int[] frequencyArr = new int[100];
    for(int i = 0; i < arr.length; i++){
      int numValue = arr[i];
      frequencyArr[numValue] ++;
    }
    return frequencyArr; 
  }

  public static int[] createArrayFrom1To100() {
    int[] arr = new int[100];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = i;
    }
    return arr;
  }

  public int findLength(int[] nums, int k) {
    //initialize let pointer
    int left = 0;
    //initialize current sum 
    int current = 0; 
    //intialize answer
    int answer = 0;

    //loop through nums initialize right to 0, instead of i
    for(int right = 0; right < nums.length; right++){
      //add nums at the right index to current sum 
      current += nums[right];
      //while current is greater than k
      while(current > k){
        //subtract nums at left index from current
        current -= nums[left];
        //increment left
        left++;
      }
      //assign answer to the maximum value of answer and the length of the window
      answer = Math.max(answer, left - right + 1);
    }
    //return the answer 
    return answer; 
  }

    public boolean[] answersQueries(int[] nums, int[][] queries, int limit){
      // create a prefix array for our prefix sums
      int[] prefix = new int[nums.length];
      // set the first element to 0
      prefix[0] = 0;
      // iterate over the prefix array from the first element 
      // and add the next sum in the sequence
      for(int i = 1; i < nums.length; i++){
        prefix[i] = nums[i] + prefix[i - 1];
      }

      // create an ans boolean array of equal size to the queries array
      boolean[] answer = new boolean[queries.length];
      // iterate over the length of the queries array 
      for(int i = 0; i < queries.length; i++){
      // set int x to queries at the index at 0
      int x = queries[i][0];
      // set int y to the queries at the index at 1
      int y = queries[i][1];
      // define and set a current variable to the value of 
      // prefix at y minus prefix x + nums at x 
      int current = prefix[y] - prefix[x] + nums[x];
       // set the ans array at the current index to the result of 
      // is current less than the limit
      answer[i] = current < limit; 
      }
      // return the answer 
      return answer; 
    }

    public double findMaxAverage(int[] nums, int k) {
//         declare curr variable to hold the current value
        int curr = 0; 

//         iterate over the first four elements of nums array to get curr 
        for(int i = 0; i < k; i++){
            curr += nums[i];
        }
//         declare a variable of ans to hold the current 
        double maxAverage = (double) curr/k;; 
//         iterate over the nums array using k as the starting index 
        for(int i = k; i < nums.length; i++){
//         add the current index minus the array at the current index minus k 
            curr += nums[i] - nums[i - k];
            double average = (double) curr/k; 
//         update the ans variable by checking the max of the answer against the current  
            maxAverage = Math.max(maxAverage, average);
        }
//         return the ans 
    return maxAverage;        
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int current = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                current++;
            }

            while (current > k) {
                if (nums[left] == 0) {
                    current--;
                }
                left++;
            }

            // Update the answer inside the loop to consider all possible windows
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

  public static void main(String[] args) {
    List<List<Integer>> arr = new ArrayList<>();
    arr.add(List.of(1, 2, 3));
    arr.add(List.of(4, 5, 6));
    arr.add(List.of(9, 8, 9));

    int result = diagonalDifference(arr);

    int[] testArr = createArrayFrom1To100();
    int[] countSortedArray = countingSort(testArr);

    for(int i = 0; i < countSortedArray.length; i++){
      System.out.println("current value is " + testArr[i]);
    }

    System.out.println(result);
  }
}