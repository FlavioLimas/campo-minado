package br.com.curso.campoMinado.visao;

import java.util.Scanner;

import br.com.curso.campoMinado.excecao.ExitException;
import br.com.curso.campoMinado.excecao.ExplosaoException;
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
            boolean continuar = true;

            while (continuar) {

                startGame();

                System.out.println("Outra partida? (S/n) ");
                String resposta = entrada.nextLine();

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (ExitException e) {
            System.out.println("Tchau!!!");
        } finally {
            entrada.close();
        }
    }

    private void startGame() {
        try {
            System.out.println("Você ganhou!");
        } catch (ExplosaoException e) {
            System.out.println("Você perdeu!");
        }
    }
}
