package net.uku3lig.nowheel.config;

import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "nowheel")
@Getter @Setter
public class NoWheelConfig implements ConfigData {
    private boolean enabled = true;
}
