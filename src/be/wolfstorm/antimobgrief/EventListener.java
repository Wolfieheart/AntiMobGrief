package be.wolfstorm.antimobgrief;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.World;

//---- EVENTS FOR ENTITIES ----\\
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.block.BlockExplodeEvent;


public class EventListener implements Listener {

    @EventHandler
    public void onEntityChangeBlock(EntityExplodeEvent e){

        Entity entity = e.getEntity();

        //GHAST FIREBALL DAMAGE DISABLED
        if(entity instanceof Ghast){
            if(Utils.getAllowGhastGrief().equals("false")){
                e.setCancelled(true);
            }
        }

        //CREEPER GRIEFING DISABLED
        if (entity instanceof Creeper){
            if(Utils.getAllowCreeperGrief().equalsIgnoreCase("false")){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e){
        Entity entity = e.getEntity();

        if(entity instanceof Enderman){
            if(Utils.getAllowEndermanGrief().equalsIgnoreCase("false")){
                e.setCancelled(true);
            }
        }
    }


    //Disable Ravager Griefing
    @EventHandler
    public void onRavagerGriefEvent(EntityChangeBlockEvent e){
        if(e.getEntityType() == EntityType.RAVAGER){
            e.setCancelled(true);
        }
    }

    //Disable Bed Explosions
    @EventHandler
    public void onExplode(BlockExplodeEvent e){
        if (e.getBlock().getWorld().getEnvironment() == World.Environment.NETHER){
            if(e.getBlock().getType().equals(Material.AIR)){
                e.setCancelled(true);
            }
        }

    }


}
