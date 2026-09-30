package me.nova1733.usefulEchoShards.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import me.nova1733.usefulEchoShards.client.datagen.UsefulEchoShardsItemTagProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Repairable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Repairable.class)
public class RepairableMixin {

    @ModifyReturnValue(method = "isValidRepairItem", at = @At("RETURN"))
    private boolean addUniversalRepairIngredientsTag(boolean original, ItemStack repairItemStack) {
        return original || repairItemStack.is(UsefulEchoShardsItemTagProvider.UNIVERSAL_REPAIR_INGREDIENTS);
    }
}
