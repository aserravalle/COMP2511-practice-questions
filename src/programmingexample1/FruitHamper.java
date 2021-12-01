package programmingexample1;

import java.util.Iterator;

public class FruitHamper extends ArrayListItemHamper<Fruit> {
    /**
     * invariant: FruitHamper must have at least 2 apples and 2 avocados when have >= 6 fruits. Otherwise, adding an item should do nothing
     * fruit hamper has price surcharge of 25%, rounded up to nearest integer
     */

    @Override
    public int getPrice(){
        return (int) Math.ceil( super.getPrice() * 1.25 );
    }

    @Override
    public void add(Fruit e, int n){
        if (fruitHamperPreconditionsAreSatisfied(e, n)) {
            super.add(e, n);
        }
    }

    private boolean fruitHamperPreconditionsAreSatisfied(Item e, int n) {
        int numItem = 0;
        int numAvo = 0;
        int numApple = 0;
        Iterator<Count<Fruit>> iter = iterator();
        while(iter.hasNext()) {
            Count<Fruit> c = iter.next();
            Item item = c.getElement();
            int num = c.getCount();
            if (item instanceof Avocado) {
                numAvo += num;
            } else if (item instanceof Apple) {
                numApple += num;
            }
            numItem += num;
        }
        if (e instanceof Avocado) {
            numAvo += n;
        }
        if (e instanceof Apple) {
            numApple += n;
        }
        numItem += n;

        return numItem < 6 || (numAvo >= 2 && numApple >= 2);
    }

}
