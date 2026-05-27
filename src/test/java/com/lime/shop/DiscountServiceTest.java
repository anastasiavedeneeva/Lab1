package com.lime.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    @DisplayName("Скидка 0% при сумме заказа < 5000")
    void testCalculateDiscount_Under5000() {
        double discount = discountService.calculateDiscount(4000, 1, null);
        assertEquals(0.0, discount);
    }

    @Test
    @DisplayName("Скидка 5% при сумме от 5000 до 9999")
    void testCalculateDiscount_5000To9999() {
        double discount = discountService.calculateDiscount(7500, 1, null);
        assertEquals(0.05, discount);
    }

    @Test
    @DisplayName("Скидка 10% при сумме от 10000")
    void testCalculateDiscount_10000AndAbove() {
        double discount = discountService.calculateDiscount(12000, 1, null);
        assertEquals(0.10, discount);
    }

    @Test
    @DisplayName("Дополнительная скидка 3% при количестве товаров >= 5")
    void testCalculateDiscount_BulkDiscount() {
        double discount = discountService.calculateDiscount(4000, 5, null);
        assertEquals(0.03, discount);
    }

    @Test
    @DisplayName("Скидка по промокоду LIME2026")
    void testCalculateDiscount_PromoCode() {
        double discount = discountService.calculateDiscount(4000, 1, "LIME2026");
        assertEquals(0.07, discount);
    }

    @Test
    @DisplayName("ApplyDiscount: корректное применение скидки")
    void testApplyDiscount() {
        double result = discountService.applyDiscount(1000, 0.10);
        assertEquals(900.0, result);
    }
}