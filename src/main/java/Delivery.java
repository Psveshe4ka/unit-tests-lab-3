
public class Delivery {
    public static double deliveryCost(double weightKg, boolean sameCity) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Вага має бути більшою за 0");
        }

        double cost = 40.0;

        if (weightKg > 1.0) {
            int extraKg = (int) (weightKg - 1.0);
            if (extraKg > 0) {
                cost += extraKg * 15.0;
            }
        }

        if (sameCity) {
            cost *= 0.8; // Знижка 20%
        }

        return cost;
    }
}
