public class ILS extends Coin{

    final private double value = 0.28;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        double shekel = amount / getValue();
        return shekel;
    }
}
