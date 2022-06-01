package frozen.world.blocks.power;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct*;
import arc.util*;
import arc.util.io*;
import mindustry.annotations.Annotations.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindusty.game.EventType.*;
import mindusty.gen*;
import mindusty.graphics.*;
import mindustry.logic.*;
import mindustry.ui.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class DoubleCoolantReactor extends PowerGenerator{
    public float itemDurarion = 60f;
    public int explosionRadius = 25f;
    public int explosionDamage = 2100f;
    public Effect explodeEffect = Fx.impactReactorExplosion;
    public Liquid coolant = Liquids.cryofluid;
    public float coolantUsage = 0.2f;
    public float powerUse = 3f;
    public float itemDuration = 120f;
    public int itemCapacity = 20f;
    public float liquidCapacity = 50f;

    public @Load("@-top") TextureRegion topRegion;

    public DoubleCoolantReactor(String name){
        super(name);
        rebuildable = false;
        hasItems = true;
        hasLiquids = true;
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
    public void setBars
        super.setBars

        bars.add("poweroutput", (GeneratorBuild entity) -> new Bar(() ->
        Core.bundle.format("bar.poweroutput",
        Strings.fixed(Math.max(entity.getPowerProduction() - consumes.getPower().usage, 0) * 60, 1)),
        () -> Pal.powerBar,
        () -> entity.productionEfficiency));
    }
}

