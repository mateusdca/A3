import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  
    private static List<JogadorDeFutebol> jogadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        jogadores = CarregaJogador.carregar();
        int opcao;

        do {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> criarJogador();
                case 2 -> listarJogadores();
                case 3 -> buscarJogadorPorId();
                case 4 -> acaoJogador();
                case 5 -> editarJogador();
                case 6 -> excluirJogador();
                case 7 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU DE JOGADORES ===");
        System.out.println("1. Criar novo jogador");
        System.out.println("2. Listar todos os jogadores");
        System.out.println("3. Buscar jogador por ID");
        System.out.println("4. Ações com o jogador (Titular, Lesionado, Gols, Assistências, etc.)");
        System.out.println("5. Editar jogador");
        System.out.println("6. Excluir jogador");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarJogador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Posição: ");
        String posicao = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();
        System.out.print("Clube: ");
        String clube = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = Double.parseDouble(scanner.nextLine());
        System.out.print("Número da camisa: ");
        int numeroCamisa = Integer.parseInt(scanner.nextLine());
        System.out.print("Perna dominante: ");
        String pernaDominante = scanner.nextLine();
        System.out.print("Altura(em cm): ");
        double altura = Double.parseDouble(scanner.nextLine());
        System.out.print("Peso(em Kg): ");
        double peso = Double.parseDouble(scanner.nextLine());

        JogadorDeFutebol jogador = new JogadorDeFutebol(nome, posicao, idade, nacionalidade, clube, salario, numeroCamisa, pernaDominante, altura, peso);
        jogadores.add(jogador);
        SalvaJogador.salvar(jogadores);
        System.out.println("Jogador criado com sucesso!");
    }

    private static void listarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }

        System.out.println("\n=== LISTA DE JOGADORES ===");
        for (JogadorDeFutebol jogador : jogadores) {
            System.out.println(jogador.resumo());
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println();
        }
    }

    private static void buscarJogadorPorId() {
        System.out.print("Digite o ID do jogador: ");
        int id = Integer.parseInt(scanner.nextLine());
        JogadorDeFutebol jogador = encontrarJogadorPorId(id);

        if (jogador != null) {
            System.out.println("\n=== JOGADOR ENCONTRADO ===");
            System.out.println(jogador.resumo());
        } else {
            System.out.println("===== Jogador não encontrado. =====");
        }
    }

    private static JogadorDeFutebol encontrarJogadorPorId(int id) {
        for (JogadorDeFutebol jogador : jogadores) {
            if (jogador.getId() == id) {
                return jogador;
            }
        }
        return null;
    }

    private static void acaoJogador() {
        System.out.print("Digite o ID do jogador: ");
        int id = Integer.parseInt(scanner.nextLine());
        JogadorDeFutebol jogador = encontrarJogadorPorId(id);

        if (jogador == null) {
            System.out.println("===== Jogador não encontrado. =====");
            return;
        }

        int acao;

        do {
            exibirAcoesJogador();
            acao = Integer.parseInt(scanner.nextLine());

            switch (acao) {
                case 1 -> {
                    jogador.jogadorTitular();
                    System.out.println();
                    System.out.println("===== Jogador marcado como titular. =====");
                }
                case 2 -> {
                    jogador.jogadorReserva();
                    System.out.println();
                    System.out.println("===== Jogador marcado como reserva. =====");
                }
                case 3 -> {
                    jogador.marcarGol();
                    System.out.println();
                    System.out.println("===== Gol marcado! ===== Total de gols: " + jogador.getGolsMarcados());
                }
                case 4 -> {
                    jogador.darAssistencia();
                    System.out.println();
                    System.out.println("===== Assistência dada! ===== Total de assistências: " + jogador.getAssistencias());
                }
                case 5 -> {
                    jogador.defender();
                    System.out.println();
                    System.out.println("===== Defesa realizada! ===== Total de defesas: " + jogador.getDefesas());
                }
                case 6 -> {
                    jogador.sofrerLesao();
                    System.out.println();
                    System.out.println("===== Jogador marcado como lesionado. =====");
                }
                case 7 -> {
                    jogador.recuperarLesao();
                    System.out.println();
                    System.out.println("===== Jogador recuperado da lesão. =====");
                }
                case 8 -> {
                    jogador.receberCartaoAmarelo();
                    System.out.println();
                    System.out.println(
                            "===== Cartão amarelo recebido! =====  Total de cartões amarelos: " + jogador.getCartoesAmarelos());
                }
                case 9 -> {
                    jogador.receberCartaoVermelho();
                    System.out.println();
                    System.out.println(
                            "===== Cartão vermelho recebido!   ===== Total de cartões vermelhos: " + jogador.getCartoesVermelhos());
                }
                case 10 -> {
                    jogador.registrarPartida();
                    System.out.println();
                    System.out
                            .println("===== Partida registrada! ===== Total de partidas jogadas: " + jogador.getPartidasJogadas());
                }
                case 11 -> {
                    System.out.println();
                    System.out.println("Voltando ao menu principal...");
                    break;
                }

                default -> System.out.println("Ação inválida.");
            }
        } while (acao != 11);
    }

    private static void exibirAcoesJogador() {
        System.out.println("\n=== AÇÕES COM O JOGADOR ===");
        System.out.println("1. Marcar como titular");
        System.out.println("2. Marcar como reserva");
        System.out.println("3. Marcar gol");
        System.out.println("4. Dar assistência");
        System.out.println("5. Defender");
        System.out.println("6. Jogador lesionado");
        System.out.println("7. Jogador recuperado");
        System.out.println("8. Marcar cartão amarelo");
        System.out.println("9. Marcar cartão vermelho");
        System.out.println("10. Registrar partida jogada");
        System.out.println("11. Voltar ao menu principal");

        System.out.print("Escolha uma ação: ");
    }

    private static void editarJogador() {
        System.out.print("Digite o ID do jogador: ");
        int id = Integer.parseInt(scanner.nextLine());
        JogadorDeFutebol jogador = encontrarJogadorPorId(id);

        if (jogador == null) {
            System.out.println("===== Jogador não encontrado. =====");
            return;
        }

        int editar;

        do {
            exibirEdicao();
            editar = Integer.parseInt(scanner.nextLine());

            switch (editar) {
                case 1 -> {
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    jogador.setNome(novoNome);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Nome atualizado com sucesso! =====");
                }
                case 2 -> {
                    System.out.print("Digite a nova posição: ");
                    String novaPosicao = scanner.nextLine();
                    jogador.setPosicao(novaPosicao);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Posição atualizada com sucesso! =====");
                }
                case 3 -> {
                    System.out.print("Digite a nova idade: ");
                    int novaIdade = Integer.parseInt(scanner.nextLine());
                    jogador.setIdade(novaIdade);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Idade atualizada com sucesso! =====");
                }
                case 4 -> {
                    System.out.print("Digite a nova nacionalidade: ");
                    String novaNacionalidade = scanner.nextLine();
                    jogador.setNacionalidade(novaNacionalidade);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Nacionalidade atualizada com sucesso! =====");
                }
                case 5 -> {
                    System.out.print("Digite o novo clube: ");
                    String novoClube = scanner.nextLine();
                    jogador.setClube(novoClube);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Clube atualizado com sucesso! =====");
                }
                case 6 -> {
                    System.out.print("Digite o novo salário: ");
                    double novoSalario = Double.parseDouble(scanner.nextLine());
                    jogador.setSalario(novoSalario);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Salário atualizado com sucesso! =====");
                }
                case 7 -> {
                    System.out.print("Digite o novo número da camisa: ");
                    int novoNumeroCamisa = Integer.parseInt(scanner.nextLine());
                    jogador.setNumeroCamisa(novoNumeroCamisa);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Número da camisa atualizado com sucesso! =====");
                }
                case 8 -> {
                    System.out.print("Digite a nova perna dominante: ");
                    String novaPernaDominante = scanner.nextLine();
                    jogador.setPernaDominante(novaPernaDominante);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Perna dominante atualizada com sucesso! =====");
                }
                case 9 -> {
                    System.out.print("Digite a nova altura (em cm): ");
                    double novaAltura = Double.parseDouble(scanner.nextLine());
                    jogador.setAltura(novaAltura);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Altura atualizada com sucesso! =====");
                }
                case 10 -> {
                    System.out.print("Digite o novo peso (em Kg): ");
                    double novoPeso = Double.parseDouble(scanner.nextLine());
                    jogador.setPeso(novoPeso);
                    SalvaJogador.salvar(jogadores);
                    System.out.println();
                    System.out.println("===== Peso atualizado com sucesso! =====");
                }
                case 11 -> {
                    System.out.println();
                    System.out.println("Voltando ao menu principal...");
                    break;
                }

                default -> System.out.println("Ação inválida.");
            }
        } while (editar != 11);
    }

    private static void exibirEdicao() {
        System.out.println("\n=== EDITAR JOGADOR ===");
        System.out.println("1. Editar nome");
        System.out.println("2. Editar posição");
        System.out.println("3. Editar idade");
        System.out.println("4. Editar nacionalidade");
        System.out.println("5. Editar clube");
        System.out.println("6. Editar salário");
        System.out.println("7. Editar número da camisa");
        System.out.println("8. Editar perna dominante");
        System.out.println("9. Editar altura");
        System.out.println("10. Editar peso");
        System.out.println("11. Voltar ao menu principal");
        

        System.out.print("Escolha uma ação: ");
    }

    private static void excluirJogador() {
        System.out.print("Digite o ID do jogador a ser excluído: ");
        int id = Integer.parseInt(scanner.nextLine());
        JogadorDeFutebol jogador = encontrarJogadorPorId(id);

        if (jogador != null) {
            jogadores.remove(jogador);
            SalvaJogador.salvar(jogadores);
            System.out.println();
            System.out.println("===== Jogador excluído com sucesso! =====");
        } else {
            System.out.println();
            System.out.println("=====  Jogador não encontrado. =====");
        }
    }
}
