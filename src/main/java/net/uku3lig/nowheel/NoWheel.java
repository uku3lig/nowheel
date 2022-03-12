package net.uku3lig.nowheel;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.uku3lig.nowheel.config.NoWheelConfig;

@Environment(EnvType.CLIENT)
public class NoWheel implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.register(NoWheelConfig.class, Toml4jConfigSerializer::new);
    }
}
