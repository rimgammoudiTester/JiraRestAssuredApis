package Utlis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SerilaizingDeserializingClass {

    @SneakyThrows
    public static <T> T deserliaze(String filePath, Class<T>className) {
        ObjectMapper mapper= new ObjectMapper();
       return mapper.readValue(new File(filePath),className);

    }

    //deserialize jsons
    @SneakyThrows
    public static HashMap<String,Object>deserialize(String filePath)
    {
        HashMap<String,Object> hashmap;
        ObjectMapper map=new ObjectMapper();
        hashmap=map.readValue(new File(filePath), new TypeReference<HashMap<String, Object>>(){});
        return hashmap;
    }
}
