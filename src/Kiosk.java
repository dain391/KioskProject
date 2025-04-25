import java.util.Scanner;

public class Kiosk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n[ SHAKESHACK MENU ]"); // 메뉴 시작
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. Exit          | W -   |'0'을 입력하면 종료합니다"); // 종료 옵션

            System.out.print("\n메뉴를 선택하세요: ");
            String input = sc.nextLine();
            input = input.trim(); // 공백 제거, 대소문자 무시

            // 종료 처리
            if (input.equals("0") || input.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input.equals("1") || input.equalsIgnoreCase("shackburger")) {
                System.out.println("ShackBurger를 선택하셨습니다.");
            } else if (input.equals("2") || input.equalsIgnoreCase("smokeshack")) {
                System.out.println("SmokeShack를 선택하셨습니다.");
            } else if (input.equals("3") || input.equalsIgnoreCase("cheeseburger")) {
                System.out.println("Cheeseburger를 선택하셨습니다.");
            } else if (input.equals("4") || input.equalsIgnoreCase("hamburger")) {
                System.out.println("Hamburger를 선택하셨습니다.");
            } else {
                System.out.println("잘못된 입력입니다. 메뉴를 다시 입력해주세요.");
            }
        }
        sc.close();
    }
}