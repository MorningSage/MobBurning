package morningsage.mobburning;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobBurning implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(MobBurning.class);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Mobs will now die instantly when burning from the daylight.");
	}
}
