import junit.framework.Assert;
import model.Animal;
import org.junit.jupiter.api.Test;
import service.AnimalSerializer;

import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalYamlSerializerTest {

    private final AnimalSerializer animalYamlSerializer = new AnimalSerializer();
    private final Animal dog = new Animal("sharik", "2015.03.11", 7, false, "doberman");
    private final Animal cat = new Animal("myrka", "2016.04.20", 7, false, "persian");


    @Test
    public void serializeTest() {
        animalYamlSerializer.yamlSerialize(dog);
    }

    @Test
    public void serializeListTest() {
        animalYamlSerializer.yamlSerialize(List.of(cat, dog));
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalYamlSerializer.yamlDeserialize();
        Assert.assertEquals(dog, deserialize.orElse(null));
    }
}
