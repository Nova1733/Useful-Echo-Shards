package me.nova1733.usefulEchoShards.client;

import me.nova1733.usefulEchoShards.client.datagen.UsefulEchoShardsItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class UsefulEchoShardsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(UsefulEchoShardsItemTagProvider::new);
    }
}
