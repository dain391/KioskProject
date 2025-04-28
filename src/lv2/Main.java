package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>(); // 메뉴 항목 관리 리스트
        // 메뉴 항목
        menuItems.add(new MenuItem("ShackBurger  ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack   ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger    ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in); // Scanner 선언

        while (true) {
            System.out.println("\n[ SHAKESHACK MENU ]"); // 메뉴 시작

            //리스트 메뉴 출력
            int index = 1;
            for (MenuItem item : menuItems) {
                System.out.print(index++ + ". ");
                item.printMenu(); // item 객체에 printMenu 메서드 호출
            }
            System.out.println("0. Exit          | w  -  | '0'을 입력하면 종료합니다."); // 종료 옵션

            System.out.print("\n메뉴를 선택하세요: ");
            String input = sc.nextLine();
            input = input.trim(); // 공백 제거, 대소문자 무시

            // 종료 처리
            if (input.equals("0") || input.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            boolean check = false;
            // 입력에 따른 처리

            // 숫자
            try {
                int selectItem = Integer.parseInt(input); // 문자열 -> 정수 변환 시도
                if (selectItem > 0 && selectItem <= menuItems.size()) {
                    MenuItem selected = menuItems.get(selectItem - 1); // 리스트는 0부터 시작이므로 -1
                    printSelected(selected);
                    check = true; // 올바른 입력 -> true
                }
                // 문자
            } catch (NumberFormatException nfx) { // 숫자가 아닌 값 입력 -> 예외 발생
                for (MenuItem item : menuItems) {
                    if (item.getName().equalsIgnoreCase(input)) {
                        printSelected(item);
                        check = true;
                        break;
                    }
                }
            }
            // 잘못된 입력 처리
            if (!check) {
                System.out.println("잘못된 입력입니다. 메뉴를 다시 입력해주세요.");
            }
        }
        sc.close();
    }
    // 메뉴 선택 시 출력
    private static void printSelected(MenuItem item) {
        System.out.println(item.getName() + "를 선택하셨습니다.");
        System.out.println("가격: W " + item.getPrice());
        System.out.println("설명: " + item.getInfo());
    }
}