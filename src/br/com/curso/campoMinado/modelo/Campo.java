package br.com.curso.campoMinado.modelo;

public class Campo {

    private final int linha;
    private final int coluna;

    private boolean aberto = false;
    private boolean minado = false;

    Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
}
