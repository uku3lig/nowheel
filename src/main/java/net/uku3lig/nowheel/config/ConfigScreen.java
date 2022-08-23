package net.uku3lig.nowheel.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

public class ConfigScreen extends AbstractConfigScreen {
    public ConfigScreen(Screen parent, Config config) {
        super(parent, Text.literal("NoWheel Config"), config);
    }

    @Override
    protected SimpleOption<?>[] getOptions() {
        return new SimpleOption[] {
                SimpleOption.ofBoolean("nowheel.option.enabled", config.isEnabled(), config::setEnabled)
        };
    }
}
