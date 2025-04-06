class Result{
  static void printNextGreaterElement(int arr[],int n){
    // Write your code here
     int res[]=new int[n];
      Stack<Integer> st=new Stack<>();
      for(int i=0;i<n;i++){
          res[i]=-1;
      }
      for(int i=0;i<n;i++){
          if(!st.isEmpty() && arr[i]>arr[st.peek()]){
              res[st.pop()]=arr[i];
          }
          st.push(i);
      }
      for(int i=0;i<n;i++){
          System.out.print(res[i]+" ");
      }
  }
}
