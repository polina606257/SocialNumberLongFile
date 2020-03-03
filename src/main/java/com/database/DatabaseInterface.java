package com.database;

import javax.persistence.EntityManager;
import java.util.Map;

public interface DatabaseInterface {

    void saveDataFromFile(EntityManager entityManager);

    Map<String, Double> getDataFromFile(EntityManager entityManager, int beginId, int lastId);
}
