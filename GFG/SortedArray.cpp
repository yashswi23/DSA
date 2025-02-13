//In C++
class Solution {
  public:
    void nearlySorted(vector<int>& arr, int k) {
   priority_queue<int, vector<int>, greater<int>> minheap;

        // Insert the first k+1 elements into the min heap
       int index=0;
       for(int i=0;i<=k&& i<arr.size();i++){
           minheap.push(arr[i]);
       }
       
       
     for(int i=k+1;i<arr.size();i++){
         arr[index] = minheap.top();
         minheap.pop();
         minheap.push(arr[i]);
         index++;
     }
     
     while(minheap.size()>0){
         arr[index] = minheap.top();
         minheap.pop();
         index++;
     }
}

//IN JAVA
public void nearlySorted(int[] arr, int k) {
        // code
        PriorityQueue<Integer >minheap = new PriorityQueue<>();
        // Insert the first k+1 elements into the min heap
       int index=0;
       for(int i=0;i<=k&& i<arr.length;i++){
           minheap.add(arr[i]);
       }
       
       
     for(int i=k+1;i<arr.length;i++){
         arr[index] = minheap.poll();
         minheap.add(arr[i]);
         index++;
     }
     
     while(minheap.size()>0){
         arr[index] = minheap.poll();
         index++;
     }
