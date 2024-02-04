package lol.koblizek.koblib.config;

import lol.koblizek.koblib.KoblibPlugin;
import lol.koblizek.koblib.util.Koblib;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class ConfigManager {
    private static ConfigManager instance;
    private KoblibPlugin executingPlugin;
    private Map<String, Configuration> configurations;

    public static void initialize(KoblibPlugin plugin) {
        instance = new ConfigManager();
        instance.configurations = new HashMap<>();
        instance.executingPlugin = plugin;
    }

    public static ConfigManager getInstance() {
        return instance;
    }

    private ConfigManager() {}

    public Configuration getConfig(String name) {
        if (configurations.containsKey(name)) {
            return configurations.get(name);
        } else {
            Configuration configuration = new Configuration(new File(executingPlugin.getDataFolder(), name + ".yml"), Koblib.async(() -> YamlConfiguration.loadConfiguration(new File(executingPlugin.getDataFolder(), name + ".yml"))));
            configurations.put(name, configuration);
            return configuration;
        }
    }
}
