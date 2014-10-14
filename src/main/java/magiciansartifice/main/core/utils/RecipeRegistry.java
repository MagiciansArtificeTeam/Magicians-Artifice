package magiciansartifice.main.core.utils;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.api.modifiers.BasicWandStick;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.items.magicalitems.wand.ItemModularWand;
import magiciansartifice.main.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.main.tileentities.recipes.RecipesMetalForge;
import magiciansartifice.main.tileentities.recipes.RecipesMysticAnvil;
import magiciansartifice.main.tileentities.recipes.RecipesWandCarver;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tconstruct.TConstruct;
import tconstruct.tools.blocks.CraftingStationBlock;

public class RecipeRegistry
{
    private static void registerItems() {
        //book
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.book, 1), new ItemStack(ItemRegistry.dustsMeta, 1, 0), new ItemStack(Items.book, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.advBook,1),new ItemStack(ItemRegistry.dustsMeta,1,1), new ItemStack(Items.book,1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ritualBook,1), new ItemStack(ItemRegistry.ritualCatalyst), new ItemStack(Items.book,1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.spellBook,1), new ItemStack(ItemRegistry.magiciansWand,1), new ItemStack(Items.book,1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.unforgivableBook,1),new ItemStack(ItemRegistry.book,1), new ItemStack(ItemRegistry.dustsMeta,1,2));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.darkestBook,1),new ItemStack(ItemRegistry.advBook,1), new ItemStack(ItemRegistry.spiderFang,1));

        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.merlinLetter,1),new ItemStack(Items.book), new ItemStack(Items.ender_eye));

        //magical items
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ritualCatalyst), "CC ", " CDC", " CC", 'C', Blocks.cobblestone, 'D', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.horcrux), "EeE", "eDe", "EeE", 'E', "dustEnderPearl",'e',new ItemStack(BlockRegistry.storage,1,2),'D', "gemDiamond"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.horcrux), "EeE", "eDe", "EeE", 'E', Items.ender_eye,'e',new ItemStack(BlockRegistry.storage,1,2),'D', "gemDiamond"));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.spiderFang), ItemRegistry.horcrux, ItemRegistry.spiderFang);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.chiselTool), "I", "S", 'I', "ingotIron", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.netherChisel), "D", "I", "S", 'I', "ingotIron", 'S', "stickWood",'D',new ItemStack(ItemRegistry.dustsMeta,1,1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.enderChisel), "D", "I", "S", 'I', "gemDiamond", 'S', "stickWood",'D',new ItemStack(ItemRegistry.dustsMeta,1,2)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.treeMutation), "NON","OBO","NON",'N', new ItemStack(ItemRegistry.dustsMeta,1,1),'O',new ItemStack(ItemRegistry.dustsMeta,1,0),'B',"dyeWhite"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.blankCore),"SO","N ",'S',"slimeball",'O',new ItemStack(ItemRegistry.dustsMeta,1,0),'N',new ItemStack(ItemRegistry.dustsMeta,1,1)));

        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.orchidPetal),BlockRegistry.angelOrchid);

        //storage blocks to ingots
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.dustsMeta, 9, 0), new ItemStack(BlockRegistry.storage, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.dustsMeta, 9, 1), new ItemStack(BlockRegistry.storage, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.dustsMeta, 9, 2), new ItemStack(BlockRegistry.storage, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ingotsMeta, 9, 0), new ItemStack(BlockRegistry.storage, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ingotsMeta, 9, 1), new ItemStack(BlockRegistry.storage, 1, 4));

        //tool recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelSword), "X", "X", "S", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelShovel), "X", "S", "S", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelPick), "XXX", " S ", " S ", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelAxe), "XX ", "XS ", " S ", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelHoe), "XX ", " S ", " S ", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelSword), "X", "X", "S", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelShovel), "X", "S", "S", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelPick), "XXX", " S ", " S ", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelAxe), "XX ", "XS ", " S ", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelHoe), "XX ", " S ", " S ", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.beastClawsCore), "XCX", "CDC", "XCX", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0), 'C', Items.iron_ingot, 'D', Items.diamond);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.beastClaws), "CCC", " OC", "   ", 'O', ItemRegistry.beastClawsCore, 'C', ItemRegistry.beastClawsClaw);

        //dye recipes
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 0), "O  ", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 1), " O ", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 2), "  O", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 3), "   ", "O  ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 4), "O O", " O ", "O O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 5), "   ", "  O", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 6), "   ", "   ", "O  ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 7), "   ", "   ", " O ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 8), "   ", "   ", "  O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 9), "  O", "   ", "  O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 10), "   ", " O ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 11), "O O", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 12), "   ", "O O", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 13), "   ", "   ", "O O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 14), "O  ", "   ", "O  ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 15), "O O", "   ", "O O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));

    }

    private static void registerBlocks() {
        //machines
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.mysticAnvil), "WWW", "IAI", "III", 'W', new ItemStack(Blocks.wool, 1, 14), 'A', Blocks.anvil, 'I', Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.metalForge, 8), "BBB", "BIB", "BBB", 'B', Blocks.stonebrick, 'I', Blocks.iron_block);
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.wandCarver), " GS", " OS", "SSS", 'G', Blocks.glass, 'S', new ItemStack(Blocks.stone_slab, 1, 0), 'O', ItemRegistry.dustsMeta);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.wandMaker),"LI"," I","CW",'L',Blocks.redstone_lamp,'I',Blocks.iron_bars,'C',"craftingTableWood",'W',"plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.wandMaker),"LI"," I","CW",'L',Blocks.redstone_lamp,'I',Blocks.iron_bars,'C',"crafterWood",'W',"plankWood"));

        //magical blocks
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.ritualCornerStone), "CDC", "DRD", "CDC", 'C', BlockRegistry.containmentRing, 'D', ItemRegistry.dustsMeta, 'R', Blocks.redstone_block );
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.containmentCornerstone), "OOO", "ONO", "OOO", 'O', BlockRegistry.containmentRing, 'N', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.containmentTop, 4), "OOO", "ONO", "ONO", 'O', BlockRegistry.containmentRing, 'N', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.containmentPillar, 4), "ONO", "ONO", "ONO", 'O', BlockRegistry.containmentRing, 'N', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.containmentRing), new ItemStack(Blocks.obsidian), new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        
        //ingots to storage blocks
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 0), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 1), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 2), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 3), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.storage, 1, 4), "XXX", "XXX", "XXX", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.potatoBlock,1),"XXX","XXX","XXX",'X',Items.potato);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.potato, 9), BlockRegistry.potatoBlock);

        for (int i = 0; i < 4; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.planks, 4,i),new ItemStack(BlockRegistry.logs,1,i));
            GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.sticksMeta,4,i), "W","W",'W',new ItemStack(BlockRegistry.planks,1,i));
        }
    }

    private static void registerMachines() {
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Items.iron_ingot), "molten.iron", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.iron_block), "molten.iron", TileEntityMetalForge.BLOCK_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Items.coal, 1, 0), "gaseous.carbon", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Items.coal, 1, 1), "gaseous.carbon", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.coal_block), "gaseous.carbon", TileEntityMetalForge.BLOCK_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(BlockRegistry.oresOres, 1, 0), "molten.star.steel", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(ItemRegistry.ingotsMeta, 1, 1), "molten.steel", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(BlockRegistry.storage, 1, 4), "molten.steel", TileEntityMetalForge.BLOCK_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.iron_ore), "molten.iron", TileEntityMetalForge.INGOT_MB * 2);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.gold_ore), "molten.gold", TileEntityMetalForge.INGOT_MB * 2);

        RecipesMetalForge.addRecipe("molten.iron", TileEntityMetalForge.INGOT_MB, "gaseous.carbon", TileEntityMetalForge.INGOT_MB, new ItemStack(ItemRegistry.ingotsMeta, 1, 1));
        RecipesMetalForge.addRecipe("molten.steel", TileEntityMetalForge.INGOT_MB, "molten.star.steel", TileEntityMetalForge.INGOT_MB, new ItemStack(ItemRegistry.ingotsMeta, 1, 0));

        // START DEPRECATION

        RecipesWandCarver.addRecipe(new ItemStack(ItemRegistry.magiciansWand), new ItemStack(ItemRegistry.chiselTool,1,OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.log, 1, 0), 100);
        RecipesWandCarver.addRecipe( new ItemStack(ItemRegistry.magiciansWand2), new ItemStack(ItemRegistry.netherChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(BlockRegistry.logs,1,0),200);
        RecipesWandCarver.addRecipe( new ItemStack(ItemRegistry.magiciansWand3), new ItemStack(ItemRegistry.enderChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(BlockRegistry.logs,1,2),400);

        // END DEPRECATION

        RecipesWandCarver.addRecipe(new ItemStack(BlockRegistry.logs,1,0), new ItemStack(ItemRegistry.netherChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.ashHandle),400);
        RecipesWandCarver.addRecipe(new ItemStack(BlockRegistry.logs,1,1), new ItemStack(ItemRegistry.netherChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.elmHandle),400);
        RecipesWandCarver.addRecipe(new ItemStack(BlockRegistry.logs,1,2), new ItemStack(ItemRegistry.netherChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.rowanHandle),400);
        RecipesWandCarver.addRecipe(new ItemStack(BlockRegistry.logs,1,3), new ItemStack(ItemRegistry.netherChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.alderHandle),400);

        RecipesWandCarver.addRecipe(new ItemStack(ItemRegistry.sticksMeta,1,0), new ItemStack(ItemRegistry.chiselTool,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.ashStick),200);
        RecipesWandCarver.addRecipe(new ItemStack(ItemRegistry.sticksMeta,1,1), new ItemStack(ItemRegistry.chiselTool,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.elmStick),200);
        RecipesWandCarver.addRecipe(new ItemStack(ItemRegistry.sticksMeta,1,2), new ItemStack(ItemRegistry.chiselTool,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.rowanStick),200);
        RecipesWandCarver.addRecipe(new ItemStack(ItemRegistry.sticksMeta,1,3), new ItemStack(ItemRegistry.chiselTool,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.alderStick),200);


        RecipesMysticAnvil.addRecipe(new ItemStack(ItemRegistry.ingotsMeta, 1, 2), new ItemStack(ItemRegistry.dustsMeta, 0, 0), new ItemStack(ItemRegistry.steelplate), 100);

        RecipesMysticAnvil.addRecipe(new ItemStack(ItemRegistry.blankCore), new ItemStack(ItemRegistry.orchidPetal), new ItemStack(ItemRegistry.orchidCore), 200);
        RecipesMysticAnvil.addRecipe(new ItemStack(ItemRegistry.blankCore), new ItemStack(Items.ender_eye), new ItemStack(ItemRegistry.enderCore), 400);
        RecipesMysticAnvil.addRecipe(new ItemStack(ItemRegistry.blankCore), new ItemStack(ItemRegistry.angelFeather), new ItemStack(ItemRegistry.angelCore), 400);
        //RecipesMysticAnvil.addRecipe(new ItemStack(ItemRegistry.blankCore), new ItemStack(BlockRegistry.angelOrchid), new ItemStack(ItemRegistry.angelCore), 500);
    }

    public static void registerModRecipes() {
        registerItems();
        registerBlocks();
        registerMachines();
    }

    @SubscribeEvent
    public void onCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() instanceof ItemModularWand) {
            if (!event.player.isSneaking()) {
                NBTTagCompound nbt = new NBTTagCompound();
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                if (event.craftMatrix.getStackInSlot(i) != null) {
                    for (int ore = 0; ore < OreDictionary.getOres("wandStick").size(); ore++) {
                        if (OreDictionary.getOres("wandStick").get(ore).getItem().equals(event.craftMatrix.getStackInSlot(i).getItem())) {
                            nbt.setString("wandStick", event.craftMatrix.getStackInSlot(i).getItem().getUnlocalizedName());
                            System.err.println(nbt.getString("wandStick"));
                        }
                    }
                    for (int ore = 0; ore < OreDictionary.getOres("wandHandle").size(); ore++) {
                        if (OreDictionary.getOres("wandHandle").get(ore).getItem().equals(event.craftMatrix.getStackInSlot(i).getItem())) {
                            nbt.setString("wandHandle", event.craftMatrix.getStackInSlot(i).getItem().getUnlocalizedName());
                            System.err.println(nbt.getString("wandHandle"));
                        }
                    }
                    for (int ore = 0; ore < OreDictionary.getOres("wandCore").size(); ore++) {
                        if (OreDictionary.getOres("wandCore").get(ore).getItem().equals(event.craftMatrix.getStackInSlot(i).getItem())) {
                            nbt.setString("wandCore", event.craftMatrix.getStackInSlot(i).getItem().getUnlocalizedName());
                            System.err.println(nbt.getString("wandCore"));
                        }
                    }
                }
            }
            event.crafting.setTagCompound(nbt);
            System.err.println("");
            System.err.println(event.crafting.stackTagCompound.getString("wandStick"));
            System.err.println(event.crafting.stackTagCompound.getString("wandCore"));
            System.err.println(event.crafting.stackTagCompound.getString("wandHandle"));
        } else {
                for (int i = 0; i < event.craftMatrix.getSizeInventory();i++) {
                    if (event.craftMatrix.getStackInSlot(i) != null) {
                        if (event.player.inventory.getFirstEmptyStack() != -1) {
                            event.player.inventory.setInventorySlotContents(event.player.inventory.getFirstEmptyStack(),event.craftMatrix.getStackInSlot(i));
                        } else {
                            event.player.entityDropItem(event.craftMatrix.getStackInSlot(i),0.0F);
                        }
                    }
                }
            }
        }
    }

}