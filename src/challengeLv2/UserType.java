package challengeLv2;

public enum UserType {
    VETERAN(0.10), // 국가유공자 10%
    SOLDIER(0.05),  // 군인 5%
    STUDENT(0.03),  // 학생 3%
    GENERAL(0.00);  // 일반인 0%

    private final double discountRate; // 각 사용자 유형에 해당 할인율 저장

    // 할인율 받아 초기화
    UserType(double discountRate) {
        this.discountRate = discountRate;
    }

    // 할인율 반환 메서드
    public double getDiscountRate() {
        return discountRate;
    }
}
