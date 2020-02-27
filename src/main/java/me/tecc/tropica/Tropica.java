package me.tecc.tropica;

import me.tecc.tropica.commands.BroadcastCommand;
import me.tecc.tropica.commands.HelpCommand;
import me.tecc.tropica.events.BasicEventHandler;
import me.tecc.tropica.features.collection.CollectionManager;
import me.tecc.tropica.features.playerData.PlayerTaskManager;
import me.tecc.tropica.menus.TropicaMenu;
import me.tecc.tropica.sidebar.Rank;
import me.tecc.tropica.storage.CollectionContainer;
import me.tecc.tropica.storage.PlayerContainer;
import me.tecc.tropica.storage.PublicContainer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tropica extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
        }

        // initialize custom files
        new PublicContainer(this, "publicContainer.yml");
        new CollectionContainer(this, "collectionContainer.yml");
        new PlayerContainer(this, "playerContainer.yml");

        // init ranks
        new Rank();

        // initialize other managers
        new CollectionManager();

        // initialize listeners
        new BasicEventHandler();
        new TropicaMenu();

       //Commands <-
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("help").setExecutor(new HelpCommand());

    }

    @Override
    public void onDisable() {
        PlayerTaskManager.getInstance().run();
    }

    /**
     * Gets the Tropica plugin instance.
     * This is short for {@code Tropica.getPlugin(Tropica.class)}.
     * @return Tropica plugin instance
     */
    public static Tropica getTropica() {
        return Tropica.getPlugin(Tropica.class);
    }

    /**
     * Registers a listener to the Tropica plugin.
     * @param listener The listener to register
     */
    public static void registerListener(Listener listener) {
        getTropica().getServer().getPluginManager().registerEvents(listener, getTropica());
    }
}
