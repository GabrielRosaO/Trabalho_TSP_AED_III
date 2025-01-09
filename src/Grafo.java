import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Grafo extends Exception {
    private int[][] matrixAdjacencia;
    private int matrixSize = 0;

    void setMatrixSize(int size) {
        this.matrixSize = size;
        matrixAdjacencia = new int[matrixSize][matrixSize];
    }

    int getMatrixSize() {
        return this.matrixSize;
    }

    void setMatrix(String fileName) {
        try {
            Scanner in = new Scanner(new FileReader(fileName));

            while (in.hasNextLine()) {
                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        this.matrixAdjacencia[i][j] = in.nextInt();
                    }
                }
            }

            in.close();
        } catch (FileNotFoundException error) {
            throw new IllegalArgumentException("File not found!");
        }

    }

    int[][] getMatrix() {
        return this.matrixAdjacencia;
    }

}
