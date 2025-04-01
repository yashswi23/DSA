class Solution {

    public static  int[] nearestleft(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] NSL = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            NSL[i] = st.isEmpty()?-1: st.peek();
            st.push(i);

        }
        return NSL;
    }

    public static  int[] nearestright(int[] heights){
         int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] NSR = new int[n];
    for(int i=n-1;i>=0;i--){
        while(!st.empty() && heights[st.peek()]>= heights[i]){
            st.pop();
        }

        NSR[i] = st.isEmpty()?n :st.peek();
        st.push(i);
    }
    return NSR;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea = 0;

        int[] Nsl = nearestleft(heights);
        int[] Nsr = nearestright(heights);
        for(int i=0;i<n;i++){
            int weight = Nsr[i]-Nsl[i]-1;
            int area = weight*heights[i];
maxarea = Math.max(maxarea,area);

        }
return maxarea;
    }
}
