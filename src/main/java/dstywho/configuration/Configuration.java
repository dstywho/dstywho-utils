package dstywho.configuration;

import com.google.gson.Gson;

public abstract class Configuration {
    public String toJson()
        {
            return new Gson().toJson(this);
        }

    public boolean equals(Object another)
        {
            return ((Configuration) another).toJson().equals(this.toJson());
        }
}
