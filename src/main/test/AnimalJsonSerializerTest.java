import com.fasterxml.jackson.databind.json.JsonMapper;
import model.Animal;
import org.junit.jupiter.api.Test;
import service.AnimalSerializer;
import junit.framework.Assert;

import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalJsonSerializerTest {

    private final AnimalSerializer<JsonMapper> animalSerializer = new AnimalSerializer<>(new JsonMapper());
    private final Animal dog = new Animal("sharik", "2015.03.11", 7, false, "doberman");
    private final Animal cat = new Animal("myrka", "2016.04.20", 7, false, "persian");


    @Test
    public void serializeTest() {
        animalSerializer.serialize(dog);
    }

    @Test
    public void serializeListTest() {
         animalSerializer.serialize(List.of(cat, dog));
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalSerializer.deserialize();
        Assert.assertEquals(dog, deserialize.orElse(null));
    }
}
