package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Adapter {

    Gson gson;

    public Adapter() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

}
