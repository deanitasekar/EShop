package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Product> products;
    List<Payment> payments;
    Order order;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        payments = new ArrayList<>();
        products = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Product product2 = new Product();
        product2.setProductId("fb558e9f-1c39-460e-8860-71af6af63bd6");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product2);

        order = new Order("gb558e9f-1c39-460e-8860-71af6af63bd6",
                products, 1708560000L, "Safira Sudrajat");

        Map<String, String> voucherData = new HashMap<>();
        voucherData.put("voucherCode", "ESHOP123");

        Map<String, String> codData = new HashMap<>();
        codData.put("address", "Jl. Bacang 123");
        codData.put("deliveryFee", "101700");

        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                PaymentMethod.VOUCHER_CODE.getValue(), order, voucherData);
        payments.add(payment1);

        Payment payment2 = new Payment("7f9e15bb-1c39-460e-8860-54eb1396d79b",
                PaymentMethod.CASH_ON_DELIVERY.getValue(), order, codData);
        payments.add(payment2);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.get(1);
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertSame(payment.getPaymentData(), findResult.getPaymentData());
    }

    @Test
    void testSaveAndCreateVoucher() {
        Map<String, String> voucherData = new HashMap<>();
        voucherData.put("voucherCode", "ESHOP1234ABC5678");

        Payment voucherPayment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d72c",
                PaymentMethod.VOUCHER_CODE.getValue(), order, voucherData
        );

        Payment result = paymentRepository.save(voucherPayment);
        Payment findResult = paymentRepository.findById(voucherPayment.getId());

        assertEquals(voucherPayment.getId(), result.getId());
        assertEquals(voucherPayment.getId(), findResult.getId());
        assertEquals(PaymentMethod.VOUCHER_CODE.getValue(), findResult.getMethod());
        assertEquals(PaymentStatus.PENDING.getValue(), findResult.getStatus());
        assertEquals("ESHOP1234ABC5678", findResult.getPaymentData().get("voucherCode"));
    }

    @Test
    void testSaveAndCreateCashOnDelivery() {
        Map<String, String> codData = new HashMap<>();
        codData.put("address", "Jl. Beji No. 60");
        codData.put("deliveryFee", "78800");

        Payment codPayment = new Payment(
                "7f9e15bb-1c39-460e-8860-54eb1396d72d",
                PaymentMethod.CASH_ON_DELIVERY.getValue(), order, codData
        );

        Payment result = paymentRepository.save(codPayment);
        Payment findResult = paymentRepository.findById(codPayment.getId());

        assertEquals(codPayment.getId(), result.getId());
        assertEquals(PaymentMethod.CASH_ON_DELIVERY.getValue(), findResult.getMethod());
        assertEquals(PaymentStatus.PENDING.getValue(), findResult.getStatus());
        assertEquals("Jl. Beji No. 60", findResult.getPaymentData().get("address"));
    }

    @Test
    void testFindByIdIfIdFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
        assertSame(payments.get(1).getPaymentData(), findResult.getPaymentData());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("1234567890");
        assertNull(findResult);
    }
}