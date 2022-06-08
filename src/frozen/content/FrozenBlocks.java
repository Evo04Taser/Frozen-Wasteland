package frozen.content;
/*
Evo04Taser, if you're reading this, remember that 
if you want to make a custom block that extends 
the vanilla content for your mod, make an object instead
of a class. except if you want to make a new type of
block. if that's the case, you can make a new class for
that block.

- 1237
*/
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadRouter;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import static mindustry.type.ItemStack.*;

public class FrozenBlocks {
	public static Block 
	hardenedConveyor,
	hardenedConduit;
	public static void load(){
		// remember to change all the field values
		hardenedConveyor = new ArmoredConveyor("hardened-conveyor"){{
			requirements(Category.distribution, with(Items.copper, 1));
			speed = 1;
			health = 200;
		}};
		hardenedConduit = new ArmoredConduit("hardened-conduit"){{
			requirements(Category.liquid, with(Items.copper, 1));
			liquidCapacity = 20;
			health = 75;
		}};
	}
}
