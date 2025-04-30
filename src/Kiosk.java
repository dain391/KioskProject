import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Kiosk {
    private List<Menu> menus; // 카테고리 리스트
    private Cart cart;

    // 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart(); // Kiosk 생성 시 장바구니도 같이
    }

    // 프로그램 시작
    public void start() {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);

        // 반복문 시작
        while (true) {
            System.out.println("\n아래 메뉴판에서 원하시는 항목을 선택하세요.");
            System.out.println("[ MAIN MENU ]");

            // 리스트 메뉴 출력 (상위 카테고리 출력)
            int index = 1;
            for (Menu menu : menus) {
                System.out.println(index++ + ". " + menu.getCategory());
            }
            System.out.println("0. Exit");

            if (!cart.isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders | 장바구니 확인 후 주문합니다.");
                System.out.println("5. Cancel | 진행중인 주문을 취소합니다.");
            }

            int maxOption = menus.size(); // 기본은 카테고리 개수
            if (!cart.isEmpty()) {
                maxOption = 5; // 장바구니가 있으면 5까지 허용
            }

            // 메뉴 선택 받기 (while문으로 입력 반복 처리)
            int select = -1;
            while (select < 0 || select > maxOption) {
                System.out.print("\n카테고리를 선택하세요 > ");
                try {
                    select = sc.nextInt(); // 숫자 입력 받기
                    sc.nextLine(); // 버퍼 비우기

                    if (select < 0 || select > maxOption) {
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

            // 장바구니 관련 기능 처리
            if (select == 4) { // 주문 메뉴
                if (cart.isEmpty()) {
                    System.out.println("장바구니가 비어있습니다. 주문할 수 없습니다.");
                    continue;
                }
                cart.showCart();
                System.out.println("\n1. 주문하기    2. 메뉴판으로 돌아가기");
                int orderSelect = -1;
                while (true) {
                    System.out.print("선택하세요 > ");
                    try {
                        orderSelect = sc.nextInt();
                        sc.nextLine(); // 버퍼 비우기
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                        sc.nextLine();
                    }
                }
                // 주문 시 할인
                if (orderSelect == 1) {
                    int userTypeChoice = 0;

                    // 할인 선택
                    while (true) {
                        System.out.println("할인 정보를 입력해주세요.");
                        System.out.println("1. 국가유공자 : 10%");
                        System.out.println("2. 군     인 : 5%");
                        System.out.println("3. 학     생 : 3%");
                        System.out.println("4. 일     반 : 0%");
                        System.out.print("입력하세요 > ");

                        userTypeChoice = sc.nextInt();
                        // 값 검증
                        if (userTypeChoice >= 1 && userTypeChoice <= 4) {
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                        }
                    }
                    // 장바구니 총액
                    double totalPrice = cart.getTotalPrice();

                    // discount 클래스에서 할인 계싼 호출
                    double finalPrice = Discount.applyDiscount(totalPrice, userTypeChoice);

                    System.out.println("주문이 완료되었습니다. 금액은 w%.1f 입니다.\n" + finalPrice);
                    cart.clearCart(); // 주문 완료 후 장바구니 비우기
                } else {
                    System.out.println("메뉴판으로 돌아갑니다.");
                }
                continue;
            }
            if (select == 5) {
                if (cart.isEmpty()) {
                    System.out.println("장바구니가 비어있습니다. 취소할 주문이 없습니다");
                    continue;
                }
                cart.clearCart();
                System.out.println("진행 중인 주문이 취소되었습니다.");
                continue;
            }

            // 메뉴 선택 처리
            Menu selected = menus.get(select - 1); // 리스트는 0부터 시작이므로 -1

            // 메뉴의 아이템 출력
            while (true) {
                System.out.println("\n[ " + selected.getCategory().toUpperCase() + " MENU ]");
                int index2 = 1;
                for (MenuItem item : selected.getMenuItems()) {
                    System.out.printf("%-1d. %-12s | W %3.1f | %s\n",
                            index2++, item.getName(), item.getPrice(), item.getInfo());
                }

                // 뒤로 가기 옵션 추가
                System.out.println("0. Back         | w  -  | 이전");

                // 메뉴 아이템 선택 받기
                int itemSelect = -1;
                while (itemSelect < 0 || itemSelect > selected.getMenuItems().size()) {
                    System.out.print("\n메뉴를 선택하세요 > ");
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
                System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getInfo());

                // 장바구니에 담을지 확인
                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                int addCartSelect = -1;
                while (true) {
                    System.out.print("선택하세요 > ");
                    try {
                        addCartSelect = sc.nextInt();
                        sc.nextLine(); // 버퍼 비움
                        break;
                    } catch (InputMismatchException i) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                        sc.nextLine();
                    }
                }
                if (addCartSelect == 1) {
                    cart.addItem(selectedItem);
                    System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.");
                } else {
                    System.out.println("메뉴 추가를 취소했습니다.");
                }
            }
        }
    }
}