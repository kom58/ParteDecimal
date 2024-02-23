package partdecim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion {
    private JPanel panBase;
    private JPanel pasSuperior;
    private JPanel pasMedio;
    private JPanel pasInferior;
    private JButton btnCalcular;
    private JButton btnSalir;
    private JLabel txtTitulo;
    private JLabel titNumero;
    private JTextField datNumero;
    private JLabel txtResultado;


    public Aplicacion() {
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                miraDecimal();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
    }


    public void miraDecimal(){

        String numPuesto = datNumero.getText();             // Lee el número puesto
        double n =Double.parseDouble(numPuesto);            // Lo convierte en double
        ParteDecimal pdeci = new ParteDecimal();            // Crea objeto pdec

        pdeci.setNumero(n);
        int m = (int) n;                                    // Obtiene parte entera del número
        double deci = n - m;                                // Obtiene los decimales
        String deciStr = String.format("%.4f", deci);       // Redondea a cuatro decimales
        if ( pdeci.tieneDecimales()) {
            txtResultado.setText(" El número " + numPuesto + " tiene " + deciStr + " decimales.");
        } else {
            txtResultado.setText(" El número " + numPuesto + " es un entero y NO tiene decimales. Pon otro número.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().panBase);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500,400);
        frame.setResizable(false);
        frame.setVisible(true);
    }


}
