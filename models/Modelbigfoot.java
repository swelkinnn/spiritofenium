// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelbigfoot extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modelbigfoot() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -5.8333F, -3.0F);
		setRotationAngle(Head, 0.0436F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -4.1667F, -1.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(40, 27).addBox(-4.0F, -4.1667F, -2.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(40, 31).addBox(-4.0F, 1.8333F, -2.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 5.0F, -1.25F);
		Body.setTextureOffset(0, 16).addBox(-4.0F, -7.0F, -0.75F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(36, 18).addBox(-4.0F, -3.0F, -1.75F, 8.0F, 8.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-6.0F, 5.0F, 0.0F);
		RightArm.setTextureOffset(36, 38).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(6.0F, 5.0F, 0.0F);
		LeftArm.setTextureOffset(32, 0).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, 17.0F, 0.0F);
		RightLeg.setTextureOffset(0, 32).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(2.0F, 17.0F, 0.0F);
		LeftLeg.setTextureOffset(24, 24).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}