package at.kaindorf.webintro.beans;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JsonTester {

    public static void main(String[] args) {
        File jsonFile = Paths.get(System.getProperty("user.dir"),
                "src", "main", "resources", "person.json").toFile();
        ObjectMapper mapper = new ObjectMapper(); // zentrale Klasse für JSON
        try {
            Person[] persons = mapper.readValue(jsonFile, Person[].class);
            List<Person> personList = mapper.readValue(jsonFile, new TypeReference<List<Person>>(){});
            mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
