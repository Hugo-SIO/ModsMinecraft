package fr.tests.tests;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;

public class ClimbTreeGoal extends Goal {
    private final PathAwareEntity entity;

    public ClimbTreeGoal(PathAwareEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean canStart() {
        if (entity.getWorld() == null) return false; // sécurité
        BlockPos posAbove = entity.getBlockPos().up();
        return !entity.getWorld().getBlockState(posAbove).isAir();
    }

    @Override
    public void tick() {
        if (entity.getWorld() != null) { // sécurité
            entity.setVelocity(entity.getVelocity().x, 0.3, entity.getVelocity().z);
        }
    }
}
