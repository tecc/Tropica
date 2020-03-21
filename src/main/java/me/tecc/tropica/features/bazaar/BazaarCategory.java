package me.tecc.tropica.features.bazaar;

public enum BazaarCategory {
    PLANTS("&aPlants & Foods &8➔ &eClick",
            "&8Farming",
            "",
            "&8&m---&r &7[&e&lINFORMATION&7] &8&m---",
            "&7All kinds of plants, seeds, and",
            "&7things that can be eaten."
    ),

    BLOCKS("&6Blocks &8➔ &eClick",
            "&8Building",
            "",
            "&8&m---&r &7[&e&lINFORMATION&7] &8&m---",
            "&7Full of cool blocks which can help",
            "&7you make your builds look stunning."),


    MINERALS("&bMinerals &8➔ &eClick",
            "&8Mining",
            "",
            "&8&m---&r &7[&e&lINFORMATION&7] &8&m---",
            "&7Need diamonds, gold or iron?",
            "&7Great place for miners."),

    DROPS("&cMob Drops &8➔ &eClick",
            "&8Hunting",
            "",
            "&8&m---&r &7[&e&lINFORMATION&7] &8&m---",
            "&7A category made specifically for",
            "&7items that are dropped from mobs."),


    VALUABLES("&dValuable Items &8➔ &eClick",
            "&8Riches & Swag",
            "",
            "&8&m---&r &7[&e&lINFORMATION&7] &8&m---",
            "&7Place made for wealthy players.",
            "&7Become one by playing on the server."); //nice advertising

    private final String prefix;
    private final String[] lore;

    BazaarCategory(String prefix, String... lore) {
        this.prefix = prefix;
        this.lore = lore;
    }

    public String getPrefix() {
        return prefix;
    }

    public String[] getLore() {
        return lore;
    }
}