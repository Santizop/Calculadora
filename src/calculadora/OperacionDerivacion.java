/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

public class OperacionDerivacion {
    private String Variable, Formula;
    private Calculadora calculadora;

    public OperacionDerivacion(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public void ProcesarDerivada() {
        Variable = calculadora.ObtenerVariableDer(); // f(x) o f(y)
        Formula = calculadora.ObtenerFormulaDer();

        if (Variable.equals("fx")) {
            DerivarRespectoX();
        } else if (Variable.equals("fy")) {
            DerivarRespectoY();
        } else {
            calculadora.MostrarResultadoDer("Selecciona un eje (fx o fy)");
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

            if (!t.contains(var)) {
                continue;
            }

            // Derivada de x -> 1
//            if (t.equals(var)) {
//                resultado.append("+1");
//            }
            
            if (t.contains("x^")) {
            // CASO 4: Potencia
            String[] partes = t.split("x\\^");
            String coefStr = partes[0].replace("+", "").trim(); // quita +
            if (coefStr.equals("") || coefStr.equals("+")) coefStr = "1";
            if (coefStr.equals("-")) coefStr = "-1";

            int coef = Integer.parseInt(coefStr);
            int exp = Integer.parseInt(partes[1].trim());

            int nuevoCoef = coef * exp;
            int nuevoExp = exp - 1;

            if (nuevoExp == 1)
                resultado.append(nuevoCoef + "x");
            else if (nuevoExp == 0)
                resultado.append(nuevoCoef);
            else
                resultado.append(nuevoCoef + "x^" + nuevoExp);
            }
        }

        if (resultado.length() == 0)
            resultado.append("0");

        return resultado.toString();
    }
}
