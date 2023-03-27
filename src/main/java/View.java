
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame {

    Controller controller = new Controller(this);

    private JTextField inputTf1 = new JTextField(20);
    private JTextField inputTf2 = new JTextField(20);

    private JLabel output = new JLabel(" ");

    private JButton    addBtn = new JButton("Add");
    private JButton    subBtn = new JButton("Substract");
    private JButton    mulBtn = new JButton("Multiply");
    private JButton    divBtn = new JButton("Divide");
    private JButton    derivBtn = new JButton("Derive");
    private JButton    integBtn = new JButton("Integrate");

    public View(String name) {
        super(name);

        addBtn.addActionListener(controller);
        subBtn.addActionListener(controller);
        mulBtn.addActionListener(controller);
        divBtn.addActionListener(controller);
        derivBtn.addActionListener(controller);
        integBtn.addActionListener(controller);

        JPanel content = new JPanel(new GridBagLayout());
        this.setContentPane(content);

        setSize(1000, 500);
        setLocation(new Point(100, 100));
        setResizable(false);

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        content.add(new JLabel("Polynomial 1"), c);

        c.gridx = 0;
        c.gridy = 3;
        content.add(new JLabel("Polynomial 2"), c);

        c.gridx = 1;
        c.gridy = 1;
        content.add(inputTf1, c);

        c.gridx = 1;
        c.gridy = 3;
        content.add(inputTf2, c);

        c.gridx = 1;
        c.gridy = 5;
        content.add(addBtn, c);

        c.gridx = 1;
        c.gridy = 6;
        content.add(subBtn, c);

        c.gridx = 1;
        c.gridy = 7;
        content.add(mulBtn, c);

        c.gridx = 1;
        c.gridy = 8;
        content.add(divBtn, c);

        c.gridx = 1;
        c.gridy = 9;
        content.add(derivBtn, c);

        c.gridx = 1;
        c.gridy = 10;
        content.add(integBtn, c);

        c.gridx = 0;
        c.gridy = 12;
        content.add(new JLabel("Output"),c);

        c.gridx = 1;
        c.gridy =12;
        content.add(output, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(12,0,0,0);
        content.revalidate();
        content.repaint();
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public JButton getAddBtn(){
        return addBtn;
    }
    public JButton getSubBtn(){
        return subBtn;
    }
    public JButton getMulBtn(){
        return mulBtn;
    }
    public JButton getDivBtn(){
        return divBtn;
    }
    public JButton getDerivBtn(){
        return derivBtn;
    }
    public JButton getIntegBtn(){
        return integBtn;
    }
    public JLabel getLabel(){
        return output;
    }
    public JTextField getInput1(){
        return inputTf1;
    }
    public JTextField getInput2(){
        return inputTf2;
    }

    public static void main(String [] args){

        JFrame frame = new View("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Polynomial p = new Polynomial();
        Polynomial q = new Polynomial();
        Monomial m1 = new Monomial(3, 1);
        Monomial m2 = new Monomial(0, 1);
        //Monomial m3 = new Monomial(0, 2);
        Monomial m4 = new Monomial(3, 1);
        //Monomial m5 = new Monomial(1, 2);
       //Monomial m6 = new Monomial(0, 1);

        p.addMonomial(m1);
        p.addMonomial(m2);
        //p.addMonomial(m3);
        q.addMonomial(m4);
        //q.addMonomial(m5);
        //q.addMonomial(m6);


        System.out.println("P(x) = " + p.toString());
        System.out.println("Q(x) = " + q.toString());
        System.out.println("sum = " + Operations.add(p,q));
        System.out.println("sub = " + Operations.sub(p,q));
        System.out.println("mul = " + Operations.mul(p,q));
        System.out.println("div = " + Operations.div(p,q));
        System.out.println("deriv = " + Operations.deriv(p));
        System.out.println("integral = " + Operations.integration(p));
    }
}
