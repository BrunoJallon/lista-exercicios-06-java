package questao4.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaUsuarios {

    //Map com o email como chave: a chave nunca se repete, entao nao tem como ter dois usuarios com o mesmo email
    //LinkedHashMap mantem a ordem de cadastro na hora de listar
    private Map<String, Usuario> usuarios = new LinkedHashMap<>();

    public boolean inserir(Usuario usuario) {
        String chave = usuario.getEmail().toLowerCase();

        //containsKey procura direto pela chave, sem precisar percorrer a colecao
        if (usuarios.containsKey(chave)) {
            System.out.println("Erro: ja existe usuario com o email " + usuario.getEmail());
            return false;
        }

        usuarios.put(chave, usuario);
        System.out.println("Usuario " + usuario.getNome() + " cadastrado.");
        return true;
    }

    public boolean remover(String email) {
        Usuario removido = usuarios.remove(email.toLowerCase());

        if (removido == null) {
            System.out.println("Erro: nenhum usuario com o email " + email);
            return false;
        }

        System.out.println("Usuario " + removido.getNome() + " removido.");
        return true;
    }

    public void listar() {
        System.out.println("=== Usuarios cadastrados (" + usuarios.size() + ") ===");

        if (usuarios.isEmpty()) {
            System.out.println("  Nenhum usuario cadastrado.");
            return;
        }

        for (Usuario usuario : usuarios.values()) {
            System.out.println("  " + usuario);
        }
    }

}
