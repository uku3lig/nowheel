package net.uku3lig.nowheel.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.uku3lig.ukulib.config.IConfig;

@Getter
@Setter
@AllArgsConstructor
public class NoWheelConfig implements IConfig<NoWheelConfig> {
    private boolean enabled;

    @Override
    public NoWheelConfig defaultConfig() {
        return new NoWheelConfig(false);
    }
}
