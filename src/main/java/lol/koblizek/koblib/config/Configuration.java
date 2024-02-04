package lol.koblizek.koblib.config;

import lol.koblizek.koblib.KoblibPlugin;
import lol.koblizek.koblib.util.Koblib;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configuration {
    private final File file;
    private final YamlConfiguration yamlConfiguration;

    public Configuration(File file, YamlConfiguration cfg) {
        this.file = file;
        this.yamlConfiguration = cfg;
    }

    public File getFile() {
        return file;
    }

    public void save() {
        Koblib.async(() -> {
            try {
                yamlConfiguration.save(file);
            } catch (IOException e) {
                KoblibPlugin.logger().warn("Failed to save configuration file: {} for plugin {}", file.getName(), KoblibPlugin.getInstance().getName());
                KoblibPlugin.logger().error("Exception: ", e);
            }
        });
    }
}
