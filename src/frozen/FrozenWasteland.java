package frozen;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import frozen.content.*;

public class FrozenWasteland extends Mod{

    public FrozenWasteland(){}

    @Override
    public void loadContent(){
        new FrozenItems().load();
    }
}
