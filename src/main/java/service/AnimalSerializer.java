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
    private final T mapper;
    private final File path;

    public AnimalSerializer(T mapper) {
        this.mapper = mapper;
        Extension extension = Extension.TXT;
        if (mapper instanceof JsonMapper) {
            extension = Extension.JSON;
        }
        if (mapper instanceof XmlMapper) {
            extension = Extension.XML;
        }
        if (mapper instanceof YAMLMapper) {
            extension = Extension.YAML;
        }
        this.path = new File("src/main/resources/animal" + extension);
    }

    public void serialize(Animal animal) {
        try {
            mapper.writeValue(path, animal);
        } catch (IOException e) {
            System.out.println("Creating file error");
        }
    }

    public void serialize(List<Animal> animals) {
        try {
            mapper.writeValue(path, animals);
        } catch (IOException e) {
            System.out.println("Creating file error");
        }
    }

    public Optional<Animal> deserialize(){
        try{
            return Optional.of(mapper.readValue(path, Animal.class));
        }catch(IOException e){
            System.out.println("Creating file error");
            return Optional.empty();
        }
    }
}