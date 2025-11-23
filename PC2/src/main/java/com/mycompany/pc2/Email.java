package com.mycompany.pc2;

public class Email {

    public Email() {
        // Constructor explícito para cobertura JaCoCo
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        String trimmed = email.trim();

        if (trimmed.length() < 6 || trimmed.length() > 254) return false;
        if (!trimmed.contains("@") || trimmed.indexOf("@") != trimmed.lastIndexOf("@")) return false;

        String[] parts = trimmed.split("@");
        if (parts.length != 2) return false;

        String local = parts[0];
        String domain = parts[1];

        return isValidLocalPart(local) && isValidDomain(domain);
    }

    private boolean isValidLocalPart(String local) {
        if (local.isEmpty()) return false;
        if (local.startsWith(".") || local.endsWith(".")) return false;
        if (local.contains("..")) return false;
        return local.matches("[A-Za-z0-9._-]+");
    }

    private boolean isValidDomain(String domain) {
        if (domain.contains(" ")) return false;
        if (!domain.contains(".")) return false;

        String[] parts = domain.split("\\.");
        if (parts.length < 2) return false;

        // Permitir dominios de 1 o más caracteres antes del primer punto
        if (parts[0].length() < 1) return false;

        String extension = parts[parts.length - 1];
        if (extension.length() < 2) return false;

        return extension.matches("com|net|org|edu|gov|pe|co|io|biz|info");
    }
}
