package baying.bayinghelp;

import static baying.bayinghelp.BayingHelp.plugin;
import static org.bukkit.Bukkit.getServer;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 *
 * @author Administrator
 */
public class BayingHelpListener
	implements Listener
{
	public BayingHelpListener(BayingHelp athis)
	{
	}
@SuppressWarnings("deprecation")
@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) throws InterruptedException
	{
		final String PluginPrefix = (new StringBuilder()).append(ChatColor.GOLD).append(BayingHelp.plugin.getConfig().getString("name")).append(ChatColor.RESET).toString();
		String ChatMessage = event.getMessage();
		final String ReplyMessage = BayingHelp.plugin.getConfig().getString("nothing");
		final Player player = event.getPlayer();
		if (CheckMsgFormat(ChatMessage))
		{
                    if(!"?".equals(ChatMessage)){
			final String onGetString = BayingHelp.plugin.getConfig().getString(ChatMessage);
			if (onGetString == null){
			getServer().getScheduler().scheduleAsyncDelayedTask(plugin,new Runnable(){
                            @Override
                            public void run(){
                            player.sendMessage((new StringBuilder()).append(PluginPrefix).append(ChatColor.YELLOW).append(ReplyMessage).toString());
                            }
                            },1);
                        }
                        else{
                           getServer().getScheduler().scheduleAsyncDelayedTask(plugin,new Runnable(){
                            @Override
                            public void run(){
                            player.sendMessage((new StringBuilder()).append(PluginPrefix).append(ChatColor.YELLOW).append(onGetString).toString());
                            }
                            },1);
                        }
                      }
                }
	}

	private boolean CheckMsgFormat(String msg)
	{
		return msg.startsWith("?");
	}
}
