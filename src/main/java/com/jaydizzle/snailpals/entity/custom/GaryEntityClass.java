package com.jaydizzle.snailpals.entity.custom;

import com.jaydizzle.snailpals.entity.JDEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.scores.Team;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class GaryEntityClass extends TamableAnimal implements IAnimatable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(GaryEntityClass.class, EntityDataSerializers.BOOLEAN);

    public GaryEntityClass(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.075f).build();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();

        Item itemForTaming = Items.BROWN_MUSHROOM;

        if(isFood(itemstack)) {
            return super.mobInteract(player, hand);
        }
        if (item == itemForTaming && !isTame()) {
            if (this.level.isClientSide) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                if (!ForgeEventFactory.onAnimalTame(this, player)) {
                    if (!this.level.isClientSide) {
                        super.tame(player);
                        this.navigation.recomputePath();
                        this.setTarget(null);
                        this.level.broadcastEntityEvent(this, (byte)7);
                        setSitting(true);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        if(isTame() && !this.level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            setSitting(!isSitting());
            return InteractionResult.SUCCESS;
        }
        if (itemstack.getItem() == itemForTaming) {
            return InteractionResult.PASS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.5D));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.5D, 4.0F, 2.0F, false));
        this.goalSelector.addGoal(5, new TemptGoal(this, 2.0D, Ingredient.of(Items.BROWN_MUSHROOM), false));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.snail.walk", true));
            return PlayState.CONTINUE;
        }
        if (this.isSitting()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.snail.sitting", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.snail.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers (AnimationData data){
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory () {
        return factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.BEEHIVE_WORK, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CAT_STRAY_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.CAT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CAT_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        GaryEntityClass baby = JDEntityTypes.GARY.get().create(level);
        return baby;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.getItem() == Items.SWEET_BERRIES;
    }

    @Override
    public float getStepHeight() {
        return 1.0F;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setSitting(pCompound.getBoolean("isSitting"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("isSitting", this.isSitting());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SITTING, false);
    }

    public void setSitting(boolean sitting) {
        this.entityData.set(SITTING, sitting);
        this.setOrderedToSit(sitting);
    }

    public boolean isSitting() {
        return this.entityData.get(SITTING);
    }

    @Override
    public Team getTeam() {
        return super.getTeam();
    }

    @Override
    public boolean canBeLeashed(Player pPlayer) {
        return false;
    }

    @Override
    public void setTame(boolean tamed) {
        super.setTame(tamed);
        if (tamed) {
            getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
            getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.15D);

        } else {
            getAttribute(Attributes.MAX_HEALTH).setBaseValue(6.0D);
            getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.075D);

        }
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
                                        MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData,
                                        @Nullable CompoundTag pDataTag) {
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }


    public static boolean canSpawn(EntityType<GaryEntityClass> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return checkAnimalSpawnRules(entityType, level, spawnType, pos, random) && level.getBlockState(pos).is(Blocks.GRASS_BLOCK);
    }
}