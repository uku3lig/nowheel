package net.uku3lig.nowheel;

import me.contaria.speedrunapi.config.api.SpeedrunConfig;
import me.contaria.speedrunapi.config.api.annotations.Config;

@Config
public class NoWheelConfig implements SpeedrunConfig {
    public static NoWheelConfig instance;

    {
        instance = this;
    }

    public boolean enabled = true;

    @Override
    public String modID() {
        return "nowheel";
    }
}
