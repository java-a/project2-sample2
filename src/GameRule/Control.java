package GameRule;


import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;

/**
 * Created by admin on 2016/12/30.
 */
public class Control {
    public Control()  {
    }

    //一般向上移动
    public void turnUp(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i - 1][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i - 1][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i - 1][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //一般向下移动
    public void turnDown(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i + 1][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i + 1][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i + 1][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //一般向左移动
    public void turnLeft(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j - 1] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j - 1] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j - 1].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //一般向右移动
    public void turnRight(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j + 1] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j + 1] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j + 1].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //狮虎向上跳河
    public void jumpUp(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i - 3][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i - 3][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i - 3][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //狮虎向下跳河
    public void jumpDowwn(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i + 3][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i + 3][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i + 3][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);

    }

    //狮虎向左跳河
    public void jumpLeft(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j - 4] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j - 4] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j - 4].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

   // 狮虎向右跳河
    public void jumpRight(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j + 4] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j + 4] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j + 4].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //改变界面上rectangles可否点击
    public void setDisable(int[][] theTeam, boolean player, Rectangle[][] rectangles) {
     if(player){
         for (int i = 0; i < 7; i++) {
             for (int j = 0; j < 9; j++) {
                 if(theTeam[i][j] == -1)
                     rectangles[i][j].setDisable(true);
                 else
                     rectangles[i][j].setDisable(false);
     }
         }
     }else {
         for (int i = 0; i < 7; i++) {
             for (int j = 0; j < 9; j++) {
                 if(theTeam[i][j] == 1)
                     rectangles[i][j].setDisable(true);
                 else
                     rectangles[i][j].setDisable(false);
             }
         }
     }
    }

    //判断当前界面是否已点击一个动物
    public boolean isClick(Rectangle[][] rectangle) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (rectangle[i][j].getOpacity() < 0.3) {
                    count++;
                }
            }
        }
        if (count == 63)
            return false;
        else
            return true;
    }
    }

