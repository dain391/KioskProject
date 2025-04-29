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

    // 장바구니 출력
    public void showCart() {
        if (menuItems.isEmpty()) {
            System.out.println("\n장바구니가 비어 있습니다.");
            return;
        }
        System.out.println("\n[ ORDERS ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            int quantity = quantities.get(i);
            System.out.println(item.getName() + " | w " + item.getPrice() + " | " + item.getInfo() + " | 수량 : " + quantity);
        }
        System.out.println("\n[ TOTAL ]");
        System.out.println("w " + getTotalPrice());
    }

    // 장바구니 총 금액 계산
    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < menuItems.size(); i++) {
            total += menuItems.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    // 장바구니 초기화
    public void clearCart() {
        menuItems.clear();
        quantities.clear();
    }

    // 장바구니 비어있는지 확인
    public boolean isEmpty() {
        return menuItems.isEmpty();
    }
}