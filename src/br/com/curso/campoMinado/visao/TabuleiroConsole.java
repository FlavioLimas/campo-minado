package br.com.curso.campoMinado.visao;

import java.util.Scanner;

import br.com.curso.campoMinado.excecao.ExitException;
import br.com.curso.campoMinado.modelo.Tabuleiro;

public class TabuleiroConsole {

    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;

        executarGame();
    }

    private void executarGame() {
        try {
            
        } catch (ExitException e) {

        } finally {
            entrada.close();
        }
    }
}
