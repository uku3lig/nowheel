package net.uku3lig.nowheel.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.Mouse;
import net.minecraft.entity.player.PlayerInventory;
import net.uku3lig.nowheel.NoWheel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Mouse.class)
public class MouseMixin {
    @WrapWithCondition(method = "onMouseScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;setSelectedSlot(I)V"))
    public boolean onHotbarScroll(PlayerInventory instance, int slot) {
        return NoWheel.getManager().getConfig().isEnabled();
    }
}
