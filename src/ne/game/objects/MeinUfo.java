package ne.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class MeinUfo extends SpielObjekt{
    private float acceleration = 0.001f;
    private float speed = 1;
    public MeinUfo(int x, int y, Image image) {
        super(x, y, image);
        setRandomPosition();
    }

    @Override
    public void draw(Graphics g) {
        this.getImage().drawCentered(this.getX(),this.getY());
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void update(int delta) {
        this.speed = (delta * this.acceleration + speed);
        if(this.getY() > (768+this.getHeight())){
            this.setRandomPosition();
        }
        this.setY(this.getY()+(int)this.speed);

    }
    public void setRandomPosition() {
        Random r =  new Random();
        int ry = 0;
        int rx = 0;
        rx=r.nextInt(1024-this.getWidth()+1-0)+this.getWidth()/2;
        // y=0 oben
        ry = r.nextInt(300+1+this.getHeight())+this.getHeight();
        this.setY(-ry);
        this.setX(rx);
        setRandomAcceleration();
    }
    private void setRandomAcceleration(){
        Random r = new Random();
        this.speed = r.nextInt(400-1)+1;
    }
}
