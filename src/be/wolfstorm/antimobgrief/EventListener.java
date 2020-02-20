package be.wolfstorm.antimobgrief;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.World;

//---- EVENTS FOR ENTITIES ----\\
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.block.BlockExplodeEvent;


public class EventListener implements Listener {

    @EventHandler
    public void onEntityChangeBlock(EntityExplodeEvent e) {

        //GHAST FIREBALL DAMAGE DISABLED
        if (e.getEntityType() == EntityType.FIREBALL) {
            if (Utils.getAllowGhastGrief().equalsIgnoreCase("false")) {
                e.setCancelled(true);
            }
        }

        //CREEPER GRIEFING DISABLED
        if (e.getEntity().getType() == EntityType.CREEPER) {
            if (Utils.getAllowCreeperGrief().equalsIgnoreCase("false")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e) {
        if (e.getEntityType() == EntityType.ENDERMAN) {
            if (Utils.getAllowEndermanGrief().equalsIgnoreCase("false")) {
                e.setCancelled(true);
            }
        }
    }


    //Disable Ravager Griefing
    @EventHandler
    public void onRavagerGriefEvent(EntityChangeBlockEvent e) {
        if (e.getEntityType() == EntityType.RAVAGER) {
            if (Utils.getAllowRavagerGrief().equalsIgnoreCase("false")) {
                e.setCancelled(true);
            }
        }
    }

    //Disable Bed Explosions
    @EventHandler
    public void onExplode(BlockExplodeEvent e) {
        if (Utils.getAllowBedExplosionGrief().equalsIgnoreCase("false")) {
            if (e.getBlock().getWorld().getEnvironment() == World.Environment.NETHER) {
                e.setCancelled(true);
            }
        }
    }
}