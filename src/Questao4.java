import questao4.model.*;

void main() {

    SistemaUsuarios sistema = new SistemaUsuarios();

    System.out.println("=== Insercao ===");
    sistema.inserir(new Usuario("ana@email.com", "Ana", "senha123"));
    sistema.inserir(new Usuario("joao@email.com", "Joao", "abc456"));
    sistema.inserir(new Usuario("maria@email.com", "Maria", "qwe789"));

    //Mesmo email da Ana (com maiuscula), deve ser recusado
    sistema.inserir(new Usuario("Ana@Email.com", "Ana Paula", "outra"));

    System.out.println();
    sistema.listar();

    System.out.println();
    System.out.println("=== Remocao ===");
    sistema.remover("joao@email.com");
    sistema.remover("naoexiste@email.com");

    System.out.println();
    sistema.listar();

}
