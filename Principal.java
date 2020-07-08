package LP3.SuperTrunfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        int op;
        System.out.println("Digite o nome dos dos jogadores:");
        Jogador jogador1 = new Jogador(ler.next());
        Jogador jogador2 = new Jogador(ler.next());

        do {
            System.out.println("ESCOLHA O TIPO DE JOGUINHO SUPER TRUNFO:");
            System.out.println("1 - HERÓIS MARVEL");
            System.out.println("2 - CAVALEIROS DO ZODÍACO");
            System.out.println("0 - SAIR");
            op = ler.nextInt();
            jogador1.setCartas(new ArrayList<>());
            jogador2.setCartas(new ArrayList<>());

            jogador1.setVitorias(0);
            jogador2.setVitorias(0);

            switch (op) {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 1:
                    int rodada = 0;
                    JogoSuperTrunfo jogoSuperTrunfo = new JogoHeroisMarvel(jogador1, jogador2);
                    int comeca = new Random().nextInt(2);

                    while (jogoSuperTrunfo.vencedor() == 0) {
                        System.out.println("\n=====================");
                        System.out.println("    RODADA: " + rodada);
                        System.out.println("=====================");
                        System.out.printf("%s: %d cartas | %d vitorias\n", jogador1.getNome(), jogador1.getQuantidadeCartas(), jogador1.getVitorias());
                        System.out.printf("%s: %d cartas | %d vitorias\n\n", jogador2.getNome(), jogador2.getQuantidadeCartas(), jogador2.getVitorias());

                        CartaSuperTrunfo cartaJogador1 = jogador1.getProximaCarta();
                        CartaSuperTrunfo cartaJogador2 = jogador2.getProximaCarta();

                        int comparaTrunfo;
                        int atributoEscolhido;


                        if (cartaJogador1.isTrunfo()) {
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            System.out.printf(" %s - CARTA TRUNFO!!! \n", jogador1.getNome());

                            if (cartaJogador1.compararTrunfo(cartaJogador2)) {
                                comparaTrunfo = 1;
                            } else {
                                comparaTrunfo = 2;
                            }
                        } else if (cartaJogador2.isTrunfo()) {
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            System.out.printf(" %s - CARTA TRUNFO!!! \n", jogador2.getNome());

                            if (cartaJogador2.compararTrunfo(cartaJogador1)) {
                                comparaTrunfo = 2;
                            } else {
                                comparaTrunfo = 1;
                            }

                        } else if (comeca == 0) {
                            cartaJogador1.mostrarListaAtributos();
                            System.out.printf("%s. Escolha o atributo: ", jogador1.getNome());
                            atributoEscolhido = ler.nextInt();
                            comparaTrunfo = cartaJogador1.compararAtributo(cartaJogador2, atributoEscolhido);
                        } else {
                            cartaJogador2.mostrarListaAtributos();
                            System.out.printf("%s. Escolha o atributo: ", jogador2.getNome());
                            atributoEscolhido = ler.nextInt();
                            comparaTrunfo = cartaJogador1.compararAtributo(cartaJogador2, atributoEscolhido);
                        }


                        //quem ganhou recebe as cartas
                        if (comparaTrunfo == 1) { // jogador 1 ganhou
                            System.out.printf("%s ganhou \n", jogador1.getNome());
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            addCartasJogador(jogador1, cartaJogador1, cartaJogador2, jogoSuperTrunfo.getMesa());
                            jogador1.incrementaVitorias();
                            jogoSuperTrunfo.setMesa(new ArrayList<>());
                            comeca = 0;
                        } else if (comparaTrunfo == 2) { // jogador 2 ganhou
                            System.out.printf("%s ganhou \n", jogador2.getNome());
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            addCartasJogador(jogador2, cartaJogador1, cartaJogador2, jogoSuperTrunfo.getMesa());
                            jogador2.incrementaVitorias();
                            jogoSuperTrunfo.setMesa(new ArrayList<>());
                            comeca = 1;
                        } else { // empate
                            System.out.println("EMPATEEE!!!");
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            jogoSuperTrunfo.getMesa().add(cartaJogador1);
                            jogoSuperTrunfo.getMesa().add(cartaJogador2);
                        }
                        jogoSuperTrunfo.gravarLogJogo();
                        rodada++;
                    }

                    if (jogoSuperTrunfo.vencedor() == 1) {
                        System.out.printf("%s VENCEU A PARTIDA!!!", jogador1.getNome());
                    } else {
                        System.out.printf("%s VENCEU A PARTIDA!!!", jogador2.getNome());
                    }
                    System.out.println("JOGAR OUTRA VEZ?");
                    System.out.println("1 - sim");
                    System.out.println("0 - não");

                    op = ler.nextInt();

                    break;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 2:

                    rodada = 0;
                    JogoSuperTrunfo jogoSuperTrunfo1 = new JogoCavaleirosZodiaco(jogador1, jogador2);
                    comeca = new Random().nextInt(2);

                    while (jogoSuperTrunfo1.vencedor() == 0) {
                        System.out.println("\n=====================");
                        System.out.println("    RODADA: " + rodada);
                        System.out.println("=====================");
                        System.out.printf("%s: %s cartas | %s vitorias\n", jogador1.getNome(), jogador1.getQuantidadeCartas(), jogador1.getVitorias());
                        System.out.printf("%s: %s cartas | %s vitorias\n\n", jogador2.getNome(), jogador2.getQuantidadeCartas(), jogador2.getVitorias());

                        CartaSuperTrunfo cartaJogador1 = jogador1.getProximaCarta();
                        CartaSuperTrunfo cartaJogador2 = jogador2.getProximaCarta();

                        int comparaTrunfo;
                        int atributoEscolhido;


                        if (cartaJogador1.isTrunfo()) {
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            System.out.printf(" %s - CARTA TRUNFO!!! \n", jogador1.getNome());

                            if (cartaJogador1.compararTrunfo(cartaJogador2)) {
                                comparaTrunfo = 1;
                            } else {
                                comparaTrunfo = 2;
                            }
                        } else if (cartaJogador2.isTrunfo()) {
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            System.out.printf(" %s - CARTA TRUNFO!!! \n", jogador2.getNome());

                            if (cartaJogador2.compararTrunfo(cartaJogador1)) {
                                comparaTrunfo = 2;
                            } else {
                                comparaTrunfo = 1;
                            }

                        } else if (comeca == 0) { // jogador 1 joga
                            cartaJogador1.mostrarListaAtributos();
                            System.out.printf("%s. Escolha o atributo: ", jogador1.getNome());
                            atributoEscolhido = ler.nextInt();
                            comparaTrunfo = cartaJogador1.compararAtributo(cartaJogador2, atributoEscolhido); // chama o metodo pra comparar os atributos
                        } else { // jogardor 2 joga
                            cartaJogador2.mostrarListaAtributos();
                            System.out.printf("%s. Escolha o atributo: ", jogador2.getNome());
                            atributoEscolhido = ler.nextInt();
                            comparaTrunfo = cartaJogador1.compararAtributo(cartaJogador2, atributoEscolhido); // chama o metodo pra comparar os atributos
                        }


                        //quem ganhou recebe as cartas
                        if (comparaTrunfo == 1) { // jogador 1 ganhou
                            System.out.printf("%s ganhou \n", jogador1.getNome());
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            addCartasJogador(jogador1, cartaJogador1, cartaJogador2, jogoSuperTrunfo1.getMesa());
                            jogador1.incrementaVitorias();
                            jogoSuperTrunfo1.setMesa(new ArrayList<>());
                            comeca = 0;
                        } else if (comparaTrunfo == 2) { // jogador 2 ganhou
                            System.out.printf("%s ganhou \n", jogador2.getNome());
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            addCartasJogador(jogador2, cartaJogador1, cartaJogador2, jogoSuperTrunfo1.getMesa());
                            jogador2.incrementaVitorias();
                            jogoSuperTrunfo1.setMesa(new ArrayList<>());
                            comeca = 1;
                        } else { // empate
                            System.out.println("EMPATEEE!!!");
                            System.out.println("---------");
                            cartaJogador1.printAll();
                            System.out.println("---------");
                            cartaJogador2.printAll();
                            System.out.println("---------");
                            jogoSuperTrunfo1.getMesa().add(cartaJogador1);
                            jogoSuperTrunfo1.getMesa().add(cartaJogador2);
                        }
                        jogoSuperTrunfo1.gravarLogJogo();
                        rodada++;
                    }

                    if (jogoSuperTrunfo1.vencedor() == 1) {
                        System.out.printf("%s VENCEU A PARTIDA!!!", jogador1.getNome());
                    } else {
                        System.out.printf("%s VENCEU A PARTIDA!!!", jogador2.getNome());
                    }
                    System.out.println("JOGAR OUTRA VEZ?");
                    System.out.println("1 - sim");
                    System.out.println("0 - não");

                    op = ler.nextInt();

                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!! TENTE NOVAMENTE");
            }
        } while (op != 0);
        System.out.println("Finalizando.....");
    }

    private static void addCartasJogador(Jogador jogador, CartaSuperTrunfo cartaJogador1, CartaSuperTrunfo cartaJogador2, ArrayList<CartaSuperTrunfo> cartasMesa) {
        jogador.adicionarCarta(cartaJogador1);
        jogador.adicionarCarta(cartaJogador2);
        cartasMesa.forEach(jogador::adicionarCarta);
    }
}