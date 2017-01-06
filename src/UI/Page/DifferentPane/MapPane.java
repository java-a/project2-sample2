package UI.Page.DifferentPane;

import Animal.Animal;
import GameRule. GameHistory;

import GameRule.GameRule;
import GameRule.Control;
import Map.Map;
import UI.Page.AnimalImageView.AnimalImage;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.*;

import Animal.SoundControl;
import GameRule.WhetherWin;
/**
 * Created by admin on 2016/12/24.
 */
//执行游戏的主界面
public class MapPane extends Pane {
    private ImageView imageView;
    private Button btFunction;
    private Animal animal;
    private Map map;
    private Rectangle rectangle[][], rectangles[][], left, right;
    private GameRule rule;
    private Control control;
    private AnimalImage animalImage;
    private boolean player;
    private GameHistory history;
    private int currentStep, lastStep, nextStep;
    private FunctionPane function;
    private WinPane winner;
    private SoundControl sound;
    private WhetherWin whether;

    public MapPane() throws FileNotFoundException {
        super();

        sound = new SoundControl();
        history = new GameHistory();
        animal = new Animal();
        map = new Map();
        rule = new GameRule();
        control = new Control();
        whether = new WhetherWin();
        player = true;
        currentStep = 0;
        lastStep = 0;
        nextStep = 0;

        //保存初始动物的数字与阵营信息
        history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
        history.saveTeamHistory(animal.getTheTeam(), currentStep);

        //加入图片
        imageView = new ImageView("pic/Map3.png");
        imageView.setFitHeight(760);
        imageView.setFitWidth(1280);
        getChildren().add(imageView);

        btFunction = new Button("function");
        btFunction.setPrefHeight(50);
        btFunction.setPrefWidth(120);
        btFunction.setLayoutX(600);
        btFunction.setLayoutY(0);
        getChildren().add(btFunction);
        btFunction.setOnAction(event ->{
            function.setVisible(true);
        });

        //创建rectangle，用于提示当前玩家
        left = new Rectangle();  //提示左方下棋
        left.setFill(Color.YELLOW);
        left.setWidth(133);
        left.setHeight(113);
        left.setLayoutX(0);
        left.setLayoutY(0);
        left.setEffect(new GaussianBlur(100));
        FadeTransition ft = new FadeTransition(Duration.millis(400),left);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.setCycleCount(Animation.INDEFINITE
        );
        ft.play();
        left.setVisible(false);
        getChildren().add(left);

        right = new Rectangle();  //提示右方下棋
        right.setFill(Color.YELLOW);
        right.setWidth(133);
        right.setHeight(113);
        right.setLayoutX(1134);
        right.setLayoutY(0);
        right.setEffect(new GaussianBlur(100));
        left.setEffect(new GaussianBlur(100));
        FadeTransition rg = new FadeTransition(Duration.millis(400),right);
        rg.setToValue(0.0);
        rg.setAutoReverse(true);
        rg.setCycleCount(Animation.INDEFINITE
        );
        rg.play();
        right.setVisible(false);
        getChildren().add(right);

        setPlayer(player,left, right);

        rectangle = new Rectangle[7][9]; //用于提示动物可走的方向
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                rectangle[i][j] = new Rectangle();
                rectangle[i][j].setOpacity(0.3);
                rectangle[i][j].setFill(Color.BLUE);
                rectangle[i][j].setHeight(88);
                rectangle[i][j].setWidth(103);
                rectangle[i][j].setLayoutX(103 * j + 184);
                rectangle[i][j].setLayoutY(115 + 88 * i);
                getChildren().add(rectangle[i][j]);
                rectangle[i][j].setVisible(false);
            }
        }
        rectangles = new Rectangle[7][9];   //用于注明已点击的动物
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                rectangles[i][j] = new Rectangle();
                rectangles[i][j].setFill(Color.YELLOW);
                rectangles[i][j].setHeight(88);
                rectangles[i][j].setWidth(103);
                rectangles[i][j].setLayoutX(103 * j + 184);
                rectangles[i][j].setLayoutY(115 + 88 * i);
                getChildren().add(rectangles[i][j]);
                rectangles[i][j].setOpacity(0);
            }
        }
        control.setDisable(animal.getTheTeam(), player ,rectangles);

        animalImage = new AnimalImage(animal.getTheTeam(), animal.getNumberOfAnimal());  //add动物的图片

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                animalImage.getAnimalImage()[i][j].setFitWidth(103);
                animalImage.getAnimalImage()[i][j].setFitHeight(88);
                animalImage.getAnimalImage()[i][j].setLayoutY(115 + 88 * i);
                animalImage.getAnimalImage()[i][j].setLayoutX(103 * j + 184);
                getChildren().add(animalImage.getAnimalImage()[i][j]);
            }
        }

        winner = new WinPane();
        winner.setPrefWidth(200);
        winner.setPrefHeight(100);
        winner.setLayoutY(330);
        winner.setLayoutX(530);
        getChildren().add(winner);
        winner.setVisible(false);
        winner.getBtOver().setOnAction(e ->{
            winner.setVisible(false);
        });

        function = new FunctionPane();
        function.setPrefWidth(120);
        function.setPrefHeight(510);
        function.setLayoutY(0);
        function.setLayoutX(600);
        getChildren().add(function);
        function.setVisible(false);
        function.setOnMouseExited(e ->{
            function.setVisible(false);
        });

        //悔棋功能
        function.getBtUndo().setOnAction(e ->{
            nextStep = currentStep;
            if(nextStep > 0){
                try {
                    history.changeMap(history.getTeamHistory()[currentStep-1], animal.getTheTeam(), history.getAnimalHistory()[currentStep-1],
                            animal.getNumberOfAnimal(), animalImage.getAnimalImage());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                nextStep = --currentStep;
                player = !player;
                setPlayer(player,left, right);
                control.setDisable(animal.getTheTeam(),player,rectangles);
            }
        });

        //撤销悔棋功能
        function.getBtRedo().setOnAction(e ->{
            nextStep = currentStep;
            if(nextStep < lastStep){
                try {
                    history.changeMap(history.getTeamHistory()[currentStep+1], animal.getTheTeam(), history.getAnimalHistory()[currentStep+1],
                            animal.getNumberOfAnimal(), animalImage.getAnimalImage());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                nextStep = ++currentStep;
                player = !player;
                setPlayer(player,left, right);
                control.setDisable(animal.getTheTeam(),player,rectangles);
            }
        });

        //重新开始功能
        function.getBtRestart().setOnAction(e ->{
                    try {
                        history.changeMap(history.getTeamHistory()[0], animal.getTheTeam(), history.getAnimalHistory()[0],
                                animal.getNumberOfAnimal(), animalImage.getAnimalImage());
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    currentStep = 0;
            lastStep = 0;
            player = true;
            setPlayer(player,left, right);
            control.setDisable(animal.getTheTeam(),player,rectangles);
        });

        //存档功能
        function.getBtSave().setOnAction(e -> {
            try {
                System.out.println(getAvailableSaveCount());
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("saves/save" + getAvailableSaveCount() + ".dat"));
                output.writeObject(history);
                output.writeInt(currentStep);
                output.close();
            }catch (IOException ex) {
//                System.out.println("无法保存存档");
                ex.printStackTrace();
            }
        });



            for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                animalImage.getAnimalImage()[i][j].addEventFilter(
                        MouseEvent.MOUSE_ENTERED_TARGET,
                        new AnimalHandler(i, j)
                );
                animalImage.getAnimalImage()[i][j].addEventFilter(
                        MouseEvent.MOUSE_EXITED_TARGET,
                        new AnimalHandlerTwo(i, j)
                );
                rectangles[i][j].addEventFilter(
                        MouseEvent.MOUSE_CLICKED,
                        new AnimalHandlerThree(i, j)
                );
            }
        }

    }

    public static int getAvailableSaveCount(){
        int i = 0;
        File f;
        do {
            i++;
            f = new File("saves/save" + i + ".dat");
        }while (f.exists());
        return i;
    }

/*该类用于执行走棋，一方面完成点击动物的注明与清除注明，另一方面，在完成一步走棋的同时改变相应的阵营数组和动物数组*/
   private class AnimalHandlerThree implements EventHandler<MouseEvent>{
        private int i;
        private int j;

        AnimalHandlerThree(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public void handle(MouseEvent event){
                if(control.isClick(rectangles)){
                    int k = PlaceOfVisibel(rectangles)/10;
                    int m = PlaceOfVisibel(rectangles)%10;
                    //判断动物类型
                    if(animal.getNumberOfAnimal()[k][m] == 1){
                        if (rule.canMouseUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i == k -1 && j ==m){
                            /*判断符合条件后，对player，lastStep，currentStep，动物阵营、数字和图片进行操作，并将相关内容保存入历史数组
                            下同
                             */
                            player = !player;
                            control.turnUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canMouseDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i == k + 1 && j==m){
                            player = !player;
                            control.turnDown(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canMouseLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j  == m - 1 && i == k){
                            player = !player;
                            control.turnLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canMouseRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j  == m + 1 && i == k){
                            player = !player;
                            control.turnRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal().clone(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam().clone(), currentStep);
                        }
                    }else if(animal.getNumberOfAnimal()[k][m] == 6 || animal.getNumberOfAnimal()[k][m] == 7){
                        if (rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                            map.getNumberOfMap()[k-1][m] == 1 && k - 3 == i && j == m) {
                            player = !player;
                            control.jumpUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else  if(k - 1 == i && map.getNumberOfMap()[k-1][m] != 1 && j == m &&
                                rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)){
                            player = !player;
                                 control.turnUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                            } else if (rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                map.getNumberOfMap()[k+1][m] == 1 && k + 3 == i && j == m) {
                            player = !player;
                            control.jumpDowwn(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        } else if(k + 1 == i && map.getNumberOfMap()[k+1][m] != 1 && j == m &&
                                rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)) {
                            player = !player;
                            control.turnDown(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if (rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                 map.getNumberOfMap()[k][m-1] == 1 && m - 4 == j && i == k) {
                            player = !player;
                            control.jumpLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        } else  if(m - 1 == j && map.getNumberOfMap()[k][m-1] != 1 && i == k &&
                                rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)) {
                            player = !player;
                            control.turnLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        } else if (rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                map.getNumberOfMap()[k][m+1] == 1 && m + 4 == j && i == k) {
                            player = !player;
                            control.jumpRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else  if(m + 1 == j && map.getNumberOfMap()[k][m+1] != 1 && i == k &&
                                rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)) {
                            player = !player;
                            control.turnRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }
                    } else{
                        if (rule.canNormalUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i  == k - 1 && j == m){
                            player = !player;
                            control.turnUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canNormalDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i  == k + 1 && j == m){
                            player = !player;
                            control.turnDown(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canNormalLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j == m - 1 && i == k){
                            player = !player;
                            control.turnLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canNormalRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j == m + 1 && i == k){
                            player = !player;
                            control.turnRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }
                    }
                    //每次点击时，清除原先被点击的标志，并设置可点击的对象
                    rectangles[k][m].setOpacity(0);
                    control.setDisable(animal.getTheTeam(), player, rectangles);
                }else if(animal.getNumberOfAnimal()[i][j] != 0) {
                    //标明被点击的对象，并设置可点击的对象，点击时播放动物音效
                    rectangles[i][j].setOpacity(0.4);
                    sound.play(animal.getNumberOfAnimal()[i][j] - 1);
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 9; j++) {
                            rectangles[i][j].setDisable(false);
                        }
                    }
                }
           setPlayer(player,left, right);

            //判断右方是否胜利
            if(whether.leftCannotMove(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap()) ||
                    whether.leftDiedOut(animal.getTheTeam()) || whether.rightEnter(animal.getTheTeam())){
                winner.setVisible(true);
                winner.getLable1().setVisible(true);
                winner.getLable2().setVisible(false);
                for(int i = 0; i < 7; i++){
                    for (int j = 0; j < 9; j++){
                        rectangles[i][j].setDisable(true);
                    }
                }
            }

            //判断左方是否胜利
            if(whether.rightCannotMove(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap()) ||
                    whether.rightDiedOut(animal.getTheTeam()) || whether.leftEnter(animal.getTheTeam())){
                winner.setVisible(true);
                winner.getLable1().setVisible(false);
                winner.getLable2().setVisible(true);
                for(int i = 0; i < 7; i++){
                    for (int j = 0; j < 9; j++){
                        rectangles[i][j].setDisable(true);
                    }
                }
            }
        }

    }

/* inner class 该类主要用于当鼠标经过某一动物上方时自动的标明该动物可以走的方向
*/
   private class AnimalHandlerTwo implements EventHandler<MouseEvent> {
        private int i;
        private int j;

        AnimalHandlerTwo(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void handle(MouseEvent event) {
            //判断动物类型
            if (animal.getNumberOfAnimal()[i][j] == 1) {
                if (rule.canMouseUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    //当符合条件时显现相应位置用于提示的rectangle，下同
                    rectangle[i - 1][j].setVisible(false);
                }
                if (rule.canMouseDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(false);
                }
                if (rule.canMouseLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(false);
                }
                if (rule.canMouseRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(false);
                }
            } else if (animal.getNumberOfAnimal()[i][j] == 6 || animal.getNumberOfAnimal()[i][j] == 7) {
                if (rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i - 1][j] == 1) {
                        rectangle[i - 3][j].setVisible(false);
                    } else
                        rectangle[i - 1][j].setVisible(false);
                }
                if (rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i + 1][j] == 1) {
                        rectangle[i + 3][j].setVisible(false);
                    } else
                        rectangle[i + 1][j].setVisible(false);
                }
                if (rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j - 1] == 1) {
                        rectangle[i][j - 4].setVisible(false);
                    } else
                        rectangle[i][j - 1].setVisible(false);
                }
                if (rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j + 1] == 1) {
                        rectangle[i][j + 4].setVisible(false);
                    } else
                        rectangle[i][j + 1].setVisible(false);
                }
            } else {
                if (rule.canNormalUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i - 1][j].setVisible(false);
                }
                if (rule.canNormalDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(false);
                }
                if (rule.canNormalLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(false);
                }
                if (rule.canNormalRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(false);
                }
            }
        }
    }

    /*inner class 该类主要用于当鼠标离开某动物时，之前由于提示而产生的标明清除
     */
    private class AnimalHandler implements EventHandler<MouseEvent> {
        private int i;
        private int j;

        AnimalHandler(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void handle(MouseEvent event) {
            //判断动物类型
            if (animal.getNumberOfAnimal()[i][j] == 1) {
                if (rule.canMouseUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    //当鼠标离开该动物时，清除相应的标志，下同
                    rectangle[i - 1][j].setVisible(true);
                }
                if (rule.canMouseDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(true);
                }
                if (rule.canMouseLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(true);
                }
                if (rule.canMouseRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(true);
                }
            } else if (animal.getNumberOfAnimal()[i][j] == 6 || animal.getNumberOfAnimal()[i][j] == 7) {
                if (rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i - 1][j] == 1) {
                        rectangle[i - 3][j].setVisible(true);
                    } else
                        rectangle[i - 1][j].setVisible(true);
                }
                if (rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i + 1][j] == 1) {
                        rectangle[i + 3][j].setVisible(true);
                    } else
                        rectangle[i + 1][j].setVisible(true);
                }
                if (rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j - 1] == 1) {
                        rectangle[i][j - 4].setVisible(true);
                    } else
                        rectangle[i][j - 1].setVisible(true);
                }
                if (rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j + 1] == 1) {
                        rectangle[i][j + 4].setVisible(true);
                    } else
                        rectangle[i][j + 1].setVisible(true);
                }
            } else {
                if (rule.canNormalUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i - 1][j].setVisible(true);
                }
                if (rule.canNormalDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(true);
                }
                if (rule.canNormalLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(true);
                }
                if (rule.canNormalRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(true);
                }
            }
        }

    }

    //获取当前被点击的动物的位置信息
    private int PlaceOfVisibel(Rectangle[][] rectangle){
        int i, j;
        for( i = 0; i < 7; i++){
            for( j = 0; j < 9; j++){
                if(rectangle[i][j].getOpacity() > 0.3)
                    return (10 * i + j);
            }
        }
        return -1;
    }

    public FunctionPane getFunction(){
        return function;
    }
    public Animal getAnimal(){
        return animal;
    }
    public  AnimalImage getAnimalImage(){
        return animalImage;
    }

    //用于玩家切换的提示
    private  void setPlayer(boolean player, Rectangle left, Rectangle right){
        if (player) {
            left.setVisible(true);
            right.setVisible(false);
        } else {
            right.setVisible(true);
            left.setVisible(false);
        }
    }

}

