import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    void testDeliveryOneKgSameCityAppliesDiscount() {
        // Arrange (Підготовка)
        double weight = 1.0;
        boolean sameCity = true;

        // Act (Виконання)
        double result = Delivery.deliveryCost(weight, sameCity);

        // Assert (Перевірка): 40 базових - 20% знижки = 32.0
        assertEquals(32.0, result);
    }

    @Test
    void testDeliveryTwoAndHalfKgOtherCityAddsSurchargeForOneFullKg() {
        // Arrange
        double weight = 2.5;
        boolean sameCity = false;

        // Act
        double result = Delivery.deliveryCost(weight, sameCity);

        // Assert: 40 базових + (1 повний кг * 15) = 55.0
        assertEquals(55.0, result);
    }

    @Test
    void testDeliveryExactlyOneKgOtherCityNoSurcharge() {
        // Arrange (Межа)
        double weight = 1.0;
        boolean sameCity = false;

        // Act
        double result = Delivery.deliveryCost(weight, sameCity);

        // Assert: 40 базових + 0 доплати = 40.0
        assertEquals(40.0, result);
    }

    @Test
    void testDeliveryZeroWeightThrowsException() {
        // Arrange (Відмова)
        double weight = 0.0;
        boolean sameCity = false;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Delivery.deliveryCost(weight, sameCity);
        });
        assertEquals("Вага має бути більшою за 0", exception.getMessage());
    }
}
