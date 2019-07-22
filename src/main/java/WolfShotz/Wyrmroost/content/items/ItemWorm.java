package WolfShotz.Wyrmroost.content.items;

import WolfShotz.Wyrmroost.util.ModUtils;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class ItemWorm extends Item
{
    public ItemWorm() {
        super(ModUtils.itemBuilder());
        setRegistryName("desertwyrm");

        addPropertyOverride(ModUtils.location("isalive"), (item, world, player) -> {
            if (item.hasTag()) if (item.getTag().getBoolean("isalive")) return 1f;
            return 0f;
        });
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity player, int itemSlot, boolean isSelected) {
        if (stack.hasTag())
            if (stack.getTag().getBoolean("isalive") && isSelected && new Random().nextInt(60) == 0)
                worldIn.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_COW_HURT, SoundCategory.NEUTRAL, 1.0f, 5f, false);
    }
}