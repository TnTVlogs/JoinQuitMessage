package me.tntvlogs.joinquitmessage.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.tntvlogs.joinquitmessage.Main;
import me.tntvlogs.joinquitmessage.utils.ActionBar;
import me.tntvlogs.joinquitmessage.utils.ColoredChat;

public class JoinListener implements Listener {

	public static Main plugin;

	public JoinListener(Main plugin) {

		JoinListener.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public static void onJoin(PlayerJoinEvent e) {

		e.setJoinMessage(null);
		
		Player p = e.getPlayer();

		String m = ColoredChat.ChatColor(
				plugin.getConfig().getString("messages.join_message").replace("%player%", p.getDisplayName()));

		ActionBar actionbar = new ActionBar(m);
		actionbar.sendToAll();

	}

}
