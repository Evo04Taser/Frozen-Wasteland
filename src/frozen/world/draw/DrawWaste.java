/** WIP(WORK IN PROGRESS) 
package frozen.world.draw;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d,*;
import arc.math.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.power.PowerGenerator.*;
import mindustry.world.draw.*;

public class DrawWaste extends DrawBlock {
    public Item waste = Items.graphite;
    public @Nullable Liquid liquidWaste;
    public TextureRegion wasteRegion;

    @Override
    public void setStats(PowerGeneratorBuild build){
      super.setStats();

      if(consumesItems){
         stats.add(Stat.output, StatValues.items(itemDuration / 60f, waste));
      }
    }

    @Override
    public void init(){
      outputsItem = waste != null;
      outputsLiquid = liquidWaste != null;
      super.init();
    } */
