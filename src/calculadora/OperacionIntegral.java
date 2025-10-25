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
    
     public String ProcesarIntegral() {
        try {
            Formula = calculadora.ObtenerFormulaIntg();
            String limInfStr = calculadora.ObtenerLimiteInferior();
            String limSupStr = calculadora.ObtenerLimiteSuperior();

            // Si los límites están vacíos => integral indefinida
            if (limInfStr.isEmpty() || limSupStr.isEmpty()) {
                return CalcularIntegralIndefinida(Formula);
            }else{
            // Si hay límites => integral definida
            LimiteInferior = Double.parseDouble(limInfStr);
            LimiteSuperior = Double.parseDouble(limSupStr);
            double definida = CalcularIntegral(Formula, LimiteInferior, LimiteSuperior);
            return String.valueOf(definida);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(calculadora, "Se necesita llenar los 2 limites: " + e.getMessage());
            return "Error";
        }
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
    
    private String CalcularIntegralIndefinida(String formula) {
        formula = formula.replace(" ", ""); // Limpiar espacios
        String[] terminos = formula.split("(?=[+-])"); // Divide por + o -

        StringBuilder resultado = new StringBuilder();

        for (String termino : terminos) {
            if (termino.isEmpty()) continue;

            // Caso más común: coeficiente * x^n
            if (termino.contains("x")) {
                double coef = 1.0;
                int exp = 1;

                if (termino.contains("^")) {
                    String[] partes = termino.split("\\^");
                    String base = partes[0]; // algo como "2x"
                    exp = Integer.parseInt(partes[1]);
                    if (base.contains("x")) {
                        String c = base.replace("x", "");
                        if (!c.isEmpty() && !c.equals("+") && !c.equals("-")) {
                            coef = Double.parseDouble(c);
                        } else if (c.equals("-")) {
                            coef = -1;
                        }
                    }
                } else {
                    // Si solo tiene "x"
                    String c = termino.replace("x", "");
                    if (!c.isEmpty() && !c.equals("+") && !c.equals("-")) {
                        coef = Double.parseDouble(c);
                    } else if (c.equals("-")) {
                        coef = -1;
                    }
                    exp = 1;
                }

                // Aplicar ∫ x^n dx = x^(n+1)/(n+1)
                double nuevoCoef = coef / (exp + 1);
                int nuevoExp = exp + 1;
                resultado.append(String.format("%.2fx^%d", nuevoCoef, nuevoExp));
            } else {
                // Término constante
                double cte = Double.parseDouble(termino);
                resultado.append(String.format("%.2fx", cte));
            }

            // Agregar el signo + si el siguiente término lo necesita
            if (!resultado.toString().endsWith("+") && !resultado.toString().endsWith("-"))
                resultado.append("+");
        }

        // Eliminar + final y agregar C
        if (resultado.toString().endsWith("+"))
            resultado.setLength(resultado.length() - 1);

        resultado.append(" + C");

        return resultado.toString();
    }
}