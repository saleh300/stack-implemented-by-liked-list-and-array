package Stack;

public class LinkedStack<E> implements Stack<E>{

	SinglyLinkedList<E> list = new SinglyLinkedList<>() ;	
	public LinkedStack() {

	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E top() {
		return list.first() ;
	}

	@Override
	public E pop() {
		return list.removeFirst() ;
	}

	@Override
	public int size() {
		return list.size() ;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty() ;
	}
	public void revers(int k) {
		
		LinkedStack<Integer> temp1 = new LinkedStack<Integer>() ;
		LinkedStack<Integer> temp2 = new LinkedStack<Integer>() ;

		for (int i = 0; i < k; i++) {
			temp1.push((int)pop());
		}
		while (!temp1.isEmpty()) {
			temp2.push(temp1.pop());
		}
		while (!temp2.isEmpty()) {
			push((E) temp2.pop());
		}
		
	}

}
