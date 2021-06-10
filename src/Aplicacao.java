import br.com.curso.campoMinado.modelo.Tabuleiro;
import br.com.curso.campoMinado.visao.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
        new TabuleiroConsole(tabuleiro);
    }
}
