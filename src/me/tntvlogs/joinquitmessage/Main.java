package me.tntvlogs.joinquitmessage;

import org.bukkit.plugin.java.JavaPlugin;

import me.tntvlogs.joinquitmessage.listeners.JoinListener;
import me.tntvlogs.joinquitmessage.listeners.QuitListener;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		new JoinListener(this);
		new QuitListener(this);
	}

}
