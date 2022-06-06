package frozen.world.blocks.power;

import mindustry.type.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.power.*;
public class BlastGenerator extends ItemLiquidGenerator{

    public BlastGenerator(String name){
        super(true, false, name);
        hasItems = true;
        hasLiquids = false;
        envEnabled = Env.any;
    }

    @Override
    protected float getItemEfficiency(Item item){
        return item.explosiveness;
    }
}
