


public class List<E>  { //Comparable<E> ???
	private int numItems;
	private Object[] listArray;
	
	/** CharacterList()
	 *  creates an empty Character List and sets the Array at 10 item slots
	 */
	
	public List() {
		numItems = 0;
		final int INITIAL_CAPACITY = 10;
		listArray = new Object[INITIAL_CAPACITY];
	}
	
	/** CharacterList(int InitialCapacity) 
	 *  
	 * @param InitialCapacity
	 */
	
	public List(int initialCapacity) {
		if (initialCapacity < 0 ) {
			throw new IllegalArgumentException
			("initialCapacity is negatice: " + initialCapacity);
		}
		numItems = 0;
		listArray = new Object[initialCapacity];
	}
	
	/** addCharacter(Character item)
	 * Adds Character to array
	 * @param item
	 */
	
	public void add(E item) {
		if (numItems == listArray.length) {
			ensureCapacity(numItems*2 + 1);
		}
		listArray[numItems ++] = item; //new Object(item.getName(), item.getTitle(), item.getPrice(), item.getRole(), item.getReleaseDate());
	}
	
	public List<E> clone() {
		List<E> mimic;
		try {
			mimic = (List<E>) super.clone();
		}
		catch (CloneNotSupportedException e) {
			throw new RuntimeException
			("This class CharacterList does not implement Cloneable");
		}
		mimic.listArray = listArray.clone();
		return mimic;
	}
	
	public void ensureCapacity(int minimumCapacity) {
		Object[] biggerArray;
		if (listArray.length < minimumCapacity) {
			biggerArray = new Object[minimumCapacity];
			System.arraycopy(listArray,  0,  biggerArray,  0 , numItems);
			listArray = biggerArray;
		}
	}
	
	public int getCapacity() {
		return listArray.length;
	}
	
	/** toString()
	 * 
	 * @return One String representing all of list
	 */
		
	public String toString() {
		String result = "";
		for (int i=0; i < numItems; i++) {
			result += listArray[i].toString() +"\n";
		}
		return result;
	}
	
	/** getList
	 * returns the list of all characters in Character List
	 * @return 
	 * @return characterArray
	 */
	
	public <E> Object[] getList() {
		return  listArray; // added cast (Object[])
	}
	
	/** ListSize
	 * Return number of items in character items
	 * @return int number of items in list
	 * 
	 */
	
	public int listSize() {
		return numItems;
	}
	
	/** searchForCharacter
	 * 
	 * @param name of item to match
	 * @return matching Character
	 * 
	 */
	
	
	public E search(Object[] a, int first, int size, String target) {
		try {
			int i = 0;
			boolean found = false;
			while ((i < size) && !found) {
				if (a[first+i].equals(target))
					found = true;
				else
					i++;
			}
			if (found)
				return (E) listArray[first+i];
			else return null;
		
			}catch (NullPointerException e) {
				throw new RuntimeException
				("Search for Character Broke");
			}
			catch (RuntimeException e) {
				throw new RuntimeException
				("Search Method Broke");
			}
		
	}
	
	/** removeCharacterFromList(String n)
	 * 
	 * @param name of item to match
	 * @return false if item was not found
	 * 		   true is item was found and remove item from Array.
	 * 
	 */
	
	public boolean delete(E target) {	//String needs to be E (don't know how to make this work)
		int index;
		if (target.equals(null)) {
			index = 0;
		while ((index < numItems) && (listArray[index] != null))
			index++;
		}
		else{
			index = 0;
			while ((index < numItems) && (!target.equals(listArray[index])))
				index++;
		}
		if (index == numItems)
			return false;
		else{
			numItems--;
			listArray[index] = listArray[numItems];
			listArray[numItems] = null;
			return true;
		}
	}


	
	
	/** change
	 * Swaps old Character with new(updated) Character
	 * @param name			sets new name
	 * @param title			sets new title
	 * @param price			sets new price
	 * @param role			sets new role
	 * @param releaseDate	sets new release Date
	 */
	
	/*public void change(String name, String title, int price, String role, String releaseDate)  { //all fucked up
		Object ci = this.search(listArray, price, price, name);
		this.remove(name);
		Object ciTemp = (Object) ci.clone();
		ciTemp.setName(name);
		ciTemp.setTitle(title);
		ciTemp.setPrice(price);
		ciTemp.setRole(role);
		ciTemp.setReleaseDate(releaseDate);
		this.add(ciTemp);
		} */
	
	 public static <E extends Comparable<E>> void selectionSort(E[] data, int numItems) {
		 int i ;
		 int j;
		 int big;
		 E temp; // this is a copy of an array element.
		 for(i=numItems-1; i > 0; i--) {
			 big = 0;
			 for(j=1; j <= i; j++) {
				 if(data[big].compareTo(data[j]) < 0);
				 big = j;
			 }
			 temp = data[i];
			 data[i] = data[big];
			 data[big] = temp; 
		 }
	 }
}




	



	




