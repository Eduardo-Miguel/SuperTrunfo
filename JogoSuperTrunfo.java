package LP3.SuperTrunfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Random;


public abstract class JogoSuperTrunfo {
    private ArrayList<CartaSuperTrunfo> cartas = new ArrayList<>();
    private ArrayList<CartaSuperTrunfo> mesa = new ArrayList<>();
    private Jogador jogador1;
    private Jogador jogador2;

    public JogoSuperTrunfo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public ArrayList<CartaSuperTrunfo> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<CartaSuperTrunfo> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<CartaSuperTrunfo> getMesa() {
        return mesa;
    }

    public void setMesa(ArrayList<CartaSuperTrunfo> mesa) {
        this.mesa = mesa;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public void embaralhar() {
        Random r = new Random();
        CartaSuperTrunfo aux;
        for (int i = 0; i < cartas.size(); i++) {
            int n1 = r.nextInt(cartas.size());
            int n2 = r.nextInt(cartas.size());
            aux = cartas.get(n1);
            cartas.set(n1, cartas.get(n2));
            cartas.set(n2, aux);

        }
    }

    public void distribuir() {
        for (int i = 0; i < cartas.size(); i++) {
            if (this.jogador1.getQuantidadeCartas() == this.jogador2.getQuantidadeCartas()) {
                this.jogador1.adicionarCarta(cartas.get(i));
            } else {
                this.jogador2.adicionarCarta(cartas.get(i));
            }
        }
    }

    public abstract void carregarCartas() throws FileAlreadyExistsException, FileNotFoundException;

    public int vencedor() {
        return jogador1.getQuantidadeCartas() == 0 ? 2 :
                jogador2.getQuantidadeCartas() == 0 ? 1 : 0;
    }

    public abstract void gravarLogJogo() throws IOException;
}
