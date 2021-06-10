package br.com.curso.campoMinado.visao;

import java.util.Arrays;
import java.util.Iterator;
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

            while(!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro);

                String digitado = capturarValorDigitado("Digite (x, y): ");
                
                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                .map(e -> Integer.parseInt(e.trim())).iterator();
                digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");

                if ("1".equals(digitado)) {
                    tabuleiro.abrir(xy.next(), xy.next());
                } else if ("2".equals(digitado)) {
                    tabuleiro.alternarMarcacao(xy.next(), xy.next());
                }
            }
            System.out.println(tabuleiro);
            System.out.println("Você ganhou!");
        } catch (ExplosaoException e) {
            System.out.println(tabuleiro);
            System.out.println("Você perdeu!");
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.print(texto);
        String digitado = entrada.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new ExitException();
        }
        return digitado;
    }
}
