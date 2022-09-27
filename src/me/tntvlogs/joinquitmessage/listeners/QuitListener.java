package me.tntvlogs.joinquitmessage.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.tntvlogs.joinquitmessage.Main;
import me.tntvlogs.joinquitmessage.utils.ActionBar;
import me.tntvlogs.joinquitmessage.utils.ColoredChat;

public class QuitListener implements Listener {

	public static Main plugin;

	public QuitListener(Main plugin) {

		QuitListener.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	public void onQuit(PlayerQuitEvent e) {

		e.setQuitMessage(null);
		
		Player p = e.getPlayer();

		String m = ColoredChat.ChatColor(
				plugin.getConfig().getString("messages.leave_message").replace("%player%", p.getDisplayName()));
		
		ActionBar actionbar = new ActionBar(m);
		actionbar.sendToAll();
		
	}

}
