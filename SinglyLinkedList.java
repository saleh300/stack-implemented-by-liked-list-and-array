package Stack ;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// instance variables of the SinglyLinkedList
public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }
    // Remove all elements

    public void clear() {
        head = tail = null;
        size = 0;
    }
    // access methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0) {
            tail = head; // special case: new node becomes tail also
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty()) {
            head = newest; // special case: previously empty list
        } else {
            tail.setNext(newest); // new node after existing tail
        }
        tail = newest; // new node becomes the tail
        size++;
    }

    public void add(E element, int index) {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node<E> newest = new Node<E>(element, null);
        if (index == 0) // add at front
        {
            newest.setNext(head);
            head = newest;
            if (tail == null) {
                tail = head;
            }
        } else // add the middle
        {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            newest.setNext(curr.getNext());
            curr.setNext(newest);
            if (tail == curr) {
                tail = tail.getNext();
            }
        }
        size++;
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) {
            return null; // nothing to remove
        }
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null; // special case as list is now empty
        }
        return answer;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0) // remove from front
        {
            element = head.getElement();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            element = (E) curr.getNext().getElement();
            if (tail == curr.getNext()) {
                tail = curr;
            }
            curr.setNext(curr.getNext().getNext());
        }

        size--;
        return element;
    }

    public void print() {
        if (isEmpty()) {
            System.out.print("List is empty");
            return;
        }
        Node<E> curr = head;
        while (curr != null) {
            System.out.print(curr.getElement()+" ");
            curr = curr.getNext();
        }

    }
    public void PostiveAndNigtive(SinglyLinkedList<Integer> single, LinkedStack<Integer> stack) {
    	
    	if (isEmpty()) {
			return ;
		}
    	
    	Node curr = head ;
    	
    	while (curr != null ) {
    		if ((int)curr.getElement() < 0) {
				stack.push((int)curr.getElement());
			}
    		curr = curr.getNext() ;
		}
    	curr = head ;
    	while (curr != null ) {
    		if ((int)curr.getElement() > 0) {
				stack.push((int)curr.getElement());
			}
    		curr = curr.getNext() ;
		}
    	
    	single.clear();
    	
    	while (!stack.isEmpty()) {
			single.addLast(stack.pop());
		}
    }
    public void revers(SinglyLinkedList<Integer> list) {
    	
    	LinkedStack<Integer> stack = new LinkedStack<Integer>() ;
    	
    	if(list.isEmpty())
    		return ;
    	
    	Node curr = head ;
    	
    	while (curr != null) {
			stack.push(list.removeFirst());
			curr = curr.getNext();
		}
    	while (!stack.isEmpty()) {
			list.addLast(stack.pop());
		}

    }
    public void reverss() {
    	if(isEmpty())
    		return ;
    	
    	SinglyLinkedList<Integer> temp = new SinglyLinkedList<Integer>() ;
    	
    	int x = size ;
    	
    	for (int i = 0; i < x; i++) {
			E val = removeFirst() ;
			temp.addFirst((int)val);
		}
    	for (int i = 0; i < temp.size; i++) {
			E val = removeFirst() ;
			addLast(val);
		}
    }
    
    

}