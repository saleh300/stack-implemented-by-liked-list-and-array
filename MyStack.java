package Stack;

import Queue.LinkedQueue;

public class MyStack {
	
	//this method is to print stack
	public static void print(ArrayStack<Integer> list ) {
		LinkedStack<Integer> temp = new LinkedStack() ;
		int x ;

		while (!list.isEmpty()) {
			x = list.pop() ;
			System.out.print(x+" ");
			temp.push(x);
		}

		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
	}
	//find the sum of stack
	public static int sumtion(LinkedStack<Integer> list ) {
		LinkedStack<Integer> temp = new LinkedStack() ;
		int x ;
		int sum = 0 ;

		while (!list.isEmpty()) {
			x = list.pop() ;
			sum+= x ;
			temp.push(x);
		}
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
		return sum ;
	}
	//find max
	public static int Max(LinkedStack<Integer> list ) {
		LinkedStack<Integer> temp = new LinkedStack() ;
		int x ;
		int Max = 0 ;

		while (!list.isEmpty()) {
			x = list.pop() ;
			if(x > Max)
				Max = x ;
			temp.push(x);
		}
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
		return Max ;
	}
	//to search in the stack if the value is found or not
	public static boolean isFound(LinkedStack<Integer> list, int key ) {
		LinkedStack<Integer> temp = new LinkedStack() ;
		int x ;		
		boolean flag = false ;
		while (!list.isEmpty()) {
			x = list.pop() ;
			if(x == key)
				flag = true ;
			temp.push(x);
		}
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
		return flag ;

	}
	public static int prec(char s) {

		switch (s) {
		case '+' :
		case '-' :
			return 1 ;
		case '*' :
		case '/' :
			return 2 ;
		case '^' :
			return 3 ;
		}
		return -1 ;

	}
	
	public static String infixToPostfix(String exp) {

		String result = new String("") ;


		ArrayStack<Character> stack = new ArrayStack<Character>() ;

		for (int i = 0; i < exp.length(); i++) {

			char c = exp.charAt(i) ;

			if(Character.isLetterOrDigit(c)) {
				result+= c ;
			}
			else if(c == '(') {
				stack.push(c) ;
			}
			else if(c == ')') {
				while (!stack.isEmpty() && stack.top() != '(') {
					result+= stack.pop() ;
				}
				stack.pop() ;
			}
			else {
				while (!stack.isEmpty() && prec(c) <= prec(stack.top())) {
					result += stack.pop() ;
				}
				stack.push(c) ;
			}

		}
		while (!stack.isEmpty()) {
			if(stack.top() == '(')
				System.out.println("Valid expretion");
			result += stack.pop() ; 
		}
		return result ;

	}
	public static int evalutePostfix(String exp) {
		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		
		for (int i = 0; i < exp.length(); i++) {
			int x ;
			int y ;
			if(Character.isDigit(exp.charAt(i))) {
				temp.push(Integer.parseInt(String.valueOf(exp.charAt(i))));
			}else {
				x = temp.pop() ;
				y = temp.pop() ;
				
				switch (exp.charAt(i)) {
				case '+':
					temp.push((x+y));
					break ;
				case '-':
					temp.push((y-x));
					break ;	
				case '*':
					temp.push((x*y));
					break ;
				case '/':
					temp.push((y/x));
					break ;
				}
			}
		}
		return temp.pop() ;
		
		
	}
	public static boolean isMatched(String exp)
	{
		final String opening = "({[" ;
		final String closeing = ")}]" ;
		
		LinkedStack<Character> temp = new LinkedStack() ;
		
		for (char c : exp.toCharArray()) {
			
			if(opening.indexOf(c) != -1) {
				temp.push(c);
			}else if(closeing.indexOf(c) != -1) {
				if(temp.isEmpty())
					return false ;
				if(closeing.indexOf(c) != opening.indexOf(temp.pop()))
					return false ;
			}
		}
		return temp.isEmpty() ;

	}
	
	//to reveres the stack by using 2 stacks
	public static void revers(LinkedStack<Integer> s) {
		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		LinkedStack<Integer> rev = new LinkedStack<Integer>() ;


		while (!s.isEmpty()) {
			temp.push(s.pop());
		}
		while (!temp.isEmpty()) {
			rev.push(temp.pop());
		}
		while (!rev.isEmpty()) {
			s.push(rev.pop());
		}
	}
	public static void revK(LinkedStack<Integer> list, int num) {
		if(num <= 0 || num>list.size())
			return ;
		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		LinkedStack<Integer> rev = new LinkedStack<Integer>() ;


		for (int j = 0; j < num; j++) {
			temp.push(list.pop());
		}
		while (!temp.isEmpty()) {
			rev.push(temp.pop());
		}
		while (!rev.isEmpty()) {
			list.push(rev.pop());
		}		
	}
	//to copy the stack
	public static LinkedStack<Integer> copyStack(LinkedStack<Integer> list) {

		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		LinkedStack<Integer> rev = new LinkedStack<Integer>() ;

		while (!list.isEmpty()) {
			temp.push(list.pop());
		}
		while (!temp.isEmpty()) {
			int x  = temp.pop() ;
			rev.push(x);
			list.push(x);
		}
		return rev ;
	}
	//Double the value
	public static void dublcate(LinkedStack<Integer>list) {
		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		if(list.isEmpty())
			return ;
		int x ;
		while (!list.isEmpty()) {
			x = list.pop() ;
			temp.push(x);
			temp.push(x);
		}
		while (!temp.isEmpty()) {
			System.out.print(temp.pop()+" ");
		}



	}
	//to add value after given index
	public static void addByInd(LinkedStack<Integer> list, int index, int num) {


		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		int n = list.size() ;

		for (int i = 0; i < n-index; i++) {
			temp.push(list.pop());
		}

		list.push(num);

		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
	}
	//delete given value
	public static void delete_num(LinkedStack<Integer> list, int key) {

		if(list.isEmpty())
			return ;

		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;

		while (!list.isEmpty()) {
			int x = list.top() ;
			if(x != key)
				temp.push(list.pop());
			else 
				list.pop() ;
		}
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
	}
	//delete max value
	public static void delete_Max(LinkedStack<Integer> list) {

		int max = list.top() ;

		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;

		while (!list.isEmpty()) {
			int x = list.pop() ;
			if(max < x)
				max = x ;
			temp.push(x);
		}
		while (!temp.isEmpty()) {
			int x = temp.top() ;
			if(x != max)
				list.push(temp.pop());
			else 
				temp.pop() ;
		}


	}
	
	//this method makes the stack sorted
	public static void specialPush(LinkedStack<Integer> list, int num) {

		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;

		if(list.size() == 0) {
			list.push(num); return ;
		}
		while (list.size() != 0 && list.top() < num) {
			temp.push(list.pop());
		}
		
		list.push(num);
		while (temp.size() != 0) {
			list.push(temp.pop());
		}
	}
	
	//will return sum of even
	public static void sumOfEven(LinkedStack<Integer> list, int start, int end) {
		
		if(list.isEmpty()) {
			System.out.println("the list is empty");
			return ;
		}
		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		int x ;
		int sum = 0  ;
		while (!list.isEmpty()) {
			x = list.pop() ;
			if(x >= start && x <= end)
				if(x%2 == 0)
					sum+= x ;
			temp.push(x);
		}
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
		list.push(sum);
	}
	// remove the minimum value
	public static void removeSmaller(LinkedStack<Integer> list , int key) {
		
		if(list.isEmpty())
			return ;
		
		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		int x ;
		while (!list.isEmpty()) {
			x = list.top() ;
			if(x <= key)
				list.pop() ;
			else 
				temp.push(list.pop());
		}
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
	}
	//to sort the stack
	public static void sort(LinkedStack<Integer> list) {
		
		LinkedStack<Integer> temp = new LinkedStack<Integer>() ;
		
		while (!list.isEmpty()) {
			
			int x = list.pop() ;
			
			while (!temp.isEmpty() && temp.top() > x) {
				list.push(temp.pop());
			}
			temp.push(x);
		}
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
	}
	public static void ArrangStack(LinkedStack<Integer> list) {
		if(list.isEmpty())
			return ;
		
		LinkedStack<Integer> temp = new LinkedStack<>() ;
		 
		int n = list.size() ;
		
		for (int i = 0; i < n; i++) {
			int x = list.pop() ;
			
			if(x % 2 == 0) {
				temp.push(x);
			}else {
				list.push(x);
			}
		}
		
		while (!temp.isEmpty()) {
			list.push(temp.pop());
		}
		
	}	
	public static void main(String[] args) {

		ArrayStack<Integer> stack = new ArrayStack<Integer>() ;
		stack.push(2);
		stack.push(4);
		stack.push(3);
		stack.push(5);
		stack.pop() ;
		print(stack);

;
	}
}
