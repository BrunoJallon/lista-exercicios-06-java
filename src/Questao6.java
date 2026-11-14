import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

void main() {

    //a) Remover os numeros menores que 0
    System.out.println("=== a) Removendo negativos ===");
    List<Integer> numeros = List.of(5, -3, 0, 12, -7, 8, -1, 4);
    System.out.println("Original: " + numeros);

    //filter mantem so quem passa na condicao, entao fica quem e maior ou igual a 0
    List<Integer> semNegativos = numeros.stream()
            .filter(n -> n >= 0)
            .toList();
    System.out.println("Sem negativos: " + semNegativos);

    //b) Exibir as Strings que comecam com P
    System.out.println();
    System.out.println("=== b) Palavras que iniciam com P ===");
    List<String> palavras = List.of("Python", "Java", "PHP", "pascal", "Kotlin", "Perl", "Ruby");
    System.out.println("Original: " + palavras);

    //toUpperCase para pegar tambem as que comecam com p minusculo
    palavras.stream()
            .filter(p -> p.toUpperCase().startsWith("P"))
            .forEach(p -> System.out.println("  " + p));

    //c) Palavras unicas de um paragrafo
    System.out.println();
    System.out.println("=== c) Palavras unicas do paragrafo ===");
    String paragrafo = "O Java roda na JVM. A JVM permite que o mesmo codigo rode em sistemas diferentes, "
            + "porque o codigo Java vira bytecode e o bytecode roda em qualquer JVM.";
    System.out.println("Texto: " + paragrafo);

    //Tira o ponto e a virgula e separa as palavras pelo espaco
    String[] palavrasDoTexto = paragrafo.replace(".", "").replace(",", "").split(" ");

    //toLowerCase para "Java" e "java" contarem como a mesma palavra
    //O Set nao aceita repetidos, entao cada palavra aparece uma vez so
    Set<String> unicas = Arrays.stream(palavrasDoTexto)
            .map(p -> p.toLowerCase())
            .collect(Collectors.toSet());

    System.out.println("Palavras unicas (" + unicas.size() + "): " + unicas);

}
