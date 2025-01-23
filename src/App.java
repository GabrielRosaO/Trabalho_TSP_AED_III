import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int numVertices = 11;
        int verticeInicio = 0;

        // Resultado Exato
        TSPExact exato = new TSPExact();

        exato.setNumVertices(numVertices);

        int matrixSize = exato.getNumVertices();

        BufferedReader fileBuffer = new BufferedReader(new FileReader("bin\\tsp1_253.txt"));
        Scanner fileExact = new Scanner(fileBuffer);

        int matrixTeste[][] = new int[matrixSize][matrixSize];
        int caminhoInicial[] = new int[matrixSize];
        exato.setCaminhoFinal();

        int i = 0;
        do {
            for (int j = 0; j < matrixSize; j++) {
                matrixTeste[i][j] = fileExact.nextInt();
            }
            caminhoInicial[i] = i;
            i++;
        } while (fileExact.hasNextInt() && i < matrixSize);

        fileExact.close();

        long start = System.currentTimeMillis();

        System.out.println("Custo total do Caminho: "
                + exato.permutacaoDeCiclos(matrixTeste, caminhoInicial, verticeInicio, numVertices - 1));

        long elapsed = System.currentTimeMillis() - start;

        System.out.printf("Tempo de execução em Segundos: %d\nTempo de execução em Milissegundos: %d",
                elapsed / 1000, elapsed);

        // Resultado Aproximado

        PrimTSP mst = new PrimTSP();
        mst.setMatrixSize(11);
        matrixSize = mst.getMatrixSize();

        long startAprox = System.currentTimeMillis();

        List<Integer> tspPath = mst.primTSP(matrixTeste);

        long elapsedAprox = System.currentTimeMillis() - start;

        System.out.println("Caminho Aproximado do TSP: " + tspPath);
        System.out.println("Custo total do caminho aproximado: " + mst.getCustoTotal());

        System.out.printf("Tempo de execução em Segundos: %d\nTempo de execução em Milissegundos: %d",
                elapsed / 1000, elapsed);

    }
}
