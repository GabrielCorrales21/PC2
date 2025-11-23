package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void caso1_minimo8Caracteres() {
        assertFalse(PasswordValidator.isValid("contra"));
    }

    @Test
    void caso2_espacioAlInicio() {
        assertFalse(PasswordValidator.isValid(" contraseña123"));
    }

    @Test
    void caso3_passwordNull() {
        assertFalse(PasswordValidator.isValid(null));
    }

    @Test
    void caso4_sinMayusculas() {
        assertFalse(PasswordValidator.isValid("nosecura#1"));
    }

    @Test
    void caso5_sinNumeros() {
        assertFalse(PasswordValidator.isValid("Contraseña#"));
    }

    @Test
    void caso6_passwordValida() {
        assertTrue(PasswordValidator.isValid("SuperContra#123"));
    }

    // ✅ Cobertura adicional para JaCoCo ↓↓↓

    @Test
    void caso7_sinMinusculas() {
        assertFalse(PasswordValidator.isValid("SUPER123#"));
    }

    @Test
    void caso8_sinCaracterEspecial() {
        assertFalse(PasswordValidator.isValid("SuperContra123"));
    }

    @Test
    void caso9_constructorParaCobertura() {
        PasswordValidator pv = new PasswordValidator();
        assertNotNull(pv);
    }
}
