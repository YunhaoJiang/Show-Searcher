import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * PLACEHOLDER CLASS FOR HASHTABLESORTEDSETS CLASS
 * 
 * @author Danny
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class TempHashTableSortedSets<KeyType, ValueType extends Comparable<ValueType>>
    implements IHashTableSortedSets<KeyType, ValueType> {

  protected LinkedList<IShow>[] arr;

  @SuppressWarnings("unchecked")
  /**
   * Constructor that sets the array capacity to default value 20
   */
  public TempHashTableSortedSets() {
    arr = (LinkedList<IShow>[]) new LinkedList[20];
    // HARD CODE
    // INDEXES:
    // 0: "Netflix"
    // 1: "Hulu"
    // 2: "Prime Video"
    // 3: "Disney+"
    // 4: "show"
    // 5: 2022
    // 6: 2021
    
    TempShow netflix = new TempShow("Netflix show", 2022, 10, true, false, false, false);
    TempShow hulu = new TempShow("Hulu show", 2022, 9, false, true, false, false);
    TempShow primeVid = new TempShow("Prime Video show", 2021, 8, false, false, true, false);
    
    
    
    for (int i = 0; i < 7; i++) {
      arr[i] = new LinkedList<IShow>();
    }
    arr[0].add(netflix);
    arr[1].add(hulu);
    arr[2].add(primeVid);
    arr[4].add(netflix);
    arr[4].add(hulu);
    arr[4].add(primeVid);
    arr[5].add(netflix);
    arr[5].add(hulu);
    arr[6].add(primeVid);
    
  }


  @Override
  /**
   * Hard coded method that if entered Disney+ show, it would add the show to the 'Disney+', 'show' and 2021 list
   */
  public boolean put(KeyType key, List<ValueType> value) {
    if (key.equals("Disney+")) {
     arr[3].add(new TempShow("Disney+ show", 2021, 7, false, false, false, true));
    }
    if (key.equals("show")) {
      arr[4].add(new TempShow("Disney+ show", 2021, 7, false, false, false, true));
    }
    if (key.equals(2021)) {
      arr[6].add(new TempShow("Disney+ show", 2021, 7, false, false, false, true));
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  @Override
  /**
   * Hard coded method that gets the lists of shows correspeding to a key.
   * Only works for specific key inputs
   */
  public List<ValueType> get(KeyType key) throws NoSuchElementException {
    if (key.equals("Netflix")) {
      return (List<ValueType>)arr[0];
    }
    if (key.equals("Hulu")) {
      return (List<ValueType>)arr[1];
    }
    if (key.equals("Prime Video")) {
      return (List<ValueType>)arr[2];
    }
    if (key.equals("Disney+")) {
      return (List<ValueType>)arr[3];
    }
    if (key.equals("show")) {
      return (List<ValueType>)arr[4];
    }
    if (key.equals(2022)) {
      return (List<ValueType>)arr[5];
    }
    if (key.equals(2021)) {
      return (List<ValueType>)arr[6];
    }
    throw new NoSuchElementException();
  }

  @Override
  /**
   * Hard coded method that returns the number of unique shows in the database
   */
  public int size() {
    // Creates ArrayList of shows
    ArrayList<IShow> showList = new ArrayList<IShow>();
    
    // For every value in the hashtable
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != null) {
        for(IShow show : arr[i]) {
          
          // If the show has not yet been counted
          if(!showList.contains(show)) {
            
            // Add it to the ArrayList
            showList.add(show);
          }
        }
      }
    }
    
    // Return the final ArrayList size
    return showList.size();
  }

  @Override
  public boolean containsKey(KeyType key) {
    return false;
  }

  @Override
  public List<ValueType> remove(KeyType key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }

  @Override
  /**
   * Hard coded method to add a specific value (show in this case)
   * based on the key (either title word or year)
   * 
   * @param key title word or year
   * @param value show associated with it
   */
  public void add(KeyType key, ValueType value) {
    if (key.equals("Netflix")) {
      arr[0].add((IShow) value);
    }
    if (key.equals("Hulu")) {
      arr[1].add((IShow) value);
    }
    if (key.equals("Prime Video")) {
      arr[2].add((IShow) value);
    }
    if (key.equals("Disney+")) {
      arr[3].add((IShow) value);
    }
    if (key.equals("show")) {
      arr[4].add((IShow) value);
    }
    if (key.equals(2022)) {
      arr[5].add((IShow) value);
    }
    if (key.equals(2021)) {
      arr[6].add((IShow) value);
    }
  }


}
