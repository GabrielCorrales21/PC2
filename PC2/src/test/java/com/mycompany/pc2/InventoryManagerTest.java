package com.mycompany.pc2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    @Test
    void caso1_ProductoYcantidadValida() {
        InventoryManager manager = new InventoryManager();
        assertDoesNotThrow(() -> manager.addItem("Laptop", 5));
    }

    @Test
    void caso2_CantidadNegativa() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("mouse", -1)
        );
    }

    @Test
    void caso3_ProductoVacioCantidadValida() {
        InventoryManager manager = new InventoryManager();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("", 5)
        );
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void caso4_LongitudMinima() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("P", 1)
        );
    }

    @Test
    void caso5_CantidadMaximaPermitida() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Mouse gamer", 1001)
        );
    }

    @Test
    void caso6_LongitudMaxima() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("PC superchevere de última generación de la mejor categoría", 10)
        );
    }
}
