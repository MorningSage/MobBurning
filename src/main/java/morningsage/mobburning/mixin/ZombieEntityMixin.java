package morningsage.mobburning.mixin;

import morningsage.mobburning.MobBurning;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin {

    @Inject(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/mob/ZombieEntity;setOnFireFor(I)V"
        ),
        method = "tickMovement",
        cancellable = true
    )
    public void setOnFireFor(CallbackInfo info) {
        MobBurning.LOGGER.info("Killing Zombie-like entity.  They were trying to see what happens when the sun comes up, but then it dawned on them.");
        ((Entity) (Object) this).kill();
        info.cancel();
    }

}
