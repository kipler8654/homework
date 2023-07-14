package service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalSerializer {

    public void jsonSerialize(Animal animal) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public void jsonSerialize(List<Animal> animals) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> jsonDeserialize() {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            return Optional.of(jsonMapper.readValue(new File("src/main/resources/animal.json"), Animal.class));
        } catch (IOException e) {
            System.out.println("cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
    public void xmlSerialize(Animal animal) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File("src/main/resources/animal.xml"), animal);
        } catch (IOException e) {
            System.out.println("cannot write file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> xmlDeserialize() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return Optional.of(xmlMapper.readValue(new File("src/main/resources/animal.json"), Animal.class));
        } catch (IOException e) {
            System.out.println("cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
    public void yamlSerialize(Animal animal) {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public void yamlSerialize(List<Animal> animals) {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> yamlDeserialize() {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            return Optional.of(yamlMapper.readValue(new File("src/main/resources/animal.yaml"), Animal.class));
        } catch (IOException e) {
            System.out.println("cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
