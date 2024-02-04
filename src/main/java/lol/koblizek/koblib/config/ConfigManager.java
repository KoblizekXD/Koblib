package lol.koblizek.koblib.config;

public final class ConfigManager {
    private static ConfigManager instance;

    public static ConfigManager getInstance() {
        if (instance == null) instance = new ConfigManager();
        return instance;
    }

    private ConfigManager() {}

    public void getConfig(String name) {

    }
}
