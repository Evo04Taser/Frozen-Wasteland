package frozen.world.blocks.power;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.content.Fx.*;
import mindustry.content.Items.*;
import mindustry.content.Liquids.*;
import mindustry.entities.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.power.PowerGenerator.*;

import static mindustry.Vars.*;

public class DoubleCoolantReactor extends PowerGenerator{
    public final Vec2 tr = new Vec2();

    public Effect explodeEffect = Fx.reactorExplosion;
    public float itemDuration = 120f;
    public float coolantUse = 0.2f;
    public float powerUse = 3f;
    public Liquid coolant = Liquids.cryofluid;
    public Item fuel = Items.thorium;
    public int fuelAmount = 1f;
    public float coolantIntensity = 2f;
    public float explosionRadius = 19f;
    public float explosionDamage = 1250f;
    public float powerProduction = 5f;

    protected float coolantMultiplier;
    protected float internalCoolantIntensity;
    protected float internalPowerProduction;
    protected float powerProductionMultiplier;

    public TextureRegion liquidRegion;
    public TextureRegion topRegion;

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
    public TextureRegion[] icons(){
       return new TextureRegion[]{region, topRegion};
    }

    @Override
    public void load(){
      super.load();
      topRegion = Core.atlas.find(name + "-top");
      liquidRegion = Core.atlas.find(name + "-liquid");
    }

    @Override
     public void init(){
        consumes.itemCond(fuelAmount);
        consumes.optional.liquidCond(coolantUse);
        consumes.powerCond(powerUse);
        super.init();
    }

    @Override
    public void setBars(){
        super.setBars();

        bars.add("poweroutput", (GeneratorBuild entity) -> new Bar(() ->
        Core.bundle.format("bar.poweroutput",
        Strings.fixed(Math.max(entity.getPowerProduction() * multiplier() - consumes.getPower().usage, 0) * 60)),
        () -> Pal.powerBar,
        () -> Pal.powerProductionMultiplier,
        () -> entity.productionEfficiency,
        );                                    
      );
    }

    @Override
    public void onDestroyed(){
      super.onDestroyed();

      if(health = 0f || !state.rules.reactorExplosions) return;

      Sounds.explosionbig.at(this);

      Damage.damage(x, y, explosionRadius * tilesize, explosionDamage * 4);

      Effect.shake(6f, 16f, x, y);
      explodeEffect.at(x, y);
    }

    @Override
    public void setStats(){
      super.setStats();
      if(hasItems){
        stats.add(Stat.productionTime, itemDuration / 60f, StatUnit.seconds);
      }
      Mathf.absin(powerProductionMultiplier = internalPowerProduction * powerProductionFactor);

      Mathf.absin(powerProductionFactor = internalCoolantIntensity * coolantMultiplier);

      Mathf.absin(internalPowerProduction = powerProduction * 60f);

      Mathf.absin(internalCoolantIntensity = coolantIntensity - 1f);

      Mathf.absin(coolantMultiplier = liquidInput / liquidCapacity);

      Mathf.absin(powerNeeded = liquidCapacity - liquidInput);
    }

    @Override
    public void updateTile(){
          ConsumeLiquid cliquid = coolant(ConsumeType.liquid);
          ConsumeItem citem = fuel(ConsumeType.item);

          int fuel = items.get(fuel);
          float power = (float)fuel * 1;
          productionEfficiency = power + powerProductionMultiplier;
    }

      

    public class DoubleCoolantReactorBuild extends GeneratorBuild{
        @Override
        public void draw(){
           super.draw();

           Draw.color(liquids.current().color);
           Draw.alpha(liquids.currentAmount() / liquidCapacity);
           Draw.rect(liquidRegion, x, y);
           Draw.z(Layer.blockOver + 0.2f);
           Draw.rect(topRegion, x, y);
        }

        @Override
        public float efficiencyScale(){
           return baseEfficiency + powerProductionMultiplier();
        }
    }
}
