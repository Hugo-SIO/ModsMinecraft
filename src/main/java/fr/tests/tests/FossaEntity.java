package fr.tests.tests;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.entity.damage.DamageSource;

public class FossaEntity extends CatEntity {
    public FossaEntity(EntityType<? extends CatEntity> type, World world) {
        super(type, world);
    }

    // Attributs (vie, vitesse, dégâts)
    public static DefaultAttributeContainer.Builder createFossaAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.3, true));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new ClimbTreeGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, CowEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, SheepEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PigEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        this.dropItem(Items.LEATHER);
    }

    public boolean canClimb() {
        return true; // utile si tu veux qu’il grimpe comme un chat
    }
}
