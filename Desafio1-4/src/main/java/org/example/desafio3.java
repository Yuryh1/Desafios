import java.util.Arrays;
import java.util.Scanner;

public class desafio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho do array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Digite os elementos do array separados por espaço: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("O valor alvo: ");
        int k = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
