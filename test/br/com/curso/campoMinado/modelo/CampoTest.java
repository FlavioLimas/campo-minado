package br.com.curso.campoMinado.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
