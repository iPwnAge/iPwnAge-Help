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
	
	
	TextComponent subtopic = new TextComponent("Click on a sub-topic to learn more about it");
	
	TextComponent doors = new TextComponent("Locking doors and chests");
	TextComponent regioning = new TextComponent("Claiming Land");
	
	TextComponent warps = new TextComponent("Warps");
	TextComponent tpa = new TextComponent("Teleporting to others");
	
	TextComponent kitsOrItems = new TextComponent("Kits/Spawning Items");
	TextComponent economy =  new TextComponent("The Economy");
	TextComponent miscMessage = new TextComponent("Oh no! This section seems to be measing");
	
	Help help;
	
	public HelpCommand(Help plugin){
		this.help = plugin;
	}
	
	
	
	public void displayHelp(Player p){
		instructions.setColor(ChatColor.RED);
		land.setColor(ChatColor.GREEN);
		tp.setColor(ChatColor.GREEN);
		creativity.setColor(ChatColor.GREEN);
		econ.setColor(ChatColor.GREEN);
		misc.setColor(ChatColor.GREEN);
		
		land.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about protecting land").create()));
		land.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,  "/help land"));
		
		tp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about teleportation").create()));
		tp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help tp"));
		
		creativity.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about the semi-creative aspect of the server").create()));
		creativity.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help creative"));
		
		econ.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about the economy").create()));
		econ.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help econ"));
		
		misc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Learn more about misc. commands").create()));
		misc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help misc"));
		
		p.spigot().sendMessage( instructions );
		p.spigot().sendMessage(land);
		p.spigot().sendMessage(tp);
		p.spigot().sendMessage(creativity);
		p.spigot().sendMessage(econ);
		p.spigot().sendMessage(misc);
		
	}
	
	
	
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if(command.getName().equalsIgnoreCase("help")){
			if(args.length < 1){
				baseCommand(sender);
				return true;
			}
			
			
			if(args[0].equalsIgnoreCase("land")){
				landProtection(player);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("tp")){
				tp(player);
			}
			
			if(args[0].equalsIgnoreCase("creative")){
				creative(player);
			}
			
			if(args[0].equalsIgnoreCase("econ")){
				econ(player);
			}
			
			if(args[0].equals("misc")){
				misc(player);
			}
			
			
		}
		
		
		return true;
	}
	
	
	
	private void baseCommand(CommandSender sender){
		Player player = (Player) sender;
		displayHelp(player);
	}
	
	private void landProtection(Player p){
		
		subtopic.setColor(ChatColor.GOLD);
		
		if(p.hasPermission(normal)){
			p.sendMessage("As a normal, you cannot protect land. Ask in chat for someone to protect it for you, or ask staff!");
		}
		
		
	}
	
	private void tp(Player p){
		
		
		
	}
	
	private void creative(Player p){
		
		
	}
	
	private void econ(Player p){
		
		if(p.hasPermission(normal) ||  p.hasPermission(commoner) || p.hasPermission(dcommoner) || p.hasPermission(trusted) || p.hasPermission(dtrusted) || p.hasPermission(vet)){
			TextComponent shopsAtSpawn = new TextComponent("Visit the various npc's at spawn to use the economy!");
			shopsAtSpawn.setColor(ChatColor.GRAY);
			shopsAtSpawn.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to visit spawn").create()));
			shopsAtSpawn.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/spawn"));
			
			p.spigot().sendMessage(shopsAtSpawn);
		}else{
			TextComponent justSpawnTheFuckingItem = new TextComponent("At your rank, you cannot use the economy! Use /i to get the desired item.");
			TextComponent plsNoSpawning =  new TextComponent("However, giving spawned items to newer players is a bannable offense!");
			
			justSpawnTheFuckingItem.setColor(ChatColor.GOLD);
			plsNoSpawning.setColor(ChatColor.RED);
			p.spigot().sendMessage(justSpawnTheFuckingItem);
			p.spigot().sendMessage(plsNoSpawning);
		}
		
	}
	
	private void misc(Player p){
		
		p.spigot().sendMessage(miscMessage);
		
	}
	

	

}
