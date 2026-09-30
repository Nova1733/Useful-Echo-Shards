package me.nova1733.usefulEchoShards.client.datagen;

import me.nova1733.usefulEchoShards.UsefulEchoShards;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class UsefulEchoShardsItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> UNIVERSAL_REPAIR_INGREDIENTS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(UsefulEchoShards.MOD_ID, "universal_repair_ingredients"));
    public static final TagKey<Item> SKIPS_REPAIR_COST_INCREASE =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(UsefulEchoShards.MOD_ID, "skips_repair_cost_increase"));

    public UsefulEchoShardsItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(UNIVERSAL_REPAIR_INGREDIENTS).add(ItemIds.ECHO_SHARD);
        builder(SKIPS_REPAIR_COST_INCREASE).add(ItemIds.ECHO_SHARD);
    }
}
