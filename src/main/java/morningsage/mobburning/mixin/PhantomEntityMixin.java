package morningsage.mobburning.mixin;

import morningsage.mobburning.MobBurning;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.PhantomEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PhantomEntity.class)
public class PhantomEntityMixin {

	@Inject(
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/entity/mob/PhantomEntity;setOnFireFor(I)V"
		),
		method = "tickMovement",
		cancellable = true
	)
	public void setOnFireFor(CallbackInfo info) {
		MobBurning.LOGGER.info("Killing Phantom entity due to having one massive sunburn");
		((Entity) (Object) this).kill();
		info.cancel();
	}

}
