package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PaymentCashOnDeliveryTest {
    private Map<String, String> paymentData;
    private Order order;

    @BeforeEach
    void setUp() {
        paymentData = new HashMap<>();
        paymentData.put("address", "Jl. Sudirman No. 123");
        paymentData.put("deliveryFee", "50000");

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(2);
        products.add(product);

        order = new Order("order-123", products, 1708560000L, "Safira Sudrajat");
    }

    @Test
    void testValidPaymentData() {
        PaymentCashOnDelivery payment = new PaymentCashOnDelivery("payment-123", order, paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testEmptyAddress() {
        paymentData.put("address", "");
        PaymentCashOnDelivery payment = new PaymentCashOnDelivery("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testNullDeliveryFee() {
        paymentData.remove("deliveryFee");
        PaymentCashOnDelivery payment = new PaymentCashOnDelivery("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testEmptyPaymentData() {
        paymentData.clear();
        assertThrows(IllegalArgumentException.class, () ->
                new PaymentCashOnDelivery("payment-123", order, paymentData)
        );
    }
}