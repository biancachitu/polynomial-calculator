
import java.awt.event.*;


public class Controller implements ActionListener{

    private final View  view;
    private final Operations op = new Operations();

    Controller(View view) {

        this.view = view;
    }


    public static Polynomial stringToPoly(String str){
        Polynomial p = new Polynomial();

        str = str.replace("-", "+-");
        String[] monoame = str.split("\\+");

        for(String  i : monoame){
            String[] coefs = new String[20];
            String[] grade = new String[20];

            if(i.contains("*")){
                coefs = i.split("\\*");
                grade = coefs[1].split("\\^");
            } else{
                grade = i.split("\\^");
                if(i.contains("^")){
                    coefs[0] = "1";
                }else{
                    coefs[0] = grade[0];
                }
            }
            int coef;
            int grad;
            if(!(grade[0].equals("x"))){
                grad = 0;
            } else if(grade.length == 2){
                grad = Integer.parseInt(grade[1]);
            } else {
                grad = 1;
            }

            if(coefs[0].equals("x")){
                coef = (int) 1.0;
            } else {
                coef = Integer.parseInt(coefs[0]);
            }
            p.addMonomial((new Monomial(grad,coef)));
        }
        return p;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        String str1 = view.getInput1().getText();
        String str2 = view.getInput2().getText();
        boolean end = false;
        boolean c1 = false;
        boolean c2 = false;

        if (!str1.equals("")) {
            try {
                pol1 = stringToPoly(str1);
                c1 = true;
            } catch (Exception NumberFormatException) {
                view.showError("Bad input 1: " + str1);
                end = true;
            }
        }
        if (!str2.equals("")) {
            try {
                pol2 = stringToPoly(str2);
                c2 = true;
            } catch (Exception NumberFormatException) {
                view.showError("Bad input 2: " + str2);
                end = true;
            }
        }

        if (source == view.getAddBtn()) {
            if (c1 && c2) {
                Polynomial sum = op.add(pol1, pol2);
                view.getLabel().setText(sum.toString());
            } else if (!end) {
                view.showError("Error. No input found.");
            }
        } else if (source == view.getSubBtn()) {
            if (c1 && c2) {
                Polynomial sub = op.sub(pol1, pol2);
                view.getLabel().setText(sub.toString());
            } else if (!end) {
                view.showError("Error. No input found.");
            }
        } else if (source == view.getMulBtn()) {
            if (c1 && c2) {
                Polynomial mul = op.mul(pol1, pol2);
                view.getLabel().setText(mul.toString());
            } else if (!end) {
                view.showError("Error. No input found.");
            }
        } else if (source == view.getDivBtn()) {
            if (c1 && c2) {
                Polynomial mul = op.div(pol1, pol2);
                view.getLabel().setText(mul.toString());
            } else if (!end) {
                view.showError("Error. No input found.");
            }
        } else if (source == view.getDerivBtn()) {
            String result = " ";
            if(c1 || c2){
                if (c1) {
                    Polynomial deriv1 = op.deriv(pol1);
                    result = result + "p1: " + deriv1.toString() + ";  ";
                }
                if (c2) {
                    Polynomial deriv2 = op.deriv(pol2);
                    result = result + "p2: " + deriv2.toString();
                }
                view.getLabel().setText(result);
            }else if (!end) {
                view.showError("Error. No input found.");
            }
        }else if(source == view.getIntegBtn()){
            String result = " ";
            if(c1 || c2) {
                if (c1) {
                    Polynomial integ1 = op.integration(pol1);
                    result = result + "p1: " + integ1.toString() + ";  ";
                }
                if (c2) {
                    Polynomial integ2 = op.integration(pol2);
                    result = result + "p2: " + integ2.toString();
                }view.getLabel().setText(result);
            }else if (!end) {
                view.showError("Error. No input found.");
            }
        }

    }
}
