public class AutoLeave extends Func {
    public AutoLeave() {
        super(FuncType.Test, "AutoLeave");
    }

    public Minecraft mc = Minecraft.getInstance();

    @Override
    public void onEnable() {
        super.onEnable();
        ChatUtils.sendMessage("Дистанции отключения зависит от значения поставленной прорисовки чанков!");
    }

    @SubscribeEvent
    public void onPlayerNoticed(RenderGameOverlayEvent e) {
        for (Entity entity : mc.level.players()) {
            if (!entity.getName().getString().startsWith("§") && !entity.getName().getString().startsWith("ID-") && !entity.getName().getString().startsWith("ID") && !entity.getName().getString().startsWith("CIT-") && !entity.getName().getString().startsWith("CITIZEN") && entity != Minecraft.getInstance().player) {
                if (entity.distanceTo(Minecraft.getInstance().player) < mc.options.renderDistance) {
                    mc.level.disconnect();
                }
            }
        }
        ChatUtils.outDisplay("Дистанция до игрока - §c§l" + mc.options.renderDistance + "§7m");
    }
}
