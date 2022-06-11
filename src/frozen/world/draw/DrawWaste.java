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
    /** public boolean indicate = true; */
    public TextureRegion wasteIndicatorRegion;

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
      super.init();
    }

    @Override
    public void load(Block block){
      wasteIndicator =  Core.atlas.find(block.name + "-wasteIndicator");
    }

    @Override
    public void draw(){
      if(waste = extant) return;

      Draw.color(waste.color);
      Draw.rect(itemRegion, req.drawx(), req.drawy());
      Draw.color();
    }
}
