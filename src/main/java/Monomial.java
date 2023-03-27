public class Monomial {

    private int degree;
    private int coef;
    private boolean isDone;

    public Monomial(){}

    public Monomial(int degree, int coef){
        this.degree = degree;
        this.coef = coef;
    }

    public int getDegree() {
        return degree;
    }

    public int getCoef() {
        return coef;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void setDone(boolean isDone){
        this.isDone = isDone;
    }

    public boolean getDone(){
        return isDone;
    }

    public void addM( Monomial mon2){
        if(this.getDegree() == mon2.getDegree()){
//            this.setDone(true);
//            mon2.setDone(true);
           this.setCoef(this.getCoef() + mon2.getCoef());
        }

    }
    public Monomial monDiv(Monomial mon){
        return new Monomial(this.getDegree() - mon.getDegree(), this.getCoef() / mon.getCoef());
    }

    public String toString(){
        return coef + "*" + "x^" + degree;
    }
}
