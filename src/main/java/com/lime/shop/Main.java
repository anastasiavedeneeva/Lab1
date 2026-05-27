package com.lime.shop;

public class Main {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        DeliveryService deliveryService = new DeliveryService();
        UserService userService = new UserService();
        OrderCalculator calculator = new OrderCalculator(
                discountService, deliveryService, userService
        );

        // Пример 1: обычный пользователь
        double total1 = calculator.calculateTotal(
                12000, 3, "LIME2026", "user123", false
        );
        System.out.println("Итоговая сумма (обычный пользователь): " + total1);

        // Пример 2: постоянный клиент
        double total2 = calculator.calculateTotal(
                12000, 3, "LIME2026", "loyalUser", false
        );
        System.out.println("Итоговая сумма (постоянный клиент): " + total2);

        // Пример 3: большая сумма + бесплатная доставка
        double total3 = calculator.calculateTotal(
                20000, 2, null, "user123", false
        );
        System.out.println("Итоговая сумма (бесплатная доставка): " + total3);
    }
}