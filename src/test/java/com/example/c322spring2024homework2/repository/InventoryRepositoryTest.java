package com.example.c322spring2024homework2.repository;
import com.example.c322spring2024homework2.model.Guitar;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryRepositoryTest {

    @Test
    public void testAddGuitar() {
        InventoryRepository inv = new InventoryRepository();
        inv.addGuitar(new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce"));
        assertEquals(1, inv.guitars.size(), "adding one guitar should result in size one");
    }
    @Test
    public void testAddGuitar2() {
        InventoryRepository inv = new InventoryRepository();
        inv.addGuitar(new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce"));
        inv.addGuitar(new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce"));
        inv.addGuitar(new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce"));
        inv.addGuitar(new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce"));
        inv.addGuitar(new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce"));
        assertEquals(5, inv.guitars.size(), "adding five guitars should result in size five");
    }
    @Test
    public void testGetGuitar() {
        InventoryRepository inv = new InventoryRepository();
        Guitar inp = new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce");
        inv.addGuitar(inp);
        Guitar result = inv.getGuitar("0001");
        assertEquals(result, inp);
    }
    @Test
    public void testSearch() {
        InventoryRepository inv = new InventoryRepository();
        Guitar inp1 = new Guitar("0001", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce");
        Guitar inp2 = new Guitar("0002", 129.99, "Simone Biles", "Fender", "Acoustic", "Mahogany", "Spruce");
        Guitar inp3 = new Guitar("0003", 129.99, "Simone Biles", "Fender", "Electric", "Mahogany", "Spruce");
        inv.addGuitar(inp1);
        inv.addGuitar(inp2);
        inv.addGuitar(inp3);
        Guitar target = new Guitar();
        target.setType("Electric");
        List<Guitar> result = inv.search(target);
        assertEquals(2, result.size(), "Two guitars are of type Electric");
    }
}