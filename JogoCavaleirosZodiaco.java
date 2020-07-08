package LP3.SuperTrunfo;

import LP3.Lista8.Principal;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JogoCavaleirosZodiaco extends JogoSuperTrunfo {
    String separador = "//";
    String local = "D:/user/Documents/IFMS-Intellij/src/LP3/SuperTrunfo/cartas/cavZod.txt";

    public JogoCavaleirosZodiaco(Jogador jogador1, Jogador jogador2) throws FileNotFoundException {
        super(jogador1, jogador2);
        carregarCartas();
        super.embaralhar();
        super.distribuir();
    }

    @Override
    public void carregarCartas() {
        try {
            FileReader arquivo = new FileReader(local);
            BufferedReader buffer = new BufferedReader(arquivo);

            while (buffer.ready()) {
                String linha = buffer.readLine();

                String dados[] = linha.split(separador);

                String nome = dados[0];
                String ident = dados[1];
                boolean trunfo = Boolean.parseBoolean(dados[2]);
                int soco = Integer.parseInt(dados[3]);
                int chute = Integer.parseInt(dados[4]);
                int tecnica = Integer.parseInt(dados[5]);
                int conhecimento = Integer.parseInt(dados[6]);
                int forca = Integer.parseInt(dados[7]);

                super.getCartas().add(new CartaCavaleirosZodiaco(nome, ident, trunfo, soco, chute, tecnica, conhecimento, forca));

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
    public void gravarLogJogo() { // data atual, hora atual, nome do jogo (cavaleiros ou marvel),
        // nome do jogador1, nome do jogador2 e vencedor.

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

            buffer.write(data + " - " + hora + " - Cavaleiros do Zodíaco - Jogador 1:"
                    + getJogador1().getNome() + " - Jogador 2: " + getJogador2().getNome() + " - Vencedor: " + nome);
            buffer.newLine();

            buffer.close();
            arquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
