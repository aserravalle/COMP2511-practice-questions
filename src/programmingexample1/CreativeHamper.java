package programmingexample1;

import java.util.Iterator;

public class CreativeHamper extends ArrayListItemHamper<Item> {
    /**
     * invariant: if hamper contains 5 or more items, it must contain at least 2 toy cars (at least 1 must be premium) and at least 2 fruits. Otherwise, adding an item should do nothing
     * creative hamper has a price surcharge of $10
     */


    @Override
    public int getPrice(){
        return super.getPrice() + 10;
    }

    @Override
    public void add(Item e, int n){
        if (creativeHamperPreconditionsAreSatisfied(e, n)) {
            super.add(e, n);
        }
    }

    private boolean creativeHamperPreconditionsAreSatisfied(Item e, int n) {
        int numItem = 0;
        int numFruit = 0;
        int numCar = 0;
        int numPremCar = 0;
        Iterator<Count<Item>> iter = iterator();
        while(iter.hasNext()) {
            Count<Item> c = iter.next();
            Item item = c.getElement();
            int num = c.getCount();
            if (item instanceof Fruit) {
                numFruit += num;
            }
            if (item instanceof ToyCar) {
                numCar += num;
            }
            if (item instanceof PremiumToyCar) {
                numPremCar += num;
            }
            numItem += num;
        }
        if (e instanceof Fruit) {
            numFruit += n;
        }
        if (e instanceof ToyCar) {
            numCar += n;
        }
        if (e instanceof PremiumToyCar) {
            numPremCar += n;
        }
        numItem += n;

        return numItem < 5 || (numFruit >= 2 && numCar >= 2 && numPremCar >= 1);
    }
}
