package be.wolfstorm.antimobgrief;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler extends JavaPlugin implements CommandExecutor{

    public Player player;
    public FileConfiguration config;

    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (cmd.getName().equalsIgnoreCase("AMG")) {
            if (sender instanceof Player) {
                player = (Player) sender;
                if (Utils.Perm.antimobgrief.has(player) && !player.isOp()) {
                    player.sendMessage(ChatColor.DARK_RED + "[AntiMobGrief] You do not have permission to perform this command!");
                    return true;
                }
            }
            //Command Code
            sender.sendMessage(ChatColor.GOLD + "[]========= AntiMobGrief Help =========[]");
            if (sender.isOp() || Utils.Perm.antimobgrief.has(player)) {
                sender.sendMessage(ChatColor.YELLOW + "List of OP Commands");
                sender.sendMessage(ChatColor.YELLOW + "/amg setGhastGrief true/false - Turn Ghast Grief On or Off");
                sender.sendMessage(ChatColor.YELLOW + "/amg setCreeperGrief true/false - Turn Creeper Grief On or Off");
                sender.sendMessage(ChatColor.YELLOW + "/amg setEndermanGrief true/false - Turn Enderman Grief On or Off");
                sender.sendMessage(ChatColor.YELLOW + "/amg setSkeletonHorseSpawnEvent true/false - Turn Skeleton Horse Spawn Events On or Off");
                sender.sendMessage(ChatColor.YELLOW + "/amg reload - Reload AntiMobGrief's Configuration File");
            }
            return true;
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
                FileConfiguration config = getConfig();
                config.set("allowGhastGrief", "" + args[1]);
                saveConfig();

                //Utils.reloadConfig(this, null);
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] setGhastGrief has been set to: " + args[1]);
                if(args[1].contains("false")){
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] FIREBALLS from Ghasts will no longer destroy blocks." );
                }else if(args[1].contains("true")) {
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] FIREBALLS from Ghasts will continue destroying blocks.");
                }
            }
        }

        //setCreeperGrief
        if (args[0].equalsIgnoreCase("setCreeperGrief")) {
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
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] Argument must be boolean. Usage: /amg setCreeperGrief True/False");
            } else if (args[1].contains("true") & !args[1].contains("false")) {
                FileConfiguration config = getConfig();
                config.set("allowCreeperGrief", "" + args[1]);
                saveConfig();

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
        if (args[0].equalsIgnoreCase("setEndermanGrief")) {
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
                FileConfiguration config = getConfig();
                config.set("allowEndermanGrief", "" + args[1]);
                saveConfig();

                //Utils.reloadConfig(this, null);
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] setEndermanGrief has been set to: " + args[1]);
                if(args[1].contains("false")){
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] ENDERMAN will no longer pick up blocks." );
                }else if(args[1].contains("true")) {
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] ENDERMAN will continue picking up blocks.");
                }
            }
        }

        //setSkeletonHorseSpawnEvent
        if (args[0].equalsIgnoreCase("setSkeletonHorseSpawnEvent")) {
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
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] Argument must be boolean. Usage: /amg setSkeletonHorseSpawnEvent True/False");
            } else if (args[1].contains("true") & !args[1].contains("false")) {
                FileConfiguration config = getConfig();
                config.set("allowSkeletonHorseSpawnEvent", "" + args[1]);
                saveConfig();

                //Utils.reloadConfig(this, null);
                sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] allowSkeletonHorseSpawnEvent has been set to: " + args[1]);
                if(args[1].contains("false")){
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] SKELETON_HORSE will not spawn during thunderstorms." );
                }else if(args[1].contains("true")){
                    sender.sendMessage(ChatColor.YELLOW + "[AntiMobGrief] SKELETON_HORSE will spawn during thunderstorms." );
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
        }
        return true;
    }
}
