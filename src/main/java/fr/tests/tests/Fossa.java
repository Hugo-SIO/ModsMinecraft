package fr.tests.tests;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Vector3f;

public class Fossa extends SinglePartEntityModel<FossaEntity> {
    private Animation currentAnimation;
    private final ModelPart tete;
    private final ModelPart corps;
    private final ModelPart PatteavantGauche;
    private final ModelPart PatteavantDroite;
    private final ModelPart PattearriereGauche;
    private final ModelPart PattearriereDroite;
    private final ModelPart queue;
    private final ModelPart queue2;
    private final ModelPart queue3;
    private final ModelPart root;
    public Fossa(ModelPart root) {
        this.tete = root.getChild("tete");
        this.corps = root.getChild("corps");
        this.PatteavantGauche = root.getChild("PatteavantGauche");
        this.PatteavantDroite = root.getChild("PatteavantDroite");
        this.PattearriereGauche = root.getChild("PattearriereGauche");
        this.PattearriereDroite = root.getChild("PattearriereDroite");
        this.queue = root.getChild("queue");
        this.queue2 = root.getChild("queue2");
        this.queue3 = root.getChild("queue3");
        this.root = root;

        this.currentAnimation = FossaAnimation.animation;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData tete = modelPartData.addChild("tete", ModelPartBuilder.create().uv(40, 49).cuboid(-4.0F, -11.0F, -10.0F, 7.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 59).cuboid(-3.0F, -9.0F, -14.0F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(1.0F, -12.0F, -6.0F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F))
                .uv(-2, 2).cuboid(-5.0F, -12.0F, -6.0F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData corps = modelPartData.addChild("corps", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -12.0F, -4.0F, 7.0F, 7.0F, 23.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData PatteavantGauche = modelPartData.addChild("PatteavantGauche", ModelPartBuilder.create().uv(0, 30).cuboid(-1.5F, -6.0F, -3.5F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, 18.0F, 1.5F));

        ModelPartData PatteavantDroite = modelPartData.addChild("PatteavantDroite", ModelPartBuilder.create().uv(20, 30).cuboid(-1.5F, -6.0F, -3.5F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, 18.0F, 1.5F));

        ModelPartData PattearriereGauche = modelPartData.addChild("PattearriereGauche", ModelPartBuilder.create().uv(20, 49).cuboid(-1.5F, -6.0F, -3.5F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, 18.0F, 12.5F));

        ModelPartData PattearriereDroite = modelPartData.addChild("PattearriereDroite", ModelPartBuilder.create().uv(40, 30).cuboid(-1.5F, -6.0F, -3.5F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, 18.0F, 12.5F));

        ModelPartData queue = modelPartData.addChild("queue", ModelPartBuilder.create().uv(60, 0).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.8623F, 21.4465F));

        ModelPartData queue2 = modelPartData.addChild("queue2", ModelPartBuilder.create().uv(0, 50).cuboid(-1.0F, 0.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 11.5745F, 26.939F));

        ModelPartData queue3 = modelPartData.addChild("queue3", ModelPartBuilder.create().uv(60, 8).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.2866F, 32.4314F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    private float animationTick = 0f; // compteur interne
    private boolean isAnimating = false;
    private boolean loopAnimation = true; // mettre à true si tu veux que ça boucle


    public void startAnimation(Animation animation, boolean loop) {
        this.currentAnimation = animation;
        this.animationTick = 0f;
        this.isAnimating = true;
        this.loopAnimation = loop;
    }

    @Override
    public void setAngles(FossaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Remise à zéro des rotations de base
        tete.pitch = 0;
        tete.yaw = 0;
        tete.roll = 0;
        PatteavantGauche.pitch = 0;
        PatteavantDroite.pitch = 0;
        PattearriereGauche.pitch = 0;
        PattearriereDroite.pitch = 0;
        queue.pitch = 0;
        queue2.pitch = 0;
        queue3.pitch = 0;

        // Appliquer les mouvements de tête manuellement
        tete.pitch = headPitch * ((float)Math.PI / 180F);
        tete.yaw = netHeadYaw * ((float)Math.PI / 180F);

        // Animation des pattes uniquement si le Fossa bouge
        if (limbSwingAmount > 0.1F) {
            if (!isAnimating) {
                startAnimation(FossaAnimation.animation, true);
            }
        } else if (isAnimating) {
            if (animationTick >= 1.3636F) {
                stopAnimation();
            }
        }

        if (currentAnimation != null && isAnimating) {
            // Sauvegarde les rotations de la tête
            float savedPitch = tete.pitch;
            float savedYaw = tete.yaw;
            float savedRoll = tete.roll;

            AnimationHelper.animate(this, currentAnimation, (long) animationTick, limbSwing, new Vector3f(headPitch, netHeadYaw, 0.0F));
            animationTick += 0.05F;
            // Restaure les rotations de la tête
            tete.pitch = savedPitch;
            tete.yaw = savedYaw;
            tete.roll = savedRoll;
        }
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        tete.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        corps.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        PatteavantGauche.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        PatteavantDroite.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        PattearriereGauche.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        PattearriereDroite.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        queue.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        queue2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        queue3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
    public void stopAnimation() {
        this.isAnimating = false;
        this.currentAnimation = null;
    }
}