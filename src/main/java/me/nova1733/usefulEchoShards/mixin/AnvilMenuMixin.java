package me.nova1733.usefulEchoShards.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.nova1733.usefulEchoShards.client.datagen.UsefulEchoShardsItemTagProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {

    public AnvilMenuMixin(@Nullable MenuType<?> menuType, int containerId, Inventory inventory,
                          ContainerLevelAccess access, ItemCombinerMenuSlotDefinition itemInputSlots) {
        super(menuType, containerId, inventory, access, itemInputSlots);
    }

    @WrapOperation(
            method = "createResult",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/AnvilMenu;calculateIncreasedRepairCost(I)I")
    )
    private int addSkipsIncreasedRepairCostTag(int baseCost, Operation<Integer> original) {
        ItemStack additional = inputSlots.getItem(AnvilMenu.ADDITIONAL_SLOT);
        return additional.is(UsefulEchoShardsItemTagProvider.SKIPS_REPAIR_COST_INCREASE) ? baseCost : original.call(baseCost);
    }
}
