import java.util.Scanner;

public class desafio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int half = line.length() / 2;
            for (int j = half - 1; j >= 0; j--) {
                System.out.print(line.charAt(j));
            }
            System.out.print(" ");
            for (int j = line.length() - 1; j >= half; j--) {
                System.out.print(line.charAt(j));
            }
            System.out.println();
        }
    }
}
