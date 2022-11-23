import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String str){
    //String parentheses = str.replaceAll("\\s+","");
    Stack<Character> stack = new Stack<Character>();
    

    for(int i = 0; i < str.length(); i++){
      
      if(stack.isEmpty()) {
        stack.push(str.charAt(i));
        continue;
      }

      switch(str.charAt(i)) {
        case '{':
        case '(':
        case '[':
          stack.push(str.charAt(i));
          break;
        case '}':
          if (!stack.isEmpty() && stack.peek()=='{') {
            stack.pop();
            continue;
          } 
          return false;
        case ')':
          if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            continue;
          } 
          return false;
        case ']':
          if (!stack.isEmpty() && stack.peek() == '[') {
            stack.pop();
            continue;
          }  
          return false;
        }
      }
     
      return stack.isEmpty();
    }

  public static void main(String[] args){
    ValidParentheses strTest = new ValidParentheses();
    System.out.println(strTest.isValid("( )[]{ }"));
    System.out.println(strTest.isValid("(])"));
  }
}
