import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 속성
    private List<MenuItem> menuItems = new ArrayList<>(); // 담은 메뉴 리스트
    private List<Integer> quantities = new ArrayList<>(); // 각각 수량 리스트

    // 기능
    // 장바구니에 아이템 추가
    public void addItem(MenuItem menuItem) {
        int index = menuItems.indexOf(menuItem);
        if (index >= 0) {
            // 이미 있으면 수량 중가
            quantities.set(index, quantities.get(index) + 1);
        } else {
            // 없는 상품이면 새로 추가
            menuItems.add(menuItem);
            quantities.add(1);
        }
    }
}