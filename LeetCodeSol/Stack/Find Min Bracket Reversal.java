Find the minimum bracket reversals for balanced expression bookmark_border
Given an expression having only square brackets ‘[‘ and ‘]’. Find the minimum number of brackets reversals required to make the expression balanced. If expression cannot be made balanced, print -1 and if it is already balanced, print 0.

Input Format

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. 
Each test case contains an expression consisting of square brackets only.
Output Format

The output for each test case will be the minimum number of bracket reversals required to make the expression balanced if possible.
Sample Input 1

2
[]
][
Sample Output 1

0
2
Explanation 1

First expression is already balanced, so print 0.
Second expression requires 2 reversals (both the brackets needs to be changed as []) so prints 2.
Sample Input 2

1
[[[[
Sample Output 2

2
Sample Input 3

1
[[[[[
Sample Output 3

-1


  Solution:-
  class Result
{
  static int minReversal(String expr){
    // Write your code here
      int n = expr.length();
      if(n%2!=0){
          return -1;
      }
      
      int opc=0;
      int cc=0;
      for(int i=0;i<n;i++){
          char c = expr.charAt(i);
          
          if(c == '['){
              opc++;
          }
          else{
              if(opc>0){
                  opc--;
              }
              else{
                  cc++;
              }
          }
      }
      return (opc+1)/2 + (cc+1)/2;
  }
}
