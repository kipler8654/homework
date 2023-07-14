package enums;

/**
 * @author Serhii Klunniy
 */
public enum Extension {
    TXT(".txt"),
    JSON(".json"),
    YAML(".yaml"),
    XML(".xml");

    private String extension;

    Extension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return extension;
    }
}
