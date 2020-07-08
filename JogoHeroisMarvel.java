package LP3.SuperTrunfo;

import LP3.Lista8.Principal;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JogoHeroisMarvel extends JogoSuperTrunfo {
    String separador = "//";
    String local = "D:/user/Documents/IFMS-Intellij/src/LP3/SuperTrunfo/cartas/marvel.txt";

    public JogoHeroisMarvel(Jogador jogador1, Jogador jogador2) throws FileNotFoundException {
        super(jogador1, jogador2);
        carregarCartas();
        super.embaralhar();
        super.distribuir();
    }

    @Override
    public void carregarCartas() throws FileNotFoundException {
        try {
            FileReader arquivo = new FileReader(local);
            BufferedReader buffer = new BufferedReader(arquivo);

            while (buffer.ready()) {
                String linha = buffer.readLine();

                String dados[] = linha.split(separador);

                String nome = dados[0];
                String ident = dados[1];
                boolean trunfo = Boolean.parseBoolean(dados[2]);
                int altura = Integer.parseInt(dados[3]);
                int inteligencia = Integer.parseInt(dados[4]);
                int forca = Integer.parseInt(dados[5]);
                int velocidade = Integer.parseInt(dados[6]);
                int habilidade = Integer.parseInt(dados[7]);

                super.getCartas().add(new CartaHeroisMarvel(nome, ident, trunfo, altura, inteligencia, forca, velocidade, habilidade));
            }

            buffer.close();
            arquivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não existe!");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void gravarLogJogo() {
        try {
            FileWriter arquivo = new FileWriter("C:\\cartas\\logJogos.txt");
            BufferedWriter buffer = new BufferedWriter(arquivo);
            String nome = "";
            Date d = new Date();
            String data = new SimpleDateFormat("dd/MM/YYYY").format(d);
            String hora = new SimpleDateFormat("HH:mm:ss").format(d);

            nome = this.vencedor() == 1 ? this.getJogador1().getNome() :
                    this.vencedor() == 2 ? this.getJogador2().getNome() :
                            "Jogo não finalizou";

            buffer.write(data + " - " + hora + " - Heróis Marvel - Jogador 1:"
                    + getJogador1().getNome() + " - Jogador 2: " + getJogador2().getNome() + " - Vencedor: " + nome);
            buffer.newLine();

            buffer.close();
            arquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
