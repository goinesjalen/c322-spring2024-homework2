package com.example.c322spring2024homework2.repository;

import com.example.c322spring2024homework2.model.Guitar;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class InventoryRepository {
    List<Guitar> guitars = new ArrayList<>();
    public boolean addGuitar(Guitar newGuitar){

        // Define the directory and file names
        String directoryName = "c322spring2024homework2";
        String fileName = "guitars_database.txt";

        // Create a Path object for the directory
        Path directoryPath = Paths.get(directoryName);

        // Combine the directory path and file name to create the full path
        Path filePath = directoryPath.resolve(fileName);


        File myFile = new File(String.valueOf(filePath));
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(myFile, true))){
            String output = newGuitar.toString();
            pw.println(output);
        }
        catch (FileNotFoundException exception) {
            // Dead Code
            System.out.println("Unable to access guitars_database.txt");
            return false;
        }
        // Successfully added guitar to database, now add to list as well
        guitars.add(newGuitar);
        return true;
    }
    public Guitar getGuitar(String serialNumb){
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumb)){
                return guitar;
            }
        }
        // No Guitars match that serialNumber
        throw new IllegalArgumentException("No guitar matches that serial number!");
    }
    public List<Guitar> search(Guitar targetGuitar) {
        List<Guitar> listToRemoveFrom = new ArrayList<>(List.copyOf(guitars));
        try {
            for(Guitar guitar: guitars) {
                for (Field field : targetGuitar.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value1 = field.get(targetGuitar);
                    Object value2 = field.get(guitar);

                    if (value1 != null && !value1.equals(0.0) && !Objects.equals(value1, value2)) {
                        listToRemoveFrom.remove(guitar);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.toString());
        }
        return listToRemoveFrom;
    }
}
