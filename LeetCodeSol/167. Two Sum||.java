//Approach
Observations Keep In Mind :-
  1. When we are given sorted Arrays :- Think of Structures That follow Sorted Conditions like - Two pointers algo, sliding window and many More 
  2. I use TWO pointer Approach here 
  Why?
  1. Obseravtion:- if(nums[i]+nums[i]<target = i++
                      if(nums[i]+nums[j]>target = j--;
else return i+1,j+1 // bascause In Solution tehy want 1-based Indexing
  class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int i =0;
      int j = numbers.length-1;

      while(i<=j){
        if(numbers[i]+numbers[j] > target){
            j--;
        }
        else if(numbers[i]+numbers[j]<target){
            i++;
        }
        else{
            return new int[]{i+1,j+1};
        }
      }
      return new int[]{};
    }
}
