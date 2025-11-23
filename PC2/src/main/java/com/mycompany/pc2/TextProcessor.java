package com.mycompany.pc2;

public class TextProcessor {

    // Constructor para JaCoCo
    public TextProcessor() {
        // solo para cobertura
    }

    public static String reverseAndCapitalize(String input) {
        // Validación: texto nulo
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        // Validación: longitud máxima permitida
        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // Recortar espacios al inicio y final
        String trimmed = input.trim();

        // Validación: vacío después del trim → solo espacios o vacío
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        // Invertir texto y convertir a mayúsculas
        return new StringBuilder(trimmed).reverse().toString().toUpperCase();
    }
}

