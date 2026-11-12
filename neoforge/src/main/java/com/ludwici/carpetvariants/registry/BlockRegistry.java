package com.ludwici.carpetvariants.registry;
import com.ludwici.carpetscore.CarpetsCore;
import com.ludwici.carpetscore.api.block.CarpetVariantBlock;
import com.ludwici.carpetvariants.CarpetVariantsMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CarpetVariantsMod.MODID);

    public static final DeferredBlock<Block> WHITE_CARPET_VARIANT = registerCarpet("white", Blocks.CARPET.white());
    public static final DeferredBlock<Block> ORANGE_CARPET_VARIANT = registerCarpet("orange", Blocks.CARPET.orange());
    public static final DeferredBlock<Block> MAGENTA_CARPET_VARIANT = registerCarpet("magenta", Blocks.CARPET.magenta());
    public static final DeferredBlock<Block> LIGHT_BLUE_CARPET_VARIANT = registerCarpet("light_blue", Blocks.CARPET.lightBlue());
    public static final DeferredBlock<Block> YELLOW_CARPET_VARIANT = registerCarpet("yellow", Blocks.CARPET.yellow());
    public static final DeferredBlock<Block> LIME_CARPET_VARIANT = registerCarpet("lime", Blocks.CARPET.lime());
    public static final DeferredBlock<Block> PINK_CARPET_VARIANT = registerCarpet("pink", Blocks.CARPET.pink());
    public static final DeferredBlock<Block> GRAY_CARPET_VARIANT = registerCarpet("gray", Blocks.CARPET.gray());
    public static final DeferredBlock<Block> LIGHT_GRAY_CARPET_VARIANT = registerCarpet("light_gray", Blocks.CARPET.lightGray());
    public static final DeferredBlock<Block> CYAN_CARPET_VARIANT = registerCarpet("cyan", Blocks.CARPET.cyan());
    public static final DeferredBlock<Block> PURPLE_CARPET_VARIANT = registerCarpet("purple", Blocks.CARPET.purple());
    public static final DeferredBlock<Block> BLUE_CARPET_VARIANT = registerCarpet("blue", Blocks.CARPET.blue());
    public static final DeferredBlock<Block> BROWN_CARPET_VARIANT = registerCarpet("brown", Blocks.CARPET.brown());
    public static final DeferredBlock<Block> GREEN_CARPET_VARIANT = registerCarpet("green", Blocks.CARPET.green());
    public static final DeferredBlock<Block> RED_CARPET_VARIANT = registerCarpet("red", Blocks.CARPET.red());
    public static final DeferredBlock<Block> BLACK_CARPET_VARIANT = registerCarpet("black", Blocks.CARPET.black());
    public static final DeferredBlock<Block> MOSS_CARPET_VARIANT = registerCarpet("moss", Blocks.MOSS_CARPET);

    private static DeferredBlock<Block> registerCarpet(String name, Block orig) {
        String identifier = name + "_carpet_variant";
        DeferredBlock<Block> ret = BLOCKS.register(identifier, () -> new CarpetVariantBlock(orig.asItem(), BlockBehaviour.Properties.ofFullCopy(orig).pushReaction(PushReaction.DESTROY).overrideDescription(orig.getDescriptionId()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CarpetVariantsMod.MODID, identifier)))));
        CarpetsCore.register(name + "_carpet", ret);
        return ret;
    }
}
