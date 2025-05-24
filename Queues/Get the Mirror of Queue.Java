static void mirrorQueue(Queue<String> q)
{
    Stack<String> st = new Stack<>();
    int size = q.size();
    for(int i=0;i<size;i++){
        String sp = q.poll();
        st.add(sp);
        q.add(sp);
    }
    while(!st.isEmpty()){
        q.add(st.pop());
    }
  
}
