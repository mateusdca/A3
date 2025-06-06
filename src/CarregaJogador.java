import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class CarregaJogador {
  public static List<JogadorDeFutebol> carregar() {
        List<JogadorDeFutebol> jogadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("jogadores.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 19) {
                    JogadorDeFutebol jogador = new JogadorDeFutebol(
                            Integer.parseInt(partes[0]),
                            partes[1],
                            partes[2],
                            Integer.parseInt(partes[3]),
                            partes[4],
                            partes[5],
                            Double.parseDouble(partes[6]),
                            Boolean.parseBoolean(partes[7]),
                            Integer.parseInt(partes[8]),
                            Boolean.parseBoolean(partes[9]),
                            Integer.parseInt(partes[10]),
                            Integer.parseInt(partes[11]),
                            partes[12],
                            Integer.parseInt(partes[13]),
                            Integer.parseInt(partes[14]),
                            Integer.parseInt(partes[15]),
                            Double.parseDouble(partes[16]),
                            Double.parseDouble(partes[17]),
                            Integer.parseInt(partes[18]));
                    jogadores.add(jogador);
                } else {
                    System.out.println("Linha inválida: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os jogadores: " + e.getMessage());
        }
        return jogadores;
    }

}
