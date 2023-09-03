// Teste de Contadores com Threads
import java.util.Scanner;

public class MyTest {
    static int i = 0;

    public static void main(String[] args) {
        new Thread(t1).start();
        new Thread(t2).start();

        // Aguarda uma entrada do usuário para encerrar o programa
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione Enter para sair...");
        scanner.nextLine();
        scanner.close();
    }

    private static void countMe(String name) {
        synchronized (MyTest.class) {
            i++;
            System.out.println("O Contador atual é: " + i + ", atualizado por: " + name);
        }
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try {
                for (int j = 0; j < 5; j++) {
                    countMe("t1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private static Runnable t2 = new Runnable() {
        public void run() {
            try {
                for (int j = 0; j < 5; j++) {
                    countMe("t2");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
