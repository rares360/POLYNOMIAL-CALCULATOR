package View;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;

public class View extends JFrame{

    private JTextField tfPolinom1;
    private JTextField tfPolinom2;
    private JTextField tfRezultat;
    private JTextField tfRezultat2;

    private JLabel lblPolinom1;
    private JLabel lblPolinom2;
    private JLabel lblRezultat;
    private JLabel lblRezultat2;

    private JButton btnAdunare;
    private JButton btnScadere;
    private JButton btnInmultire;
    private JButton btnImpartire;
    private JButton btnDerivare;
    private JButton btnIntegrare;

    public View() {
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setBounds(100, 100, 600, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        tfPolinom1 = new JTextField();
        tfPolinom1.setBounds(83, 1, 361, 26);
        this.getContentPane().add(tfPolinom1);
        tfPolinom1.setColumns(10);

        lblPolinom1 = new JLabel("Polinom1:");
        lblPolinom1.setBounds(6, 6, 91, 16);
        this.getContentPane().add(lblPolinom1);

        lblPolinom2 = new JLabel("Polinom2:");
        lblPolinom2.setBounds(6, 39, 91, 16);
        this.getContentPane().add(lblPolinom2);

        tfPolinom2 = new JTextField();
        tfPolinom2.setColumns(10);
        tfPolinom2.setBounds(83, 34, 361, 26);
        this.getContentPane().add(tfPolinom2);

        btnAdunare = new JButton("Adunare");
        btnAdunare.setBounds(6, 67, 91, 29);
        this.getContentPane().add(btnAdunare);

        btnScadere = new JButton("Scadere");
        btnScadere.setBounds(353, 67, 91, 29);
        this.getContentPane().add(btnScadere);

        btnInmultire = new JButton("Inmultire");
        btnInmultire.setBounds(6, 108, 91, 29);
        this.getContentPane().add(btnInmultire);

        btnImpartire = new JButton("Impartire");
        btnImpartire.setBounds(353, 108, 91, 29);
        this.getContentPane().add(btnImpartire);

        btnDerivare = new JButton("Derivare");
        btnDerivare.setBounds(6, 149, 91, 29);
        this.getContentPane().add(btnDerivare);

        btnIntegrare = new JButton("Integrare");
        btnIntegrare.setBounds(353, 149, 91, 29);
        this.getContentPane().add(btnIntegrare);

        lblRezultat = new JLabel("Rezultat:");
        lblRezultat.setBounds(6, 250, 91, 16);
        this.getContentPane().add(lblRezultat);

        lblRezultat2 = new JLabel("Cat:");
        lblRezultat2.setBounds(6, 275, 91, 16);
        this.getContentPane().add(lblRezultat2);

        tfRezultat = new JTextField();
        tfRezultat.setColumns(10);
        tfRezultat.setBounds(83, 245, 361, 26);
        this.getContentPane().add(tfRezultat);

        tfRezultat2 = new JTextField();
        tfRezultat2.setColumns(10);
        tfRezultat2.setBounds(83, 275, 361, 26);
        this.getContentPane().add(tfRezultat2);

        this.setVisible(true);
    }

    public String getTfPolinom1() {return tfPolinom1.getText();}
    public void setTfPolinom1(JTextField tfPolinom1) {this.tfPolinom1.setText(String.valueOf(tfPolinom1));}

    public String getTfPolinom2() {return tfPolinom2.getText();}
    public void setTfPolinom2(JTextField tfPolinom2) {this.tfPolinom2.setText(String.valueOf(tfPolinom2));}

    public String getTfRezultat() {return tfRezultat.getText();}
    public void setTfRezultat(String tfRezultat) {this.tfRezultat.setText(String.valueOf(tfRezultat));}

    public String getTfRezultat2() {return tfRezultat.getText();}
    public void setTfRezultat2(String tfRezultat2) {this.tfRezultat2.setText(String.valueOf(tfRezultat2));}

    public void getBtnAdunare(ActionListener action) {btnAdunare.addActionListener(action);}
    public void getBtnScadere(ActionListener action) {btnScadere.addActionListener(action);}
    public void getBtnInmultire(ActionListener action) {btnInmultire.addActionListener(action);}
    public void getBtnImpartire(ActionListener action) {btnImpartire.addActionListener(action);}
    public void getBtnDerivare(ActionListener action) {btnDerivare.addActionListener(action);}
    public void getBtnIntegrare(ActionListener action) {btnIntegrare.addActionListener(action);}
}
