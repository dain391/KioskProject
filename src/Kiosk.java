import com.sun.security.jgss.GSSUtil;

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
            System.out.println("\n[ SHAKESHACK MENU ]");

            // 리스트 메뉴 출력 (상위 카테고리 출력)
            int index = 1;
            for (Menu menu : menus) {
                System.out.println(index++ + ". " + menu.getCategory());
            }
            System.out.println("0. Exit");

            // 메뉴 선택 받기
            System.out.print("\n메뉴를 선택하세요: ");
            int select = -1;
            try {
                select = sc.nextInt(); // 숫자 입력 받기
                sc.nextLine(); // 버퍼 비우기
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine(); // 잘못된 입력 버퍼 비우기
                continue; // 잘못 입력 시 다시 선택
            }

            // 종료 처리
            if (select == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 메뉴 선택 처리
            if (select > 0 && select <= menus.size()) {
                Menu selected = menus.get(select - 1); // 리스트는 0부터 시작이므로 -1

                // 메뉴의 아이템 출력
                while (true) {
                    System.out.println("\n[ " + selected.getCategory().toUpperCase() + " MENU ]");
                    int index2 = 1;
                    for (MenuItem item : selected.getMenuItems()) {
                        System.out.println("0. Back          | w  -  | '0'을 입력하면 뒤로 이동합니다.");
                    }

                    // 메뉴 아이템 선택 받기
                    System.out.print("\n메뉴를 선택하세요: ");
                    int itemSelect = sc.nextInt();

                    // 뒤로 가기
                    if (itemSelect == 0) {
                        break;
                    }

                    try {
                        // 선택한 메뉴 아이템 출력
                        if (itemSelect > 0 && itemSelect <= selected.getMenuItems().size()) {
                            MenuItem selectedItem = selected.getMenuItems().get(itemSelect - 1);
                            System.out.println(selectedItem.getName() + "를 선택하셨습니다.");
                            System.out.println("가격: W " + selectedItem.getPrice());
                            System.out.println("설명: " + selectedItem.getInfo());
                        } else {
                            System.out.println("잘못된 입력입니다. 메뉴를 다시 입력해주세요.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    }
                }
            }
        }
    }
}