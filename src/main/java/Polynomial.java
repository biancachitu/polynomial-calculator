import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;

public class Polynomial{
    TreeMap<Integer, Monomial> poly = new TreeMap<>(Collections.reverseOrder()); //key= expo, value= monom

    public Polynomial(TreeMap<Integer, Monomial> polynomial) {
        this.poly = polynomial;
    }
    public Polynomial(){}

    public TreeMap<Integer, Monomial> getPolynomial() {
        return poly;
    }

    public TreeMap<Integer, Monomial> addMonomial(Monomial mon){
        poly.put(mon.getDegree(), mon);
        return poly;
    }

    public Monomial getMonomial(int key){
        Monomial mon = new Monomial();
        key = mon.getDegree();
        mon = poly.get(key);
        return mon;
    }

    public void remove(Monomial mon){ //remove entry from polynomial map
        poly.remove(mon.getDegree());
    }

    public void setFalse(Polynomial P){
        for(Monomial mon : P.getPolynomial().values()){
            mon.setDone(false);
        }
    }

    @Override
    public String toString() {
        String s = " ";
        for(Monomial i: poly.values()){
            if(s.equals(" ")){
                s += i.toString();
            }
            else if (i.getCoef() < 0){ s = s + i.toString();}
            else s = s + " + " + i.toString();
        }
        return s;
    }
}
