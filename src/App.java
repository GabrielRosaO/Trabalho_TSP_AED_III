import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Prim mst = new Prim();

        mst.setMatrixSize(11);

        int matrixSize = mst.getMatrixSize();
        // String file = "file:C:/Users/Usuario/Documents/Codigos em//
        // Java/Trabalho_TSP_AED_III/src/teste.txt";

        BufferedReader fileBuffer = new BufferedReader(new FileReader("bin\\teste.txt"));
        Scanner file = new Scanner(fileBuffer);

        int matrixTeste[][] = new int[matrixSize][matrixSize];

        int i = 0;
        do {
            for (int j = 0; j < matrixSize; j++) {
                matrixTeste[i][j] = file.nextInt();
            }
            i++;
        } while (file.hasNextInt() && i < matrixSize);

        file.close();

        mst.showMatrix(matrixTeste);

        System.out.println(mst.primAlgorithm(matrixTeste));

    }
}
