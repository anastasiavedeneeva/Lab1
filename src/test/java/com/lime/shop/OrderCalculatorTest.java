package com.lime.shop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {

    @Test
    void testCalculateTotal_Standard() {
        DiscountService discountService = new DiscountService();
        DeliveryService deliveryService = new DeliveryService();
        UserService userService = new UserService();

        OrderCalculator calculator = new OrderCalculator(discountService, deliveryService, userService);

        double total = calculator.calculateTotal(10000, 2, null, "user123", false);

        // Фактический результат: 10000 - 10% скидка = 9000 + 500 доставка = 9500
        assertEquals(9500.0, total);
    }

    @Test
    void testCalculateTotal_WithDiscount() {
        DiscountService discountService = new DiscountService();
        DeliveryService deliveryService = new DeliveryService();
        UserService userService = new UserService();

        OrderCalculator calculator = new OrderCalculator(discountService, deliveryService, userService);

        double total = calculator.calculateTotal(10000, 2, "LIME2026", "user123", false);

        // 10000 - 17% (10% + 7%) = 8300 + 500 доставка = 8800
        assertEquals(8800.0, total);
    }

    @Test
    void testCalculateTotal_FreeDelivery() {
        DiscountService discountService = new DiscountService();
        DeliveryService deliveryService = new DeliveryService();
        UserService userService = new UserService();

        OrderCalculator calculator = new OrderCalculator(discountService, deliveryService, userService);

        double total = calculator.calculateTotal(20000, 3, null, "user123", false);

        // 20000 - 10% = 18000 + доставка 0 = 18000
        assertEquals(18000.0, total);
    }
}