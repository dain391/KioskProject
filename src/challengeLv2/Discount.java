package challengeLv2;

public class Discount {
    // 할인 계산
    public static double applyDiscount(double totalPrice, int userTypeChoice) {
        UserType userType = null;
        // 입력에 따른 설정
        switch (userTypeChoice) {
            case 1 -> userType = UserType.VETERAN;
            case 2 -> userType = UserType.SOLDIER;
            case 3-> userType = UserType.STUDENT;
            case 4 -> userType = UserType.GENERAL;
            default -> {
                System.out.println("잘못된 입력입니다.");
                return totalPrice;
            }
        }
        // 할인 적용
        double discountRate = userType.getDiscountRate();
        return totalPrice * (1 - discountRate); // 최종 금액
    }
}
