package net.uku3lig.nowheel.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.player.PlayerInventory;
import net.uku3lig.nowheel.config.NoWheelConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @Inject(at = @At("HEAD"), method = "scrollInHotbar", cancellable = true)
    private void onHotbarScroll(double amount, CallbackInfo info) {
        if (AutoConfig.getConfigHolder(NoWheelConfig.class).getConfig().enabled) info.cancel();
    }
}
