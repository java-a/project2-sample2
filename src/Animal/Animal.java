package Animal;

import Map.TileType;

import java.io.FileNotFoundException;

//继承TileType类，主要用于获取动物的数字地图及阵营
public  class  Animal extends TileType{
    private int numberOfAnimal[][];
    private int[][] theTeam;

    public Animal() throws FileNotFoundException {
        super("animal.txt");
        numberOfAnimal =new int[7][9];
        theTeam = new int[7][9];
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 9; j++){
                numberOfAnimal[i][j] = this.getNumber()[i][j];
            }
        }
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 9; j++){
               if(numberOfAnimal[i][j] != 0 && j < 4){
                   theTeam[i][j] = 1;
               }else if(numberOfAnimal[i][j] != 0 && j > 4){
                   theTeam[i][j] = -1;
               }else
                   theTeam[i][j] = 0;
            }
        }
    }


    public int[][] getNumberOfAnimal() {
        return numberOfAnimal;
    }

    //获取阵营
    public int[][] getTheTeam(){
        return theTeam;
    }

}
