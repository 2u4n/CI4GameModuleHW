public class PlayerShoot {
    private int count = 0;

    public void run(Player player) {
        if (this.count >= 30) {
            PlayerBullet playerBullet = new PlayerBullet();
            playerBullet.x = player.x;
            playerBullet.y = player.y;
            playerBullet.dY = -4;
            GameObject.add(playerBullet);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
