package baying.bayinghelp;

import org.bukkit.Bukkit;

import static org.bukkit.ChatColor.AQUA;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Administrator
 */
public class BayingHelpcmd implements CommandExecutor{
    @SuppressWarnings("unused")
	private final BayingHelp plugin;
    public BayingHelpcmd(BayingHelp plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
	{
		if (cmd.getName().equalsIgnoreCase("bload"))
		{
			Plugin r = Bukkit.getServer().getPluginManager().getPlugin("BayingHelp");
			r.reloadConfig();
			sender.sendMessage(AQUA+"[BayingHelp]配置文件重载完成");
			return true;
		}else{
                return false;
	}
}
}