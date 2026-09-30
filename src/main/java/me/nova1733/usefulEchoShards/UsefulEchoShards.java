package me.nova1733.usefulEchoShards;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class UsefulEchoShards implements ModInitializer {
    public static final String MOD_ID = "useful-echo-shards";

    @Override
    public void onInitialize() {
        LootTableEvents.MODIFY.register((key, original, source, _) -> {
            if (source.isBuiltin() && key.equals(BuiltInLootTables.ANCIENT_CITY)) {
                LootPool.Builder pool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.ECHO_SHARD).setWeight(3))
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)));
                original.withPool(pool);
            }
        });
    }
}