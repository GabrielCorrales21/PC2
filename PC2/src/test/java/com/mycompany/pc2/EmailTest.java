package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    // Casos básicos de correo válido e inválido
    @Test void caso1_correoValido() {
        Email email = new Email();
        assertTrue(email.isValidEmail("gabriel.corrales@usil.pe"));
    }

    @Test void caso2_correoVacioLanzaExcepcion() {
        Email email = new Email();
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> email.isValidEmail("")
        );
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test void caso3_correoNullLanzaExcepcion() {
        Email email = new Email();
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> email.isValidEmail(null)
        );
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test void caso4_faltaArroba() {
        Email email = new Email();
        assertFalse(email.isValidEmail("correogmail.com"));
    }

    @Test void caso5_dosArrobas() {
        Email email = new Email();
        assertFalse(email.isValidEmail("ga@briel@usil.pe"));
    }

    // Tests para isValidLocalPart
    @Test void caso6_localIniciaConPunto() {
        Email email = new Email();
        assertFalse(email.isValidEmail(".user@gmail.com"));
    }

    @Test void caso7_localTerminaConPunto() {
        Email email = new Email();
        assertFalse(email.isValidEmail("user.@gmail.com"));
    }

    @Test void caso8_localDosPuntosConsecutivos() {
        Email email = new Email();
        assertFalse(email.isValidEmail("user..name@gmail.com"));
    }

    @Test void caso9_localCaracterInvalido() {
        Email email = new Email();
        assertFalse(email.isValidEmail("user!name@gmail.com"));
    }

    // Tests para isValidDomain
    @Test void caso10_dominioSinPunto() {
        Email email = new Email();
        assertFalse(email.isValidEmail("user@gmailcom"));
    }

    @Test void caso11_dominioConEspacio() {
        Email email = new Email();
        assertFalse(email.isValidEmail("user@g mail.com"));
    }

    @Test void caso12_extensionNoPermitida() {
        Email email = new Email();
        assertFalse(email.isValidEmail("user@gmail.xyz"));
    }

    @Test void caso13_dominioMuyCortoAntesDelPunto() {
        Email email = new Email();
        assertFalse(email.isValidEmail("user@.com"));
    }

    @Test void caso14_longitudMinima() {
        Email email = new Email();
        assertFalse(email.isValidEmail("c@.co"));
    }

    @Test void caso15_localVacio() {
        Email email = new Email();
        assertFalse(email.isValidEmail("@gmail.com"));
    }

    @Test void caso16_localGuionValido() {
        Email email = new Email();
        assertTrue(email.isValidEmail("a-_b@gmail.com"));
    }

    @Test void caso17_dominioMultiplesPuntos() {
        Email email = new Email();
        assertTrue(email.isValidEmail("user@mail.server.com"));
    }

    @Test void caso18_extension2Caracteres() {
        Email email = new Email();
        assertTrue(email.isValidEmail("user@mail.co"));
    }

    @Test void caso19_correoLongitud6Valido() {
        Email email = new Email();
        assertTrue(email.isValidEmail("a@b.co"));
    }

    @Test void caso20_dominioSubdominiosMultiples() {
        Email email = new Email();
        assertTrue(email.isValidEmail("usuario@mail.server.com"));
    }

    // Test extra para cubrir constructor explícito y JaCoCo
    @Test void caso21_constructorEjecutadoParaCobertura() {
        Email e = new Email();
        assertNotNull(e);
    }
}
