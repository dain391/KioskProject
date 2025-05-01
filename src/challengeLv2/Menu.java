package challengeLv2;

import java.util.List;

public class Menu {
    // MenuItem 클래스를 List로 관리
    private String category;
    private List<MenuItem> menuItems;

    // 생성자
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // getter (변경 필요 없기에 setter 제외)
    // 카테고리 리턴
    public String getCategory() {
        return category;
    }

    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수 -> 스트림 사용
    public void printMenuItems() {
        menuItems.stream()
                .forEachOrdered(item -> {
                    int index = menuItems.indexOf(item) + 1;
                    System.out.println(index + ". " + item.getName() + " | w " + item.getPrice() + " | " + item.getInfo());
                });
    }
}