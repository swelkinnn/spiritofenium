// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelmirrormask1 extends EntityModel<Entity> {
	private final ModelRenderer helmet;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public Modelmirrormask1() {
		textureWidth = 32;
		textureHeight = 32;

		helmet = new ModelRenderer(this);
		helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		helmet.setTextureOffset(0, 9).addBox(-4.0F, -8.0F, -4.2F, 8.0F, 8.0F, 0.0F, 0.0F, false);
		helmet.setTextureOffset(0, 23).addBox(-4.0F, -4.0F, -4.1F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		helmet.setTextureOffset(0, 24).addBox(-2.0F, -9.0F, -5.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		helmet.setTextureOffset(28, 19).addBox(4.0F, -8.0F, -5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		helmet.setTextureOffset(0, 24).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		helmet.setTextureOffset(0, 24).addBox(-4.0F, 0.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		helmet.setTextureOffset(28, 20).addBox(-5.0F, -8.0F, -5.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(5.2336F, -9.6698F, -4.5F);
		helmet.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0873F);
		cube_r1.setTextureOffset(0, 24).addBox(-1.7336F, -1.8302F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(5.2336F, -9.6698F, -4.5F);
		helmet.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.9599F);
		cube_r2.setTextureOffset(0, 24).addBox(-0.7336F, -0.8302F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-3.0F, -7.5F, -4.5F);
		helmet.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.6109F);
		cube_r3.setTextureOffset(0, 24).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(4.5F, -3.5F, -4.5F);
		helmet.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.1309F);
		cube_r4.setTextureOffset(28, 19).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		helmet.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}