package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import enums.Extension;
import model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalSerializer<T extends ObjectMapper> {
    private final T objectMapper;
    private final File filePath;

    public AnimalSerializer(T mapper) {
        Extension extension = Extension.TXT;
        this.objectMapper = mapper;
        if (objectMapper instanceof JsonMapper) {
            extension = Extension.JSON;
        }
        if (objectMapper instanceof XmlMapper) {
            extension = Extension.XML;
        }
        if (objectMapper instanceof YAMLMapper) {
            extension = Extension.YAML;
        }
        this.filePath = new File("src/main/resources/animal" + extension);
    }

    public void serialize(Animal animal) {
        try {
            objectMapper.writeValue(filePath, animal);
        } catch (IOException e) {
            System.out.println("Creating file error");
        }
    }

    public void serialize(List<Animal> animals) {
        try {
            objectMapper.writeValue(filePath, animals);
        } catch (IOException e) {
            System.out.println("Creating file error");
        }
    }

    public Optional<Animal> deserialize(){
        try{
            return Optional.of(objectMapper.readValue(filePath, Animal.class));
        }catch(IOException e){
            System.out.println("Creating file error");
            return Optional.empty();
        }
    }
}