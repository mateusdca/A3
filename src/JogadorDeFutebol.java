public class JogadorDeFutebol {

  private static int contadorId = 1;
  private int id;
  private String nome;
  private String posicao;
  private int idade;
  private String nacionalidade;
  private String clube;
  private double salario;
  private boolean titular;
  private int numeroCamisa;
  private boolean lesionado;
  private int golsMarcados;
  private int assistencias;
  private String pernaDominante;
  private int cartoesAmarelos;
  private int cartoesVermelhos;
  private int partidasJogadas;
  private double altura;
  private double peso;
  private int defesas;

  public JogadorDeFutebol(String nome, String posicao, int idade, String nacionalidade, String clube, double salario, int numeroCamisa, String pernaDominante, double altura, double peso) {
    
    this.id = contadorId++;
    this.nome = nome;
    this.posicao = posicao;
    this.idade = idade;
    this.nacionalidade = nacionalidade;
    this.clube = clube;
    this.salario = salario;
    this.titular = false;
    this.numeroCamisa = numeroCamisa;
    this.lesionado = false;
    this.golsMarcados = 0;
    this.assistencias = 0;
    this.pernaDominante = pernaDominante;
    this.cartoesAmarelos = 0;
    this.cartoesVermelhos = 0;
    this.partidasJogadas = 0;
    this.altura = altura;
    this.peso = peso;
  }

  public JogadorDeFutebol(String nome, String posicao, int idade, String nacionalidade, String clube, double salario, int numeroCamisa, double altura, double peso) {
    
    this.id = contadorId++;
    this.nome = nome;
    this.posicao = posicao;
    this.idade = idade;
    this.nacionalidade = nacionalidade;
    this.clube = clube;
    this.salario = salario;
    this.titular = false;
    this.numeroCamisa = numeroCamisa;
    this.lesionado = false;
    this.golsMarcados = 0;
    this.assistencias = 0;
    this.defesas = 0;
    this.cartoesAmarelos = 0;
    this.cartoesVermelhos = 0;
    this.partidasJogadas = 0;
    this.altura = altura;
    this.peso = peso;
  }
  public JogadorDeFutebol(int id, String nome, String posicao, int idade, String nacionalidade,
                        String clube, double salario, boolean titular, int numeroCamisa,
                        boolean lesionado, int golsMarcados, int assistencias,
                        String pernaDominante, int cartoesAmarelos, int cartoesVermelhos,
                        int partidasJogadas, double altura, double peso, int defesas) {

    this.id = id;
    this.nome = nome;
    this.posicao = posicao;
    this.idade = idade;
    this.nacionalidade = nacionalidade;
    this.clube = clube;
    this.salario = salario;
    this.titular = titular;
    this.numeroCamisa = numeroCamisa;
    this.lesionado = lesionado;
    this.golsMarcados = golsMarcados;
    this.assistencias = assistencias;
    this.pernaDominante = pernaDominante;
    this.cartoesAmarelos = cartoesAmarelos;
    this.cartoesVermelhos = cartoesVermelhos;
    this.partidasJogadas = partidasJogadas;
    this.altura = altura;
    this.peso = peso;
    this.defesas = defesas;

    // ATUALIZA o contadorId se necessário
    if (id >= contadorId) {
        contadorId = id + 1;
    }
}

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getPosicao() {
    return posicao;
  }

  public int getIdade() {
    return idade;
  }

  public String getNacionalidade() {
    return nacionalidade;
  }

  public String getClube() {
    return clube;
  }

  public double getSalario() {
    return salario;
  }

  public boolean isTitular() {
    return titular;
  }

  public int getNumeroCamisa() {
    return numeroCamisa;
  }

  public boolean isLesionado() {
    return lesionado;
  }

  public int getGolsMarcados() {
    return golsMarcados;
  }

  public int getAssistencias() {
    return assistencias;
  }

  public String getPernaDominante() {
    return pernaDominante;
  }

  public int getCartoesAmarelos() {
    return cartoesAmarelos;
  }

  public int getCartoesVermelhos() {
    return cartoesVermelhos;
  }

  public int getPartidasJogadas() {
    return partidasJogadas;
  }

  public double getAltura() {
    return altura;
  }

  public double getPeso() {
    return peso;
  }

  public int getDefesas() {
    return defesas;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }

  public void setClube(String clube) {
    this.clube = clube;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public void setNumeroCamisa(int numeroCamisa) {
    this.numeroCamisa = numeroCamisa;
  }

  public void setPernaDominante(String pernaDominante) {
    this.pernaDominante = pernaDominante;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }
  
  public void marcarGol() {
      this.golsMarcados++;
  }
  
  public void darAssistencia() {
      this.assistencias++;
  }


  public void registrarPartida() {
      this.partidasJogadas++;
  }

  public void jogadorTitular(){
      this.titular = true;
  }

  public void jogadorReserva(){
      this.titular = false;
  }

  public void sofrerLesao() {
      this.lesionado = true;
  }


  public void recuperarLesao() {
      this.lesionado = false;
  }


  public void receberCartaoAmarelo() {
      this.cartoesAmarelos++;
  }


  public void receberCartaoVermelho() {
      this.cartoesVermelhos++;
  }


  public double mediaGolsPorPartida() {
      if (partidasJogadas == 0) return 0.0;
      return (double) golsMarcados / partidasJogadas;
  }


  public double mediaAssistenciasPorPartida() {
      if (partidasJogadas == 0) return 0.0;
      return (double) assistencias / partidasJogadas;
  }

  public void defender() {
      this.defesas++;
  }

  public double mediaDefesasPorPartida() {
      if (partidasJogadas == 0) return 0.0;
      return (double) defesas / partidasJogadas;
  }


  public String resumo() {
      return "ID: " + id + 
            " | Jogador: " + nome +
            " | Posição: " + posicao +
            " | Idade: " + idade +
            " | Clube: " + clube +
            " | Salário: R$ " + String.format("%.2f", salario) +
            " | Número: " + numeroCamisa +
            " | Titular: " + (titular ? "Sim" : "Não") +
            " | Lesionado: " + (lesionado ? "Sim" : "Não") +
            " | Nacionalidade: " + nacionalidade +
            " | Gols: " + golsMarcados +
            " | Assistências: " + assistencias +
            " | Partidas: " + partidasJogadas +
            " | Cartões Amarelos: " + cartoesAmarelos +
            " | Cartões Vermelhos: " + cartoesVermelhos +
            " | Altura: " + altura +
            " | Peso: " + peso +
            " | Perna Dominante: " + pernaDominante +
            " | Gols por Partida: " + String.format("%.2f", mediaGolsPorPartida()) +
            " | Assistências por Partida: " + String.format("%.2f", mediaAssistenciasPorPartida()) +
            " | Defesas: " + defesas +
            " | Defesas por Partida: " + String.format("%.2f", mediaDefesasPorPartida());
}

  @Override
  public String toString() {
      return resumo();
  }


}
