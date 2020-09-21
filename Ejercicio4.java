package p2_tareagrupal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

/*
    Números primos
    1. Construir una clase que muestre los números primos comprendidos entre 1 y N,
    donde N es un número entero positivo introducido por el usuario es primo.

    2. Crear una aplicación gráfica a partir de código
    (una aplicación en NetBeans modo texto que cuando la ejecuta genera una interface gráfica,
    tal como se explica en el material 2.7 Formularios) que utilice la clase recién creada.
 */
public class Ejercicio4 extends JFrame implements ActionListener {

    private JLabel lblMensaje;
    private JTextArea txtNumero;
    private JButton btnCalcular;

    // Crear un nuevo formulario de la clase P2_TareaGrupal
    public Ejercicio4() {
        setSize(400, 300); // Tamaño del formulario
        setTitle("Números primos"); // Título de la aplicación
        inicializarComponentes(); // Inicializar los controles o componentes
    }

    // Método invocado desde el constructor GraficoFormularioSolo
    private void inicializarComponentes() {
        lblMensaje = new JLabel();
        txtNumero = new JTextArea();
        btnCalcular = new JButton();

        getContentPane().setLayout(null);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                salirDeAplicacion(evt);
            }
        }
        );

        lblMensaje.setText("Ingrese numero");
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setFont(new java.awt.Font("Dialog", 1, 18));
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(42, 30, 250, 30);

        txtNumero.setFont(new java.awt.Font("Dialog", 1, 18));
        getContentPane().add(txtNumero);
        txtNumero.setBounds(42, 70, 250, 30);

        btnCalcular.setText("Calcular");
        btnCalcular.setToolTipText("Calcular numeros primos");
        btnCalcular.setMnemonic('c');
        getContentPane().add(btnCalcular);
        btnCalcular.setBounds(42, 110, 250, 30);
        
        //aqui se dispara el evento
        btnCalcular.addActionListener(this);
    }

    // Salir de la aplicación
    private void salirDeAplicacion(WindowEvent evt) {
        System.exit(0);
    }

    // Acción del botón
    public void actionPerformed(ActionEvent e) {
        try {
            if (Integer.parseInt(txtNumero.getText()) > 0) {
                Numero numero = new Numero();
                String cadena = "";
                for (int i = 1; i <= Integer.parseInt(txtNumero.getText()); i++) {
                    if (numero.esPrimo(i)) {
                        cadena += (i + ", ");
                    }
                }
                JOptionPane.showMessageDialog(null, "Los números primos entre 1 y " + txtNumero.getText() + " son:\n" + cadena);
                txtNumero.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Se espera numero entero mayor a 0");
                txtNumero.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se admiten letras, espacios vacios ni decimales");
            txtNumero.setText("");
        }
    }

    public static void main(String[] args) {
        new Ejercicio4().setVisible(true);
    }
}
