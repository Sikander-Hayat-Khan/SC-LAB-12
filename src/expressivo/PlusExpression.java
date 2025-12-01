package expressivo;

import java.util.Objects;

/**
 * Immutable addition expression.
 */
public final class PlusExpression implements Expression {

    private final Expression left;
    private final Expression right;

    // rep invariant: left != null, right != null
    // AF(left, right) = (left + right)

    public PlusExpression(Expression left, Expression right) {
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
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PlusExpression)) return false;
        PlusExpression p = (PlusExpression) obj;

        return left.equals(p.left) && right.equals(p.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash("PLUS", left.hashCode(), right.hashCode());
    }
}
