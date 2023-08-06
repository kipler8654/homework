import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

    private final AnimalSerializer<XmlMapper> animalSerializer = new AnimalSerializer<>(new XmlMapper());
    private final Animal input = new Animal("sharik", "2015.03.11", 7,
            false, "doberman", new Type(1, "root", "text"));


    @Test
    public void serializeTest() {
        animalSerializer.serialize(input);
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalSerializer.deserialize();
        Assert.assertEquals(input, deserialize.orElse(null));
    }
}
