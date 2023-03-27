import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {

    Polynomial poly1 = new Polynomial();
    Polynomial poly2 = new Polynomial();
    Polynomial result = new Polynomial();

    @Test
    public void addTest(){
        Monomial mon1 = new Monomial(2,1);
        Monomial mon2 = new Monomial(1,3);
        Monomial mon3 = new Monomial(0,-2);
        poly1.addMonomial(mon1);
        poly1.addMonomial(mon2);
        poly1.addMonomial(mon3);

        Monomial mon4 = new Monomial(2,5);
        Monomial mon5 = new Monomial(1,1);
        Monomial mon6 = new Monomial(0,3);
        poly2.addMonomial(mon4);
        poly2.addMonomial(mon5);
        poly2.addMonomial(mon6);

        Monomial monR1 = new Monomial(2,6);
        Monomial monR2 = new Monomial(1,4);
        Monomial monR3 = new Monomial(0,1);
        result.addMonomial(monR1);
        result.addMonomial(monR2);
        result.addMonomial(monR3);

        assertEquals(Operations.add(poly1, poly2), result);
    }
    @Test
    public void subTest(){
        Monomial mon1 = new Monomial(2,1);
        Monomial mon2 = new Monomial(1,3);
        Monomial mon3 = new Monomial(0,-2);
        poly1.addMonomial(mon1);
        poly1.addMonomial(mon2);
        poly1.addMonomial(mon3);

        Monomial mon4 = new Monomial(2,5);
        Monomial mon5 = new Monomial(1,1);
        Monomial mon6 = new Monomial(0,3);
        poly2.addMonomial(mon4);
        poly2.addMonomial(mon5);
        poly2.addMonomial(mon6);

        Monomial monR1 = new Monomial(2,-4);
        Monomial monR2 = new Monomial(1,2);
        Monomial monR3 = new Monomial(0,-5);
        result.addMonomial(monR1);
        result.addMonomial(monR2);
        result.addMonomial(monR3);

        assertEquals(Operations.sub(poly1, poly2), result);
    }
    @Test
    public void mulTest(){
        Monomial mon1 = new Monomial(2,1);
        Monomial mon2 = new Monomial(1,3);
        Monomial mon3 = new Monomial(0,-2);
        poly1.addMonomial(mon1);
        poly1.addMonomial(mon2);
        poly1.addMonomial(mon3);

        Monomial mon4 = new Monomial(2,5);
        Monomial mon5 = new Monomial(1,1);
        Monomial mon6 = new Monomial(0,3);
        poly2.addMonomial(mon4);
        poly2.addMonomial(mon5);
        poly2.addMonomial(mon6);

        Monomial monR1 = new Monomial(4,5);
        Monomial monR2 = new Monomial(3,16);
        Monomial monR3 = new Monomial(2,-7);
        Monomial monR4 = new Monomial(1,7);
        Monomial monR5 = new Monomial(0,-6);
        result.addMonomial(monR1);
        result.addMonomial(monR2);
        result.addMonomial(monR3);
        result.addMonomial(monR4);
        result.addMonomial(monR5);

        assertEquals(Operations.mul(poly1, poly2), result);
    }
    @Test
    public void divTest(){
        Monomial mon1 = new Monomial(3,1);
        Monomial mon2 = new Monomial(2,-2);
        Monomial mon3 = new Monomial(1,6);
        Monomial mon4 = new Monomial(0,-5);
        poly1.addMonomial(mon1);
        poly1.addMonomial(mon2);
        poly1.addMonomial(mon3);
        poly1.addMonomial(mon4);

        Monomial mon5 = new Monomial(2,1);
        Monomial mon6 = new Monomial(0,-1);
        poly2.addMonomial(mon5);
        poly2.addMonomial(mon6);

        Monomial monR1 = new Monomial(1,1);
        Monomial monR2 = new Monomial(0,-2);
        result.addMonomial(monR1);
        result.addMonomial(monR2);

        assertEquals(Operations.div(poly1, poly2), result);
    }
    @Test
    public void derivTest(){
        Monomial mon1 = new Monomial(2,1);
        Monomial mon2 = new Monomial(1,3);
        Monomial mon3 = new Monomial(0,-2);
        poly1.addMonomial(mon1);
        poly1.addMonomial(mon2);
        poly1.addMonomial(mon3);

        Monomial monR1 = new Monomial(1,2);
        Monomial monR2 = new Monomial(0,3);
        result.addMonomial(monR1);
        result.addMonomial(monR2);

        assertEquals(Operations.deriv(poly1), result);
    }
    @Test
    public void integrationTest(){
        Monomial mon1 = new Monomial(2,1);
        Monomial mon2 = new Monomial(1,3);
        Monomial mon3 = new Monomial(0,-2);
        poly1.addMonomial(mon1);
        poly1.addMonomial(mon2);
        poly1.addMonomial(mon3);
        Monomial monR1 = new Monomial(3,1/3);
        Monomial monR2 = new Monomial(2,3/2);
        Monomial monR3 = new Monomial(1,-2);
        result.addMonomial(monR1);
        result.addMonomial(monR2);
        result.addMonomial(monR3);

        assertEquals(Operations.integration(poly1), result);
    }
}
