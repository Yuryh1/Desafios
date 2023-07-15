package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class desafio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());  // Ler o valor de N

        List<Integer> pares = new ArrayList<>();  // Lista para armazenar os números pares
        List<Integer> impares = new ArrayList<>();  // Lista para armazenar os números ímpares

        // Iterar N vezes para ler os valores de entrada
        for (int i = 0; i < N; i++) {
            int valor = Integer.parseInt(scanner.nextLine());
            if (valor % 2 == 0) {
                pares.add(valor);  // Adicionar número par à lista de pares
            } else {
                impares.add(valor);  // Adicionar número ímpar à lista de ímpares
            }
        }

        Collections.sort(pares);  // Ordenar os números pares em ordem crescente
        Collections.sort(impares, Collections.reverseOrder());  // Ordenar os números ímpares em ordem decrescente

        // Imprimir os números pares em ordem crescente
        for (int par : pares) {
            System.out.println(par);
        }

        // Imprimir os números ímpares em ordem decrescente
        for (int impar : impares) {
            System.out.println(impar);
        }
    }

}
