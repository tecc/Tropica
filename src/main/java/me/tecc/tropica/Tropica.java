package me.tecc.tropica;

import me.tecc.tropica.commands.*;
import me.tecc.tropica.events.BasicEventHandler;
import me.tecc.tropica.features.backpacks.BackpackHandler;
import me.tecc.tropica.features.collection.CollectionManager;
import me.tecc.tropica.features.homes.HomeHandler;
import me.tecc.tropica.features.jumppads.JumpPadHandler;
import me.tecc.tropica.features.playerData.PlayerTaskManager;
import me.tecc.tropica.features.recipes.RecipeHandler;
import me.tecc.tropica.features.teams.TeamHandler;
import me.tecc.tropica.menus.TropicaMenu;
import me.tecc.tropica.sidebar.Rank;
import me.tecc.tropica.storage.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tropica extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
        }

        // initialize custom files
        new PublicContainer(this, "publicContainer.yml"); //file for server stuff
        new CollectionContainer(this, "collectionContainer.yml"); //file for collections
        new PlayerContainer(this, "playerContainer.yml"); //file for player data
        new JumpPadContainer(this, "jumpPadContainer.yml"); //file for jumppads

        // init word filter
        new WordFilter();

        // init ranks
        new Rank();

        // initialize other managers
        new CollectionManager();

        // init teams
        new TeamHandler();

        // initialize listeners
        new BasicEventHandler();
        new TropicaMenu();

        // init recipes
        new RecipeHandler();

        // register backpack handler
        new BackpackHandler();

        // register jumppad handler
        new JumpPadHandler().initializationProcess();

        // init home handler
        new HomeHandler();


       //Commands <-
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("craft").setExecutor(new CraftingCommand());
        getCommand("surface").setExecutor(new SurfaceCommand());

        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(player, "");
            Bukkit.getPluginManager().callEvent(playerJoinEvent);
        }

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
