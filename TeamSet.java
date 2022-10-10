import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.NoSuchElementException;

/**
* TeamSet to be implemented by students
* Note: Check the Java 8 API to make sure you are throwing
* the correct exceptions.
* @author cproenza3
* @version 1
* @param <T> is a generic type
 */
public class TeamSet<T> implements Set<T>, Iterable<T> {
    private T[] backingArray;
    private int size;

    /**
     * Constructor should set an empty backingArray of size 10.
     */
    public TeamSet() {
        backingArray = (T[]) new Object[10];
        size = 0;
    }

    /**
     * Adds the specified element to the end of this set if
     * it is not already present, and increments size. If
     * the element requires you to resize the backingArray,
     * double the current array length.
     * This method should return a boolean of whether or not the
     * element was added.
     * This should not support adding nulls. Consult the API.
     * @param t is the element being added
     * @return if lthe element is added
     */
    public boolean add(T t) {
        if (!contains(t)) {
            if (t == null) {
                throw new NullPointerException("Null Pointer Exception.");
            }

            if (size == backingArray.length) {
                T[] resizeArray = (T[]) new Object[backingArray.length * 2];
                for (int i = 0; i < size; i++) {
                    resizeArray[i] = backingArray[i];
                }
                backingArray = resizeArray;
            }
            backingArray[size] = t;
            size++;
            return true;
        }
        return false;
    }

    /**
     * Adds all of the elements in the specified collection to
     * this set if they're not already present. You may also
     * need to resize the backing array to 2 * current size.
     * This method should return a boolean of whether or not any
     * of the elements were added.
     * This should not support adding nulls. Consult the API.
     * @param c is the collection being added
     * @return if the collection is added
     */
    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        if (c == null) {
            throw new NullPointerException("Null pointer exception.");
        }

        for (T v : c) {
            if (add(v)) {
                added = true;
            }
        }
        return added;
    }

    /**
     * Removes all of the elements from this set.
     * Should not use any form of loops, should be O(1).
     * Size should be reset to 0. Capacity should be reset to 10.
     */
    public void clear() {
        T[] resizeArray = (T[]) new Object[10];
        backingArray = resizeArray;
        size = 0;
    }

    /**
     * Returns true if this set contains the specified element.
     * @param o is the element in the set
     * @return if the object is in the set
     */
    public boolean contains(Object o) throws NullPointerException {
        if (o == null) {
            throw new NullPointerException("Null pointer except");
        }

        for (int i = 0; i < size; i++) {
            if (backingArray[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this set contains all of the elements of the
     * specified collection.
     * @param c is the collection being checked for
     * @return if the collection is there
     */
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Null pointer exception");
        }

        boolean container = false;
        for (Object v : c) {
            if (contains(v)) {
                container = true;
            }
        }
        return container;
    }

    /**
     * Removes the specified element from this set if it is present,
     * and shifts all other elements up. Will return a boolean value
     * of whether or not the element has been removed.
     * @param o is the object being removed
     * @return if the element is removed
     */
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Null pointe.");
        }

        if (contains(o)) {
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (backingArray[i].equals(o)) {
                    backingArray[i] = null;
                    j = i;
                }
            }

            for (int k = j; k < size - 1; k++) {
                if (backingArray[k] == null) {
                    backingArray[k] = backingArray[k + 1];
                    backingArray[k + 1] = null;
                }
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Compares the specified object with this set for equality.
     * Do not include order in your equality check.
     * ex: a set of {ARGENTINA, PERU, GERMANY} would be equivalent
     * to another set of {PERU, GERMANY, ARGENTINA}.
     * @param o is the item in the enum being checked
     * @return if the items are equal
     */
    public boolean equals(Object o) {
        if (o instanceof TeamSet && size == ((TeamSet) o).size()
            && containsAll((TeamSet) o) && o != null) {
            return true;
        }
        return false;
    }

    /**
     * Creates an array containing all of the elements in this set.
     * @return an array containing those elements
     */
    public T[] toArray() {
        T[] newArray = (T[]) new Object[size];
        if (newArray == null) {
            throw new NullPointerException("Null pointer exception.");
        }

        for (int i = 0; i < size; i++) {
            if (backingArray[i] == null) {
                remove(backingArray[i]);
            }
            newArray[i] = backingArray[i];
        }
        return newArray;
    }

    /**
     * Should return the number of elements in the set.
     * @return the size of the set
     */
    public int size() {
        return size;
    }

    /**
     * Check if the set contains no elements.
     * @return if the set contains no elements. NOT FINISHED
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this set.
     * @return an iterator over backingArray
     */
    public Iterator<T> iterator() {
        return new MyIterator<T>(backingArray);
    }

    /**
     * The inner class for the iterator
    */
    public class MyIterator<T> implements Iterator<T> {

        private T[] genericArray;
        private int index = 0;

        /**
         * Constructor for myIterator
         * @param genericArray is a generic array for the iterator
        */
        public MyIterator(T[] genericArray) {
            this.genericArray = genericArray;
        }



        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!(hasNext())) {
                throw new NoSuchElementException("End of string.");
            }
            return genericArray[index++];
        }
    }

    /* DO NOT EDIT ANYTHING BELOW THIS LINE,
       DOING SO WILL RESULT IN POINT DEDUCTIONS.
    */


    /**
     * @return the backing array, necessary for the tester.
     * DO NOT edit!
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * @return the sum of the hashcodes of the players in the set.
     */
    public int hashCode() {
        int sum = 0;
        for (T t : backingArray) {
            if (t != null) {
                sum += ((Player) t).hashCode();
            }
        }
        return sum;
    }

    /**
     * Retains only the elements in the set that are in the
     * specified collection, and removes everything else.
     * @param c a collection of all the elements to be retained
     * @return a boolean of whether the set was changed at all.
     */
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes every element in the specified collection.
     * @param c a collection of all the elements to be removed
     * @return a boolean of whether the set was changed.
     */
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an array containing all of the elements in this set.
     * The runtime type of the returned array is that of the
     * specified array.
     * @param a a generic array
     * @param <T> the runtime type of a
     * @return a generic array
     */
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}