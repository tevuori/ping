public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        player.sendMessage(String.valueOf(getPing(player)));
        return false;
    }
    public int getPing(Player player){
        try {
            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            int ping = (int) entityPlayer.getClass().getField("ping").get(entityPlayer);
            return ping;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
            return 0;
        }
    }
