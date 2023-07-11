package config;

public enum DEVICES {
    PIXEL6NATIVE("Pixel6ProNative"),
    PIXEL("Pixel");

    public String getName() {
        return name;
    }

    String name;

    DEVICES(String name) {
        this.name = name;
    }

}
