package com.ipwnage.ipahelp;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
			
			if(!(sender instanceof Player)){
				sender.sendMessage("You've got to be a player to run this command!");
			}
			
			
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
		
		if(p.hasPermission(normal)){
			p.sendMessage(ChatColor.RED + "As a normal, you cannot protect land. Ask in chat for someone to protect it for you, or ask staff!");
		}
		
		if(p.hasPermission(commoner) || p.hasPermission(dcommoner) || p.hasPermission(trusted) || p.hasPermission(dtrusted)){
			
			TextComponent learnRegioning = new TextComponent("The 'region' command lets you protect your land from grief! The syntax is /region claim <regionName>. Make sure you set the points first with  //wand!");
			TextComponent idkHowToWand = new TextComponent("Don't know how to use the worldedit wand? No problem! Click on ");
			TextComponent thisLink = new TextComponent("this link!");
			
			learnRegioning.setColor(ChatColor.GOLD);
			
			idkHowToWand.setColor(ChatColor.GRAY);
			thisLink.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://wiki.sk89q.com/wiki/WorldEdit/Selection#Selecting_cuboids"));
			thisLink.setColor(ChatColor.BLUE);
			idkHowToWand.addExtra(thisLink);
			
			p.spigot().sendMessage(learnRegioning);
			p.spigot().sendMessage(idkHowToWand);
		}else{
			p.sendMessage(ChatColor.RED + "You should already know how to region land by now.");
		}
		
		
	}
	
	private void tp(Player p){
		TextComponent tpa = new TextComponent("Tpa   ");
		TextComponent tp = new TextComponent("Tp   ");
		TextComponent home = new TextComponent("Home   ");
		TextComponent warp = new TextComponent("Warp");
	
		tpa.setColor(ChatColor.GOLD);
		tp.setColor(ChatColor.GOLD);
		warp.setColor(ChatColor.GOLD);
		home.setColor(ChatColor.GOLD);
		
		home.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Go to your home").create()));
		home.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/home"));
		
		if(p.hasPermission(normal) || p.hasPermission(commoner) || p.hasPermission(dcommoner)){
			
			TextComponent normie = new TextComponent("As a newer player, you can only use /tpa, and /warp. You'll gain more commands as you rankup. Click on a command, below, to learn how to use it.");
			
			normie.setColor(ChatColor.GRAY);
			
			tpa.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Teleport to other players, with thier permission.").create()));
			tpa.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpa"));
			
			warp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Warp to player-created warps around the server!").create()));
			warp.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/warp list"));
			warp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/warp"));
			
			p.spigot().sendMessage(normie);
			p.spigot().sendMessage(tpa, home, warp);
			
			
			
			
			
		}
		
		if(p.hasPermission(vet) || p.hasPermission(dvet) || p.hasPermission(senior) || p.hasPermission(dsenior) || p.hasPermission(elder) || p.hasPermission(delder) || p.hasPermission(arch) || p.hasPermission(trib)){
			
			TextComponent nonNormie = new TextComponent("As a seasoned player, you have access to commands like /warp /tphere, and /tp.");
			TextComponent dontSpam = new TextComponent("However, spamming /tphere on someone, and tping to staff without thier explicit permission is a punishable offense!");
			
			TextComponent tphere = new TextComponent("Tphere   ");
			
			nonNormie.setColor(ChatColor.GRAY);
			dontSpam.setColor(ChatColor.RED);
			
			tphere.setColor(ChatColor.GOLD);
			tphere.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Teleport another player to you.").create()));
			tphere.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tphere"));
			
			warp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Warp to player-created warps around the server!").create()));
			warp.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/warp list"));
			warp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/warp"));
			
			tp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Teleport to other players").create()));
			tp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp"));
			
			
			p.spigot().sendMessage(nonNormie);
			p.spigot().sendMessage(dontSpam);
			
			p.spigot().sendMessage(tp, tphere, home, warp);
			
		}
		
		
		
		
		
		
	}
	
	private void creative(Player p){
		
		TextComponent items = new TextComponent("Item spawning");
		TextComponent worldedit = new TextComponent("Worldedit");
		
		worldedit.setColor(ChatColor.GOLD);
		items.setColor(ChatColor.GOLD);
		
		if(p.hasPermission(normal) || p.hasPermission(commoner) || p.hasPermission(dcommoner) || p.hasPermission(trusted) || p.hasPermission(dtrusted) || p.hasPermission(vet)){
			items.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Item spawning is unlocked at senior+").create()));
			p.spigot().sendMessage(items);
		}else{
			items.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Spawn any item").create()));
			items.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/i"));
			TextComponent noSpawnPls = new TextComponent("Spawning items for new players will result in a ban.");
			noSpawnPls.setColor(ChatColor.RED);
			p.spigot().sendMessage(noSpawnPls);
			p.spigot().sendMessage(items);
		}
		
		
		if(p.hasPermission(trib) || p.hasPermission(arch)){
			worldedit.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("You should already know how to use worldedit.").create()));
			p.spigot().sendMessage(worldedit);
		}else{
			worldedit.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Worldedit is unlocked at tribune, and architect").create()));
			p.spigot().sendMessage(worldedit);
		}
		
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
		
		miscMessage.setColor(ChatColor.AQUA);
		
		p.spigot().sendMessage(miscMessage);
		
	}
	

	

}
