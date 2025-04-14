package it.prova.test.NumberUtility;

import it.prova.model.Utility.NumberUtility;

import javax.swing.*;

public class NumberUtilityTester {
    public static void main (String[] args) {
        boolean ciclando= true;
        while(ciclando){
            String valoreDaConvertire = JOptionPane.showInputDialog("Dammi un numero");
            if (valoreDaConvertire == null){
                ciclando=true;
                break;
            }
            Integer numeroParsato = NumberUtility.parseFromStringToInt(valoreDaConvertire); // Importante mettere Integer

            if(numeroParsato != null){
                JOptionPane.showMessageDialog(null, numeroParsato);

                break;
            }
        }

    }
}
