/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;
import javax.swing.JOptionPane;

/**
 *
 * @author psant
 */

public class OperacionIntegral {
    private String Formula;
    private double LimiteInferior;
    private double LimiteSuperior;
    private Calculadora calculadora;

    public OperacionIntegral(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public double ProcesarIntegral() {
    Formula = calculadora.ObtenerFormulaIntg();
    LimiteInferior = Double.parseDouble(calculadora.ObtenerLimiteInferior());
    LimiteSuperior = Double.parseDouble(calculadora.ObtenerLimiteSuperior());

    return CalcularIntegral(Formula, LimiteInferior, LimiteSuperior);
}

    private double CalcularIntegral(String formula, double a, double b) {
        formula = formula.replace(" ", "");
        
        // Asignar operador al termino inicial
        if (!formula.startsWith("+") && !formula.startsWith("-")) {
            formula = "+" + formula;
        }

        // Separamos terminos
        String[] terminos = formula.split("(?=[+-])");

        double resultadoTotal = 0;

        for (String term : terminos) {
            if (term.isEmpty()) continue;

            char signo = term.charAt(0);
            String parte = term.substring(1);

            double parcial = integrarTermino(parte, a, b);

            // Se suma o resta segun el signo
            if (signo == '-') {
                resultadoTotal -= parcial;
            } else {
                resultadoTotal += parcial;
            }
        }

        // Ponemos el resultado con decimales
        return Math.round(resultadoTotal * 100.0) / 100.0;
    }

    private double integrarTermino(String formula, double a, double b) {
        double coef = 0;
        double exp = 0;

        try {
            // Formula solo contiene x
            if (formula.equals("x")) {
                coef = 1;
                exp = 1;
            }
            else if (formula.matches("^[0-9.]+x$")) {
                // Constante con variable 3x
                coef = Double.parseDouble(formula.replace("x", ""));
                exp = 1;
            }
            else if (formula.matches("^x\\^[0-9.]+$")) {
                // Variable con exponente x^2
                coef = 1;
                exp = Double.parseDouble(formula.substring(2));
            }
            else if (formula.matches("^[0-9.]+x\\^[0-9.]+$")) {
                // Constante por variable con exponente 3x^2
                String[] partes = formula.split("x\\^");
                coef = Double.parseDouble(partes[0]);
                exp = Double.parseDouble(partes[1]);
            }
            else if (formula.matches("^[0-9.]+$")) {
                // Solo constante 
                coef = Double.parseDouble(formula);
                exp = 0;
            }
            else {
                JOptionPane.showMessageDialog(null, "Término no soportado: " + formula);
                return 0;
            }

            // Integral: coef/(exp+1) * x^(exp+1)
            double nuevoCoef = coef / (exp + 1);
            double nuevoExp = exp + 1;

            double valorSuperior = nuevoCoef * Math.pow(b, nuevoExp);
            double valorInferior = nuevoCoef * Math.pow(a, nuevoExp);

            return valorSuperior - valorInferior;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el término: " + formula);
            return 0;
        }
    }
}


