// --== CS400 Project One File Header ==--
// Name: Sangho Jeon
// CSL Username: sangho	
// Email: sjeon36@wisc.edu
// Lecture #:  002 @1:00pm
// Notes to Grader: <any optional extra notes to your grader>

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class HashTableSortedSets<KeyType, ValueType extends Comparable<ValueType>> extends HashtableMap <KeyType, List<ValueType>> implements IHashTableSortedSets <KeyType,ValueType> {

	/**
     * This add method is different from the put() method in that it appends a
     * single value to the end of the list associated with a given key.  If a
     * key does not yet have a list of values associated with it, then a new 
     * one will be created when this method is called.
     * @param key used to later lookup the list containing this value
     * @param value associated with the previous key
     */
	@Override
	public void add(KeyType key, ValueType value) {
		// TODO Auto-generated method stub
		List<ValueType> list;
		try {
		    list = this.get(key);
		    int idx = 0;
		    for(ValueType v: list) {
		    	if(v.compareTo(value)>=0) {
		    		break;
		    	}
		    	idx ++;
		    }
		    list.add(idx, value);
		} catch (NoSuchElementException e) {
			list = new LinkedList<ValueType>();
			list.add(value);
			this.put(key, list);
		}
		
	}
	
}

