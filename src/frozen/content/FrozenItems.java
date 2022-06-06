package frozen.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class FrozenItems implements ContentList{
    public static Item
    snow, snowBlock, snowBrick;

    @Override
    public void load(){
        snow = new Item("snow", Color.valueOf("e8e8e8")){{
            hardness = 0.3;
            cost = 0.7f;
            alwaysUnlocked = true;
        }};

        snowBlock = new Item("snow-block", Color.valueOf("f5f5f5")){{
            cost = 1f;
        }};

        snowBrick = new Item("snow-brick", Color.valueOf("ffffff")){{
            cost = 1.5f;
        }};
    }
}
