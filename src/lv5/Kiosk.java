package lv5;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Kiosk {
    private List<Menu> menus; // 카테고리 리스트

    // 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    // 프로그램 시작
    public void start() {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);

        // 반복문 시작
        while (true) {
            System.out.println("\n[ MAIN MENU ]");

            // 리스트 메뉴 출력 (상위 카테고리 출력)
            int index = 1;
            for (Menu menu : menus) {
                System.out.println(index++ + ". " + menu.getCategory());
            }
            System.out.println("0. Exit");

            // 메뉴 선택 받기 (while문으로 입력 반복 처리)
            int select = -1;
            while (select < 0 || select > menus.size()) {
                System.out.print("\n메뉴를 선택하세요: ");
                try {
                    select = sc.nextInt(); // 숫자 입력 받기
                    sc.nextLine(); // 버퍼 비우기

                    if (select < 0 || select > menus.size()) {
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    sc.nextLine(); // 잘못된 입력 버퍼 비우기
                }
            }

            // 종료 처리
            if (select == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 메뉴 선택 처리
            Menu selected = menus.get(select - 1); // 리스트는 0부터 시작이므로 -1

            // 메뉴의 아이템 출력
            while (true) {
                System.out.println("\n[ " + selected.getCategory().toUpperCase() + " MENU ]");
                int index2 = 1;
                for (MenuItem item : selected.getMenuItems()) {
                    System.out.println(index2++ + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getInfo());
                }

                // 뒤로 가기 옵션 추가
                System.out.println("0. Back          | w  -  | 이전");

                // 메뉴 아이템 선택 받기
                int itemSelect = -1;
                while (itemSelect < 0 || itemSelect > selected.getMenuItems().size()) {
                    System.out.print("\n메뉴를 선택하세요: ");
                    try {
                        itemSelect = sc.nextInt(); // 숫자 입력 받기
                        sc.nextLine(); // 버퍼 비우기

                        if (itemSelect < 0 || itemSelect > selected.getMenuItems().size()) {
                            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                        sc.nextLine(); // 잘못된 입력 버퍼 비우기
                    }
                }
                // 뒤로 가기
                if (itemSelect == 0) {
                    break;
                }
                // 선택한 메뉴 아이템 출력
                MenuItem selectedItem = selected.getMenuItems().get(itemSelect - 1);
                System.out.println("선택한 메뉴: " + selectedItem.getName().trim() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getInfo());
            }
        }
    }
}