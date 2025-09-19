package fr.tests.tests;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.damage.DamageSource;

public class FossaEntity extends AnimalEntity {

    public FossaEntity(EntityType<? extends AnimalEntity> type, World world) {
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
        this.goalSelector.add(4, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(5, new ClimbTreeGoal(this));
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

    // Définir quel item sert à la reproduction
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.WHEAT; // ici, le blé
    }

    // Créer l’enfant
    @Override
    public FossaEntity createChild(ServerWorld world, PassiveEntity mate) {
        FossaEntity child = ModEntities.FOSSA.create(world); // ton enregistrement d’entité
        if(child != null){
            child.setBaby(true);
        }
        return child;
    }
}
