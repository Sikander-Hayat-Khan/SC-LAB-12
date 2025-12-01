package expressivo;

import java.util.Objects;

/**
 * Immutable multiplication expression.
 */
public final class TimesExpression implements Expression {

    private final Expression left;
    private final Expression right;

    // rep invariant: left != null, right != null
    // AF(left, right) = (left * right)

    public TimesExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }

    private void checkRep() {
        assert left != null;
        assert right != null;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TimesExpression)) return false;
        TimesExpression t = (TimesExpression) obj;

        return left.equals(t.left) && right.equals(t.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash("TIMES", left.hashCode(), right.hashCode());
    }
}
