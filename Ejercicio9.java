package p2_tareagrupal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio9 extends JFrame implements ActionListener {

    private JLabel lblMensaje;
    private JLabel lblMedio;
    private JTextArea txtNumero;
    private JButton btnCalcular;
    private JComboBox medio;

    public Ejercicio9() {
        setSize(650, 550);
        setTitle("Velocidad del Sonido");
        inicializarComponentes();
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        lblMensaje = new JLabel();
        txtNumero = new JTextArea();
        btnCalcular = new JButton();
        lblMedio = new JLabel();
        String valores[] = {"aire", "agua", "madera", "acero", "aluminio", "hormigon"};
        medio = new JComboBox(valores);
        getContentPane().setLayout(null);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                salirDeAplicacion(evt);
            }
        }
        );

        lblMedio.setText("Seleccione el medio");
        lblMedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMedio.setFont(new java.awt.Font("Dialog", 1, 18));
        getContentPane().add(lblMedio);
        lblMedio.setBounds(400, 100, 250, 30);

        lblMensaje.setText("Ingrese tiempo en segundos");
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setFont(new java.awt.Font("Dialog", 1, 18));
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(100, 100, 250, 30);

        txtNumero.setFont(new java.awt.Font("Dialog", 1, 18));
        getContentPane().add(txtNumero);
        txtNumero.setBounds(150, 150, 150, 30);

        btnCalcular.setText("Calcular");
        btnCalcular.setToolTipText("Calcular Distancia");
        btnCalcular.setMnemonic('c');
        getContentPane().add(btnCalcular);
        btnCalcular.setBounds(100, 310, 400, 30);
        btnCalcular.addActionListener(this);
        getContentPane().add(medio);
        medio.setBounds(450, 150, 150, 30);

    }

    private void salirDeAplicacion(WindowEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Ejercicio9().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (Integer.parseInt(txtNumero.getText()) > 0) {
                VelocidadSonido Dis = new VelocidadSonido();
                Double aire = 0.0;
                String cadena = (String) medio.getSelectedItem();
                
                if (cadena.equals("aire")) {
                    aire = Dis.PropaAire(Integer.parseInt(txtNumero.getText()));
                } else if (cadena.equals("agua")) {
                    aire = Dis.PropaAgua(Integer.parseInt(txtNumero.getText()));
                } else if (cadena.equals("madera")) {
                    aire = Dis.PropaMadera(Integer.parseInt(txtNumero.getText()));
                } else if (cadena.equals("acero")) {
                    aire = Dis.PropaAcero(Integer.parseInt(txtNumero.getText()));
                } else if (cadena.equals("aluminio")) {
                    aire = Dis.PropaAluminio(Integer.parseInt(txtNumero.getText()));
                } else if (cadena.equals("hormigon")) {
                    aire = Dis.PropaHormigon(Integer.parseInt(txtNumero.getText()));
                }

                JOptionPane.showMessageDialog(null, "La distancia a la que se encuentra segun el medio " + cadena + " es: " + aire + " KM");
                txtNumero.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Se espera numero  mayor a 0");
                txtNumero.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se admiten letras, espacios vacios ni decimales");
            txtNumero.setText("");
        }
    }

}
