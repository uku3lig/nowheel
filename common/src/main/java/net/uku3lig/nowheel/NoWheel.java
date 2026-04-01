package net.uku3lig.nowheel;

import lombok.Getter;
import net.uku3lig.nowheel.config.NoWheelConfig;
import net.uku3lig.ukulib.config.ConfigManager;

public class NoWheel {
    @Getter
    private static final ConfigManager<NoWheelConfig> manager = ConfigManager.createDefault(NoWheelConfig.class, "nowheel");

    private NoWheel() {}
}
