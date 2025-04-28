package lv3;

public class MenuItem {
    private String name; // 메뉴 이름
    private double price; // 가격
    private String info; // 설명

    // 생성자
    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    // getter
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    // 메뉴 정보 출력
    public void printMenu() {
        System.out.println(name + " | w " + price + " | " + info);
    }
}