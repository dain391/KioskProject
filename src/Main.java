import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // burger 객체 생성
        List<MenuItem> burger = new ArrayList<>();
        burger.add(new MenuItem("ShackBurger", 6.9, "토마토와 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"));
        burger.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프 패티가 토핑된 치즈버거"));
        burger.add(new MenuItem("Hamburger", 5.4, "비프 패티 기반으로 야채가 들어간 기본버거"));

        // drink
        List<MenuItem> drink = new ArrayList<>();
        drink.add(new MenuItem("coke", 1.5, "코카콜라 (제로 콜라 가능!)                   "));
        drink.add(new MenuItem("OrangeJuice", 1.8, "오렌지 / 토마토 / 포도 (중 택 1)             "));

        // side
        List<MenuItem> side = new ArrayList<>();
        side.add(new MenuItem("FrenchFries", 1.6, "바삭하고 짭조롬한 감자 튀김 (케첩 추가 가능)"));
        side.add(new MenuItem("OnionRings", 3.5, "바삭하고 촉촉한 양파링 튀김 4조각 (소스 포함)"));
        side.add(new MenuItem("IceCream", 2.0, "우유 / 바닐라 / 초코쉘 (중 택 1)             "));

        // 각 카테고리별 객체
        Menu burgerMenu = new Menu("Burgers", burger);
        Menu drinkrMenu = new Menu("Drink", drink);
        Menu sideMenu = new Menu("Side", side);

        // 메뉴 리스트 카테고리 추가
        List<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinkrMenu);
        menus.add(sideMenu);

        Kiosk kiosk = new Kiosk(menus); // Kiosk 객체 생성
        kiosk.start(); // Kiosk 클래스의 start() 호출
    }
}