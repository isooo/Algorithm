package Jan2019;

public class Ex02 {
/*
   Add the missing code to Chicken and Egg so the following actions are completed:
    - Chicken implements the Bird Interface base class.
    - A Chicken lays an egg that will hatch into a new Chicken.
    - Eggs from other types of birds should hatch into a new bird of their parent type.
    - Hatching an egg for the second time throws a [System.lnvalidOperationException].
 */
}

interface Bird{
    abstract void layEgg();
}

class Chicken implements Bird {
    @Override
    public void layEgg() {

    }
}

//class Duck implements Bird {
//
//}