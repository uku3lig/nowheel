package net.uku3lig.nowheel.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.Mouse;
import net.minecraft.entity.player.PlayerInventory;
import net.uku3lig.nowheel.NoWheelConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Mouse.class)
public class MouseMixin {
    @WrapWithCondition(method = "onMouseScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;scrollInHotbar(D)V"))
    public boolean onHotbarScroll(PlayerInventory instance, double scrollAmount) {
        return NoWheelConfig.instance.enabled;
    }
}
