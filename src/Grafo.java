import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Grafo extends Exception {
    private int[][] matrixAdjacencia;
    private int matrixSize = 0;// tamanho da matrix

    // set do tamanho da matrix, indicado pelo usuário

    // set da matrix, usa o tamanho da matrix dado pelo usuario e le do arquivo os
    // valores em cada posição e salva a matrix
    // do arquvio .txt no grafo
    public void setMatrix(File fileName) {
        try {
            Scanner in = new Scanner(fileName);

            while (in.hasNextInt()) {
                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        this.matrixAdjacencia[i][j] = in.nextInt();
                    }
                }
            }
            // in.close();
        } catch (FileNotFoundException error) {
            throw new IllegalArgumentException("File not found!");
        }

    }

    // @override

}
