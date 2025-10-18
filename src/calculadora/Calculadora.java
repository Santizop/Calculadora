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
    private JLabel signoIgual, signoIntg;
    
    //Botones Derivaciones
    private JButton Der0, Der1, Der2, Der3, Der4, Der5, Der6, Der7, Der8, Der9;
    private JButton DerX, DerY, DerMas, DerMenos, DerAtras, DerExp, DerMult, DerIgual;
    private JButton DerFx, DerFy;
    
    //Botones Integrales 
    private JButton Intg0, Intg1, Intg2, Intg3, Intg4, Intg5, Intg6, Intg7, Intg8, Intg9;
    private JButton IntgX, IntgMas, IntgMenos, IntgAtras, IntgExp, IntgMult, IntgIgual;
    
    //Texfield entrada de Formula
    private JTextField DerFormula, DerResultado;
    private JTextField IntgFormula, IntgResultado, LiInferior, LiSuperior, Focus;
    private JTextField DerEje;
    
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
    setLocationRelativeTo(null);
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
    btnIntegral.addActionListener(e -> cambiarIntegral());
}

public void crearDerivada(){
    Derivada = new JPanel();
    Derivada.setLayout(null);
    Derivada.setBackground(new Color(48, 48, 54));
    
    //Boton de navegación
    btnIntegral = new JButton("Calcular Integrales =3");
    btnIntegral.setFont(new Font("Arial", Font.BOLD, 16));
    btnIntegral.setBackground(new Color(48, 188, 237));
    btnIntegral.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    btnIntegral.setBounds(350, 30, 300, 40);
    
    //Botones de Accion
    DerFx = new JButton("fx");
    DerFy = new JButton("fy");
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
    DerX = new JButton("x");
    DerMas = new JButton("+");
    DerMenos = new JButton("-");
    DerAtras = new JButton("Limpiar");
    DerMult = new JButton("*");
    DerExp = new JButton("^");
    DerIgual = new JButton("=");
    DerY = new JButton("y");
    
    DerFx.setBounds(550, 150, 80, 80);
    DerFy.setBounds(640, 150, 80, 80);
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
    DerX.setBounds(425, 575, 120, 120);
    DerY.setBounds(550, 575, 120, 120);
    DerMas.setBounds(425, 700, 120, 120);
    DerMenos.setBounds(550, 700, 120, 120);
    DerMult.setBounds(425, 450, 120, 120);
    DerExp.setBounds(550, 450, 120, 120);
    DerIgual.setBounds(675, 700, 120, 120);
    DerAtras.setBounds(675, 450, 120, 120);
    
    EstiloBoton(DerFx);
    EstiloBoton(DerFy);
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
    EstiloBoton(DerMas);
    EstiloBoton(DerMenos);
    EstiloBoton(DerMult);
    EstiloBoton(DerExp);
    EstiloBoton(DerIgual);
    EstiloBoton(DerY);
    EstiloBoton(DerAtras);
    
    // Formula
    DerEje = new JTextField();
    DerEje.setBounds(300, 150, 120, 80);
    DerEje.setFont(new Font("Arial", Font.BOLD, 30));
    DerEje.setHorizontalAlignment(JTextField.CENTER);
    DerEje.setEditable(false);
    
    DerFormula = new JTextField();
    DerFormula.setBounds(35, 280, 445, 100);
    DerFormula.setFont(new Font("Arial", Font.BOLD, 30));
    DerFormula.setHorizontalAlignment(JTextField.CENTER);
    DerFormula.setEditable(false);
    
    DerResultado = new JTextField();
    DerResultado.setBounds(550, 280, 400, 100);
    DerResultado.setFont(new Font("Arial", Font.BOLD, 30));
    DerResultado.setEditable(false);
    DerResultado.setHorizontalAlignment(JTextField.CENTER);
    
    //Texto
    signoIgual = new JLabel("=");
    signoIgual.setBounds(500, 300, 50, 50);
    signoIgual.setFont(new Font("Arial", Font.BOLD, 40));
    signoIgual.setForeground(Color.WHITE);

    
    Derivada.add(DerFx);
    Derivada.add(DerFy);
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
    Derivada.add(DerMas);
    Derivada.add(DerMenos);
    Derivada.add(DerMult);
    Derivada.add(DerExp);
    Derivada.add(DerIgual);
    Derivada.add(DerEje);
    Derivada.add(DerFormula);
    Derivada.add(DerResultado);
    Derivada.add(DerY);
    Derivada.add(btnIntegral);
    Derivada.add(DerAtras);
    Derivada.add(signoIgual);
    

    
    IngresoDatosDer();
    
    DerIgual.addActionListener(e -> {
    OperacionDerivacion operacion = new OperacionDerivacion(this); // le pasas la instancia actual
    operacion.ProcesarDerivada();
});

    btnIntegral.addActionListener(e -> cambiarIntegral());
}

public void crearIntegral(){
    Integral = new JPanel();
    Integral.setLayout(null);
    Integral.setBackground(new Color(48, 48, 54));
    
    //Boton navegación
    btnDerivada = new JButton("Calcular Derivadas =D");
    btnDerivada.setFont(new Font("Arial", Font.BOLD, 16));
    btnDerivada.setBackground(new Color(48, 188, 237));
    btnDerivada.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    btnDerivada.setBounds(350, 30, 300, 40);
    
    //Botones de Accion
    Intg0 = new JButton("0");
    Intg1 = new JButton("1");
    Intg2 = new JButton("2");
    Intg3 = new JButton("3");
    Intg4 = new JButton("4");
    Intg5 = new JButton("5");
    Intg6 = new JButton("6");
    Intg7 = new JButton("7");
    Intg8 = new JButton("8");
    Intg9 = new JButton("9");
    IntgX = new JButton("x");
    IntgMas = new JButton ("+");
    IntgMenos = new JButton ("-");
    IntgMult = new JButton("*");
    IntgExp = new JButton("^");
    IntgIgual = new JButton("=");
    IntgAtras = new JButton ("Limpiar");

    Intg0.setBounds(175, 825, 120, 120);
    Intg1.setBounds(50, 700, 120, 120);
    Intg2.setBounds(175, 700, 120, 120);
    Intg3.setBounds(300, 700, 120, 120);
    Intg4.setBounds(50, 575, 120, 120);
    Intg5.setBounds(175, 575, 120, 120);
    Intg6.setBounds(300, 575, 120, 120);
    Intg7.setBounds(50, 450, 120, 120);
    Intg8.setBounds(175, 450, 120, 120);
    Intg9.setBounds(300, 450, 120, 120);
    IntgX.setBounds(425, 700, 120, 120);
    IntgMas.setBounds(425, 575, 120, 120);
    IntgMenos.setBounds(550, 575, 120, 120);
    IntgMult.setBounds(425, 450, 120, 120);
    IntgExp.setBounds(550, 450, 120, 120);
    IntgIgual.setBounds(550, 700, 120, 120);
    IntgAtras.setBounds(675, 450, 120, 120);
    
    EstiloBoton(Intg0);
    EstiloBoton(Intg1);
    EstiloBoton(Intg2);
    EstiloBoton(Intg3);
    EstiloBoton(Intg4);
    EstiloBoton(Intg5);
    EstiloBoton(Intg6);
    EstiloBoton(Intg7);
    EstiloBoton(Intg8);
    EstiloBoton(Intg9);
    EstiloBoton(IntgX);
    EstiloBoton(IntgMas);
    EstiloBoton(IntgMenos);
    EstiloBoton(IntgMult);
    EstiloBoton(IntgExp);
    EstiloBoton(IntgIgual);
    EstiloBoton(IntgAtras);
        
    // Formula
    IntgFormula = new JTextField();
    IntgFormula.setBounds(115, 280, 365, 100);
    IntgFormula.setFont(new Font("Arial", Font.BOLD, 30));
    IntgFormula.setHorizontalAlignment(JTextField.CENTER);
    IntgFormula.setEditable(false);
    
    IntgResultado = new JTextField();
    IntgResultado.setBounds(550, 280, 400, 100);
    IntgResultado.setFont(new Font("Arial", Font.BOLD, 30));
    IntgResultado.setEditable(false);
    IntgResultado.setHorizontalAlignment(JTextField.CENTER);
    
    LiSuperior = new JTextField();
    LiSuperior.setBounds(65, 265, 30, 30);
    LiSuperior.setFont(new Font("Arial", Font.BOLD, 20));
    LiSuperior.setHorizontalAlignment(JTextField.CENTER);
    LiSuperior.setEditable(false);
    
    LiInferior = new JTextField();
    LiInferior.setBounds(65, 355, 30, 30);
    LiInferior.setFont(new Font("Arial", Font.BOLD, 20));
    LiInferior.setHorizontalAlignment(JTextField.CENTER);
    LiInferior.setEditable(false);
      
    //Texto
    signoIgual = new JLabel("=");
    signoIgual.setBounds(500, 300, 50, 50);
    signoIgual.setFont(new Font("Arial", Font.BOLD, 40));
    signoIgual.setForeground(Color.WHITE);
    
    signoIntg = new JLabel("∫");
    signoIntg.setBounds(40, 300, 50, 50);
    signoIntg.setFont(new Font("Arial", Font.BOLD, 40));
    signoIntg.setForeground(Color.WHITE);

    Integral.add(Intg0);
    Integral.add(Intg1);
    Integral.add(Intg2);
    Integral.add(Intg3);
    Integral.add(Intg4);
    Integral.add(Intg5);
    Integral.add(Intg6);
    Integral.add(Intg7);
    Integral.add(Intg8);
    Integral.add(Intg9);
    Integral.add(IntgX);
    Integral.add(IntgMas);
    Integral.add(IntgMenos);
    Integral.add(IntgMult);
    Integral.add(IntgExp);
    Integral.add(IntgIgual);
    Integral.add(IntgFormula);
    Integral.add(btnDerivada);
    Integral.add(IntgAtras);
    Integral.add(IntgResultado);
    Integral.add(signoIgual);
    Integral.add(signoIntg);
    Integral.add(LiSuperior);
    Integral.add(LiInferior);
    
    btnDerivada.addActionListener(e -> cambiarDerivada());
  
    LiSuperior.addFocusListener(new java.awt.event.FocusAdapter(){
        @Override
        public void focusGained(java.awt.event.FocusEvent evt){
            Focus = LiSuperior;
        }
    });
    
    LiInferior.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt){
            Focus = LiInferior;
        }
    });
    
    IntgFormula.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt){
            Focus = IntgFormula;
        }
    });
    
    IngresoDatosIntg();
    
    IntgIgual.addActionListener(e -> {
        OperacionIntegral integral = new OperacionIntegral(this);
        double resultado = integral.ProcesarIntegral();
        IntgResultado.setText(String.valueOf(resultado));
    });
    
}

public void cambiarDerivada(){
    LiSuperior.setText("");
    LiInferior.setText("");
    IntgFormula.setText("");
    IntgResultado.setText("");
    cardlayout.show(PanelPrincipal, "derivada");
}

public void cambiarIntegral(){
    DerEje.setText("");
    DerFormula.setText("");
    DerResultado.setText("");
    cardlayout.show(PanelPrincipal, "integral");
}

public void IngresoDatosDer(){
    JButton[] botonesEje = {DerFx, DerFy};
    
    for (JButton Eje: botonesEje){
        Eje.addActionListener(e ->{
            DerEje.setText(Eje.getText());
        });
    }
    
    JButton[] botones = {Der0, Der1, Der2, Der3, Der4, Der5, Der6, Der7, Der8, Der9,
                         DerX, DerY, DerMas, DerMenos, DerMult, DerExp};
    
    for (JButton boton: botones){
        boton.addActionListener(e -> {
            DerFormula.setText(DerFormula.getText() + boton.getText());
        });
    }
    
    DerAtras.addActionListener(e ->{
        DerFormula.setText("");
        DerResultado.setText("");
    });
}

public void IngresoDatosIntg(){
    JButton[] botones = {Intg0, Intg1, Intg2, Intg3, Intg4, Intg5, Intg6, Intg7, Intg8, Intg9,
                         IntgX, IntgMas, IntgMenos, IntgMult, IntgExp};
    
    for (JButton boton: botones){
        boton.addActionListener(e -> {
            Focus.setText(Focus.getText() + boton.getText());
        });
    }
    
    IntgAtras.addActionListener(e ->{
        IntgFormula.setText("");
        IntgResultado.setText("");
        LiSuperior.setText("");
        LiInferior.setText("");
    });
}

public String ObtenerVariableDer(){
    return DerEje.getText();
}

public String ObtenerFormulaDer(){
    return DerFormula.getText();
}

public String ObtenerFormulaIntg(){
    return IntgFormula.getText();
}

public String ObtenerLimiteInferior(){
    return LiInferior.getText();
}

public String ObtenerLimiteSuperior(){
    return LiSuperior.getText();
}

public void MostrarResultadoDer(String resultado) {
        DerResultado.setText(resultado);
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
