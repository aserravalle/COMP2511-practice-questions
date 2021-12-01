package programmingexample2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A bag implemented using an ArrayList.
 *
 * @author Robert Clifton-Everest
 *
 * @invariant for all c in counts, c.getCount() > 0
 *
 * @param <E>
 */
public class ArrayListBag<E> implements Bag<E> {

    private ArrayList<Count<E>> counts;

    /**
     * Create a new empty bag.
     */
    public ArrayListBag() {
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
    public Bag<E> sum(Bag<? extends E> bag) {
        ArrayListBag<E> new_bag = new ArrayListBag<>();
        new_bag.addAll(this);
        new_bag.addAll(bag);
        return new_bag;
    }

    private void addAll(Bag<? extends E> bag) {
        for (Count<? extends E> count : bag) {
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
     * For this method, it should be possible to compare all other possible bags
     * for equality with this bag. For example, if an ArrayListBag<Fruit> and a
     * LinkedListBag<Fruit> both contain the same number of each element they
     * are equal. Similarly, if a Bag<Apple> contains the same elements as a
     * Bag<Fruit> they are also equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {return true;}
        if (o == null) {return false;}
        if (!this.getClass().equals(o.getClass())) {return false;}
        ArrayListBag<?> c = (ArrayListBag<?>)o;
        return hasSameItems(c);
    }

    private boolean hasSameItems(ArrayListBag<?> other) {
        if (size() != other.size()){return false;}

        var itr = other.iterator();
        while(itr.hasNext()) {
            var cOther = itr.next();
            boolean matchFound = false;
            for (Count<E> cThis : counts) {
                if(cThis.getElement().equals(cOther.getElement()) && cThis.getCount() == cOther.getCount()) {
                    matchFound = true;
                }
            }
            if (!matchFound) {
                return false;
            }
        }
        return true;
    }
}
