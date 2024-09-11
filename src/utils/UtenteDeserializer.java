package utils;

import User.Utente;
import User.UtenteFactory;
import com.google.gson.*;

import java.lang.reflect.Type;

public class UtenteDeserializer implements JsonDeserializer<Utente> {
    @Override
    public Utente deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String ruolo = jsonObject.get("ruolo").getAsString();
        String nome = jsonObject.get("nome").getAsString();
        String cognome = jsonObject.get("cognome").getAsString();
        String id = jsonObject.get("id").getAsString();
        String password = jsonObject.get("password").getAsString();

        // Use the factory to create the appropriate Utente instance
        return UtenteFactory.createUtente(nome, cognome, id, password, ruolo);
    }
}
