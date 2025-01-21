public class Prim extends Exception {
    private int custoTotal = 0;
    private int matrixSize = 0;

    // get tamanho matrix
    public int getMatrixSize() {
        return this.matrixSize;
    }

    public void setMatrixSize(int size) {
        this.matrixSize = size;
    }

    private void initializeVectors(int custos[], Boolean mst[]) {
        for (int i = 0; i < this.matrixSize; i++) {
            custos[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }
    }

    private int calculoCustoTotal(int custos[]) {
        for (int i = 0; i < custos.length; i++) {
            this.custoTotal += custos[i];
        }

        return custoTotal;
    }

    private int minCusto(int custos[], Boolean mst[]) {
        // inicializa o valor mínimo
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < this.matrixSize; i++) {
            if (custos[i] < min && mst[i] == false) {
                min = custos[i];
                index = i;
            }
        }
        return index;
    }

    public int primAlgorithm(int matrixAdjacencia[][]) {
        Boolean mst[] = new Boolean[this.matrixSize];
        int vertices[] = new int[this.matrixSize];
        int custos[] = new int[this.matrixSize];
        initializeVectors(custos, mst);

        custos[0] = 0;
        vertices[0] = -1;

        for (int i = 0; i < this.matrixSize - 1; i++) {
            int minIndex = minCusto(custos, mst);

            mst[minIndex] = true;

            for (int j = 0; j < this.matrixSize; j++) {
                if (matrixAdjacencia[minIndex][j] != 0 && mst[j] == false
                        && matrixAdjacencia[minIndex][j] < custos[j]) {
                    vertices[j] = minIndex;
                    custos[j] = matrixAdjacencia[minIndex][j];
                }
            }
        }
        for (int i = 0; i < custos.length; i++) {
            System.out.println(custos[i]);
        }

        return calculoCustoTotal(custos);
    }

    public void showMatrix(int matrixAdjacencia[][]) {
        for (int i = 0; i < this.matrixSize; i++) {
            for (int j = 0; j < this.matrixSize; j++) {
                System.out.printf("%d ", matrixAdjacencia[i][j]);
            }
            System.out.println(" ");
        }
    }
}
