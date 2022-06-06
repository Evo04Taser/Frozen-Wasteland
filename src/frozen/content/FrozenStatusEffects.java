package frozen.content;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import mindustry.type.*;
import mindustry.graphics.*;


import static mindustry.Vars.*;

public class StatusEffects implements ContentList{
    public static StatusEffect frostbite, incinerating;


    @Override
    public void load(){
        frostbite = new StatusEffect("frostbite"){{
            color = Color.valueOf("1891db");
            speedMultiplier = 0.4f;
            healthMultiplier = 0.7f;
            effect = Fx.freezing
            damage = 0.4f;
            transitionDamage = 23f; 
            
            init(() -> {
                opposite(melting, burning);

                affinity(wet, blasted, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                });
            });
        }};
        incinerating = new StatusEffect("incinerating"){{
            color = Color.valueOf("ff5b00");
            speedMultiplier = 0.15f;
            healthMultiplier = 0.9f;
            effect = Fx.melting
            damage = 1.3f;

            init(() -> {
                opposite(wet, freezing);
                affinity(tarred, (unit, result, time) -> {
                    unit.damagePierce(11f);
                    Fx.burning.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(melting, Math.min(time + result.time, 150f));
                });
            });
        }};
    }
}
