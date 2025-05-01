package challengeLv2;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        System.out.println("\n아래와 같이 주문 하시겠습니까?");
        System.out.println("[ ORDERS ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            int quantity = quantities.get(i);
            System.out.printf("%-12s | w %-3.1f | %-30s | 수량 : %d\n", item.getName(), item.getPrice(), item.getInfo(), quantity);
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
        // 소수점 둘째자리 반올림
        BigDecimal bd = new BigDecimal(total);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue(); // 포맷팅된 double 반환
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

    // 이름 일치 메뉴 제거
    public boolean removeItem(String name) {
        int oSize = menuItems.size();

        // Stream + filler 사용 / 이름 일치 X 항목 유지
        menuItems = menuItems.stream()
                .filter(item -> !item.getName().equalsIgnoreCase(name))
                .toList();

        return menuItems.size() < oSize; // 제거됐다면 true
    }
}