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

        // Funcion sin variable = 0
        if (!t.contains(var)) continue;

        int coef = 1;
        int exp = 1;

        // Detectar si hay exponente, como "x^3"
        if (t.contains(var + "^")) {
            String[] partes = t.split(var + "\\^");
            String coefStr = partes[0].replace("+", "").trim();

            if (coefStr.equals("") || coefStr.equals("+")) coefStr = "1";
            if (coefStr.equals("-")) coefStr = "-1";

            coef = Integer.parseInt(coefStr);
            exp = Integer.parseInt(partes[1].trim());

            // Aplicar derivada: coef * exp, y reducir exponente en 1
            int nuevoCoef = coef * exp;
            int nuevoExp = exp - 1;

            if (nuevoExp == 1)
                resultado.append(signo(resultado, nuevoCoef)).append(Math.abs(nuevoCoef)).append(var);
            else if (nuevoExp == 0)
                resultado.append(signo(resultado, nuevoCoef)).append(Math.abs(nuevoCoef));
            else
                resultado.append(signo(resultado, nuevoCoef)).append(Math.abs(nuevoCoef)).append(var).append("^").append(nuevoExp);

        } else if (t.contains(var)) {
            // Caso sin exponente explícito: "3x", "-x", "+x"
            String coefStr = t.replace(var, "").replace("+", "").trim();
            if (coefStr.equals("") || coefStr.equals("+")) coefStr = "1";
            if (coefStr.equals("-")) coefStr = "-1";

            coef = Integer.parseInt(coefStr);
            int nuevoCoef = coef; // derivada de ax = a

            resultado.append(signo(resultado, nuevoCoef)).append(Math.abs(nuevoCoef));
        }
    }

    if (resultado.length() == 0)
        resultado.append("0");

    return resultado.toString();
}

// 🔹 Función auxiliar para poner + o - correctamente
    private String signo(StringBuilder resultado, int valor) {
        if (resultado.length() == 0) return valor < 0 ? "-" : "";
        return valor < 0 ? " - " : " + ";
    }
}
