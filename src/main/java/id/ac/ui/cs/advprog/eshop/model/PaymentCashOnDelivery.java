package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import java.util.Map;

public class PaymentCashOnDelivery extends Payment {
    public PaymentCashOnDelivery(String id, Order order, Map<String, String> paymentData) {
        super(id, PaymentMethod.CASH_ON_DELIVERY.getValue(), order, paymentData);
        validatePaymentData(paymentData);
    }

    public PaymentCashOnDelivery(String id, Order order, Map<String, String> paymentData, String status) {
        super(id, PaymentMethod.CASH_ON_DELIVERY.getValue(), order, paymentData, status);
        validatePaymentData(paymentData);
    }

    private void validatePaymentData(Map<String, String> paymentData) {
        String address = paymentData.get("address");
        String deliveryFee = paymentData.get("deliveryFee");

        if (address == null || address.isEmpty() || deliveryFee == null || deliveryFee.isEmpty()) {
            this.setStatus(PaymentStatus.REJECTED.getValue());
        } else {
            this.setStatus(PaymentStatus.SUCCESS.getValue());
        }
    }
}