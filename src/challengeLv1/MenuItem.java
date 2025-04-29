package challengeLv1;

public class MenuItem {
    private String name;
    private double price;
    private String info;

    // 생성자
    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    // getter (변경 필요 없기에 setter 제외)
    // 이름 리턴
    public String getName() {
        return name;
    }

    // 가격 리턴
    public double getPrice() {
        return price;
    }

    // 설명 리턴
    public String getInfo() {
        return info;
    }
}