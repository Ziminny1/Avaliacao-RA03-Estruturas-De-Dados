/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package poo.ra03;

import java.util.Random;

public class RA03 {

    public static void main(String[] args) {

        int numDeElementos = 5000000;
        int tamanhoTabela = 10000;

        Registro[] elementos = new Registro[numDeElementos];

        int j = 100000000;
        for (int i = 0; i < numDeElementos; i++) {
            elementos[i] = new Registro(j);
            j++;
        }

        Random random = new Random(1);
        for (int i = 0; i < numDeElementos; i++) {
            int randomIndex = random.nextInt(numDeElementos);
            Registro temp = elementos[randomIndex];
            elementos[randomIndex] = elementos[i];
            elementos[i] = temp;
            i++;
        }

        int numeroDeRodadas = 1; // numero de vezes para rodar as funcoes.

        long tempoStart;
        long tempoFinish;

        long tempoTotalInsercao = 0;
        long tempoTotalBusca = 0;
        long somaColisoes = 0;
        long somaComparacoes = 0;

        for (int i = 0; i < numeroDeRodadas; i++) {

            TabelaHash tabelaResto = new TabelaHash(tamanhoTabela);

            tempoStart = System.nanoTime();
            for (int k = 0; k < numDeElementos; k++) {
                tabelaResto.insere_hashing(elementos[k].getCodigo());
            }
            tempoFinish = System.nanoTime();
            tempoTotalInsercao += tempoFinish - tempoStart;
            somaColisoes += tabelaResto.getColisoes();

            tempoStart = System.nanoTime();
            for (int k = 0; k < numDeElementos; k++) {
                tabelaResto.busca_hashing(elementos[k].getCodigo());
            }
            tempoFinish = System.nanoTime();
            tempoTotalBusca += tempoFinish - tempoStart;
            somaComparacoes += tabelaResto.getComparacoes();
        }
        
        System.out.println("Resto - Media de Colisoes: " + somaColisoes / numeroDeRodadas);
        System.out.println("Resto - Media de Tempo Insercao: " + tempoTotalInsercao / numeroDeRodadas + " ns");
        System.out.println("Resto - Media de Comparacoes: " + somaComparacoes / numeroDeRodadas);
        System.out.println("Resto - Media de Tempo Busca: " + tempoTotalBusca / numeroDeRodadas + " ns");

        tempoTotalInsercao = 0;
        tempoTotalBusca = 0;
        somaColisoes = 0;
        somaComparacoes = 0;

        for (int i = 0; i < numeroDeRodadas; i++) {

            TabelaHashDobramento tabelaDobramento = new TabelaHashDobramento(tamanhoTabela);

            tempoStart = System.nanoTime();
            for (int k = 0; k < numDeElementos; k++) {
                tabelaDobramento.insere_hashing(elementos[k].getCodigo());
            }
            tempoFinish = System.nanoTime();
            tempoTotalInsercao += tempoFinish - tempoStart;
            somaColisoes += tabelaDobramento.getColisoes();

            tempoStart = System.nanoTime();
            for (int k = 0; k < numDeElementos; k++) {
                tabelaDobramento.busca_hashing(elementos[k].getCodigo());
            }
            tempoFinish = System.nanoTime();
            tempoTotalBusca += tempoFinish - tempoStart;
            somaComparacoes += tabelaDobramento.getComparacoes();
        }

        System.out.println("Dobramento - Media de Colisoes: " + somaColisoes / numeroDeRodadas);
        System.out.println("Dobramento - Media de Tempo Insercao: " + tempoTotalInsercao / numeroDeRodadas + " ns");
        System.out.println("Dobramento - Media de Comparacoes: " + somaComparacoes / numeroDeRodadas);
        System.out.println("Dobramento - Media de Tempo Busca: " + tempoTotalBusca / numeroDeRodadas + " ns");

        tempoTotalInsercao = 0;
        tempoTotalBusca = 0;
        somaColisoes = 0;
        somaComparacoes = 0;

        for (int i = 0; i < numeroDeRodadas; i++) {

            TabelaHashMultiplicacao tabelaMultiplicacao = new TabelaHashMultiplicacao(tamanhoTabela);

            tempoStart = System.nanoTime();
            for (int k = 0; k < numDeElementos; k++) {
                tabelaMultiplicacao.insere_hashing(elementos[k].getCodigo());
            }
            tempoFinish = System.nanoTime();
            tempoTotalInsercao += tempoFinish - tempoStart;
            somaColisoes += tabelaMultiplicacao.getColisoes();

            tempoStart = System.nanoTime();
            for (int k = 0; k < numDeElementos; k++) {
                tabelaMultiplicacao.busca_hashing(elementos[k].getCodigo());
            }
            tempoFinish = System.nanoTime();
            tempoTotalBusca += tempoFinish - tempoStart;
            somaComparacoes += tabelaMultiplicacao.getComparacoes();
        }

        System.out.println("Multiplicacao - Media de Colisoes: " + somaColisoes / numeroDeRodadas);
        System.out.println("Multiplicacao - Media de Tempo Insercao: " + tempoTotalInsercao / numeroDeRodadas + " ns");
        System.out.println("Multiplicacao - Media de Comparacoes: " + somaComparacoes / numeroDeRodadas);
        System.out.println("Multiplicacao - Media de Tempo Busca: " + tempoTotalBusca / numeroDeRodadas + " ns");

    }
}
