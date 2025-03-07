package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

public class PaymentCashOnDelivery extends Payment {
    public PaymentCashOnDelivery(String id, Order order, Map<String, String> paymentData) {
        super(id, method, paymentData);
    }

    public PaymentCashOnDelivery(String id, Order order, Map<String, String> paymentData, String status) {
        super(id, method, paymentData);
    }

    private void validatePaymentData(Map<String, String> paymentData) {
    }
}