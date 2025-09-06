class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<= arr[i])count++;
                else break;
            }
            
            ans.add(count);
         
        }
        return ans;
        
    }
}

//Optimised
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<= arr[i]){
                st.pop();
            }
            if(st.isEmpty())
            ans.add(i+1);
            else{
                ans.add(i-st.peek());
            }
            st.add(i);
        }
        return ans;
        
    }
}
