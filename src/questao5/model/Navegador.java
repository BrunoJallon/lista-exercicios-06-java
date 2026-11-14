package questao5.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Navegador {

    //Pilha de titulos: o topo e sempre a pagina que esta aberta
    //ArrayDeque e o que a documentacao do Java recomenda para pilha, no lugar da classe Stack
    private Deque<String> historico = new ArrayDeque<>();

    public void acessar(String titulo) {
        //push coloca a nova pagina no topo da pilha
        historico.push(titulo);
        System.out.println("Acessando: " + titulo);
    }

    public void voltar() {
        //Precisa ter pelo menos duas paginas para conseguir voltar para a anterior
        if (historico.size() <= 1) {
            System.out.println("Nao ha pagina anterior para voltar.");
            return;
        }

        //pop desempilha a pagina atual, e a anterior passa a ser o topo
        String saiu = historico.pop();
        System.out.println("Voltando de \"" + saiu + "\" para \"" + historico.peek() + "\"");
    }

    public String paginaAtual() {
        //peek olha o topo sem remover
        return historico.peek();
    }

    public void exibirPilha() {
        System.out.println("Pilha (topo primeiro): " + historico);
    }

}
