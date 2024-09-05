package JsonHandler;

import java.io.IOException;

public interface DeprecatedJsonWritable<T> {
    void writeToJson(String filePath, T Object) throws IOException;
}
