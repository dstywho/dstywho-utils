package dstywho.configuration;

import com.google.gson.Gson;

public class ConfigFactory {
    public static <T> T fromJson(String json, Class<T> clazz)
        {
            return new Gson().fromJson(json, clazz);
        }
}
