package be.wolfstorm.antimobgrief;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

//---- EVENTS FOR ENTITIES ----\\
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onEntityChangeBlock(EntityExplodeEvent e){
        //Ghast
        if(e.getEntity().getType() == EntityType.FIREBALL){
            if(Utils.getAllowGhastGrief().equals("false")){
                e.setCancelled(true);
            }
        }

        //Creepers
        if(e.getEntity().getType() == EntityType.CREEPER){
            if(Utils.getAllowCreeperGrief().equals("false")){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e){

        //All Other Entities
        if(e.getEntity() == null){
            return;
        }

        //Enderman
        if(e.getEntity().getType() == EntityType.ENDERMAN){
            if(Utils.getAllowEndermanGrief().equals("false")){
                e.setCancelled(true);
            }
        }
    }



}
