package frozen.world.blocks.distribution;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.entities.units.*;
import mindustry.world.blocks.distribution.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class HardenedConduit extends ArmoredConduit{

    public TextureRegion topRegion;

    public HardenedConduit(String name){
        super(name);
        solid = true;
        armor = 3
    }

    @Override
    public void load(){
        super.load();
        topRegion = Core.atlas.find(name + "-top");
    }

    @Override
    public void drawRequestRegion(BuildPlan req, Eachable<BuildPlan> list){
        super.drawRequestRegion(req, list);

        Draw.rect(glassRegion, req.drawx(), req.drawy());
    }

    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{regions[0][0], topRegion};
    }

    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.size, "@x@", size, size);

        if(synthetic()){
            stats.add(Stat.health, health, StatUnit.none);
            if(armor > 0){
                stats.add(Stat.armor, armor, StatUnit.none);
            }
        }

    public class HardenedConduitBuild extends ArmoredConduitBuild{
        @Override
        public void draw(){
            super.draw();

            Draw.z(Layer.blockOver + 0.1f);

            Draw.rect(topRegion, x, y);
        }

        @Override
        public void unitOn(Unit unit){}
    }
}
