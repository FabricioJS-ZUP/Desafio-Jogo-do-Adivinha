import java.util.Scanner;
import java.util.Random; //biblioteca para randomizar numeros
public class Desafio_req_minimo {
    public static void main(String[] args) {
        //--------------------------------------------------------------------------
        //variaveis globais
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Random random = new Random();  // gerar numeros aleatorios
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
        //loop do jogo
        while (desisto != 0) {
            System.out.println("escolha um numero de 1 a 10:");
            palpite = scanner.nextInt(); // Le o palpite do usuario
            if (palpite == numaleatorio) {
                ponto_usuario += 10; // Adiciona 10 pontos para acerto exato
                System.out.println("voce acertou o numero!");
                break; // Encerra o loop
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
                System.out.println("voce errou!");
            }
            System.out.println("voce tem: " + ponto_usuario + " pontos.");
            // Pergunta ao usuario se deseja desistir
            System.out.println("caso queira desistir, digite 0 para sair e outro numero para continuar");
            desisto = scanner.nextInt();
            rodadas++;
        }
        rodadas +=1;
        System.out.println("Fim de jogo! sua pontuacao final foi: " + ponto_usuario);
        System.out.println("voce jogou um total de " + rodadas + " rodadas.");
        scanner.close();
    }
}