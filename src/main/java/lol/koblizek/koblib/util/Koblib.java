package lol.koblizek.koblib.util;

import lol.koblizek.koblib.KoblibPlugin;
import org.bukkit.Bukkit;

import java.util.concurrent.atomic.AtomicReference;

public final class Koblib {
    private Koblib() {}

    public static final String VERSION = "1.0.0";

    public static <R> R async(ReturningFunction<R> r) {
        AtomicReference<R> result = new AtomicReference<>();
        Bukkit.getScheduler().runTaskAsynchronously(KoblibPlugin.getInstance(), () -> result.set(r.apply()));
        return result.get();
    }

    public static void async(Runnable r) {
        Bukkit.getScheduler().runTaskAsynchronously(KoblibPlugin.getInstance(), r);
    }
}
