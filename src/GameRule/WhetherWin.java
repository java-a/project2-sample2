package GameRule;

/**
 * Created by admin on 2017/1/4.
 */
public class WhetherWin {
    private GameRule rule;
    public WhetherWin(){
        rule = new GameRule();
    }

    //判断左方是否死光
    public boolean leftDiedOut(int[][] theTeam){
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 9; j++){
                if(theTeam[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    //判断右方是否死光
    public boolean rightDiedOut(int[][] theTeam){
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 9; j++){
                if(theTeam[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    //判断右方是否进入左方洞穴
    public boolean rightEnter(int[][] theTeam){
        if(theTeam[3][0] == -1)
            return true;
        else
            return false;
    }

    //判断左方是否进入右方洞穴
    public boolean leftEnter(int[][] theTeam){
        if(theTeam[3][8] == 1)
            return true;
        else
            return false;
    }

    //判断左方是否无子可动
    public boolean leftCannotMove(int[][] theTeam, int[][]numberOfanimal, int[][]numberOfMap) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if(theTeam[i][j] == 1){
                    if(numberOfanimal[i][j] == 1){
                        if(rule.canMouseUp(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                         else if(rule.canMouseDown(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if (rule.canMouseLeft(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canMouseRight(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                    }else if(numberOfanimal[i][j] == 6 || numberOfanimal[i][j] == 7){
                        if(rule.canTigerUp(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canTigerDown(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if (rule.canTigerLeft(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canTigerRight(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                    }else {
                        if(rule.canNormalUp(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canNormalDown(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if (rule.canNormalLeft(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canNormalRight(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    //判断右方是否无子可动
    public boolean rightCannotMove(int[][] theTeam, int[][]numberOfanimal, int[][]numberOfMap){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if(theTeam[i][j] == -1){
                    if(numberOfanimal[i][j] == 1){
                        if(rule.canMouseUp(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canMouseDown(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if (rule.canMouseLeft(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canMouseRight(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                    }else if(numberOfanimal[i][j] == 6 || numberOfanimal[i][j] == 7){
                        if(rule.canTigerUp(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canTigerDown(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if (rule.canTigerLeft(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canTigerRight(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                    }else {
                        if(rule.canNormalUp(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canNormalDown(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if (rule.canNormalLeft(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                        else if(rule.canNormalRight(theTeam, numberOfMap, numberOfMap, i, j))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
