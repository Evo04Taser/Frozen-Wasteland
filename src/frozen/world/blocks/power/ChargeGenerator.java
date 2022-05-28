package frozen.world.blocks.power;

import mindustry.type.*;
import mindustry.world.meta.*;

public class ChargeGenerator extends ItemLiquidGenerator{

    public ChargeGenerator(String name){
        super(true, false, name);
        hasItems = true;
        hasLiquids = false;
        envEnabled = Env.any;
    }

    @Override
    protected float getItemEfficiency(Item item){
        return item.charge;
    }
}