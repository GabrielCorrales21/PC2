package com.mycompany.pc2;

public class PasswordValidator {

    // Constructor para JaCoCo
    public PasswordValidator() {
        // solo para cobertura
    }

    public static boolean isValid(String password) {
        if (password == null) return false;

        // 1. Longitud mínima
        if (password.length() < 8) return false;

        // 2. Sin espacios
        if (password.contains(" ")) return false;

        // 3. Validaciones de contenido
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.indexOf(c) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
