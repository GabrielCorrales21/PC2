package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void caso1_textoVacioDebeLanzarExcepcion() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> TextProcessor.reverseAndCapitalize("")
        );
        assertEquals("El texto no puede estar vacío", ex.getMessage());
    }

    @Test
    void caso2_textoExcedeLongitudDebeLanzarExcepcion() {
        String largo = "a".repeat(1005);
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> TextProcessor.reverseAndCapitalize(largo)
        );
        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }

    @Test
    void caso3_invertirTextoCorrectamente() {
        assertEquals("02 NU OREPSE", TextProcessor.reverseAndCapitalize("Espero un 20"));
    }

    @Test
    void caso4_convertirAMayusculas() {
        assertEquals("RABORPA OREPSE", TextProcessor.reverseAndCapitalize("espero aprobar"));
    }

    @Test
    void caso5_eliminarEspaciosInicioFinal() {
        assertEquals("ODAICAPSE REPUS", TextProcessor.reverseAndCapitalize("  Super espaciado   "));
    }

    @Test
    void caso6_textoValidoProcesadoCorrectamente() {
        assertEquals("ODILAV OTXET NU SE OTSE",
            TextProcessor.reverseAndCapitalize("Esto es un texto valido"));
    }

    @Test
    void caso7_textoNuloDebeLanzarExcepcion() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> TextProcessor.reverseAndCapitalize(null)
        );
        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    @Test
    void caso8_soloEspaciosDebeLanzarExcepcion() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> TextProcessor.reverseAndCapitalize("    ")
        );
        assertEquals("El texto no puede estar vacío", ex.getMessage());
    }

    @Test
    void caso9_respetaEspaciosInternos() {
        assertEquals("02  NU  OREPSE",
            TextProcessor.reverseAndCapitalize("EsperO  un  20"));
    }

    @Test
    void caso10_caracteresEspeciales() {
        assertEquals("!ODNUM@ ALOH",
            TextProcessor.reverseAndCapitalize("Hola @mundo!"));
    }

    @Test
    void caso11_constructorCubreJaCoCo() {
        TextProcessor tp = new TextProcessor();
        assertNotNull(tp);
    }
}

