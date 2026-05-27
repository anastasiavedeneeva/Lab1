package com.lime.shop;

public class OrderCalculator {

    private final DiscountService discountService;
    private final DeliveryService deliveryService;
    private final UserService userService;

    public OrderCalculator(DiscountService discountService,
                           DeliveryService deliveryService,
                           UserService userService) {
        this.discountService = discountService;
        this.deliveryService = deliveryService;
        this.userService = userService;
    }

    public double calculateTotal(double orderAmount, int itemCount,
                                 String promoCode, String userId,
                                 boolean isRemoteRegion) {
        // 1. Расчёт скидки
        double discountRate = discountService.calculateDiscount(orderAmount, itemCount, promoCode);

        // 2. Дополнительная скидка для постоянных клиентов
        if (userService.isLoyalCustomer(userId)) {
            discountRate = Math.min(discountRate + 0.05, 0.25);
        }

        // 3. Применение скидки к сумме заказа
        double discountedAmount = discountService.applyDiscount(orderAmount, discountRate);

        // 4. Расчёт стоимости доставки
        double deliveryCost = deliveryService.calculateDeliveryCost(discountedAmount, isRemoteRegion);

        // 5. Итоговая сумма
        return discountedAmount + deliveryCost;
    }

    public double calculateTotalWithUserCheck(double orderAmount, int itemCount,
                                              String promoCode, String userId,
                                              boolean isRemoteRegion) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        return calculateTotal(orderAmount, itemCount, promoCode, userId, isRemoteRegion);
    }
}