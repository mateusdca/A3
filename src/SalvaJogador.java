import java.io.*;
import java.util.List;
;

public class SalvaJogador {

    public static void salvar(List<JogadorDeFutebol> jogadores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("jogadores.txt"))) {
            for (JogadorDeFutebol j : jogadores) {
                writer.write(
                        j.getId() + "," +
                                j.getNome() + "," +
                                j.getPosicao() + "," +
                                j.getIdade() + "," +
                                j.getNacionalidade() + "," +
                                j.getClube() + "," +
                                j.getSalario() + "," +
                                j.isTitular() + "," +
                                j.getNumeroCamisa() + "," +
                                j.isLesionado() + "," +
                                j.getGolsMarcados() + "," +
                                j.getAssistencias() + "," +
                                j.getPernaDominante() + "," +
                                j.getCartoesAmarelos() + "," +
                                j.getCartoesVermelhos() + "," +
                                j.getPartidasJogadas() + "," +
                                j.getAltura() + "," +
                                j.getPeso() + "," +
                                j.getDefesas());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os jogadores: " + e.getMessage());
        }
    }

}
