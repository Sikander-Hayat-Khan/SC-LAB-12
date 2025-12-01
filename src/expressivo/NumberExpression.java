package expressivo;

import java.util.Objects;

/**
 * Immutable numeric expression.
 */
public final class NumberExpression implements Expression {
    private final double value;

    // rep invariant: no constraints beyond double validity
    // abstraction function: AF(value) = numeric literal represented
    // safety from rep exposure: value is primitive, immutable

    public NumberExpression(double value) {
        this.value = value;
        checkRep();
    }

    private void checkRep() {
        // nothing extra
    }

    @Override
    public String toString() {
        // avoid scientific notation for whole numbers
        if (value == Math.rint(value)) {
            return String.format("%.0f", value);
        }
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NumberExpression)) return false;
        NumberExpression other = (NumberExpression) obj;

        // integers equal to integer-looking decimals
        return Math.abs(this.value - other.value) < 1e-9;
    }

    @Override
    public int hashCode() {
        return Objects.hash((int) Math.rint(value));
    }
}
