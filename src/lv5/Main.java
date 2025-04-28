package lv5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // burger 객체 생성
        List<MenuItem> burger = new ArrayList<>();
        burger.add(new MenuItem("ShackBurger  ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.add(new MenuItem("SmokeShack   ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.add(new MenuItem("Cheeseburger ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.add(new MenuItem("Hamburger    ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // drink
        List<MenuItem> drink = new ArrayList<>();
        drink.add(new MenuItem("coke         ", 1.5, "코카콜라나 펩시"));
        drink.add(new MenuItem("OrangeJuice  ", 1.8, "시원한 오렌지 주스"));

        // side
        List<MenuItem> side = new ArrayList<>();
        side.add(new MenuItem("FrenchFries  ", 1.6, "바삭한 감자튀김"));
        side.add(new MenuItem("OnionRings   ", 3.5, "바삭한 양파튀김"));
        side.add(new MenuItem("IceCream     ", 2.0, "바닐라 아이스크림"));

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