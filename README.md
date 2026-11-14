# Lista 06: Collections e Streams

## Questão 1

O Java Collections Framework é o conjunto de interfaces e classes do pacote `java.util` usado para guardar e manipular grupos de objetos. As principais interfaces são `List`, `Set`, `Queue` e `Map`, e cada uma tem implementações prontas, como `ArrayList`, `HashSet`, `ArrayDeque` e `HashMap`. Também existe a classe `Collections`, com métodos prontos como `sort()` e `reverse()`.

A maior vantagem em relação ao array é o tamanho: o array tem tamanho fixo, definido na criação, enquanto uma coleção cresce conforme os elementos são adicionados. Além disso, as coleções já têm métodos para adicionar, remover, buscar e ordenar, que no array eu teria que fazer na mão, deslocando as posições. Elas também usam generics (`List<String>`), então o compilador garante o tipo dos elementos, e podem ser usadas com streams.

## Questão 2

A `List` guarda os elementos em sequência, cada um com uma posição (índice), e aceita repetidos. É indicada quando a ordem importa e podem existir elementos iguais, como os itens de um carrinho de compras ou as mensagens de um chat.

O `Set` não aceita elementos repetidos e não tem índice. Se eu tentar adicionar um elemento que já existe, o `add()` retorna `false` e nada muda. É indicado quando cada elemento só pode aparecer uma vez, como as tags de uma postagem ou as palavras diferentes de um texto (questão 6).

O `Map` guarda pares de chave e valor. As chaves não se repetem, os valores podem se repetir, e a busca é feita pela chave. É indicado quando preciso encontrar algo a partir de um identificador, como um usuário pelo email (questão 4) ou um produto pelo código de barras.

## Questão 3

**Ordem:** o `HashSet` não garante nenhuma ordem. O `LinkedHashSet` mantém a ordem de inserção. O `TreeSet` mantém os elementos sempre ordenados, pela ordem natural ou por um `Comparator`.

**Complexidade:** no `HashSet` e no `LinkedHashSet`, buscar, inserir e remover são O(1) em média, porque o `hashCode()` do elemento já indica onde ele fica na tabela. No `TreeSet` essas operações são O(log n), porque ele usa uma árvore balanceada e precisa ir comparando os elementos até achar a posição certa.

**Memória:** o `LinkedHashSet` é o que mais gasta, porque além da tabela hash cada elemento guarda uma referência para o anterior e outra para o próximo. O `HashSet` e o `TreeSet` ficam parecidos: o `HashSet` tem a tabela, que sempre tem posições sobrando, e o `TreeSet` não tem tabela, mas cada nó da árvore guarda referências para os filhos e para o pai.

Resumindo: `HashSet` quando a ordem não importa (é o mais rápido), `LinkedHashSet` quando preciso manter a ordem de inserção e `TreeSet` quando preciso dos elementos ordenados.

## Questões 4, 5 e 6

Os códigos estão na pasta `src`. Assim como nas listas 04 e 05, usei Java 25 com `void main()`.

- **Questão 4:** usei um `Map<String, Usuario>` com o email como chave. Como a chave de um `Map` não se repete, não tem como cadastrar dois usuários com o mesmo email. Um `Set` também impediria repetidos, mas com o `Map` dá para buscar e remover direto pelo email. Usei `LinkedHashMap` para a listagem sair na ordem de cadastro, e o email é guardado em minúsculo, então `Ana@Email.com` e `ana@email.com` contam como o mesmo.
- **Questão 5:** a classe `Navegador` guarda os títulos das páginas numa pilha (`ArrayDeque`). Ao acessar uma página, o `push()` coloca ela no topo. Ao voltar, o `pop()` tira a página atual e a anterior volta a ser o topo. Usei `ArrayDeque` em vez de `Stack` porque é o que a documentação do Java recomenda para pilhas.
- **Questão 6:** na parte a, o `filter(n -> n >= 0)` deixa só os números que não são negativos. Na parte b, o `filter` com `startsWith("P")` exibe as palavras que começam com P, maiúsculo ou minúsculo. Na parte c, tirei a pontuação do parágrafo, separei as palavras com `split(" ")`, passei para minúsculo com `map` e juntei tudo num `Set` com `Collectors.toSet()`. Como o `Set` não aceita repetidos, sobram só as palavras únicas.
