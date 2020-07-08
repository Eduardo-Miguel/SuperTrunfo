package LP3.SuperTrunfo;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int vitorias = 0;
    private ArrayList<CartaSuperTrunfo> cartas;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public ArrayList<CartaSuperTrunfo> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<CartaSuperTrunfo> cartas) {
        this.cartas = cartas;
    }

    ////////////////////////

    public CartaSuperTrunfo getProximaCarta(){
        return this.getCartas().remove(0);
    }
   // Este método retorna a primeira carta.


    public void adicionarCarta(CartaSuperTrunfo carta){
        this.getCartas().add(carta);
    }
    //Este método insere a carta no final das cartas.

    public int getQuantidadeCartas(){
        return this.getCartas().size();
    }

    public boolean isSemCartas(){
        return this.getQuantidadeCartas() == 0;
    }
    //Este método retorna verdadeiro caso o jogador esteja sem cartas.


    public void incrementaVitorias(){
        this.vitorias ++;
    }
}