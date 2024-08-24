package JsonHandler;

import java.io.IOException;

public interface UserJsonWritable<T> {
    void writeToJson(String filePath, T Object) throws IOException;
}
