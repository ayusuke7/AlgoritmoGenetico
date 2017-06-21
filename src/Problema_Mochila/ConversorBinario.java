package Problema_Mochila;

import javax.swing.JOptionPane;

/**
 *
 * @author YU7
 */
public class ConversorBinario {

    public int converteBinDec(String binario) {

        int decimal = 0;
        int potencia = 0;

        for (int i = binario.length() - 1; i >= 0; i--) {
            if (binario.charAt(i) == '0' || binario.charAt(i) == '1') {
                int aux = Character.getNumericValue(binario.charAt(i));
                decimal += Math.pow(2, potencia) * aux;
                potencia++;
            } else {
                JOptionPane.showMessageDialog(null, binario + " não é um valor BINÁRIO");
            }
        }

        return decimal;

    }

    public String converteDecBin(int num) {

        String bin = Integer.toBinaryString(num);

        return bin;

    }

   }
