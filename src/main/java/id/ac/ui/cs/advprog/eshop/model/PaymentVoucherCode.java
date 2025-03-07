package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;

import java.util.Map;

public class PaymentVoucherCode extends Payment {
    public PaymentVoucherCode(String id, Order order, Map<String, String> paymentData) {
        super(id, PaymentMethod.VOUCHER_CODE.getValue(), order, paymentData);
    }

    public PaymentVoucherCode(String id, Order order, Map<String, String> paymentData, String status) {
        super(id, PaymentMethod.VOUCHER_CODE.getValue(), order, paymentData, status);
    }
}