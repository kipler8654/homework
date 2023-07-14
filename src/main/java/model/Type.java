package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Serhii Klunniy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    private int id;
    private String name;
    private String string;

}
