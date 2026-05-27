package com.lime.shop;

public class DeliveryService {

    private static final double FREE_DELIVERY_THRESHOLD = 15000.0;
    private static final double STANDARD_DELIVERY_COST = 500.0;
    private static final double REMOTE_DELIVERY_COST = 1000.0;

    public double calculateDeliveryCost(double orderAmount, boolean isRemoteRegion) {
        if (orderAmount >= FREE_DELIVERY_THRESHOLD) {
            return 0.0;
        }
        return isRemoteRegion ? REMOTE_DELIVERY_COST : STANDARD_DELIVERY_COST;
    }
}