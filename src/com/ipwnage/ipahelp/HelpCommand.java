package com.ipwnage.ipahelp;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mkremins.fanciful.FancyMessage;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
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
	
	TextComponent instructions = new TextComponent( "Click on a category to learn more about it" );
	
	TextComponent land = new TextComponent("Protecting Land");
	TextComponent tp = new TextComponent("Teleporting");
	TextComponent creativity = new TextComponent("Creativity");
	TextComponent econ = new TextComponent("Economy");
	TextComponent misc = new TextComponent("Miscellaneous");
	
	Help help;
	
	public HelpCommand(Help plugin){
		this.help = plugin;
	}
	
	public void sendMessage(Player p){
		if(p.hasPermission(normal)){
			displayHelp(normal, p);
		}
		if(p.hasPermission(commoner)){
			displayHelp(commoner, p);
		}
		if(p.hasPermission(dcommoner)){
			displayHelp(dcommoner, p);
		}
		if(p.hasPermission(trusted)){
			displayHelp(trusted, p);
		}
		if(p.hasPermission(dtrusted)){
			displayHelp(dtrusted, p);
		}
		if(p.hasPermission(vet)){
			displayHelp(vet, p);
		}
		if(p.hasPermission(dvet)){
			displayHelp(dvet, p);
		}
		if(p.hasPermission(senior)){
			displayHelp(senior, p);
		}
		if(p.hasPermission(dsenior)){
			displayHelp(dsenior, p);
		}
		if(p.hasPermission(elder)){
			displayHelp(elder, p);
		}
		if(p.hasPermission(delder)){
			displayHelp(delder, p);
		}
		if(p.hasPermission(arch)){
			displayHelp(arch, p);
		}
		if(p.hasPermission(trib)){
			displayHelp(trib, p);
		}
	}
	
	public void displayHelp(String rank, Player p){
		instructions.setColor(ChatColor.RED);
		land.setColor(ChatColor.GREEN);
		tp.setColor(ChatColor.GREEN);
		creativity.setColor(ChatColor.GREEN);
		econ.setColor(ChatColor.GREEN);
		misc.setColor(ChatColor.GREEN);
		
		land.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about protecting land").create()));
		land.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,  "/help land "+ rank.substring(13)));
		
		tp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about teleportation").create()));
		tp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help tp "+ rank.substring(13)));
		
		creativity.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about the semi-creative aspect of the server").create()));
		creativity.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help creative "+ rank.substring(13)));
		
		econ.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about the economy").create()));
		econ.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help econ "+ rank.substring(13)));
		
		misc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about misc. commands").create()));
		misc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help misc "+ rank.substring(13)));
		
		p.spigot().sendMessage( instructions );
		p.spigot().sendMessage(land);
		p.spigot().sendMessage(tp);
		p.spigot().sendMessage(creativity);
		p.spigot().sendMessage(econ);
		p.spigot().sendMessage(misc);
		
	}
	
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("help")){
			
			
		}
		
		
		return true;
	}
	
	
	private void BaseCommand(CommandSender sender){
		
	}
	
	private void normalLand(CommandSender sender){
		
	}

}
