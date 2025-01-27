# Trabalho de AED III TSP

```
Autores: Gabriel Rosa de Oliveira Silva e Karen Ono Satie
```

### Descrição do Trabalho

O trabalho consiste no desenvolvimento de dois algoritmos que solucionem o Problema do Caixeiro Viajante (sigla em inglês: TSP). O problema consiste em encontrar um caminho para o caixeiro viajante em que, dado um conjunto de cidades com as distâncias entre elas, ele possa passar por todas e retornar a sua cidade de origem.

Nesse trabalho tínhamos que desenvolver 2 algoritmos: Um algoritmo exato e outro aproximativo.

- Algoritmo exato (Permutações): A nossa escolha de algoritmo exato foi a de força bruta, testar todas as possíveis combinações para encontrar o menor caminho possível

- Algoritmo aproximativo (Algoritmo de Prim): Para o algoritmo aproximativos escolhemos o algoritmo de Prim que retornar uma Árvore Geradora Mínima (MST) do grafo que representa o conjunto de cidades. Tivemos que adicionar mais uma etapa em que é formado o caminho a partir da MST gerada, pois ela não tem um ciclo fechado em sua construção, apenas todos os vétices conectados com os menores custos.

### Execução do código

Para execução dos dois algoritmos tenha certeza de que todos os arquivos com as matrizes de adjacência dos grafos seja um arquivo .txt neste formato:

```
0 29  20  21  16  31  100 12  4   31  18
29  0   15  29  28  40  72  21  29  41  12
20  15  0   15  14  25  81  9   23  27  13
21  29  15  0   4   12  92  12  25  13  25
16  28  14  4   0   16  94  9   20  16  22
31  40  25  12  16  0   95  24  36  3   37
100 72  81  92  94  95  0   90  101 99  84
12  21  9   12  9   24  90  0   15  25  13
4   29  23  25  20  36  101 15  0   35  18
31  41  27  13  16  3   99  25  35  0   38
18  12  13  25  22  37  84  13  18  38  0
```

Todos os arquivos que desejar executar devem estar na pasta raiz do local em que será executado o código, como no exemplo:
`
Seu / Caminho / Ate / A / Pasta /Trabalho_TSP_AED_III/teste.txt
`

### Output

O código pedirá pra inserir a quantidade de vértices o grafo contém, o nome do arquivo que contém a matriz de adjacência e pedirá para escolher o tipo de algoritmo que deseja executar, sendo 1 para o algoritmo exato e 2 para o aproximado.

Após a escolha ele retornará o resultado do custo do caminho encontrado e os tempos de execução.

- Algoritmo Exato: Os tempos retornados são em Segundos e Milissegundos;
- Algoritmo Aproximativo: Os tempos retornados são em Milissegundos e Nanosegundos;

Essa diferença existe pois o algoritmo aproximativo executa muito rapido para os exemplos dados, não fazendo sentido demonstrar os tempos em segundos para ele.
