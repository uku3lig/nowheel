package net.uku3lig.nowheel.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "nowheel")
public class NoWheelConfig implements ConfigData {
    public boolean enabled = true;
}
