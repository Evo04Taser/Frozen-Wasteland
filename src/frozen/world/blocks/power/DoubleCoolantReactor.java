package frozen.world.blocks.power;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.annotations.Annotations.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class DoubleCoolantReactor extends PowerGenerator{
    public final Vec2 tr = new Vec2();

    public Effect explodeEffect = Fx.reactorExplosion;
    public float itemDuration = 120f;
    public float coolantUse = 0.2f;
    public float powerUse = 3f;
    public Liquid coolant = cryofluid;
    public int explosionRadius = 19f;
    public int explosionDamage = 1250f;

    public @Load("@-top") TextureRegion topRegion;

    public DoubleCoolantReactor(String name){
        super(name);
        updateInUnits = false;
        itemCapacity = 30;
        liquidCapacity = 30;
        hasItems = true;
        hasLiquids = true;
        rebuildable = false;
        flags = EnumSet.of(BlockFlag.reactor, BlockFlag.generator);
        schematicPriority = -5;
        envEnabled = Env.any;
    }

    @Override
    public void setStats(){
        super.setStats();

        if(hasItems){
            stats.add(Stat.productionTime, itemDuration / 60f, StatUnit.seconds);
        }
    }

    @Override
     public void init(){
        consumes.liquidCond(coolantUse)
        super.init();
    }

    @Override
    public void init(){
       consumes.powerCond(powerUse);
       super.init();
    }

    @Override
    public void setStats(){
          super.setStats();

          Mathf.absin(liquidNeeded = powerNeeded - powerAvailable)
    }

    @Override
    public void setBars(){
        super.setBars();

        bars.add("poweroutput", (GeneratorBuild entity) -> new Bar(() ->
        Core.bundle.format("bar.poweroutput",
        Strings.fixed(Math.max(entity.getPowerProduction() - consumes.getPower().usage, 0) * 60)),
        () -> Pal.powerBar,
        () -> entity.productionEfficiency));
    }
}
