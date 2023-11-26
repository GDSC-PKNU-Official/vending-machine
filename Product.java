import java.util.HashMap;

public class Product {
    HashMap<Long, Drink> drinkList = new HashMap<>();

    public Product() {
        drinkList.put(1L, new Drink("스프라이트", 1500, 1));
        drinkList.put(2L, new Drink("코카콜라", 1300, 1));
        drinkList.put(3L, new Drink("솔의눈", 1000, 1));
        drinkList.put(4L, new Drink("펩시 콜라", 1100, 1));
        drinkList.put(5L, new Drink("TOP커피", 2500, 2));
        drinkList.put(6L, new Drink("꿀물", 3000, 2));
        drinkList.put(7L, new Drink("홍삼차", 3000, 2));
        drinkList.put(8L, new Drink("단팥죽", 3000, 2));
    }




}