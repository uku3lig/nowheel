package net.uku3lig.nowheel;

import lombok.Getter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.uku3lig.nowheel.config.NoWheelConfig;
import net.uku3lig.ukulib.config.ConfigManager;

@Environment(EnvType.CLIENT)
public class NoWheel {
    @Getter
    private static final ConfigManager<NoWheelConfig> manager = ConfigManager.create(NoWheelConfig.class, "nowheel");

    private NoWheel() {}
}
