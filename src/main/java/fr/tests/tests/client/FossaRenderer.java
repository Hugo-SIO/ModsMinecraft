package fr.tests.tests.client;

import fr.tests.tests.FossaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FossaRenderer extends MobEntityRenderer<FossaEntity, fr.tests.tests.Fossa> {

    private static final Identifier TEXTURE = new Identifier("tests", "textures/entity/fossa.png");

    public FossaRenderer(EntityRendererFactory.Context context) {
        super(context, new fr.tests.tests.Fossa(createModelPart()), 1.0f);

    }

    private static ModelPart createModelPart() {
        return fr.tests.tests.Fossa.getTexturedModelData().createModel();
    }

    @Override
    public Identifier getTexture(FossaEntity entity) {
        return TEXTURE;
    }




    @Override
    protected void scale(FossaEntity entity, net.minecraft.client.util.math.MatrixStack matrices, float tickDelta) {
        float scale = entity.isBaby() ? 0.5f : 1.0f; // 50% pour bébé, 100% pour adulte
        matrices.scale(scale, scale, scale);
        super.scale(entity, matrices, tickDelta);
    }
}
