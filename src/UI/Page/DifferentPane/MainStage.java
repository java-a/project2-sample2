package UI.Page.DifferentPane;

import Animal.SoundControl;
import GameRule.GameHistory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by admin on 2016/12/25.
 */
//界面的切换和程序的运行，其中由于载入需要进行界面切换，因此载入功能在该类中完成
public class MainStage extends Application {
    WelcomePane welcomePane;
    MapPane mapPane;
    HelpPane helpPane;
    LoadPane loadPane;
    Pane mainPane;
    private SoundControl sound;
    private final static int HEIGHT = 760,WIDTH = 1280;
    @Override
    public void  start(Stage primaryStage) throws FileNotFoundException {
        welcomePane = new WelcomePane();
        mapPane = new MapPane();
        helpPane = new HelpPane();
        loadPane = new LoadPane();
        mainPane = new Pane();
        mapPane.setVisible(false);
        helpPane.setVisible(false);
        loadPane.setVisible(false);
        mainPane.getChildren().addAll(welcomePane, mapPane, helpPane, loadPane);
        primaryStage.setResizable(false);

        Scene scene = new Scene(mainPane,WIDTH,HEIGHT);

        sound = new SoundControl();
        sound.music();

        welcomePane.getBt1().setOnAction(e-> {
            welcomePane.setVisible(false);
            mapPane.setVisible(true);
        });
        welcomePane.getBt2().setOnAction(e->{
            welcomePane.setVisible(false);
            helpPane.setVisible(true);
        });
        welcomePane.getBt3().setOnAction(e->{
            welcomePane.setVisible(false);
            loadPane.setVisible(true);
        });

        helpPane.getBt1().setOnAction(e->{
            helpPane.setVisible(false);
            welcomePane.setVisible(true);
        });

        mapPane.getFunction().getBtReturn().setOnAction(e->{
            mapPane.setVisible(false);
            welcomePane.setVisible(true);
        });

        loadPane.getBt1().setOnAction(e->{
            loadPane.setVisible(false);
            welcomePane.setVisible(true);
        });
        loadPane.getBt2().setOnAction(e ->{
            loadPane.setVisible(false);
            mapPane.setVisible(true);
        });

        //读档功能按钮
        loadPane.getBt3().setOnAction(e -> {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("saves/" + loadPane.getCurrentSelected()));
                GameHistory history = (GameHistory)input.readObject();
                int steps = input.readInt();
                input.close();
                history.changeMap(history.getTeamHistory()[steps], mapPane.getAnimal().getTheTeam(), history.getAnimalHistory()[steps],
                        mapPane.getAnimal().getNumberOfAnimal(), mapPane.getAnimalImage().getAnimalImage());

                loadPane.setVisible(false);
                mapPane.setVisible(true);

            }catch (IOException ex){
                System.out.println("无法读取存档");
            }catch (ClassNotFoundException ex){
                System.out.println("存档文件已损坏");
            }

        });

        scene.getStylesheets().add("all.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("JungleFX");
        primaryStage.show();
    }
  public static void main(String[] args){
      Application.launch(args);
  }
}
