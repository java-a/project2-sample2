package GameRule;

/**
 * Created by admin on 2017/1/1.
 */
//判断动物是否可以移动
public class GameRule {
    public  GameRule(){
    }

    //判断普通动物可否向上
    public boolean canNormalUp(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if(i >= 1){
            if(numberOfMap[i-1][j] == 1){
                return false;
            }else if(theTeam[i][j] == theTeam[i-1][j]){
                return false;
            }else if((theTeam[i][j] ==1 && numberOfMap[i-1][j] == 3) || (numberOfMap[i-1][j] == 5 && theTeam[i][j] == -1 )){
                return false;
            }else if((theTeam[i][j] == 1 && numberOfMap[i-1][j] ==2) || (theTeam[i][j] == -1 && numberOfMap[i-1][j] == 4)){
                return true;
            } if(theTeam[i][j] != theTeam[i-1][j] && numberOfAnimal[i][j] == 8 && numberOfAnimal[i-1][j] == 1){
                return false;
            } else if(theTeam[i][j] != theTeam[i-1][j] && numberOfAnimal[i][j] < numberOfAnimal[i-1][j]){
                return false;
            }else
                return true;
        }else {
            return false;
        }
    }

    //判断普通动物是否可以向下
    public boolean canNormalDown(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if(i < 6){
            if(numberOfMap[i+1][j] == 1){
                return false;
            }else if(theTeam[i][j] == theTeam[i+1][j]){
                return false;
            }else if((theTeam[i][j] ==1 && numberOfMap[i+1][j] == 3) || (numberOfMap[i+1][j] == 5 && theTeam[i][j] == -1 )){
                return false;
            }else if((theTeam[i][j] == 1 && numberOfMap[i+1][j] ==2) || (theTeam[i][j] == -1 && numberOfMap[i+1][j] == 4)){
                return true;
            }if(theTeam[i][j] != theTeam[i+1][j] && numberOfAnimal[i][j] == 8 && numberOfAnimal[i+1][j] == 1){
                return false;
            } else if(theTeam[i][j] != theTeam[i+1][j] && numberOfAnimal[i][j] < numberOfAnimal[i+1][j]){
                return false;
            }else
                return true;
        }else {
            return false;
        }
    }

    //判断普通动物可否向左
    public boolean canNormalLeft(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if(j >= 1){
            if(numberOfMap[i][j-1] == 1){
                return false;
            }else if(theTeam[i][j] == theTeam[i][j-1]){
                return false;
            }else if((theTeam[i][j] ==1 && numberOfMap[i][j-1] == 3) || (numberOfMap[i][j-1] == 5 && theTeam[i][j] == -1 )){
                return false;
            }else if((theTeam[i][j] == 1 && numberOfMap[i][j-1] ==2) || (theTeam[i][j] == -1 && numberOfMap[i][j-1] == 4)){
                return true;
            } if(theTeam[i][j] != theTeam[i][j-1] && numberOfAnimal[i][j] == 8 && numberOfAnimal[i][j-1] == 1){
                return false;
            }else if(theTeam[i][j] != theTeam[i][j-1] && numberOfAnimal[i][j] < numberOfAnimal[i][j-1]){
                return false;
            }else
                return true;
        }else {
            return false;
        }
    }

    //判断普通动物是否可以向右
    public boolean canNormalRight(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if(j < 8){
            if(numberOfMap[i][j+1] == 1){
                return false;
            }else if(theTeam[i][j] == theTeam[i][j+1]){
                return false;
            }else if((theTeam[i][j] ==1 && numberOfMap[i][j+1] == 3) || (numberOfMap[i][j+1] == 5 && theTeam[i][j] == -1 )){
                return false;
            }else if((theTeam[i][j] == 1 && numberOfMap[i][j+1] ==2) || (theTeam[i][j] == -1 && numberOfMap[i][j+1] == 4)){
                return true;
            }if(theTeam[i][j] != theTeam[i][j+1] && numberOfAnimal[i][j] == 8 && numberOfAnimal[i][j+1] == 1){
                return false;
            } else if(theTeam[i][j] != theTeam[i][j+1] && numberOfAnimal[i][j] < numberOfAnimal[i][j+1]){
                return false;
            }else
                return true;
        }else {
            return false;
        }
    }

    //判断老鼠可否向上
    public boolean canMouseUp(int[][] theTeam, int[][] numberOfAnimal, int[][] numberOfMap, int i, int j){
        if(i >= 1){
            if(numberOfMap[i-1][j] == 1){
                return true;
            }else{
                if(theTeam[i][j] == theTeam[i-1][j]){
                    return false;
                }else if(numberOfMap[i][j] == 1 && numberOfAnimal[i-1][j] == 8){
                    return false;
                } else if((theTeam[i][j] ==1 && numberOfMap[i-1][j] == 3) || (numberOfMap[i-1][j] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i-1][j] ==2) || (theTeam[i][j] == -1 && numberOfMap[i-1][j] == 4)){
                    return true;
                } else if(theTeam[i][j] != theTeam[i-1][j] && (numberOfAnimal[i-1][j] != 8
                        && numberOfAnimal[i][j] < numberOfAnimal[i-1][j])){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }

    //判断老鼠可否向下
    public boolean canMouseDown(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if(i < 6){
            if(numberOfMap[i+1][j] == 1){
                return true;
            }else{
                if(theTeam[i][j] == theTeam[i+1][j]){
                    return false;
                }else if(numberOfMap[i][j] == 1 && numberOfAnimal[i+1][j] == 8){
                    return false;
                } else if((theTeam[i][j] ==1 && numberOfMap[i+1][j] == 3) || (numberOfMap[i+1][j] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i+1][j] ==2) || (theTeam[i][j] == -1 && numberOfMap[i+1][j] == 4)){
                    return true;
                } else if(theTeam[i][j] != theTeam[i+1][j] && (numberOfAnimal[i+1][j] != 8
                        && numberOfAnimal[i][j] < numberOfAnimal[i+1][j])){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }

    //判断老鼠可否向左
    public boolean canMouseLeft(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if(j >= 1){
            if(numberOfMap[i][j-1] == 1){
                return true;
            }else{
                if(theTeam[i][j] == theTeam[i][j-1]){
                    return false;
                }else if(numberOfMap[i][j] == 1 && numberOfAnimal[i][j-1] == 8){
                    return false;
                } else if((theTeam[i][j] ==1 && numberOfMap[i][j-1] == 3) || (numberOfMap[i][j-1] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i][j-1] ==2) || (theTeam[i][j] == -1 && numberOfMap[i][j-1] == 4)){
                    return true;
                }
                else if(theTeam[i][j] != theTeam[i][j-1] && (numberOfAnimal[i][j-1] != 8
                        && numberOfAnimal[i][j] < numberOfAnimal[i][j-1])){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }

    //判断老鼠可否向右
    public boolean canMouseRight(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if(j < 8){
            if(numberOfMap[i][j+1] == 1){
                return true;
            }else{
                if(theTeam[i][j] == theTeam[i][j+1]){
                    return false;
                }else if(numberOfMap[i][j] == 1 && numberOfAnimal[i][j+1] == 8){
                    return false;
                } else if((theTeam[i][j] ==1 && numberOfMap[i][j+1] == 3) || (numberOfMap[i][j+1] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i][j+1] ==2) || (theTeam[i][j] == -1 && numberOfMap[i][j+1] == 4)){
                    return true;
                } else if(theTeam[i][j] != theTeam[i][j+1] && (numberOfAnimal[i][j+1] != 8
                        && numberOfAnimal[i][j] < numberOfAnimal[i][j+1])){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }

    //判断狮虎可否向上
    public boolean canTigerUp(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if (i >= 1){
            if(numberOfMap[i-1][j] !=1){
                if(theTeam[i][j] == theTeam[i-1][j]){
                    return false;
                }else if((theTeam[i][j] ==1 && numberOfMap[i-1][j] == 3) || (numberOfMap[i-1][j] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i-1][j] ==2) || (theTeam[i][j] == -1 && numberOfMap[i-1][j] == 4)){
                    return true;
                } else if(theTeam[i][j] != theTeam[i-1][j] && numberOfAnimal[i][j] < numberOfAnimal[i-1][j]){
                    return false;
                }else
                    return true;
            }else {
                if((numberOfAnimal[i-1][j] == 1 || numberOfAnimal[i-2][j] == 1) &&
                        (theTeam[i-1][j] == -theTeam[i][j] || theTeam[i][j] == -theTeam[i-2][j]) ){
                    return false;
                }else if(theTeam[i][j] == theTeam[i-3][j]){
                    return false;
                }else if(numberOfAnimal[i][j] < numberOfAnimal[i-3][j]){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }

    //判断狮虎可否向下
    public boolean canTigerDown(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if (i < 6){
            if(numberOfMap[i+1][j] !=1){
                if(theTeam[i][j] == theTeam[i+1][j]){
                    return false;
                }else if((theTeam[i][j] ==1 && numberOfMap[i+1][j] == 3) || (numberOfMap[i+1][j] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i+1][j] ==2) || (theTeam[i][j] == -1 && numberOfMap[i+1][j] == 4)){
                    return true;
                } else if(theTeam[i][j] != theTeam[i+1][j] && numberOfAnimal[i][j] < numberOfAnimal[i+1][j]){
                    return false;
                }else
                    return true;
            }else {
                if((numberOfAnimal[i+1][j] == 1 || numberOfAnimal[i+2][j] == 1) &&
                        (theTeam[i+1][j] == -theTeam[i][j] || theTeam[i+2][j] == -theTeam[i][j]) ){
                    return false;
                }else if(theTeam[i][j] == theTeam[i+3][j]){
                    return false;
                }else if(numberOfAnimal[i][j] < numberOfAnimal[i+3][j]){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }

    //判断狮虎可否向左
    public boolean canTigerLeft(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if (j >= 1){
            if(numberOfMap[i][j-1] !=1){
                if(theTeam[i][j] == theTeam[i][j-1]){
                    return false;
                }else if((theTeam[i][j] ==1 && numberOfMap[i][j-1] == 3) || (numberOfMap[i][j-1] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i][j-1] == 2) || (theTeam[i][j] == -1 && numberOfMap[i][j-1] == 4)){
                    return true;
                } else if(theTeam[i][j] != theTeam[i][j-1] && numberOfAnimal[i][j] < numberOfAnimal[i][j-1]){
                    return false;
                }else
                    return true;
            }else {
                if((numberOfAnimal[i][j-1] == 1 || numberOfAnimal[i][j-2] == 1 || numberOfAnimal[i][j-3] == 1) &&
                        (theTeam[i][j-1] == -theTeam[i][j] || theTeam[i][j-2] == -theTeam[i][j] || theTeam[i][j-3] == -theTeam[i][j])){
                    return false;
                }else if(theTeam[i][j] == theTeam[i-4][j]){
                    return false;
                }else if(numberOfAnimal[i][j] < numberOfAnimal[i-4][j]){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }

    //判断狮虎可否向右
    public boolean canTigerRight(int[][] theTeam, int[][] numberOfAnimal, int[][]numberOfMap, int i, int j){
        if (j < 8){
            if(numberOfMap[i][j+1] !=1){
                if(theTeam[i][j] == theTeam[i][j+1]){
                    return false;
                }else if((theTeam[i][j] ==1 && numberOfMap[i][j+1] == 3) || (numberOfMap[i][j+1] == 5 && theTeam[i][j] == -1 )){
                    return false;
                }else if((theTeam[i][j] == 1 && numberOfMap[i][j+1] == 2) || (theTeam[i][j] == -1 && numberOfMap[i][j+1] == 4)){
                    return true;
                } else if(theTeam[i][j] != theTeam[i][j+1] && numberOfAnimal[i][j] < numberOfAnimal[i][j+1]){
                    return false;
                }else
                    return true;
            }else {
                if((numberOfAnimal[i][j+1] == 1 || numberOfAnimal[i][j+2] == 1 || numberOfAnimal[i][j+3] == 1) &&
                        (theTeam[i][j+1] == -theTeam[i][j] || theTeam[i][j+2] == -theTeam[i][j] || theTeam[i][j+3] == -theTeam[i][j])){
                    return false;
                }else if(theTeam[i][j] == theTeam[i+4][j]){
                    return false;
                }else if(numberOfAnimal[i][j] < numberOfAnimal[i+4][j]){
                    return false;
                }else
                    return true;
            }
        }else
            return false;
    }
}
