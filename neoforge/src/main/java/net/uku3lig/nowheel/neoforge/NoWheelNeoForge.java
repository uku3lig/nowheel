package net.uku3lig.nowheel.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.uku3lig.nowheel.config.UkulibHook;
import net.uku3lig.ukulib.neoforge.UkulibNFProvider;

@Mod(value = "nowheel", dist = Dist.CLIENT)
public class NoWheelNeoForge {
    public NoWheelNeoForge(ModContainer container) {
        container.registerExtensionPoint(UkulibNFProvider.class, UkulibHook::new);
    }
}
