package JsonHandler;

import java.io.IOException;

public interface JsonWritable<T> {
    void writeToJson(String filePath, T Object) throws IOException;
}
