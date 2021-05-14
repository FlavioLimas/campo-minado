package br.com.curso.campoMinado.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.curso.campoMinado.excecao.ExplosaoException;

public class CampoTest {
    
    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testVizinhoDistanciaEsquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    
    @Test
    void testVizinhoDistanciaDireita() {
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    
    @Test
    void testVizinhoDistanciaCima() {
        Campo vizinho = new Campo(2, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    
    @Test
    void testVizinhoDistanciaBaixo() {
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testVizinhoDistanciaDiagoanal() {
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    
    @Test
    void testNaoVizinhoDistanciaDiagoanal() {
        Campo vizinho = new Campo(1, 1);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }

    @Test
    void TestValorPadraoMarcacao() {
       assertFalse(campo.isMarcado()); // Inicia false por padrão
    }

    @Test
    void testAlternarMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado()); // Apos alteracao passar a ser true
    }
    
    @Test
    void testAlternarMarcacaoDuasChamadas() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado()); // Apos alteracao passar a ser true
    }

    
    @Test
    void TestAbrirNaoMinadoMarcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testAbrirNaoMinadoNaoMarcado() {
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }
    
    @Test
    void testCampoMinado() {
        campo.minar();

        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }

    @Test
    void testAbrirComVizinhos() {
        Campo campo11 = new Campo(1, 1);

        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        campo.abrir();
        assertTrue(campo22.isAberto() && campo11.isAberto());
    }
}
