package imbutUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static TestData getTestData() {

        try {
            InputStream is = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream("user.json");

            //Transformă JSON → obiect Java
            return mapper.readValue(is, TestData.class);

        } catch (Exception e) {
            throw new RuntimeException("Eroare citire JSON", e);
        }
    }
}