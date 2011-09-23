package dstywho.configuration;

import com.google.gson.Gson;

public abstract class Configuration {
    public String toJson()
        {
            return new Gson().toJson(this);
        }
}
