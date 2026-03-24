Com base no livro do Goodrich cujas leituras são devidamente indicadas tanto nos slides (e aula), quanto no Moodle,  responda:

1) O que são TADs? Dê 3 exemplos e descreva-os.

TAD significa Tipo Abstrato de Dado. É um tipo que representa uma estrutura específica, porém não é devidamente implementada com esse nome numa linguagem de programação. Exemplos de TAD são lista, pilha e fila.

2) Qual a definição de Listas lineares?

Lista linear é uma lista não vazia de elementos ordenados com base em algum critério. A posição de um elemento dentro da lista se deve pela sua relação com os demais elementos.

3) Qual a diferença de contiguidade física e dinâmica? Cite 2 vantagens e duas desvantagens de cada uma delas. 

Contiguidade física é a pilha, é onde ficam as variáveis estática e globais, todos os blocos ficam juntos, rápido de acessar, mas pouco espaço para armazenamento. É onde ficam as variáveis da função que está executando. O SO insere e remove essas variáveis quando a função é chamada.

Contiguidade dinâmica é o heap, é onde ficam as variáveis locais do programa que só são armazenadas durante a execução dele ele aloca os dados dinamicamente, sem posição específica apenas com um endereço. Uma posição da memória estática armazena esse endereço para quando for necessário recuperar. Tem mais espaço para armazenamento, mas o acesso é mais lento. O programador gerencia as variáveis.

4) Qual a definição de Lista com Arranjo?

Lista com arranjo é utilizar um arranjo para armazenar elementos de uma lista.

O acesso aos elementos é rápido pois se utiliza o índice.

5) Qual a desvantagem da implementação de lista com arranjo apresentada em aula? 

Remover ou adicionar um elemento é custoso já que será preciso realocar todos elementos a partir da posição alterada.

--> Parte prática de listas com arranjo: utilize os códigos disponibilizados - ListArrayOfInteger.java

6) Incorpode no código base também o método - void add (int index, Integer element) 

