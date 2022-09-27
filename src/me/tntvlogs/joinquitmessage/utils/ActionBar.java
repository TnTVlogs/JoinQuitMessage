package me.tntvlogs.joinquitmessage.utils;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

public class ActionBar {

	private PacketPlayOutChat packet;

	public ActionBar(String text) {
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte) 2);
		this.packet = packet;
	}

	public void sendToPlayer(Player p) {
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}

	public void sendToAll() {
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (p.hasPermission("actionbarjoin.message")) {
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
				;
			}
		}
	}

}