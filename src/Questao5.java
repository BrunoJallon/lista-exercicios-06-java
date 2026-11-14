import questao5.model.*;

void main() {

    Navegador navegador = new Navegador();

    System.out.println("=== Navegando ===");
    navegador.acessar("Pagina Inicial");
    navegador.acessar("Noticias");
    navegador.acessar("Esportes");
    navegador.acessar("Resultado do Jogo");
    navegador.exibirPilha();
    System.out.println("Pagina atual: " + navegador.paginaAtual());

    System.out.println();
    System.out.println("=== Voltando ===");
    navegador.voltar();
    navegador.voltar();
    navegador.exibirPilha();
    System.out.println("Pagina atual: " + navegador.paginaAtual());

    //Depois de voltar, uma nova pagina entra no topo normalmente
    System.out.println();
    System.out.println("=== Nova pagina ===");
    navegador.acessar("Previsao do Tempo");
    navegador.exibirPilha();

    System.out.println();
    System.out.println("=== Voltando ate o inicio ===");
    navegador.voltar();
    navegador.voltar();
    navegador.voltar();
    System.out.println("Pagina atual: " + navegador.paginaAtual());

}
