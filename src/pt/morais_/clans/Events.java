package pt.morais_.clans;

import com.nametagedit.plugin.NametagEdit;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;


public class Events implements Listener {

    private Plugin config = Main.getPlugin(Main.class);

    public Events(Main main) {

        SimpleClans sc = SimpleClans.getInstance();

            Bukkit.getScheduler().runTaskTimer(main, new Runnable() {
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (sc.getClanManager().getClanPlayer(player) == null) {
                            //String "Sem-Clan" = "Without Clan"
                            NametagEdit.getApi().setSuffix(player, " " + config.getConfig().getString("Sem-Clan").replace("&", "§"));
                        } else {
                            //Tag.Abrir = "["+Clan
                            //Tag.Fechar = Clan+"]"
                            NametagEdit.getApi().setSuffix(player, " " + config.getConfig().getString("Tag.Abrir").replace("&", "§") + sc.getClanManager().getClanPlayer(player).getClan().getColorTag() + config.getConfig().getString("Tag.Fechar").replace("&", "§"));
                        }
                    }
                }
                //Refresh-Time = time to check
            }, 20L, 20 * config.getConfig().getInt("Refresh-Time"));
    }
}

