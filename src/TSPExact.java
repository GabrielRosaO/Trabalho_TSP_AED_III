public class TSPExact {
    private int verticesNum = 0;
    private int custoMinimoFinal = Integer.MAX_VALUE;
    private int caminhoFinal[];
    public long tempoTotal = 0;
    public long contadorPermutacao = 0;

    // get do numero de vertices
    public int getNumVertices() {
        return this.verticesNum;
    }

    // set do numero de vertices
    public void setNumVertices(int size) {
        this.verticesNum = size;
    }

    public void setCaminhoFinal() {
        this.caminhoFinal = new int[this.verticesNum];
    }

    private int calculoCustoDeUmCiclo(int matrixAdjacencia[][], int caminhoDeArestas[], int n) {
        int custoFinalCiclo = 0;
        for (int i = 0; i < n - 1; i++) {
            // Pega o valor do vertice i com o seguinte dele i+1,
            // Por exemplo vertice custoFinalCiclo += [0][1] e assim por diante para cada
            // iteração
            custoFinalCiclo += matrixAdjacencia[caminhoDeArestas[i]][caminhoDeArestas[i + 1]];
        }
        // Pega o ultimo vértice e volta ao primeiro e soma o valor ao custoFinalCiclo
        custoFinalCiclo += matrixAdjacencia[caminhoDeArestas[n - 1]][caminhoDeArestas[0]];

        return custoFinalCiclo;
    }

    // Vai por força bruta em todas as permutações do grafo
    // Basicamente vai comparar todos os ciclos até achar o menor deles
    public int permutacaoDeCiclos(int matrixAdjacencia[][], int caminhoArestas[], int verticeInicio, int verticeFim) {

        long startTime = System.nanoTime();

        // Vai fazer isso para todos os ciclos, basicamente ta comparando o valor do
        // ciclo atual da recursão com o anterior
        // e salva na variavel do objeto custoMinimoFinal
        if (verticeInicio == verticeFim) {
            int custoMinimo = calculoCustoDeUmCiclo(matrixAdjacencia, caminhoArestas, verticeFim + 1);
            if (custoMinimo < this.custoMinimoFinal) {
                this.custoMinimoFinal = custoMinimo;
                for (int i = 0; i <= verticeFim; i++) {
                    this.caminhoFinal[i] = caminhoArestas[i];
                }
            }
            contadorPermutacao++;
        } else {
            // pega o primerio vertice, troca de lugar com o vertice i
            // percorre todos os vertices fazendo isso alterando o vertice de inicio com o
            // vertice seguinte
            // ai ele chama a recursão desse próximo vertice
            // Basicamente no vetor caminhoArestas[] vao ser feitas todas as permutações
            // possíveis do grafo e para cada permutação
            // é calculado o custo total do ciclo
            for (int i = verticeInicio; i <= verticeFim; i++) {
                int temp = caminhoArestas[verticeInicio];
                caminhoArestas[verticeInicio] = caminhoArestas[i];
                caminhoArestas[i] = temp;

                permutacaoDeCiclos(matrixAdjacencia, caminhoArestas, verticeInicio + 1, verticeFim);

                temp = caminhoArestas[verticeInicio];
                caminhoArestas[verticeInicio] = caminhoArestas[i];
                caminhoArestas[i] = temp;
            }
        }

        long endTime = System.nanoTime() - startTime;

        tempoTotal += endTime;

        // Retorna o custo minimo final
        return custoMinimoFinal;
    }

    public void showArestas() {
        for (int i = 0; i < this.caminhoFinal.length; i++) {
            System.out.printf(this.caminhoFinal[i] + " ");
        }
        System.out.println(" ");
    }

}
