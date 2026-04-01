package net.uku3lig.nowheel.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.option.StringTranslatable;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoWheelConfig implements Serializable {
    public static final ConfigManager<NoWheelConfig> manager = ConfigManager.createDefault(NoWheelConfig.class, "nowheel");

    private Direction disabledDirection = Direction.ALL;
    private Context disableContext = Context.HOTBAR;

    public static NoWheelConfig get() {
        return manager.getConfig();
    }

    @Getter
    @AllArgsConstructor
    public enum Direction implements StringTranslatable {
        ALL("all", "nowheel.config.all"),
        VERTICAL("vertical", "nowheel.config.direction.vertical"),
        HORIZONTAL("horizontal", "nowheel.config.direction.horizontal"),
        NONE("none", "nowheel.config.direction.none"),
        ;

        public boolean isHoriz() {
            return this == ALL || this == HORIZONTAL;
        }

        public boolean isVert() {
            return this == ALL || this == VERTICAL;
        }

        private final String name;
        private final String translationKey;
    }

    @Getter
    @AllArgsConstructor
    public enum Context implements StringTranslatable {
        HOTBAR("hotbar", "nowheel.config.context.hotbar"),
        GAMEPLAY("gameplay", "nowheel.config.context.gameplay"),
        ALL("all", "nowheel.config.all"),
        ;

        private final String name;
        private final String translationKey;
    }
}
