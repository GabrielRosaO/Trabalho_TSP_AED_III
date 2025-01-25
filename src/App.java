import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

public class App {
    public static void main(String[] args) throws Exception {

        int numVertices = 0;
        int verticeInicio = 0;
        int algoOpcao = -1; // Controla qual o tipo de algoritmo a ser executado, 1 pro exato e 2 pro
                            // aproximativo

        Scanner lerDados = new Scanner(System.in);
        System.out.printf("Informe o número de vértices do grafo: ");
        numVertices = lerDados.nextInt();

        lerDados.nextLine();

        System.out.printf("Informe o nome do arquivo que contém a matriz de adjacência do grafo: ");
        String fileName = lerDados.nextLine();

        while (algoOpcao < 0 || algoOpcao > 2) {
            System.out.println("Insira qual o algoritmo que deseja executar");
            System.out.println("1-Algoritmo Exato");
            System.out.println("2-Algoritmo Aproximativo");
            System.out.printf("Opção: ");
            algoOpcao = lerDados.nextInt();
        }

        lerDados.close();

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader fileBuffer = new BufferedReader(file);
            Scanner fileExact = new Scanner(fileBuffer);

            int matrixTeste[][] = new int[numVertices][numVertices];
            int caminhoInicial[] = new int[numVertices];

            int i = 0;
            do {
                for (int j = 0; j < numVertices; j++) {
                    matrixTeste[i][j] = fileExact.nextInt();
                }
                caminhoInicial[i] = i;
                i++;
            } while (fileExact.hasNextInt() && i < numVertices);

            fileExact.close();

            if (algoOpcao == 1) {
                // Resultado Exato
                TSPExact exato = new TSPExact();

                exato.setNumVertices(numVertices);

                exato.setCaminhoFinal();

                long start = System.currentTimeMillis();

                System.out.println("Custo total do Caminho: "
                        + exato.permutacaoDeCiclos(matrixTeste, caminhoInicial, verticeInicio, numVertices - 1));

                long elapsed = System.currentTimeMillis() - start;

                System.out.printf("Tempo de execução em Segundos: %d\nTempo de execução em Milissegundos: %d\n\n",
                        elapsed / 1000, elapsed);

            } else if (algoOpcao == 2) {
                // Resultado Aproximado

                PrimTSP mst = new PrimTSP();
                mst.setMatrixSize(numVertices);

                long startAprox = System.currentTimeMillis();

                List<Integer> tspPath = mst.primTSP(matrixTeste);

                long elapsedAprox = System.currentTimeMillis() - startAprox;

                System.out.println("Custo total do caminho aproximado: " + mst.getCustoTotal());
                // System.out.println("Caminho Aproximado do TSP: " + tspPath);

                System.out.printf("Tempo de execução em Segundos: %d\nTempo de execução em Milissegundos: %d",
                        elapsedAprox / 1000, elapsedAprox);
            }
        } catch (IOException error) {
            System.err.printf("Erro na abertura do arquivo: %s. \n", error.getMessage());
        }

    }
}
