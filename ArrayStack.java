package Stack;

public class ArrayStack<E> implements Stack<E> {
	
	private static final  int CAPCITY = 1000 ;
	private E[] data ;
	int t = -1 ;
	
	public ArrayStack() {
		this(CAPCITY) ;
	}
	public ArrayStack(int size) {
		data = ((E[]) new Object[CAPCITY]) ;
	}
	@Override
	public void push(E e) {
		if(size() == data.length) {
			System.out.println("stack is full");
			return ;
		}else {
			data[++t] = e ;
		}
		
	}

	@Override
	public E top() {
		if(isEmpty()) return null;
		return data[t] ;
	}

	@Override
	public E pop() {
		if(isEmpty()) return null ;
		
		E deleted = data[t] ;
		data[t] = null ;
		t-- ;
		return deleted ;
	}

	@Override
	public int size() {
		return (t +1) ;
	}

	@Override
	public boolean isEmpty() {
		return (t == -1) ;
	}

}
