/*
Aluno: Fabrício John Sullivan
Dia: 16/12/2024
Projeto: Catalisa
Professora: Laura Fumagalli Rodrigues
Desafio: 2
Neste projeto foi pedido para fazer um jogo de adivinha de numeros.
 */

import java.util.ArrayList; // Importado para modificar o tamanho do array
import java.util.Random; // Importa a classe Random para gerar números aleatórios.
import java.util.Scanner;
import java.util.stream.IntStream; // Importado para ir de um numero á outro sem ter que escreverver a sequencia (ex 1 á 100000)
//--------------------------------
// Classe principal
//--------------------------------
public class Desafio_Req_Maximo {

    // Método principal, ponto de entrada do programa.
    public static void main(String[] args) {
        Random random = new Random(); // Gera números aleatórios.
        Scanner scanner = new Scanner(System.in); // Capturar entradas do usuário.
        //--------------------------------
        // Listas para armazenar os números acertados e errados.
        //--------------------------------
        ArrayList<Integer> numerosAcertados = new ArrayList<>();
        ArrayList<Integer> numerosErrados = new ArrayList<>();

        //--------------------------------
        // Escolha do nível
        //--------------------------------
        int[] numeros = Escolha_do_nivel(scanner); // Chama o método para escolher o nível e retorna o intervalo de números.
        //--------------------------------
        // Exibição do maior número do intervalo.
        //--------------------------------
        int maiorNumero = numeros[numeros.length - 1]; // Obtém o maior número do intervalo.
        System.out.println("Você pode escolher números de 1 até " + maiorNumero + ".");

        //--------------------------------
        // Inicialização de variáveis do jogo
        //--------------------------------
        int numAleatorio = numeros[random.nextInt(numeros.length)]; // Gera um número aleatório dentro do intervalo.
        int rodadas = 0; // Contador de rodadas.
        int pontosUsuario = 0; // Pontuação do usuário.

        //--------------------------------
        // Loop onde se encontra o jogo
        //--------------------------------
        while (true) { // Loop infinito controlado pelas condições do jogo.
            System.out.println("Escolha um número dentro do intervalo de 1 até " + maiorNumero + ":");
            System.out.println("Caso queira sair do jogo digite um número fora do intervalo de 1 até " + maiorNumero + ":");
            int palpite = scanner.nextInt(); // Lê o palpite do usuário.

            // Verifica se o palpite está dentro do intervalo.
            if (palpite < 1 || palpite > maiorNumero) {
                System.out.println("Você digitou um número fora do intervalo. Encerrando o jogo...");
                break; // Sai do loop se o número estiver fora do intervalo.
            }

            //--------------------------------
            // Verificação do palpite do usuário
            //--------------------------------
            if (palpite == numAleatorio) { // Caso o palpite seja exato.
                pontosUsuario += 10; // Adiciona 10 pontos.
                System.out.println("Parabéns! Você acertou o número exato!");
                numerosAcertados.add(palpite); // Adiciona o número acertado à lista.

                // Gera um novo número aleatório.
                numAleatorio = numeros[random.nextInt(numeros.length)];
                System.out.println("Um novo número foi gerado! Continue jogando.");
            } else if (palpite == numAleatorio - 1 || palpite == numAleatorio + 1) { // Caso o palpite esteja próximo.
                pontosUsuario += 5; // Adiciona 5 pontos.
                System.out.println("Você está próximo! Tente novamente.");
                numerosErrados.add(palpite); // Adiciona o número errado à lista.
            } else { // Caso o palpite esteja errado.
                System.out.println("Você errou!");
                numerosErrados.add(palpite); // Adiciona o número errado à lista.
            }

            // Exibição da pontuação.
            System.out.println("Você tem: " + pontosUsuario + " pontos.");
            rodadas++; // Incrementa o contador de rodadas.
        }

        //--------------------------------
        // Exibição do resultado final
        //--------------------------------
        System.out.println("Fim de jogo! Sua pontuação final foi: " + pontosUsuario);
        System.out.println("Você jogou um total de " + rodadas + " rodadas.");
        System.out.println("Números que você acertou: " + numerosAcertados);
        System.out.println("Números que você errou: " + numerosErrados);
        scanner.close();
    }

    //--------------------------------
    // Método para escolher o nível
    //--------------------------------
    public static int[] Escolha_do_nivel(Scanner scanner) {
        int niveis = 0; // Variável para armazenar o nível escolhido.
        int[] numeros = {}; // Array de números que será definido pelo nível.

        // Loop até o usuário escolher um nível válido.
        while (niveis != 1 && niveis != 2 && niveis != 3) {
            System.out.println("Escolha um dos níveis a seguir:");
            System.out.println("Digite 1 para jogar no Fácil: Números entre 1 e 10");
            System.out.println("Digite 2 para jogar no Médio: Números entre 1 e 50");
            System.out.println("Digite 3 para jogar no Difícil: Números entre 1 e 100");
            System.out.print("Escolha um número (1, 2 ou 3): ");
            niveis = scanner.nextInt();

            // Define o intervalo de números com base no nível escolhido.
            if (niveis == 1) {
                numeros = IntStream.rangeClosed(1, 10).toArray();
            } else if (niveis == 2) {
                numeros = IntStream.rangeClosed(1, 50).toArray();
            } else if (niveis == 3) {
                numeros = IntStream.rangeClosed(1, 100).toArray();
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        return numeros;
    }
}