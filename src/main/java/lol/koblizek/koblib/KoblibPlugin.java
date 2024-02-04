package lol.koblizek.koblib;

import lol.koblizek.koblib.util.DisableAdvertise;
import lol.koblizek.koblib.util.Koblib;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

public class KoblibPlugin extends JavaPlugin {
    private static KoblibPlugin instance;

    public static KoblibPlugin getInstance() {
        return instance;
    }

    public static Logger logger() {
        return instance.getSLF4JLogger();
    }

    @Override
    public final void onEnable() {
        instance = this;
        if (!this.getClass().isAnnotationPresent(DisableAdvertise.class))
            getSLF4JLogger().info("Using Koblib v{}", Koblib.VERSION);
        onEnabled();
    }

    @Override
    public void onDisable() {
        instance = null;
        onDisabled();
    }

    public void onEnabled() {}
    public void onDisabled() {}
}
