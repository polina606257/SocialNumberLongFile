package com.fileService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileService implements FileInterface {

    public Map<String, Double> createListWithoutCopy(Map<String, Double> listWithCopy) {
        Map<String, Double> listNoCopy = new HashMap<>();

        for (Map.Entry<String, Double> data : listWithCopy.entrySet()) {
            if (!listNoCopy.isEmpty() && listNoCopy.containsKey(data.getKey())) {
                double newSumValue = listNoCopy.get(data.getKey()).doubleValue() + data.getValue().doubleValue();
                listNoCopy.put(data.getKey(), newSumValue);
            } else {
                listNoCopy.put(data.getKey(), data.getValue());
            }
        }
        return listNoCopy;
    }


    public void writeFileWithoutCopy(Map<String, Double> listNoCopy) {
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/newSocNumbers.txt"));
            for (Map.Entry<String, Double> entry : listNoCopy.entrySet()) {
                myWriter.write(entry.getKey() + ";" + String.format("%.2f", entry.getValue()));
                myWriter.newLine();
            }
            myWriter.close();
            System.out.println("Successfully wrote to the socialNumber.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
