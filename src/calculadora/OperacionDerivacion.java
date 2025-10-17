/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import javax.swing.JOptionPane;

public class OperacionDerivacion {
    private String Variable, Formula;
    private Calculadora calculadora;

    public OperacionDerivacion(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public void ProcesarDerivada() {
        Variable = calculadora.ObtenerVariableDer();
        Formula = calculadora.ObtenerFormulaDer();

        if (Variable.equals("fx")) {
            DerivarRespectoX();
        } else if (Variable.equals("fy")) {
            DerivarRespectoY();
        } else {
            JOptionPane.showMessageDialog(calculadora, "Selecciona un eje (fx o fy)");
        }
    }

    private void DerivarRespectoX() {
        String resultado = Derivar(Formula, "x");
        calculadora.MostrarResultadoDer(resultado);
    }

    private void DerivarRespectoY() {
        String resultado = Derivar(Formula, "y");
        calculadora.MostrarResultadoDer(resultado);
    }
    
private String Derivar(String formula, String var) {
    String[] terminos = formula.split("(?=[+-])");
    StringBuilder resultado = new StringBuilder();

    for (String t : terminos) {
        t = t.trim();
        if (t.isEmpty()) continue;

        // Si no hay variable = 0
        if (!t.contains(var)) continue;

        String[] factores = t.split("\\*");
        StringBuilder termResult = new StringBuilder();
        boolean derivado = false;

        for (int i = 0; i < factores.length; i++) {
            String f = factores[i].trim();

            if (!derivado && f.contains(var)) {
                String derivadoStr = DerivarFactor(f, var);
                if (derivadoStr.equals("0")) {
                    termResult = new StringBuilder("0");
                    break;
                }

                termResult.append(derivadoStr);

                for (int j = 0; j < factores.length; j++) {
                    if (j != i) termResult.append("*").append(factores[j].trim());
                }
                derivado = true;
            }
        }

        // Agregamos Simbolo
        String termFinal = termResult.toString().trim();
        if (!termFinal.equals("") && !termFinal.equals("0")) {
            // Ver cual es el signo
            boolean esNegativo = t.startsWith("-");
            if (resultado.length() == 0) {
                resultado.append(esNegativo ? "-" : "");
                resultado.append(termFinal.replace("-", ""));
            } else {
                resultado.append(esNegativo ? " - " : " + ");
                resultado.append(termFinal.replace("-", ""));
            }
        }
    }

    if (resultado.length() == 0)
        resultado.append("0");

    return resultado.toString();
}

private String DerivarFactor(String factor, String var) {
    factor = factor.trim();
    if (!factor.contains(var)) return "0";

    int coef = 1;
    int exp = 1;

    if (factor.contains(var + "^")) {
        String[] partes = factor.split(var + "\\^");
        String coefStr = partes[0].replace("+", "").trim();
        if (coefStr.equals("") || coefStr.equals("+")) coefStr = "1";
        if (coefStr.equals("-")) coefStr = "-1";
        coef = Integer.parseInt(coefStr);
        exp = Integer.parseInt(partes[1].trim());

        // Si el exponente es 0 el resultado es 0
        if (exp == 0) return "0";
        
        int nuevoCoef = coef * exp;
        int nuevoExp = exp - 1;

        if (nuevoExp == 0)
            return String.valueOf(nuevoCoef);
        else if (nuevoExp == 1)
            return nuevoCoef + var;
        else
            return nuevoCoef + var + "^" + nuevoExp;
    } else {
        String coefStr = factor.replace(var, "").replace("+", "").trim();
        if (coefStr.equals("") || coefStr.equals("+")) coefStr = "1";
        if (coefStr.equals("-")) coefStr = "-1";
        coef = Integer.parseInt(coefStr);
        return String.valueOf(coef);
    }
  }
}