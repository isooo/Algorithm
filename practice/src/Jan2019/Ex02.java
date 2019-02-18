package Jan2019;

/*
   Add the missing code to Chicken and Egg so the following actions are completed:
    - Chicken implements the Bird Interface base class.
    - A Chicken lays an egg that will hatch into a new Chicken.
     Eggs from other types of birds should hatch into a new bird of their parent type.
     Hatching an egg for the second time throws a [System.lnvalidOperationException].

    닭은 알을 낳는다
    알은 부화해서 새로운 닭이된다
    부화된 알을 다시 부화시킬 땐 에러
 */

interface Bird {
}

class Chicken implements Bird {

    void hatch(Egg egg) throws InvalidOperationException {
        if (!egg.isHatched()) {
            egg.setHatched(true);
            System.out.println("The egg is hatched :)");
        } else {
            throw new InvalidOperationException("already hatched Egg!");
        }
    }
}

class Egg {
    private boolean hatched;

    public Egg() {
        hatched = false;
    }

    public void setHatched(boolean hatched) {
        this.hatched = hatched;
    }

    public boolean isHatched() {
        return hatched;
    }
}

class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        System.out.println(message);
    }
}

public class Ex02 {
    public static void main(String[] args) throws InvalidOperationException{
        Chicken chic = new Chicken();
        Egg e = new Egg();
        chic.hatch(e);

        Chicken chic2 = new Chicken();
        chic2.hatch(e);
    }
}
