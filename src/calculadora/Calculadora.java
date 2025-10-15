/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author psant
 */
public class Calculadora extends JFrame {
    private CardLayout cardlayout;
    private JPanel PanelPrincipal;
    private JPanel Menu, Derivada, Integral;
    
    //Labels
    private JLabel lblBienvenida;
    private JButton btnDerivada, btnIntegral;
    
    //Botones Derivaciones
    private JButton Der0, Der1, Der2, Der3, Der4, Der5, Der6, Der7, Der8, Der9;
    private JButton DerX, DerExp, DerMult, DerResultado, Der, DerY;
    //Mostrar Formula
    private JTextField DerFormula;
    
public Calculadora(){
    cardlayout = new CardLayout();
    PanelPrincipal = new JPanel(cardlayout);
    setContentPane(PanelPrincipal);
    
    // Paneles
    crearMenu();
    crearDerivada();
    crearIntegral();
    
    // Nombre de Paneles
    PanelPrincipal.add(Menu, "menu");
    PanelPrincipal.add(Derivada, "derivada");
    PanelPrincipal.add(Integral, "integral");
    
    cardlayout.show(PanelPrincipal, "menu");
    
    setTitle("Integratron");
    setSize(1000,1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}

public void crearMenu(){
    Menu = new JPanel();
    Menu.setLayout(null);
    Menu.setBackground(new Color(48, 48, 54));
    
    // Logo
    ImageIcon logo = new ImageIcon(getClass().getResource("/Imagenes/logo.png"));
    
    // Label
    lblBienvenida = new JLabel(logo);
    lblBienvenida.setBounds(25, 100, 900, 300);
    
    // Botones
    btnDerivada = new JButton("Calcular Derivadas =D");
    btnDerivada.setFont(new Font("Arial", Font.BOLD, 16));
    btnDerivada.setBackground(new Color(48, 188, 237));
    btnDerivada.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    btnDerivada.setBounds(100, 600, 300, 40);
    
    btnIntegral = new JButton("Calcular Integrales =3");
    btnIntegral.setFont(new Font("Arial", Font.BOLD, 16));
    btnIntegral.setBackground(new Color(48, 188, 237));
    btnIntegral.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    btnIntegral.setBounds(550, 600, 300, 40);
    
    Menu.add(lblBienvenida);
    Menu.add(btnDerivada);
    Menu.add(btnIntegral);
    
    btnDerivada.addActionListener(e -> cambiarDerivada());
}

public void crearDerivada(){
    Derivada = new JPanel();
    Derivada.setLayout(null);
    Derivada.setBackground(new Color(48, 48, 54));
    
    //Botones de Accion
    Der0 = new JButton("0");
    Der1 = new JButton("1");
    Der2 = new JButton("2");
    Der3 = new JButton("3");
    Der4 = new JButton("4");
    Der5 = new JButton("5");
    Der6 = new JButton("6");
    Der7 = new JButton("7");
    Der8 = new JButton("8");
    Der9 = new JButton("9");
    DerX = new JButton("X");
    DerMult = new JButton("*");
    DerExp = new JButton("^");
    DerResultado = new JButton("=");
    Der = new JButton("∫");
    DerY = new JButton("Y");
    
    Der0.setBounds(175, 825, 120, 120);
    Der1.setBounds(50, 700, 120, 120);
    Der2.setBounds(175, 700, 120, 120);
    Der3.setBounds(300, 700, 120, 120);
    Der4.setBounds(50, 575, 120, 120);
    Der5.setBounds(175, 575, 120, 120);
    Der6.setBounds(300, 575, 120, 120);
    Der7.setBounds(50, 450, 120, 120);
    Der8.setBounds(175, 450, 120, 120);
    Der9.setBounds(300, 450, 120, 120);
    DerX.setBounds(550, 575, 120, 120);
    DerMult.setBounds(425, 450, 120, 120);
    DerExp.setBounds(550, 450, 120, 120);
    DerResultado.setBounds(550, 700, 120, 120);
    Der.setBounds(425, 700, 120, 120);
    DerY.setBounds(425, 575, 120, 120);
    
    EstiloBoton(Der0);
    EstiloBoton(Der1);
    EstiloBoton(Der2);
    EstiloBoton(Der3);
    EstiloBoton(Der4);
    EstiloBoton(Der5);
    EstiloBoton(Der6);
    EstiloBoton(Der7);
    EstiloBoton(Der8);
    EstiloBoton(Der9);
    EstiloBoton(DerX);
    EstiloBoton(DerMult);
    EstiloBoton(DerExp);
    EstiloBoton(DerResultado);
    EstiloBoton(Der);
    EstiloBoton(DerY);
    
    // Formula
    DerFormula = new JTextField();
    DerFormula.setBounds(50, 200, 900, 100);
    DerFormula.setFont(new Font("Arial", Font.BOLD, 30));
    DerFormula.setHorizontalAlignment(JTextField.CENTER);
    DerFormula.setEditable(false);
    
    Derivada.add(Der0);
    Derivada.add(Der1);
    Derivada.add(Der2);
    Derivada.add(Der3);
    Derivada.add(Der4);
    Derivada.add(Der5);
    Derivada.add(Der6);
    Derivada.add(Der7);
    Derivada.add(Der8);
    Derivada.add(Der9);
    Derivada.add(DerX);
    Derivada.add(DerMult);
    Derivada.add(DerExp);
    Derivada.add(DerResultado);
    Derivada.add(DerFormula);
    Derivada.add(Der);
    Derivada.add(DerY);
}

public void crearIntegral(){
    Integral = new JPanel();
    Integral.setLayout(null);
}

public void cambiarDerivada(){
    cardlayout.show(PanelPrincipal, "derivada");
}

public static void EstiloBoton(JButton boton){
    boton.setFont(new Font("Arial", Font.BOLD, 20));
    boton.setBackground(new Color(48, 188, 237));
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Calculadora();
    }
    
}
