package dev.turtywurty.tutorialmod.client.model;

import dev.turtywurty.tutorialmod.Constants;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;
import org.jspecify.annotations.NonNull;

public class ExampleEntityModel extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Constants.id("example_entity"), "main");

    private final ModelPart main;
    private final ModelPart body;
    private final ModelPart lid;
    private final ModelPart handle;
    private final ModelPart legs;
    private final ModelPart frontLegs;
    private final ModelPart frontLeft;
    private final ModelPart leg0;
    private final ModelPart frontRight;
    private final ModelPart leg1;
    private final ModelPart backLegs;
    private final ModelPart backRight;
    private final ModelPart leg2;
    private final ModelPart backLeft;
    private final ModelPart leg3;

    public ExampleEntityModel(ModelPart root) {
        super(root);
        this.main = root.getChild("main");
        this.body = this.main.getChild("body");
        this.lid = this.body.getChild("lid");
        this.handle = this.lid.getChild("handle");
        this.legs = this.main.getChild("legs");
        this.frontLegs = this.legs.getChild("frontLegs");
        this.frontLeft = this.frontLegs.getChild("frontLeft");
        this.leg0 = this.frontLeft.getChild("leg0");
        this.frontRight = this.frontLegs.getChild("frontRight");
        this.leg1 = this.frontRight.getChild("leg1");
        this.backLegs = this.legs.getChild("backLegs");
        this.backRight = this.backLegs.getChild("backRight");
        this.leg2 = this.backRight.getChild("leg2");
        this.backLeft = this.backLegs.getChild("backLeft");
        this.leg3 = this.backLeft.getChild("leg3");
    }

    public static LayerDefinition createBodyLayer() {
        var meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        PartDefinition main = root.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 11.5F, 0.0F));

        PartDefinition body = main.addOrReplaceChild(
                "body",
                CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -4.5F, -7.0F, 14.0F, 9.0F, 14.0F),
                PartPose.ZERO
        );

        PartDefinition lid = body.addOrReplaceChild(
                "lid",
                CubeListBuilder.create().texOffs(0, 24).addBox(-7.0F, -5.0F, -14.0F, 14.0F, 5.0F, 14.0F),
                PartPose.offset(0.0F, -4.5F, 7.0F)
        );

        lid.addOrReplaceChild(
                "handle",
                CubeListBuilder.create()
                        .texOffs(57, 9).addBox(-4.0F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F)
                        .texOffs(30, 52).addBox(3.0F, 0.5F, -2.0F, 2.0F, 1.0F, 4.0F)
                        .texOffs(0, 52).addBox(-3.0F, -1.5F, -1.0F, 6.0F, 1.0F, 2.0F)
                        .texOffs(9, 56).addBox(3.0F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F)
                        .texOffs(17, 52).addBox(-5.0F, 0.5F, -2.0F, 2.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, -6.5F, -7.0F)
        );

        PartDefinition legs = main.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 12.5F, 0.0F));
        PartDefinition frontLegs = legs.addOrReplaceChild("frontLegs", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -5.0F));

        PartDefinition frontLeft = frontLegs.addOrReplaceChild(
                "frontLeft",
                CubeListBuilder.create().texOffs(15, 44).addBox(-1.0F, 6.0F, -2.75F, 2.0F, 2.0F, 5.0F),
                PartPose.offset(5.0F, 0.0F, -0.25F)
        );
        frontLeft.addOrReplaceChild(
                "leg0",
                CubeListBuilder.create().texOffs(52, 52).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 0.25F)
        );

        PartDefinition frontRight = frontLegs.addOrReplaceChild(
                "frontRight",
                CubeListBuilder.create().texOffs(0, 44).addBox(-1.0F, 6.0F, -2.75F, 2.0F, 2.0F, 5.0F),
                PartPose.offset(-5.0F, 0.0F, -0.25F)
        );
        frontRight.addOrReplaceChild(
                "leg1",
                CubeListBuilder.create().texOffs(43, 52).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 0.25F)
        );

        PartDefinition backLegs = legs.addOrReplaceChild("backLegs", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 5.0F));

        PartDefinition backRight = backLegs.addOrReplaceChild(
                "backRight",
                CubeListBuilder.create().texOffs(30, 44).addBox(-1.0F, 6.0F, -2.75F, 2.0F, 2.0F, 5.0F),
                PartPose.offset(-5.0F, 0.0F, -0.25F)
        );
        backRight.addOrReplaceChild(
                "leg2",
                CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 0.25F)
        );

        PartDefinition backLeft = backLegs.addOrReplaceChild(
                "backLeft",
                CubeListBuilder.create().texOffs(45, 44).addBox(-1.0F, 6.0F, -2.75F, 2.0F, 2.0F, 5.0F),
                PartPose.offset(5.0F, 0.0F, -0.25F)
        );
        backLeft.addOrReplaceChild(
                "leg3",
                CubeListBuilder.create().texOffs(57, 0).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 6.0F, 0.25F)
        );

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(@NonNull LivingEntityRenderState state) {
        super.setupAnim(state);
        this.body.xRot = state.xRot * (float) (Math.PI / 180.0);
        this.body.yRot = state.yRot * (float) (Math.PI / 180.0);

        float walk = state.walkAnimationPos;
        float speed = state.walkAnimationSpeed;
        this.backRight.xRot = Mth.cos(walk * 0.6662F) * 1.4F * speed;
        this.backLeft.xRot = Mth.cos(walk * 0.6662F + (float) Math.PI) * 1.4F * speed;
        this.frontRight.xRot = Mth.cos(walk * 0.6662F + (float) Math.PI) * 1.4F * speed;
        this.frontLeft.xRot = Mth.cos(walk * 0.6662F) * 1.4F * speed;
    }
}