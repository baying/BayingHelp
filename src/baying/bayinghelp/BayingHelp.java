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
                SendColorLog("[BayingHelp]��ӭʹ�øÿ���");
                SendColorLog("[BayingHelp]����汾2.0");
                if (!configFile.exists()) { 
                    saveDefaultConfig();
                    SendColorLog("[BayingHelp]�����ļ��������");
        }
		SendColorLog("[BayingHelp]�������");
	}



        @Override
	public void onDisable()
	{
		SendColorLog("[BayingHelp]��ж��");
	}

	public static void SendColorLog(String Log)
	{
		ConsoleCommandSender sender = plugin.getServer().getConsoleSender();
		sender.sendMessage(Log);
	}
}