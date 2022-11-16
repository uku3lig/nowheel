package net.uku3lig.nowheel.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;
import net.minecraft.client.option.CyclingOption;
import net.minecraft.client.option.Option;

public class ConfigScreen extends AbstractConfigScreen<NoWheelConfig> {
    protected ConfigScreen(Screen parent, ConfigManager<NoWheelConfig> manager) {
        super(parent, Text.of("NoWheel Config"), manager);
    }

    @Override
    protected Option[] getOptions(NoWheelConfig config) {
        return new Option[] {
                CyclingOption.create("nowheel.option.enabled", opt -> config.isEnabled(), (option, opt, value) -> config.setEnabled(value))
        };
    }
}
