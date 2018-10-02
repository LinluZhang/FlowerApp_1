package suwu.flowerapp.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import suwu.flowerapp.config.jsonAdapter.EventAdapter;
import suwu.flowerapp.config.jsonAdapter.SpringfoxJsonToGsonAdapter;
import suwu.flowerapp.parameters.event.EventAddParameters;
import springfox.documentation.spring.web.json.Json;
import suwu.flowerapp.config.jsonAdapter.EventAdapter;
import suwu.flowerapp.config.jsonAdapter.SpringfoxJsonToGsonAdapter;
import suwu.flowerapp.parameters.event.EventAddParameters;

public class GsonFactory {
    public static Gson get() {
        return new GsonBuilder()
                .registerTypeAdapter(EventAddParameters.class, new EventAdapter())
                .registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter())
                .create();
    }
}
