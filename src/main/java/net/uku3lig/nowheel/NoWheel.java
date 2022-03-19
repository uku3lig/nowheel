package net.uku3lig.nowheel;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import net.uku3lig.nowheel.config.NoWheelConfig;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class NoWheel implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.register(NoWheelConfig.class, Toml4jConfigSerializer::new);

        final KeyBinding toggle = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "nowheel.key.toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_B, "nowheel.key"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggle.wasPressed()) {
                ConfigHolder<NoWheelConfig> holder = AutoConfig.getConfigHolder(NoWheelConfig.class);
                boolean value = holder.getConfig().isEnabled();
                client.player.sendMessage(new LiteralText("§fMouse Scrolling " + (value ? "§aON" : "§cOFF")), true);
                holder.getConfig().setEnabled(!value);
                holder.save();
            }
        });
    }
}
