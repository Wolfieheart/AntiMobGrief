package be.wolfstorm.antimobgrief;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class AntiMobGrief extends JavaPlugin {

    private static AntiMobGrief instance;

    @Override
    public void onEnable(){
        instance = this;

        devCheck();
        Utils.checkForConfigs(instance);

        Utils.readConfig(getConfig());

        getServer().getPluginManager().registerEvents(new EventListener(), instance);
        //getCommand("amg").setExecutor(new CommandHandler());
    }

    @Override
    public void onDisable(){
        devCheck();
    }

    private void devCheck(){
        File jarfile = this.getFile().getAbsoluteFile();
        if(jarfile.toString().contains("-SNAPSHOT")){
            getServer().getLogger().info("[AntiMobGrief] Enabling " + getInstance() + "");
        } else{
            getServer().getLogger().info("[AntiMobGrief] Enabling BetterSocialSpy Version: " + getInstance() + "");
        }
    }

    public static AntiMobGrief getInstance() {
        return instance;
    }
}
