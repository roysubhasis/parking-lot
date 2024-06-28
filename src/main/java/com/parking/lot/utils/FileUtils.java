package com.parking.lot.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileUtils {
  public static List<String> readFile(String fileName) {
    List<String> lines = Collections.emptyList();
    try {
      lines =
          Files.readAllLines(
              Paths.get(System.getProperty("user.dir") + "/src/main/resources/" + fileName));

    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }
}
