package dstywho.configuration;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;

import dstywho.FileUtil;

public class ConfigFactory {
  public static <T> T fromJson(String json, Class<T> clazz) {
    return new Gson().fromJson(json, clazz);
  }

  public static <T> T fromJson(File file, Class<T> clazz) {
    String json;
    try
      {
        json = FileUtil.fileToString(file);
      }
    catch (IOException e)
      {
        throw new RuntimeException("problem reading file", e);
      }
    return fromJson(json, clazz);
  }
}
