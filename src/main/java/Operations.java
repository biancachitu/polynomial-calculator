public class Operations {
    public static Polynomial add(Polynomial poly1, Polynomial poly2){
        Polynomial sum = new Polynomial();
        Monomial monResult;
        for(Monomial mon1 : poly1.getPolynomial().values()){
            for(Monomial mon2 : poly2.getPolynomial().values()){
                if(mon1.getDegree() == mon2.getDegree()){
                    mon1.setDone(true);
                    mon2.setDone(true);
                    monResult = new Monomial(mon1.getDegree(),(mon1.getCoef() + mon2.getCoef()));
                    sum.addMonomial(monResult);
                }
            }
        }
        for(Monomial mon1 : poly2.getPolynomial().values()){
            if(mon1.getDone() == false) {
                sum.addMonomial(mon1);
            }
        }
        for(Monomial mon2 : poly1.getPolynomial().values()){
            if(mon2.getDone() == false) {
                sum.addMonomial(mon2);
            }
        }
        return sum;
    }

    public static Polynomial sub(Polynomial P, Polynomial Q){
        Polynomial sub = new Polynomial();
        Monomial monResult;
        P.setFalse(P);
        Q.setFalse(Q);
        for(Monomial mon1 : P.getPolynomial().values()){
            for(Monomial mon2 : Q.getPolynomial().values()){
                if(mon1.getDegree() == mon2.getDegree()){
                    mon1.setDone(true);
                    mon2.setDone(true);
                    monResult = new Monomial (mon1.getDegree(),mon1.getCoef() - mon2.getCoef());
                    sub.addMonomial(monResult);
                }
            }
        }

        for(Monomial mon1 : P.getPolynomial().values()){
            if(mon1.getDone() == false) {
                sub.addMonomial(mon1);
            }
        }
        for(Monomial mon2 : Q.getPolynomial().values()){
            if(mon2.getDone() == false) {
                mon2.setCoef(0 - mon2.getCoef());
                sub.addMonomial(mon2);
            }
        }
        int i=0;
        while((sub.getPolynomial().size()>0) && (i<=sub.getPolynomial().firstKey())){
            if(sub.getPolynomial().containsKey(i) && (sub.getPolynomial().get(i).getCoef() == 0)) {
                sub.getPolynomial().remove(i);
            }
            i++;
        }

        return sub;
    }

    public static Polynomial mul(Polynomial P, Polynomial Q){
        Polynomial mul = new Polynomial();
        Monomial monResult;

        for(Monomial mon1 : P.getPolynomial().values()){
            for(Monomial mon2 : Q.getPolynomial().values()){
                monResult = new Monomial(mon1.getDegree() + mon2.getDegree() , mon1.getCoef() *  mon2.getCoef());
                if(!mul.poly.containsKey(monResult.getDegree()))
                    mul.addMonomial(monResult);
                else
                    mul.poly.get(monResult.getDegree()).addM(monResult);
                mon1.setDone(true);
                mon2.setDone(true);
            }
        }
        return mul;
    }

    public static Polynomial div(Polynomial P, Polynomial Q){
        Polynomial div = new Polynomial();
        Monomial monResult = new Monomial();
        Polynomial aux = new Polynomial();
        //Polynomial newP = P;

        while (P.getPolynomial().firstEntry().getValue().getDegree() >= Q.getPolynomial().firstEntry().getValue().getDegree()) {
                monResult = P.getPolynomial().firstEntry().getValue().monDiv(Q.getPolynomial().firstEntry().getValue());
                div.addMonomial(monResult);
                aux.addMonomial(monResult);
                P = sub(P, mul(aux, Q));
                aux.remove(aux.getPolynomial().firstEntry().getValue());
        }
        return div;
    }

    public static Polynomial deriv(Polynomial P){
        Polynomial deriv = new Polynomial();
        P.remove(P.getMonomial(0));
        for(Monomial mon:P.getPolynomial().values()) {
            mon.setCoef(mon.getCoef() * mon.getDegree());
            mon.setDegree(mon.getDegree() - 1);
            deriv.addMonomial(mon);
        }
        return deriv;
    }
    public static Polynomial integration(Polynomial P){
        Polynomial integral = new Polynomial();

        for(Monomial mon : P.getPolynomial().values()){
            if(mon.getDegree() >= 0){
                mon.setCoef(mon.getCoef()  / (mon.getDegree() + 1));
                mon.setDegree(mon.getDegree() + 1);
                integral.addMonomial(mon);
            }
        }
        return integral;
    }
}
