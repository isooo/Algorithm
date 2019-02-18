package Feb2019.COSPro2;

import java.util.ArrayList;
import java.util.Iterator;

class Ex08_2 {

// setOrderList 메소드는 주문 메뉴의 리스트를 매개변수로 받아 저장합니다. getTotalPrice 메소드는 주문받은 음식 가격의 총합을 return 합니다.

    interface DeliveryStore {
        public void setOrderList(String[] orderList);
        public int getTotalPrice();
    }

    class PizzaStore implements DeliveryStore {
        private final ArrayList<Food> menuList;
        private ArrayList<String> orderList;

        public PizzaStore() {
            //init menuList
            menuList = new ArrayList<Food>();
            String[] menuNames = {"Cheese", "Potato", "Shrimp", "Pineapple", "Meatball"};
            int[] menuPrices = {11100, 12600, 13300, 21000, 19500};
            for (int i = 0; i < 5; i++) {
                menuList.add(new Food(menuNames[i], menuPrices[i]));
            }

            //init orderList
            orderList = new ArrayList<String>();
        }

        // 주문 메뉴의 리스트를 저장
        @Override
        public void setOrderList(String[] orderList) {
            for(String order : orderList) {
                this.orderList.add(order);
            }
        }

        // 주문받은 음식 가격의 총합
        @Override
        public int getTotalPrice() {
            int total = 0;

            for(String order : this.orderList) {
                for(Food menu : this.menuList) {
                    if(menu.name.equals(order)) {
                        total += menu.price;
                    }
                }
            }
            return total;
        }
    }

    class Food {
        public String name;
        public int price;

        public Food(String name, int price) {
            this.name = name;
            this.price = price;
        }

    }

    private int solution(String[] orderList) {
        DeliveryStore store = new PizzaStore();
        store.setOrderList(orderList);
        return store.getTotalPrice();
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex08_2 ex08 = new Ex08_2();
        String[] orderList = {"Cheese", "Pineapple", "Meatball"};
        int ret = ex08.solution(orderList);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
