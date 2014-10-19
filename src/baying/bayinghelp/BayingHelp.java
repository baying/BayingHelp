package baying.bayinghelp;

import java.io.File;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BayingHelp extends JavaPlugin
{

	public static BayingHelp plugin;

	public BayingHelp()
	{
	}

        @Override
	public void onEnable()
	{
		plugin = this;
		getServer().getPluginManager().registerEvents(new BayingHelpListener(this), this);
                getCommand("bload").setExecutor(new BayingHelpcmd(plugin));
                File configFile = new File(getDataFolder(), "config.yml");
                SendColorLog("[BayingHelp]欢迎使用该款插件");
                SendColorLog("[BayingHelp]插件版本2.0");
                if (!configFile.exists()) { 
                    saveDefaultConfig();
                    SendColorLog("[BayingHelp]配置文件生成完成");
        }
		SendColorLog("[BayingHelp]加载完成");
	}



        @Override
	public void onDisable()
	{
		SendColorLog("[BayingHelp]已卸载");
	}

	public static void SendColorLog(String Log)
	{
		ConsoleCommandSender sender = plugin.getServer().getConsoleSender();
		sender.sendMessage(Log);
	}
}