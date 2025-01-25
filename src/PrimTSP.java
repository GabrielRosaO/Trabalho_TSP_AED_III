import java.util.ArrayList;
import java.util.List;

public class PrimTSP {
    private int custoTotal = 0;
    private int matrixSize = 0;

    // get tamanho matrix
    public int getMatrixSize() {
        return this.matrixSize;
    }

    public void setMatrixSize(int size) {
        this.matrixSize = size;
    }

    // Inicializa os vetores utilizados
    private void initializeVectors(int custos[], Boolean mst[]) {
        for (int i = 0; i < this.matrixSize; i++) {
            custos[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }
    }

    // Retorna o indice do caminho de menor custo
    private int minCusto(int custos[], Boolean mst[]) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < this.matrixSize; i++) {
            if (custos[i] < min && !mst[i]) {
                min = custos[i];
                index = i;
            }
        }
        return index;
    }

    public List<Integer> primTSP(int matrixAdjacencia[][]) {
        Boolean mst[] = new Boolean[this.matrixSize];
        int vertices[] = new int[this.matrixSize];
        int custos[] = new int[this.matrixSize];
        initializeVectors(custos, mst);

        // Inicia a posição do primeiro vértice como já visitado, já que ele é o ponto
        // de partida
        custos[0] = 0;
        vertices[0] = -1;

        // Construir a árvore geradora mínima
        for (int i = 0; i < this.matrixSize - 1; i++) {
            int minIndex = minCusto(custos, mst);// Encontra o indice do caminho de menor custo na iteração atual
            mst[minIndex] = true;// marca aquele vértice como presente na MST

            // Faz a alteração e ajustes dos vetores de custo com o menor custo e salva o
            // indice do vértice que foi visitado
            for (int j = 0; j < this.matrixSize; j++) {
                if (matrixAdjacencia[minIndex][j] != 0 && !mst[j] && matrixAdjacencia[minIndex][j] < custos[j]) {
                    vertices[j] = minIndex;
                    custos[j] = matrixAdjacencia[minIndex][j];
                }
            }
        }

        // Caminhada em pré-ordem dos nodos para obter uma solução aproximada para o TSP
        List<Integer> tspPath = new ArrayList<>();
        boolean visited[] = new boolean[this.matrixSize];
        preorderTraversal(0, vertices, visited, tspPath);

        // Adiciona o vértice inicial ao final para fechar o ciclo
        tspPath.add(0);

        // Calculo do custo total
        this.custoTotal = 0;
        for (int i = 0; i < tspPath.size() - 1; i++) {
            int from = tspPath.get(i);
            int to = tspPath.get(i + 1);
            this.custoTotal += matrixAdjacencia[from][to];
        }

        // Retorna a List com a pré-ordem dos vértices da MST
        return tspPath;
    }

    // Função que encontra e monta a pre ordem dos nodos, adicionando na lista
    // tspPath na ordem
    private void preorderTraversal(int node, int[] vertices, boolean[] visited, List<Integer> tspPath) {
        visited[node] = true;
        tspPath.add(node);

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == node && !visited[i]) {
                preorderTraversal(i, vertices, visited, tspPath);
            }
        }
    }

    // Retorna o custo total da MST
    public int getCustoTotal() {
        return this.custoTotal;
    }

    // Imprime a matrix
    public void showMatrix(int matrixAdjacencia[][]) {
        for (int i = 0; i < this.matrixSize; i++) {
            for (int j = 0; j < this.matrixSize; j++) {
                System.out.printf("%d ", matrixAdjacencia[i][j]);
            }
            System.out.println(" ");
        }
    }
}
