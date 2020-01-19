package be.wolfstorm.antimobgrief;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;

public class Utils {

    private static PluginDescriptionFile pluginDescFile;
    private static FileConfiguration config;

    private static String allowGhastGrief;
    private static String allowEndermanGrief;
    private static String allowCreeperGrief;
    private static String allowSkeletonHorseSpawnEvent;


    public static void checkForConfigs(Plugin plugin){
        try{
            pluginDescFile = plugin.getDescription();
            if(!plugin.getDataFolder().exists()){
                Bukkit.getServer().getLogger().warning("[AntiMobGrief] Data Folder does not exist. Creating Data Folder Now");
                plugin.getDataFolder().mkdirs();
            }
            File file = new File(plugin.getDataFolder(), "config.yml");
            Bukkit.getServer().getLogger().info("[AntiMobGrief] Configuration File Created");
            if(!file.exists()){
                Bukkit.getServer().getLogger().warning("[AntiMobGrief] Configuration not complete. Creating Configs Now");
                plugin.saveDefaultConfig();
                config = plugin.getConfig();
                config.options().copyDefaults(true);
                plugin.saveConfig();
            }
        }catch (Exception e){
            Bukkit.getServer().getLogger().severe("--- [AntiMobGrief] An Error has Occurred ---");
            Bukkit.getServer().getLogger().severe("--- Please Create an issue with this Stack Trace ---");
            e.printStackTrace();
        }
    }

    public static void readConfig(FileConfiguration config){
        allowGhastGrief = config.getString("allowGhastGrief");
        allowEndermanGrief = config.getString("allowEndermanGrief");
        allowCreeperGrief = config.getString("allowCreeperGrief");
        allowSkeletonHorseSpawnEvent = config.getString("allowSkeletonHorseSpawnEvent");
    }

    public static String getAllowGhastGrief(){
        return allowGhastGrief;
    }

    public static String getAllowEndermanGrief(){
        return allowEndermanGrief;
    }

    public static String getAllowCreeperGrief(){
        return allowCreeperGrief;
    }

    public static String getAllowSkeletonHorseSpawnEvent(){
        return allowSkeletonHorseSpawnEvent;
    }

    /*public static void reloadConfig(Plugin plugin, CommandSender sender) {
        config = plugin.getConfig();

        if(allowCreeperGrief.contains("true")){

        }

    }*/

    public enum Perm{
        antimobgrief("AntiMobGrief.op");

        String permission;
        Perm(String permission){
            this.permission = permission;
        }

        public boolean has(Player player){
            return player.hasPermission(permission);
        }
    }

}
