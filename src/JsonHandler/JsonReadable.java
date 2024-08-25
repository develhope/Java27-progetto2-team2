package JsonHandler;


import java.io.IOException;
import java.util.List;

public interface JsonReadable<T> {
        List<Object> readFromJson(String filePath) throws IOException;
}
