public class EnemyShoot {
    private int count = 0;

    public void run(Enemy enemy) {
        if (this.count >= 10) {
            SquareBullet squareBullet = new SquareBullet();
            squareBullet.x = enemy.x + 20;
            squareBullet.y = enemy.y;
            squareBullet.dY = 7;
            GameObject.add(squareBullet);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
