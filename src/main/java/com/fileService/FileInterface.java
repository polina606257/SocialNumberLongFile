package com.fileService;

import java.util.Map;

public interface FileInterface {

    Map<String, Double> createListWithoutCopy(Map<String, Double> listWithCopy);

    void writeFileWithoutCopy(Map<String, Double> listNoCopy);
}
