package com.example.c322spring2024homework2.controllers;

import com.example.c322spring2024homework2.model.Guitar;
import com.example.c322spring2024homework2.repository.InventoryRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    private final InventoryRepository inventoryRepository;
    private final AuthenticationManager authenticationManager;

    public InventoryController(InventoryRepository inventoryRepository, AuthenticationManager authenticationManager) {
        this.inventoryRepository = inventoryRepository;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/search")
    public List<Guitar> search(@RequestParam(required = false) String serialNumber,
                       @RequestParam(required = false) Double price,
                       @RequestParam(required = false) String builder,
                       @RequestParam(required = false) String model,
                       @RequestParam(required = false) String type,
                       @RequestParam(required = false) String backWood,
                       @RequestParam(required = false) String topWood)
    {
        Guitar target = new Guitar();
        if(serialNumber != null) target.setSerialNumber(serialNumber);
        if(price != null) target.setPrice(price.floatValue());
        else{target.setPrice(0);}
        if(builder != null) target.setBuilder(builder);
        if(model != null) target.setModel(model);
        if(type != null) target.setType(type);
        if(backWood != null) target.setBackWood(backWood);
        if(topWood != null) target.setTopWood(topWood);
        return inventoryRepository.search(target);
    }

    @GetMapping("/find")
    public Guitar find(@RequestParam String serialNumber)
    {
        return inventoryRepository.getGuitar(serialNumber);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Guitar data)
    {
        return inventoryRepository.addGuitar(data);
    }
}
