public class Square extends GameObject{
    public int dX;
    public int dY;
    private boolean hitX = false;
    private boolean hitY = false;


    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
    }

    @Override
    public void run() {
        super.run();
        if (this.x < 365 && !hitX) {
            this.x += this.dX;
        } else if (this.x == 365 && this.y < 100 && !hitY) {
            hitX = true;
            this.y += this.dY;
        } else if (this.x > 10 && this.y == 100 && hitX) {
            this.x -= this.dX;
        } else if (this.x == 10 && this.y < 200 && !hitY) {
            hitX = true;
            this.y += this.dY;
        } else if (this.x < 365 && this.y == 200 && hitX) {
            this.x += this.dX;
        } else if (this.x == 365 && this.y < 300 && !hitY) {
            hitX = true;
            this.y += this.dY;
        } else if (this.x > 10 && this.y == 300 && hitX) {
            this.x -= this.dX;
        } else if (this.x == 10 && this.y < 400 && !hitY) {
            hitX = true;
            this.y += this.dY;
        } else if (this.x < 365 && this.y == 400 && hitX) {
            this.x += this.dX;
        } else if (this.x == 365 && this.y < 500 && !hitY) {
            hitX = true;
            this.y += this.dY;
        } else if (this.x > 10 && this.y == 500 && hitX) {
            this.x -= this.dX;
        } else if (this.x == 10 && this.y < 565 && !hitY) {
            hitX = true;
            this.y += this.dY;
        } else if (this.x < 365 && this.y == 565 && hitX) {
            this.x += this.dX;
        }
        else if (this.x == 365 && this.y < 600 && !hitY) {
            hitX = true;
            this.y += this.dY;
        }
    }
}
