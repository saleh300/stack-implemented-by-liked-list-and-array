package Stack;

public interface Stack<E> {

	void push(E e) ;
	E top() ; //peck
	E pop() ;
	int size() ;
	boolean isEmpty() ;

}
