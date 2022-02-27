package morningsage.mobburning.mixin;

import morningsage.mobburning.MobBurning;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSkeletonEntity.class)
public class AbstractSkeletonEntityMixin {

    @Inject(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/mob/AbstractSkeletonEntity;setOnFireFor(I)V"
        ),
        method = "tickMovement",
        cancellable = true
    )
    public void setOnFireFor(CallbackInfo info) {
        MobBurning.LOGGER.info("Killing Skeleton-like entity due to sun damage");
        ((Entity) (Object) this).kill();
        info.cancel();
    }

}
