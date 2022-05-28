package frozen.world.meta;

import arc.struct.*;
import mindustry.*;

public class Attribute{
    public static Attribute[] all = {};
    public static ObjectMap<String, Attribute> map = new ObjectMap<>();

    public static final Attribute 
    wind = add("wind"),
    cold = add("cold"),
    wave = add("wave");

    public final int id;
    public final String name;
}
