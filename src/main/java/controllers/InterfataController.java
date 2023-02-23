package controllers;

import models.Operatii;
import models.Polinom;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfataController {
    private View view;
    Polinom polinom1;
    Polinom polinom2;

    public InterfataController(View view) {
        this.view = view;
        this.view.getBtnAdunare(new BtnAdunareListener());
        this.view.getBtnScadere(new BtnScadereListener());
        this.view.getBtnInmultire(new BtnInmultireListener());
        this.view.getBtnImpartire(new BtnImpartireListener());
        this.view.getBtnDerivare(new BtnDerivareListener());
        this.view.getBtnIntegrare(new BtnIntegrareListener());
    }

    public int verificarePolinoame() {
        if (view.getTfPolinom1().isEmpty() || view.getTfPolinom2().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Polinoamele nu sunt introduse!");
            return 0;
        }
        return 1;
    }

    class BtnAdunareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (verificarePolinoame() == 0) {
                System.out.println("gresit");
            }else {
                polinom1=new Polinom();
                polinom2=new Polinom();
                String polynomial1 = view.getTfPolinom1();
                String polynomial2 = view.getTfPolinom2();

                polinom1.convertToMonomial(polynomial1);
                polinom2.convertToMonomial(polynomial2);

                view.setTfRezultat(Operatii.adunarePolinom(polinom1,polinom2).toString());
            }
        }
    }

    class BtnScadereListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (verificarePolinoame() == 0) {
                System.out.println("gresit");
            }else {
                polinom1=new Polinom();
                polinom2=new Polinom();
                String polynomial1 = view.getTfPolinom1();
                String polynomial2 = view.getTfPolinom2();

                polinom1.convertToMonomial(polynomial1);
                polinom2.convertToMonomial(polynomial2);

                view.setTfRezultat(Operatii.scaderePolinom(polinom1,polinom2).toString());
            }
        }
    }

    class BtnInmultireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (verificarePolinoame() == 0) {
                System.out.println("gresit");
            }else {
                polinom1=new Polinom();
                polinom2=new Polinom();
                String polynomial1 = view.getTfPolinom1();
                String polynomial2 = view.getTfPolinom2();

                polinom1.convertToMonomial(polynomial1);
                polinom2.convertToMonomial(polynomial2);

                view.setTfRezultat(Operatii.inmultirePolinom(polinom1,polinom2).toString());
            }
        }
    }

    class BtnImpartireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (verificarePolinoame() == 0) {
                System.out.println("gresit");
            }else {
                polinom1=new Polinom();
                polinom2=new Polinom();
                String polynomial1 = view.getTfPolinom1();
                String polynomial2 = view.getTfPolinom2();

                polinom1.convertToMonomial(polynomial1);
                polinom2.convertToMonomial(polynomial2);
                List<Polinom> rezultatPolinom=Operatii.impartirePolinom(polinom1,polinom2);
                view.setTfRezultat(rezultatPolinom.get(0).toString());
                view.setTfRezultat2(rezultatPolinom.get(1).toString());
            }
        }
    }

    class BtnDerivareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getTfPolinom1().isEmpty()) {
                System.out.println("gresit");
            }else {
                polinom1=new Polinom();
                String polynomial1 = view.getTfPolinom1();

                polinom1.convertToMonomial(polynomial1);

                view.setTfRezultat(Operatii.derivarePolinom(polinom1).toString());
            }
        }
    }

    class BtnIntegrareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getTfPolinom1().isEmpty()) {
                System.out.println("Text field-ul este gol.");
            }else {
                polinom1=new Polinom();
                String polynomial1 = view.getTfPolinom1();

                polinom1.convertToMonomial(polynomial1);

                view.setTfRezultat(Operatii.integrarePolinom(polinom1).toString());
            }
        }
    }
}

