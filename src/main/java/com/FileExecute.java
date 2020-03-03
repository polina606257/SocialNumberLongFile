package com;

import com.database.DatabaseInterface;
import com.database.DatabaseService;
import com.fileService.FileInterface;
import com.fileService.FileService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Map;

public class FileExecute {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        DatabaseInterface database = new DatabaseService();
        FileInterface fileInterface = new FileService();

        transaction.begin();

        database.saveDataFromFile(entityManager);
        Map<String, Double> listWithCopies = database.getDataFromFile(entityManager, 0, 1);
        Map<String, Double> listWithoutCopy = fileInterface.createListWithoutCopy(listWithCopies);
        fileInterface.writeFileWithoutCopy(listWithoutCopy);

        transaction.commit();

        entityManager.close();
        factory.close();
    }
}
