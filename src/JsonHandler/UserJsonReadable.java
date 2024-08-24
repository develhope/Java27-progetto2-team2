package JsonHandler;


import User.Utente;

import java.io.IOException;
import java.util.List;

public interface UserJsonReadable<T> {
        List<Utente> readFromJson(String filePath) throws IOException;
}
