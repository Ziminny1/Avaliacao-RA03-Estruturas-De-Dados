/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.ra03;

public class TabelaHash {

    private Registro[] tabela;
    private int tamanho;
    private int quantidade;
    private int colisoes;
    private int comparacoes;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new Registro[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new Registro(-1);
        }
    }

    public int getColisoes() {
        return colisoes;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public int hash_resto(int chave) {
        int indice = chave % tamanho;
        return indice;
    }

    int rehashing(int chave) {
        int novoIndice = (chave + 1) % tamanho;
        return novoIndice;
    }

    public void insere_hashing(int chave) {
        if (quantidade < tamanho) {
            int i = hash_resto(chave);
            while (tabela[i].getCodigo() != -1) {
                i = rehashing(i);
                colisoes++;
            }
            tabela[i].setCodigo(chave);
            quantidade++;
        }
    }

    public int busca_hashing(int chave) {
        int tentativas = 0;
        int i = hash_resto(chave);
        while (tabela[i].getCodigo() != chave && tabela[i].getCodigo() != -1 && tentativas <= tamanho) {
            i = rehashing(i);
            tentativas++;
            comparacoes++;
        }
        if (tentativas >= tamanho) {
            return -1;
        }
        if (tabela[i].getCodigo() == -1) {
            return -1;
        } else {
            return i;
        }
    }

}
