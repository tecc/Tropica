package me.tecc.tropica.storage;

import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class PublicContainer extends AbstractContainer {

    private static PublicContainer publicContainer;

    public PublicContainer(Plugin plugin, String filename) {
        super(plugin, filename);

        publicContainer = this;
    }

    public static PublicContainer getInstance() {
        return publicContainer;
    }
}
