package be.wolfstorm.antimobgrief;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.IOException;

public class CommandHandler implements CommandExecutor {

    public Player player;
    private Plugin plugin;
    public FileConfiguration config;

    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (cmd.getName().equalsIgnoreCase("amg")) {
            if (sender instanceof Player) {
                player = (Player) sender;
                if (Utils.Perm.antimobgrief.has(player) && !player.isOp()) {
                    player.sendMessage(ChatColor.DARK_RED + "[AntiMobGrief] You do not have permission to perform this command!");
                    return true;
                }

                //Command Code
                sender.sendMessage(ChatColor.GOLD + "[]========= AntiMobGrief Help =========[]");
                if (sender.isOp() || Utils.Perm.antimobgrief.has(player)) {
                    sender.sendMessage(ChatColor.YELLOW + "List of OP Commands");
                    sender.sendMessage(ChatColor.YELLOW + "/amg setGhastGrief true/false - Turn Ghast Grief On or Off");
                    sender.sendMessage(ChatColor.YELLOW + "/amg setCreeperGrief true/false - Turn Creeper Grief On or Off");
                    sender.sendMessage(ChatColor.YELLOW + "/amg setEndermanGrief true/false - Turn Enderman Grief On or Off");
                    sender.sendMessage(ChatColor.YELLOW + "/amg reload - Reload AntiMobGrief's Configuration File");
                }
            }

            //setGhastGrief true/false
            if (args[0].equalsIgnoreCase("setGhastGrief")) {
                if (args.length < 1) {
                    return false;
                }
                if (sender instanceof Player) {
                    player = (Player) sender;
                    if (Utils.Perm.antimobgrief.has(player) && !player.isOp()) {
                        player.sendMessage(ChatColor.DARK_RED + "[AntiMobGrief] You do not have permission to perform this command!");
                        return true;
                    }
                }
                if (!args[1].contains("true") & !args[1].contains("false")) {
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] Argument must be boolean. Usage: /amg setGhastGrief True/False");
                } else if (args[1].contains("true") & !args[1].contains("false")) {
                    config = plugin.getConfig();
                    config.set("allowGhastGrief", "" + args[1] + "");
                    try {
                        config.save(String.valueOf(config));
                    }catch (IOException e){
                        Bukkit.getServer().getLogger().severe("--- [AntiMobGrief] An Error has Occurred ---");
                        Bukkit.getServer().getLogger().severe("--- Please Create an issueA with this Stack Trace ---");
                        e.printStackTrace();
                    }

                    //Utils.reloadConfig(this, null);
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] setGhastGrief has been set to: " + args[1]);
                    if (args[1].contains("false")) {
                        sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] FIREBALLS from Ghasts will no longer destroy blocks.");
                    } else if (args[1].contains("true")) {
                        sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] FIREBALLS from Ghasts will continue destroying blocks.");
                    }
                }
            }
        }
        return true;
    }
}
        /*
        //setCreeperGrief
        if (args[1].equalsIgnoreCase("setCreeperGrief")) {
            if (args.length < 1) {
                return false;
            }
            if (sender instanceof Player) {
                player = (Player) sender;
                if (Utils.Perm.antimobgrief.has(player) && !player.isOp()) {
                    player.sendMessage(ChatColor.DARK_RED + "[AntiMobGrief] You do not have permission to perform this command!");
                    return true;
                }
            }
            if (!args[2].contains("true") & !args[2].contains("false")) {
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] Argument must be boolean. Usage: /amg setCreeperGrief True/False");
            } else if (args[2].contains("true") & !args[2].contains("false")) {
                Utils.readConfig(config);
                config.set("allowCreeperGrief", "" + args[2]);
                plugin.saveConfig();

                //Utils.reloadConfig(this, null);
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] setCreeperGrief has been set to: " + args[1]);
                if(args[1].contains("false")){
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] CREEPERS will no longer destroy blocks." );
                }else if(args[1].contains("true")) {
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] CREEPERS will continue destroying blocks.");
                }
            }
        }

        //setEndermanGrief
        if (args[2].equalsIgnoreCase("setEndermanGrief")) {
            if (args.length < 1) {
                return false;
            }
            if (sender instanceof Player) {
                player = (Player) sender;
                if (Utils.Perm.antimobgrief.has(player) && !player.isOp()) {
                    player.sendMessage(ChatColor.DARK_RED + "[AntiMobGrief] You do not have permission to perform this command!");
                    return true;
                }
            }
            if (!args[1].contains("true") & !args[1].contains("false")) {
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] Argument must be boolean. Usage: /amg setEndermanGrief True/False");
            } else if (args[1].contains("true") & !args[1].contains("false")) {
                Utils.readConfig(config);
                config.set("allowEndermanGrief", "" + args[1]);
                plugin.saveConfig();

                //Utils.reloadConfig(this, null);
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] setEndermanGrief has been set to: " + args[1]);
                if(args[1].contains("false")){
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] ENDERMAN will no longer pick up blocks." );
                }else if(args[1].contains("true")) {
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] ENDERMAN will continue picking up blocks.");
                }
            }
        }

        //reload
        if(args[0].equalsIgnoreCase("reload")){
            if (sender instanceof Player) {
                player = (Player) sender;
                if (Utils.Perm.antimobgrief.has(player) && !player.isOp()) {
                    player.sendMessage(ChatColor.DARK_RED + "[AntiMobGrief] You do not have permission to perform this command!");
                    return true;
                }
            }
            //Utils.reloadConfig(this, null);
        }*/