// --== CS400 Project One File Header ==--
// Name: Sangho Jeon
// CSL Username: sangho	
// Email: sjeon36@wisc.edu
// Lecture #:  002 @1:00pm
// Notes to Grader: <any optional extra notes to your grader>


import java.util.LinkedList;
import java.util.NoSuchElementException;


public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType>{
	private class Node {
		KeyType k;
		ValueType v;

		Node(KeyType k, ValueType v) {
			this.k = k;
			this.v = v;
		}
	}

	private int size;
	private int capacity;

	private LinkedList<Node>[] array;

	public HashtableMap() {
		this(20);
	}

	@SuppressWarnings("unchecked")
	public HashtableMap(int capacity) throws IllegalArgumentException {
		if (capacity <= 0) {
			throw new IllegalArgumentException("capacity shoudld be over 0");
		}
		this.capacity = capacity;
		array = new LinkedList[capacity];
		for (int i = 0; i < capacity; i++) {
			array[i] = new LinkedList<Node>();
		}
	}

	private void rehash(int newCapacity) {
		LinkedList<Node>[] newArray = new LinkedList[newCapacity];
		for (int i = 0; i < newCapacity; i++) {
			newArray[i] = new LinkedList<Node>();
		}
		int idx;
		for (int i = 0; i < capacity; i++) {

			for (Node n : array[i]) {
				idx = Math.abs(n.k.hashCode()) % newCapacity;
				newArray[idx].add(n);
			}
		}
		capacity = newCapacity;
		array = newArray;
	}

	public boolean put(KeyType key, ValueType value) {
		// TODO Auto-generated method stub
		if (key == null) {
			return false;
		}
		int idx = Math.abs(key.hashCode()) % capacity;
		for (Node n : array[idx]) {
			if (n.v.equals(value)) {
				return false;
			}
		}
		array[idx].add(new Node(key, value));
		size++;
		if (((double) size) / capacity >= 0.75) {
			rehash(capacity * 2);
		}
		return true;
	}

	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		// TODO Auto-generated method stub

		int idx = Math.abs(key.hashCode()) % capacity;
		for (Node n : array[idx]) {
			if (n.k.equals(key)) {
				return n.v;
			}
		}
		throw new NoSuchElementException("No such element in the HashMap");
	}



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean containsKey(KeyType key) {
		// TODO Auto-generated method stub
		if (key == null) {
			return false;
		}
		int idx = Math.abs(key.hashCode()) % capacity;
		for (Node n : array[idx]) {
			if (n.k.equals(key)) {
				return true;
			}

		}

		return false;
	}

	@Override
	public ValueType remove(KeyType key) {
		// TODO Auto-generated method stu
		if (key == null) {
			return null;
		}
		int idx = Math.abs(key.hashCode()) % capacity;
		Node target = null;
		for (Node n : array[idx]) {
			if (n.k.equals(key)) {
				target = n;
				break;
			}

		}
		if (target != null) {
			array[idx].remove(target);
			size--;
			return target.v;
		} else {
			return null;
		}
	}

	@Override
	public void clear() {

		for (int i = 0; i < capacity; i++) {
			array[i].clear();
		}
		size = 0;

		// TODO Auto-generated method stub

	}
	
		
	
}

	

