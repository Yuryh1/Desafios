import java.util.Scanner;

public class desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String valorString = scanner.nextLine().replace(",", ".");
        double valor = Double.parseDouble(valorString);

        int[] notas = { 100, 50, 20, 10, 5, 2 };
        int[] moedas = { 100, 50, 25, 10, 5, 1 };

        System.out.println("NOTAS:");
        for (int nota : notas) {
            int quantidadeNotas = (int) (valor / nota);
            System.out.println(quantidadeNotas + " nota(s) de R$ " + nota + ".00");
            valor %= nota;
        }

        System.out.println("MOEDAS:");
        for (int moeda : moedas) {
            int quantidadeMoedas = (int) (valor * 100 / moeda);
            System.out.println(quantidadeMoedas + " moeda(s) de R$ " + (moeda / 100.0));
            valor %= (moeda / 100.0);
        }
    }
}
