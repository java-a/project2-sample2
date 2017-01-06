package UI.Page.AnimalImageView;

import Animal.Animal;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

/**
 * Created by admin on 2017/1/2.
 */
public class AnimalImage {
    private ImageView animalImage[][];
    private AnimalImageView animalView;
    private Animal animal;

    public AnimalImage(int theTeam[][], int numberOfAnimal[][]) throws FileNotFoundException {
        animalImage = new ImageView[7][9];
        animalView = new AnimalImageView();
        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                animalImage[i][j] = new ImageView();
                if (theTeam[i][j] == 1) {
                    switch (numberOfAnimal[i][j]) {
                        case 1:
                            animalImage[i][j] = animalView.getMouseLeft();
                            ;
                            break;
                        case 2:
                            animalImage[i][j] = animalView.getCatLeft();
                            break;
                        case 3:
                            animalImage[i][j] = animalView.getWolfLeft();
                            break;
                        case 4:
                            animalImage[i][j] = animalView.getDogLeft();
                            break;
                        case 5:
                            animalImage[i][j] = animalView.getLeopardLeft();
                            break;
                        case 6:
                            animalImage[i][j] = animalView.getTigerLeft();
                            break;
                        case 7:
                            animalImage[i][j] = animalView.getLionLeft();
                            break;
                        case 8:
                            animalImage[i][j] = animalView.getElephantLeft();
                            break;
                        default:
                            animalImage[i][j] = new ImageView();
                            break;
                    }
                } else if (theTeam[i][j] == -1) {
                    switch (numberOfAnimal[i][j]) {
                        case 1:
                            animalImage[i][j] = animalView.getMouseRight();
                            break;
                        case 2:
                            animalImage[i][j] = animalView.getCatRight();
                            break;
                        case 3:
                            animalImage[i][j] = animalView.getWolfRight();
                            break;
                        case 4:
                            animalImage[i][j] = animalView.getDogRight();
                            break;
                        case 5:
                            animalImage[i][j] = animalView.getLeopardRight();
                            break;
                        case 6:
                            animalImage[i][j] = animalView.getTigerRight();
                            break;
                        case 7:
                            animalImage[i][j] = animalView.getLionRight();
                            break;
                        case 8:
                            animalImage[i][j] = animalView.getElephantRight();
                            break;
                        default:
                            animalImage[i][j] = new ImageView();
                            break;
                    }
                }
            }
        }
    }
    public ImageView[][] getAnimalImage(){
        return animalImage;
    }
}
