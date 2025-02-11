import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        // Vulnerabilidade: Execuçãoo de código arbitrário via Runtime.exec()
        try {
            Process process = Runtime.getRuntime().exec("echo Olá, " + nome);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
