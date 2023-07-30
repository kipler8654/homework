import junit.framework.Assert;
import model.Animal;
import model.Type;
import org.junit.jupiter.api.Test;
import service.AnimalSerializer;


import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalXmlSerializerTest {

    private final AnimalSerializer animalXmlSerializer = new AnimalSerializer();
    private final Animal input = new Animal("sharik", "2015.03.11", 7,
            false, "doberman", new Type(1, "root", "text"));


    @Test
    public void serializeTest() {
        animalXmlSerializer.xmlSerialize(input);
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalXmlSerializer.xmlDeserialize();
        Assert.assertEquals(input, deserialize.orElse(null));
    }
}
