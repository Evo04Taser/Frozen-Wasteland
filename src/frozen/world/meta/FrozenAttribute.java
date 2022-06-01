package frozen.world.meta;

import arc.struct.*;
import mindustry.*;

public class Attribute{
    public static  Attribute[] all = {};
    public static ObjectMap<String, 
Attribute> map = new ObjectMap<>(); 

    public static final Attribute 
    wind = add("wind"),
    cold = add("cold"),
    tide = add("tide");

    public final int id;
    public final String name;
}
