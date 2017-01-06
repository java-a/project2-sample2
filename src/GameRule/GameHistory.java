package GameRule;

import UI.Page.AnimalImageView.AnimalImage;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Created by admin on 2017/1/3.
 */
//保存动物阵营及数字的历史信息
public class GameHistory implements Serializable {
    private int[][][]teamHistory;
    private int[][][] animalHistory;

    public GameHistory(){
        teamHistory = new int[500][7][9];
        animalHistory = new int[500][7][9];
    }

    public int[][][]getTeamHistory(){
        return teamHistory;
    }

    public int[][][] getAnimalHistory(){
        return animalHistory;
    }

    //将保存当前阵营信息
    public void saveTeamHistory(int[][]theTeam, int k){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 9; j++){
                teamHistory[k][i][j] = theTeam[i][j];
            }
        }
    }

    //保存当前动物数字信息
    public void saveAnimalHistory(int[][]numberOfAnimal, int k){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 9; j++){
                animalHistory[k][i][j] = numberOfAnimal[i][j];
            }
        }
    }

    //获取动物的历史阵营与数字信息以改变当前的相应信息，并且改变界面
    public void changeMap(int[][]teamHistory, int[][]theTeam, int[][]animalHistory, int[][]numberOfAnimal, ImageView[][]animalImage) throws FileNotFoundException {
        AnimalImage newAnimalImage = new AnimalImage(teamHistory, animalHistory);
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 9; j++){
                theTeam[i][j] = teamHistory[i][j];
                numberOfAnimal[i][j] = animalHistory[i][j];
                animalImage[i][j].setImage(newAnimalImage.getAnimalImage()[i][j].getImage());
            }
        }
    }

}
