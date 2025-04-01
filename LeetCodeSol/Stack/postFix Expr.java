/* isEmpty(), isFull(), push(int) and int pop() functions available on Stack. */
static int evalPostfix(CQStack s, String exp) {
  // Write your code here
    int n = exp.length();
    for(int i=0;i<n;i++){
        char c = exp.charAt(i);
        if(Character.isDigit(c)){
            s.push(c-'0');
        }
        else{
            int op2 = s.pop();
            int op1 = s.pop();
            int result=0;
            switch(c){
                case '+':
                    result = op1+op2;
                    break;
                case '-':
                    result = op1-op2;
                    break;
                case '*':
                    result = op1*op2;
                    break;
                case '/':
                    result = op1/op2;
                    break;
                case '^':
                    result = (int)Math.pow(op1,op2);
                    break;
            }
            s.push(result);
        }
    }
     return s.pop();
}
