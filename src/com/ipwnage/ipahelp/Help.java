package com.ipwnage.ipahelp;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class Help extends JavaPlugin {
	
	public static final Logger log = Logger.getLogger("Minecraft");
	
	
	public void onEnable(){
		log.info("The boys are back at it again!");
	}
	
	public void onDisable(){
		
	}
}
