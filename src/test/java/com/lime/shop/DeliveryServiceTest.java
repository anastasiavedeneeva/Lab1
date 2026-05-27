package com.lime.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    private final DeliveryService deliveryService = new DeliveryService();

    @Test
    @DisplayName("Бесплатная доставка при сумме >= 15000")
    void testCalculateDeliveryCost_FreeDelivery() {
        double cost = deliveryService.calculateDeliveryCost(15000, false);
        assertEquals(0.0, cost);
    }

    @Test
    @DisplayName("Стандартная доставка 500 руб. при сумме < 15000")
    void testCalculateDeliveryCost_Standard() {
        double cost = deliveryService.calculateDeliveryCost(10000, false);
        assertEquals(500.0, cost);
    }

    @Test
    @DisplayName("Удалённый регион: доставка 1000 руб. при сумме < 15000")
    void testCalculateDeliveryCost_RemoteRegion() {
        double cost = deliveryService.calculateDeliveryCost(10000, true);
        assertEquals(1000.0, cost);
    }
}