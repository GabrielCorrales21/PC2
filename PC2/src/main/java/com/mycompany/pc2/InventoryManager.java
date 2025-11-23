package com.mycompany.pc2;

import java.util.HashMap;
import java.util.Map;
public class InventoryManager {
    private Map<String, Integer> inventory = new HashMap<>();
    public void addItem(String item, int quantity) {
    // Validación del nombre
    if (item == null || item.trim().isEmpty()) {
    throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
    }
    String trimmedItem = item.trim();
    if (trimmedItem.length() < 2 || trimmedItem.length() > 50) {
    throw new IllegalArgumentException("El nombre del producto debe tener entre 2 y 50 caracteres");
    }
    // Validación de cantidad
    if (quantity <= 0) {
    throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
    }
    if (quantity > 1000) {
    throw new IllegalArgumentException("La cantidad máxima permitida es 1000");
    }
    // Si el producto ya existe, sumar; si no, agregarlo
    inventory.put(trimmedItem, inventory.getOrDefault(trimmedItem, 0) + quantity);
    }
}