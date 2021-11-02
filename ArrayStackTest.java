public class ArrayStackTest {
	public static void main(String args[]) {
		ArrayStack S = new ArrayStack(10);
		
		String test = "(3*5)-(6/2)))))";
		int length = test.length();
		for (int i = 0; i < length; i++) {
			char testCh = test.charAt(i);
			if (testCh == '{' || testCh == '(' || testCh == '[') {
				S.push(testCh);
			} else if (testCh == '}' || testCh == ')' || testCh == ']') {
				char poppeditem = S.pop();
				if ((testCh == ')' && poppeditem != '(') || (testCh == '}' && poppeditem != '{')
					|| (testCh == ']' && poppeditem != '[')) {
					System.out.println("틀림!");
					return;
				} 
			}
		}
		if(! S.isEmpty()) {
			System.out.println("틀림!");
			return;
		}
		System.out.println("맞음!");
	}
}