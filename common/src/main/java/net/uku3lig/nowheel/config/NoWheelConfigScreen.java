package net.uku3lig.nowheel.config;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.uku3lig.ukulib.config.option.CyclingOption;
import net.uku3lig.ukulib.config.option.WidgetCreator;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;

public class NoWheelConfigScreen extends AbstractConfigScreen<NoWheelConfig> {
    protected NoWheelConfigScreen(Screen parent) {
        super("NoWheel Config", parent, NoWheelConfig.manager);
    }

    @Override
    protected WidgetCreator[] getWidgets(NoWheelConfig config) {
        return new WidgetCreator[] {
                CyclingOption.ofTranslatableEnum("nowheel.config.disabledDirection", NoWheelConfig.Direction.class, config.getDisabledDirection(), config::setDisabledDirection),
                CyclingOption.ofTranslatableEnum("nowheel.config.disableContext", NoWheelConfig.Context.class, config.getDisableContext(), config::setDisableContext,
                        OptionInstance.cachedConstantTooltip(Component.translatable("nowheel.config.disableContext.tooltip"))),
        };
    }
}
