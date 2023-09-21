package net.uku3lig.nowheel.config;

import net.minecraft.client.gui.screen.Screen;
import net.uku3lig.nowheel.NoWheel;
import net.uku3lig.ukulib.config.option.CyclingOption;
import net.uku3lig.ukulib.config.option.WidgetCreator;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;

public class ConfigScreen extends AbstractConfigScreen<NoWheelConfig> {
    protected ConfigScreen(Screen parent) {
        super("NoWheel Config", parent, NoWheel.getManager());
    }

    @Override
    protected WidgetCreator[] getWidgets(NoWheelConfig config) {
        return new WidgetCreator[] {
                CyclingOption.ofBoolean("nowheel.option.enabled", config.isEnabled(), config::setEnabled)
        };
    }
}
