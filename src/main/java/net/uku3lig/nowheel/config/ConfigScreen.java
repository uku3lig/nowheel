package net.uku3lig.nowheel.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;

public class ConfigScreen extends AbstractConfigScreen<NoWheelConfig> {
    protected ConfigScreen(Screen parent, ConfigManager<NoWheelConfig> manager) {
        super(parent, Text.of("NoWheel Config"), manager);
    }

    @Override
    protected SimpleOption<?>[] getOptions(NoWheelConfig config) {
        return new SimpleOption[] {
                SimpleOption.ofBoolean("nowheel.option.enabled", config.isEnabled(), config::setEnabled)
        };
    }
}
