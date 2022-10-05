public class Fraction {
    private int dividend = 1;
    private int divisor = 1;

    public Fraction(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public Fraction add(Fraction other) {
        /**
         * @ToDo
         * Add this with other
         */
        int thisNewDivisor = this.getDivisor() * other.getDivisor();
        int thisNewDividend = this.getDividend() * other.getDivisor();

        int otherNewDivisor = other.getDivisor() * this.getDivisor();
        int otherNewDividend = other.getDividend() * this.getDivisor();

        int dividend = thisNewDividend + otherNewDividend;
        int divisor = thisNewDivisor + otherNewDivisor;

        return new Fraction(dividend, divisor);
    }

    public Fraction subtract(Fraction other) {
        /**
         * @ToDo
         * Subtract this with other
         */
        int thisNewDivisor = this.getDivisor() * other.getDivisor();
        int thisNewDividend = this.getDividend() * other.getDivisor();

        int otherNewDivisor = other.getDivisor() * this.getDivisor();
        int otherNewDividend = other.getDividend() * this.getDivisor();

        int dividend = thisNewDividend - otherNewDividend;
        int divisor = thisNewDivisor - otherNewDivisor;

        return new Fraction(dividend, divisor);
    }

    public Fraction divide(Fraction other) {
        /**
         * @ToDo
         * Divide this by other
         */
        int dividend = this.getDividend() * other.getDivisor();
        int divisor = this.getDivisor() * other.getDividend();

        return new Fraction(dividend, divisor);
    }

    public Fraction multiply(Fraction other) {
        /**
         * @ToDo
         * Multiply this with other
         */
        int dividend = this.getDividend() * other.getDividend();
        int divisor = this.getDivisor() * other.getDivisor();

        return new Fraction(dividend, divisor);
    }

    public Fraction shorten() {
        /**
         * @ToDo
         * Shorten the fraction (kürzen)
         */
        int largerOne = Math.max(this.dividend, this.divisor);
        int gcd = 0;

        for (int i = largerOne; i >= 2; i--) {
            if (this.dividend % i == 0 && this.divisor % i == 0) {
                gcd = i;
                break;
            }
        }

        if (gcd != 0) {
            this.dividend /= gcd;
            this.divisor /= gcd;
        }

        return new Fraction(this.dividend, this.divisor);
    }

    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }
}
