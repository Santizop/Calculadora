/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;
/**
 *
 * @author psant
 */
public class OperacionDerivacion extends Calculadora{
    private String Variable, Formula;
    
public void OperacionesDerivacion(){
    Variable = ObtenerVariableDer();
    
}

public void DerivarVariableX(){
    Formula = ObtenerFormulaDer();
    String[] Terminos = Formula.split("(?=[+-])");
    
    for (String Expresion: Terminos){
        Expresion = Expresion.trim();
        
            if (!Expresion.contains("x")){
                
            }
    }
    
}

}
