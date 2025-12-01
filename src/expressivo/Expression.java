package expressivo;

/**
 * Expression is an immutable datatype representing arithmetic expressions
 * consisting of:
 *   - numbers      (double)
 *   - variables    (nonempty alphabetic strings)
 *   - addition     (e1 + e2)
 *   - multiplication (e1 * e2)
 *
 * Rep definition (AST):
 *   Expression = Number(value: double)
 *               | Variable(name: String)
 *               | Plus(left: Expression, right: Expression)
 *               | Times(left: Expression, right: Expression)
 *
 * Expression is immutable.
 */
public interface Expression {

    static Expression parse(String input) {
        return null;
    }

    /** @return string form of the expression (valid concrete syntax) */
    @Override String toString();

    /** Structural equality */
    @Override boolean equals(Object obj);

    /** Structural hashCode — must be consistent with equals */
    @Override int hashCode();

}
