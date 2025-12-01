package expressivo;

import java.util.Objects;

/**
 * Immutable variable expression.
 */
public final class VariableExpression implements Expression {
    private final String name;

    // rep invariant: name must be alphabetic
    // AF(name) = the variable with that name

    public VariableExpression(String name) {
        this.name = name;
        checkRep();
    }

    private void checkRep() {
        assert name.matches("[A-Za-z]+");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VariableExpression)) return false;
        VariableExpression v = (VariableExpression) obj;
        return name.equals(v.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
