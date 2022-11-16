package net.uku3lig.nowheel.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.uku3lig.nowheel.NoWheel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @Inject(at = @At("HEAD"), method = "scrollInHotbar", cancellable = true)
    private void onHotbarScroll(double amount, CallbackInfo ci) {
        if (!NoWheel.getManager().getConfig().isEnabled()) ci.cancel();
    }
}
