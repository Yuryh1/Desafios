package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class desafio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());   

        List<Integer> pares = new ArrayList<>();   
        List<Integer> impares = new ArrayList<>(); 

   
        for (int i = 0; i < N; i++) {
            int valor = Integer.parseInt(scanner.nextLine());
            if (valor % 2 == 0) {
                pares.add(valor);   
            } else {
                impares.add(valor);   
            }
        }

        Collections.sort(pares);   
        Collections.sort(impares, Collections.reverseOrder()); 

    
        for (int par : pares) {
            System.out.println(par);
        }

      
        for (int impar : impares) {
            System.out.println(impar);
        }
    }

}
