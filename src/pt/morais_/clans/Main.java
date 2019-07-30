package pt.morais_.clans;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(new Events(this), this);
        Bukkit.getConsoleSender().sendMessage("§aDiscord: Morais_#7336");
        saveDefaultConfig();
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nte reload");
    }

}
