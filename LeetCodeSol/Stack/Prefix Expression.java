/* class CQStack{
      public CQStack(int s) // constructor
      public void push(int j) // put item on top of stack
      public int pop() // take item from top of stack
      public boolean isEmpty() // true if stack is empty
      public boolean isFull() // true if stack is full
    }
    CQStack class already defined as per the above blueprint
*/
class Result {
  static int evalPrefix(CQStack s, String exp) {
    // Write your code here
      int n= exp.length();
      int res=0;
      for(int i=n-1;i>=0;i--){
          char c=exp.charAt(i);
          if(Character.isDigit(c)){
              s.push(c-'0');
          }
          else{
              int op1=s.pop();
              int op2=s.pop();
              switch(c){
                  case '+':
                      res=op1+op2;
                      break;
                  case '-':
                      res=op1-op2;
                      break;
                  case '*':
                      res=op1*op2;
                      break;
                  case '/':
                      res=op1/op2;
                      break;
                  case '^':
                      res=(int)Math.pow(op1,op2);
                      break;
              }
              s.push(res);
          }
      }
      return s.pop();
  }
}
