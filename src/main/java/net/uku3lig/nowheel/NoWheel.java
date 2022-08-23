package net.uku3lig.nowheel;

import lombok.Getter;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.uku3lig.nowheel.config.Config;

import java.io.File;

@Environment(EnvType.CLIENT)
public class NoWheel implements ClientModInitializer {
    @Getter
    private static final File file = new File("./config/nowheel.toml");
    @Getter
    private static final Config config = Config.readConfig(file);

    @Override
    public void onInitializeClient() {
        // hi
    }
}
