package net.uku3lig.nowheel.mixin;

import net.minecraft.client.Mouse;
import net.uku3lig.nowheel.NoWheel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {
    @Inject(method = "onMouseScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;setSelectedSlot(I)V"), cancellable = true)
    public void onHotbarScroll(long window, double horizontal, double vertical, CallbackInfo ci) {
        if (!NoWheel.getManager().getConfig().isEnabled()) ci.cancel();
    }
}
