package UI.Page.AnimalImageView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by admin on 2016/12/26.
 */
public class AnimalImageView {
   private  ImageView mouseLeft, catLeft, wolfLeft, dogLeft, leopardLeft, tigerLeft, lionLeft, elephantLeft;
   private ImageView mouseRight, catRight, wolfRight, dogRight, leopardRight, tigerRight, lionRight, elephantRight;

    public AnimalImageView(){
        mouseLeft = new ImageView("pic/animals/left/1MouseLeft.png");
        catLeft = new ImageView("pic/animals/left/2CatLeft.png");
        wolfLeft =  new ImageView("pic/animals/left/3WolfLeft.png");
        dogLeft =  new ImageView("pic/animals/left/4DogLeft.png");
        leopardLeft = new ImageView("pic/animals/left/5LeopardLeft.png");
        tigerLeft =  new ImageView("pic/animals/left/6TigerLeft.png");
        lionLeft = new ImageView("pic/animals/left/7LionLeft.png");
        elephantLeft = new ImageView("pic/animals/left/8ElephantLeft.png");

        mouseRight = new ImageView("pic/animals/right/1MouseRight.png");
        catRight = new ImageView("pic/animals/right/2CatRight.png");
        wolfRight = new ImageView("pic/animals/right/3WolfRight.png");
        dogRight = new ImageView("pic/animals/right/4DogRight.png");
        leopardRight = new ImageView("pic/animals/right/5LeopardRight.png");
        tigerRight = new ImageView("pic/animals/right/6TigerRight.png");
        lionRight = new ImageView("pic/animals/right/7LionRight.png");
        elephantRight = new ImageView("pic/animals/right/8ElephantRight.png");
    }

    public ImageView getMouseLeft(){
        return mouseLeft;
    }
    public ImageView getCatLeft(){
        return catLeft;
    }
    public ImageView getWolfLeft(){
        return wolfLeft;
    }
    public ImageView getDogLeft(){
        return dogLeft;
    }
    public ImageView getLeopardLeft(){
        return leopardLeft;
    }
    public ImageView getTigerLeft(){
        return tigerLeft;
    }
    public ImageView getLionLeft(){
        return lionLeft;
    }
    public ImageView getElephantLeft(){
        return elephantLeft;
    }

    public ImageView getMouseRight(){
        return mouseRight;
    }
    public ImageView getCatRight(){
        return catRight;
    }
    public ImageView getWolfRight(){
        return wolfRight;
    }
    public ImageView getDogRight(){
        return dogRight;
    }
    public ImageView getLeopardRight(){
        return leopardRight;
    }
    public ImageView getTigerRight(){
        return tigerRight;
    }
    public ImageView getLionRight(){
        return lionRight;
    }
    public ImageView getElephantRight(){
        return elephantRight;
    }

}
