package com.database;

import com.domain.SocialNumber;
import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DatabaseService implements DatabaseInterface {

    SocialNumber socialNumber;

    @Override
    public void saveDataFromFile(EntityManager entityManager) {

        try {
            Scanner myReader = new Scanner(new java.io.File("src/socNumbers.txt"));

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitData = data.split(";");
                socialNumber = new SocialNumber(splitData[0], Double.valueOf(splitData[1]));
                entityManager.persist(socialNumber);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    @Override
    public Map<String, Double> getDataFromFile(EntityManager entityManager, int beginId, int lastId) {
        Map<String, Double> listSocialNumbers = new HashMap<>();
        for (int i = beginId; i <= lastId; i++) {
            SocialNumber socialNumber = entityManager.find(SocialNumber.class, i);
            listSocialNumbers.put(socialNumber.getSocialNumber(), socialNumber.getPrice());
            }
            return listSocialNumbers;
        }
    }
