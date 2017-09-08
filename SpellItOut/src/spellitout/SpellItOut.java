/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellitout;

import java.util.Scanner;

/**
 *
 * @author José Torres
 */
public class SpellItOut {

    /**
     * @param args the command line arguments
     */
   private static final String[] thousandUp = {
        "",
        " thousand",
        " million",
             
    };

    private static final String[] tenMultiples= {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };

    private static final String[] zeroUp = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };
    //primeiro testei com uma base menor para ser mais fácil
    private String convertLessThanThousand(int number) {
        String current;

        if (number % 100 < 20){
            current = zeroUp[number % 100];
            number /= 100;
        }
        else {
            current = zeroUp[number % 10];
            number /= 10;

            current = tenMultiples[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return zeroUp[number] + " hundred" + current;
    }

    public String convert(int number) {

        if (number == 0) { return "zero"; }
        if (number == 1000000000) { return "one billion"; }

        String prefix = "";

        String current = "";
        int place = 0;
        
        do {
            //testa se o numero é maior que 0
            //se for salta para convertLessThanThousand, escolhe a posição [0] da string thounsandUp que é uma
            //posição vazia
            int n = number % 1000;
            if (n != 0){
                String s = convertLessThanThousand(n);
                current = s + thousandUp[place] + current;
            }
            //se o n for maior diferente de 0 quer dizer que o numero é maior que 1000 e aumenta o lugar na string thoundsandUp
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    public static void main(String[] args) {
        SpellItOut sio = new SpellItOut();
        System.out.print("0-1000000000\n");
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        System.out.println(" "+ sio.convert(number));
        
    }

    public SpellItOut() {
    }
}
