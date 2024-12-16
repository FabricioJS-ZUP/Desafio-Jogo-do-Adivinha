import java.util.Scanner;
import java.util.Random;
public class Desafio_reg_medio {
    public static void main(String[] args) {
        //--------------------------------------------------------------------------
        // Variáveis globais
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Random random = new Random();
        int numaleatorio = numeros[random.nextInt(numeros.length)];
        int numeroaproxi = numaleatorio + 1;
        int numeroaproxab = numaleatorio - 1;
        int rodadas = 0;
        int ponto_usuario = 0;
        int desisto = 1;
        int palpite;
        //--------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        //--------------------------------------------------------------------------
        // Loop do jogo
        while (desisto != 0) {
            System.out.println("Escolha um número de 1 a 10:");
            palpite = scanner.nextInt(); // Lê o palpite do usuário
            if (palpite == numaleatorio) {
                ponto_usuario += 10; // Adiciona 10 pontos para acerto exato
                System.out.println("Parabéns! Você acertou o número exato!");
                //--------------------------------------------------------------------------
                // Gera um novo número aleatório para as 3 variaveis
                numaleatorio = numeros[random.nextInt(numeros.length)];
                numeroaproxi = numaleatorio + 1;
                numeroaproxab = numaleatorio - 1;
                //--------------------------------------------------------------------------
                System.out.println("Um novo número foi gerado! Continue jogando.");
            }
            // Verifica se o palpite esta proximo do numero aleatorio

            else if (palpite == numeroaproxab) {
                ponto_usuario += 5; // Adiciona 5 pontos para acerto aproximado
                System.out.println("para voçe acertar coloque o numero posterior a:" + numeroaproxab);
            }
            // Verifica se o palpite esta proximo do numero aleatorio
            else if (palpite == numeroaproxi) {
                ponto_usuario += 5; // Adiciona 5 pontos para acerto aproximado
                System.out.println("para voçe acertar coloque o numero anterior a:" + numeroaproxi);
            }
            // Caso o palpite esteja errado
            else {
                System.out.println("Você errou!");
            }
            System.out.println("Você tem: " + ponto_usuario + " pontos.");
            // Pergunta ao usuário se deseja desistir
            System.out.println("Caso queira desistir, digite 0 para sair ou outro número para continuar:");
            desisto = scanner.nextInt();
            rodadas++;
        }
        rodadas +=1;
        System.out.println("Fim de jogo! Sua pontuação final foi: " + ponto_usuario);
        System.out.println("Você jogou um total de " + rodadas + " rodadas.");
        scanner.close();
    }
}