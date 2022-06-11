package frozen.content;

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
		hardenedConveyor = new HardenedConveyor("hardened-conveyor"){{
			requirements(Category.distribution, with(Items.copper, 1));
			speed = 0.15f;
                        displayedSpeed = 20.625f;
			health = 200f;
		}};
		hardenedConduit = new HardenedConduit("hardened-conduit"){{
			requirements(Category.liquid, with(Items.copper, 1));
			liquidCapacity = 25f;
                        liquidPressure = 1.6015625f;
			health = 300f;
		}};
	}
}
