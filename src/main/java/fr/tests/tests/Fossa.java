package fr.tests.tests;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Fossa extends EntityModel<FossaEntity> {
    private final ModelPart tete;
    private final ModelPart corps;
    private final ModelPart PatteavantGauche;
    private final ModelPart PatteavantDroite;
    private final ModelPart PattearriereGauche;
    private final ModelPart PattearriereDroite;
    private final ModelPart queue;
    public Fossa(ModelPart root) {
        this.tete = root.getChild("tete");
        this.corps = root.getChild("corps");
        this.PatteavantGauche = root.getChild("PatteavantGauche");
        this.PatteavantDroite = root.getChild("PatteavantDroite");
        this.PattearriereGauche = root.getChild("PattearriereGauche");
        this.PattearriereDroite = root.getChild("PattearriereDroite");
        this.queue = root.getChild("queue");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData tete = modelPartData.addChild("tete", ModelPartBuilder.create().uv(40, 49).cuboid(-4.0F, -11.0F, -10.0F, 7.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 59).cuboid(-3.0F, -9.0F, -14.0F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(1.0F, -12.0F, -6.0F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F))
                .uv(-2, 2).cuboid(-5.0F, -12.0F, -6.0F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData corps = modelPartData.addChild("corps", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -12.0F, -4.0F, 7.0F, 7.0F, 23.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData PatteavantGauche = modelPartData.addChild("PatteavantGauche", ModelPartBuilder.create().uv(0, 30).cuboid(2.0F, -12.0F, -2.0F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData PatteavantDroite = modelPartData.addChild("PatteavantDroite", ModelPartBuilder.create().uv(20, 30).cuboid(-1.5F, -6.0F, -3.5F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, 18.0F, 1.5F));

        ModelPartData PattearriereGauche = modelPartData.addChild("PattearriereGauche", ModelPartBuilder.create().uv(20, 49).cuboid(2.0F, -12.0F, 9.0F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData PattearriereDroite = modelPartData.addChild("PattearriereDroite", ModelPartBuilder.create().uv(40, 30).cuboid(-6.0F, -12.0F, 9.0F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData queue = modelPartData.addChild("queue", ModelPartBuilder.create().uv(0, 50).cuboid(-1.0F, -11.0F, 24.0F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F))
                .uv(60, 0).cuboid(-1.0F, -11.0F, 19.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(60, 8).cuboid(-1.0F, -11.0F, 30.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(FossaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
    }
}