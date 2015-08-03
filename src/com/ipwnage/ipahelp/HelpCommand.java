package com.ipwnage.ipahelp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mkremins.fanciful.FancyMessage;
import net.md_5.bungee.api.chat.TextComponent;

public class HelpCommand implements CommandExecutor {
	
	public String normal = "ipwnage.help.normal";
	public String commoner = "ipwnage.help.commoner";
	public String dcommoner = "ipwnage.help.dcommoner";
	public String trusted = "ipwnage.help.trusted";
	public String dtrusted = "ipwnage.help.dtrusted";
	public String vet = "ipwnage.help.veteran";
	public String dvet = "ipwnage.help.dveteran";
	public String senior = "ipwnage.help.senior";
	public String dsenior = "ipwnage.help.dsenior";
	public String elder = "ipwnage.help.elder";
	public String delder = "ipwnage.help.delder";
	public String arch = "ipwnage.help.architect";
	public String trib = "ipwnage.help.tribune";
	
	Help help;
	
	public HelpCommand(Help plugin){
		this.help = plugin;
	}
	
	public void sendMessage(Player p){
		if(p.hasPermission(normal)){
			p.sendMessage("Normal Commands");
			p.sendMessage("Protecting Land");
			p.sendMessage(ChatColor.GREEN + "   /lock, /unlock, /cmodify <player> (This adds another player to your chests or doors)");
			p.sendMessage(ChatColor.GREEN + "   /region claim <regionName>, //wand");
			p.sendMessage("Normal Commands");
			p.sendMessage("Normal Commands");
			
		}
		if(p.hasPermission(commoner)){
			
		}
		if(p.hasPermission(dcommoner)){
			
		}
		if(p.hasPermission(trusted)){
			
		}
		if(p.hasPermission(dtrusted)){
			
		}
		if(p.hasPermission(vet)){
			
		}
		if(p.hasPermission(dvet)){
			
		}
		if(p.hasPermission(senior)){
			
		}
		if(p.hasPermission(dsenior)){
			
		}
		if(p.hasPermission(elder)){
			
		}
		if(p.hasPermission(delder)){
			
		}
		if(p.hasPermission(arch)){
			
		}
		if(p.hasPermission(trib)){
			
		}
	}
	
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(command.getName().equalsIgnoreCase("help")){
			sendMessage(player);
		}
		
		
		return false;
	}

}
