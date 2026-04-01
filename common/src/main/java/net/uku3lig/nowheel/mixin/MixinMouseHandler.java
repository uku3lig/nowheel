package net.uku3lig.nowheel.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.ScrollWheelHandler;
import net.uku3lig.nowheel.config.NoWheelConfig;
import org.joml.Vector2i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MouseHandler.class)
public class MixinMouseHandler {
    @WrapMethod(method = "onScroll")
    public void disableGlobalScroll(long handle, double xoffset, double yoffset, Operation<Void> original) {
        if (NoWheelConfig.get().getDisableContext() == NoWheelConfig.Context.ALL) {
            if (NoWheelConfig.get().getDisabledDirection().isHoriz()) xoffset = 0;
            if (NoWheelConfig.get().getDisabledDirection().isVert()) yoffset = 0;
        }

        original.call(handle, xoffset, yoffset);
    }

    @WrapOperation(method = "onScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/ScrollWheelHandler;onMouseScroll(DD)Lorg/joml/Vector2i;"))
    public Vector2i disableGameplayScroll(ScrollWheelHandler instance, double scaledXScrollOffset, double scaledYScrollOffset, Operation<Vector2i> original, @Share("fixedVec") LocalRef<Vector2i> fixedVecRef) {
        Vector2i vec = original.call(instance, scaledXScrollOffset, scaledYScrollOffset);
        if (NoWheelConfig.get().getDisabledDirection().isHoriz()) vec.x = 0;
        if (NoWheelConfig.get().getDisabledDirection().isVert()) vec.y = 0;

        if (NoWheelConfig.get().getDisableContext() == NoWheelConfig.Context.GAMEPLAY) {
            return vec;
        } else {
            fixedVecRef.set(vec);
            return original.call(instance, scaledXScrollOffset, scaledYScrollOffset);
        }
    }

    @ModifyArg(method = "onScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/ScrollWheelHandler;getNextScrollWheelSelection(DII)I"))
    public double onHotbarScroll(double wheel, @Share("fixedVec") LocalRef<Vector2i> fixedVecRef) {
        if (NoWheelConfig.get().getDisableContext() == NoWheelConfig.Context.HOTBAR) {
            Vector2i wheelXY = fixedVecRef.get();
            wheel = wheelXY.y == 0 ? -wheelXY.x : wheelXY.y;
        }

        return wheel;
    }
}
