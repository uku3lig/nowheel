package net.uku3lig.nowheel.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.CyclingOption;
import net.minecraft.client.option.Option;
import net.minecraft.text.LiteralText;

public class ConfigScreen extends AbstractConfigScreen {
    public ConfigScreen(Screen parent, Config config) {
        super(parent, new LiteralText("NoWheel Config"), config);
    }

    @Override
    protected Option[] getOptions() {
        return new Option[] {
                CyclingOption.create("nowheel.option.enabled", opt -> config.isEnabled(), (option, opt, value) -> config.setEnabled(value))
        };
    }
}
