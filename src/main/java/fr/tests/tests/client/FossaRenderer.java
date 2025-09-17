package fr.tests.tests.client;

import fr.tests.tests.FossaEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.CatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class FossaRenderer extends MobEntityRenderer<FossaEntity, CatEntityModel<FossaEntity>> {

    public FossaRenderer(EntityRendererFactory.Context context) {
        super(context, new CatEntityModel<>(context.getPart(EntityModelLayers.CAT)), 0.5f);
    }

    @Override
    public Identifier getTexture(FossaEntity entity) {
        return new Identifier("minecraft", "textures/entity/fossa.png"); // tu peux mettre ta texture custom ici
    }
}
