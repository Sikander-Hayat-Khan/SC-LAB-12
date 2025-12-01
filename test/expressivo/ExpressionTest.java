package expressivo;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionTest {

    /* ========= NUMBER TESTS ========= */

    @Test
    public void testNumberToString() {
        Expression e = new NumberExpression(5);
        assertEquals("5", e.toString());
    }

    @Test
    public void testNumberEqualsDecimal() {
        assertEquals(new NumberExpression(1), new NumberExpression(1.000));
    }

    @Test
    public void testNumberNotEqual() {
        assertNotEquals(new NumberExpression(2), new NumberExpression(3));
    }

    /* ========= VARIABLE TESTS ========= */

    @Test
    public void testVariableToString() {
        Expression x = new VariableExpression("x");
        assertEquals("x", x.toString());
    }

    @Test
    public void testVariableEquals() {
        assertEquals(new VariableExpression("abc"), new VariableExpression("abc"));
    }

    @Test
    public void testVariableNotEqual() {
        assertNotEquals(new VariableExpression("x"), new VariableExpression("y"));
    }

    /* ========= PLUS TESTS ========= */

    @Test
    public void testPlusToString() {
        Expression e = new PlusExpression(new NumberExpression(1),
                new VariableExpression("x"));
        assertEquals("(1 + x)", e.toString());
    }

    @Test
    public void testPlusEqualsSameStructure() {
        Expression e1 = new PlusExpression(new NumberExpression(1), new VariableExpression("x"));
        Expression e2 = new PlusExpression(new NumberExpression(1), new VariableExpression("x"));
        assertEquals(e1, e2);
    }

    @Test
    public void testPlusNotEqualDifferentOrder() {
        Expression e1 = new PlusExpression(new NumberExpression(1), new VariableExpression("x"));
        Expression e2 = new PlusExpression(new VariableExpression("x"), new NumberExpression(1));
        assertNotEquals(e1, e2);
    }

    /* ========= TIMES TESTS ========= */

    @Test
    public void testTimesToString() {
        Expression e = new TimesExpression(new NumberExpression(2),
                new VariableExpression("y"));
        assertEquals("(2 * y)", e.toString());
    }

    @Test
    public void testTimesEqualsSameStructure() {
        Expression e1 = new TimesExpression(new NumberExpression(2), new NumberExpression(3));
        Expression e2 = new TimesExpression(new NumberExpression(2), new NumberExpression(3));
        assertEquals(e1, e2);
    }

    @Test
    public void testTimesNotEqualDifferentOperands() {
        Expression e1 = new TimesExpression(new NumberExpression(2), new NumberExpression(3));
        Expression e2 = new TimesExpression(new NumberExpression(3), new NumberExpression(2));
        assertNotEquals(e1, e2);
    }

    /* ========= NESTED EXPRESSIONS ========= */

    @Test
    public void testNestedToString() {
        Expression e = new PlusExpression(
                new TimesExpression(new NumberExpression(3), new VariableExpression("x")),
                new NumberExpression(4)
        );
        assertEquals("((3 * x) + 4)", e.toString());
    }

    @Test
    public void testNestedEquals() {
        Expression e1 = new PlusExpression(
                new TimesExpression(new NumberExpression(3), new VariableExpression("x")),
                new NumberExpression(4)
        );

        Expression e2 = new PlusExpression(
                new TimesExpression(new NumberExpression(3), new VariableExpression("x")),
                new NumberExpression(4)
        );

        assertEquals(e1, e2);
    }

    @Test
    public void testNestedHashCodeConsistency() {
        Expression e1 = new PlusExpression(
                new NumberExpression(1),
                new TimesExpression(new NumberExpression(2), new NumberExpression(3))
        );

        Expression e2 = new PlusExpression(
                new NumberExpression(1),
                new TimesExpression(new NumberExpression(2), new NumberExpression(3))
        );

        assertEquals(e1.hashCode(), e2.hashCode());
    }
}
