package br.com.curso.campoMinado.modelo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTest {
    
    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testVizinhoReal() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
}
