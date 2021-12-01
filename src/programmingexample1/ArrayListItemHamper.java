package programmingexample1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A hamper implemented using an ArrayList.
 *
 * @author Matthew Perry
 *
 * @invariant for all c in counts, c.getCount() > 0
 *
 * @param <E>
 */
public class ArrayListItemHamper<E extends Item> implements Hamper<E> {

    private ArrayList<Count<E>> counts;

    /**
     * Create a new empty hamper.
     */
    public ArrayListItemHamper() {
        this.counts = new ArrayList<Count<E>>();
    }

    private Count<E> getCount(Object o) {
        for (Count<E> c : counts)
            if (c.getElement().equals(o))
                return c;
        return null;
    }

    @Override
    public void add(E e) {
        add(e,1);
    }

    @Override
    public void add(E e, int n) {
        Count<E> c = getCount(e);
        if (c != null) {
            c.incrementCount(n);
        } else if (n > 0) {
            counts.add(new Count<E>(e, n));
        }
    }

    @Override
    public void remove(E e) {
        remove(e, 1);
    }

    @Override
    public void remove(E e, int n) {
        Count<E> count = getCount(e);
        count.decrementCount(n);
        if (count.getCount() <= 0) {
            counts.remove(count);
        }
    }

    @Override
    public int count(Object o) {
        Count<E> c = getCount(o);
        if (c != null)
            return c.getCount();
        return 0;
    }

    @Override
    public int size() {
        int size = 0;
        for (Count<E> c : counts) {
            size += c.getCount();
        }
        return size;
    }

    @Override
    public Hamper<E> sum(Hamper<? extends E> hamper) {
        ArrayListItemHamper<E> new_hamper = new ArrayListItemHamper<>();
        new_hamper.addAll(this);
        new_hamper.addAll(hamper);
        return new_hamper;
    }

    void addAll(Hamper<? extends E> hamper) {
        for (Count<? extends E> count : hamper) {
            this.add(
                count.getElement(), count.getCount()
            );
        }
    }

    @Override
    public Iterator<Count<E>> iterator() {
        return counts.iterator();
    }

    /**
     * For this method, hampers should be the same class to be equal (ignore the generic type component). For example, a CreativeHamper cannot be equal to a FruitHamper,
     * And a FruitHamper cannot be equal to an ArrayListItemHamper<Fruit>,
     * However an ArrayListItemHamper<Fruit> can be equal to a ArrayListItemHamper<Item> if they both only contain fruit.
     * HINT: use getclass() to compare objects.
     */
    @Override
    public boolean equals(Object o) {
        // Check if both refer to the same object
        if (this  == o) {
            return true;
        }
        // Check other is not null
        if ( o == null) {
            return false;
        }

        // Check hampers of same class, if not return false
        if(!this.getClass().equals(o.getClass())) {
            return false;
        }
        // Cast other to a hamper of same time
        ArrayListItemHamper<?> other = (ArrayListItemHamper<?>) o;

        // Check both hampers have same number of items
        if (size() != other.size()){
            return false;
        }

        // Check the number of each element matches between both hampers
        var hamperIter = other.iterator();
        while(hamperIter.hasNext()) {
            var cOther = hamperIter.next();
            // Check if the number of this element matches in the other
            boolean matchFound = false;
            for (Count<E> cThis : counts) {
                // If element are equal and count are equal, then a match is found
                if(cThis.getElement().equals(cOther.getElement()) && cThis.getCount() == cOther.getCount()) {
                    matchFound = true;
                }
            }
            // If a match wasnt found then not equal and return false
            if (!matchFound) {
                return false;
            }
        }
        // If made it to here every check was passed so return true
        return true;

    }

    /**
	 * 
	 * @return price of the hamper - for ArrayListItemHamper, this should be the sum of the prices of items with each price multiplied by the number of times that item occurs
	 */
	@Override
    public int getPrice() {
        int sum = 0;
        for (Count<E> count : counts) {
            Item item = count.getElement();
            sum += item.getPrice() * count.getCount();
        }
        return sum;
    }

    @Override
    public String toString(){
        return counts.toString();
    }
}
