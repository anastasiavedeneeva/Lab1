package com.lime.shop;

public class DiscountService {

    public double calculateDiscount(double orderAmount, int itemCount, String promoCode) {
        double discount = 0.0;

        // Скидка 5% при сумме от 5000 до 9999
        if (orderAmount >= 5000 && orderAmount < 10000) {
            discount = 0.05;
        }
        // Скидка 10% при сумме от 10000
        else if (orderAmount >= 10000) {
            discount = 0.10;
        }

        // Дополнительная скидка 3% при количестве товаров >= 5
        if (itemCount >= 5) {
            discount += 0.03;
        }

        // Промокод "LIME2026" даёт дополнительную скидку 7%
        if (promoCode != null && promoCode.equals("LIME2026")) {
            discount += 0.07;
        }

        // Скидка не может превышать 25%
        return Math.min(discount, 0.25);
    }

    public double applyDiscount(double amount, double discountRate) {
        return amount * (1 - discountRate);
    }
}