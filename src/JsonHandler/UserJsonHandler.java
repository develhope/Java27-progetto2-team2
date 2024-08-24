package JsonHandler;

import User.Utente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class UserJsonHandler implements UserJsonReadable<List<Utente>>, UserJsonWritable<Utente> {
    private final Gson gson;

    public UserJsonHandler(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public List<Utente> readFromJson(String filePath) throws IOException {
        try(FileReader reader = new FileReader(filePath)){
            Type userListType = new TypeToken<List<Utente>>() {}.getType();
            return gson.fromJson(reader,userListType);
        }
    }

    @Override
    public void writeToJson(String filePath, Utente utente) throws IOException {
        try(FileWriter writer = new FileWriter(filePath)){
            gson.toJson(utente,writer);
        }
    }
}
