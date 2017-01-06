package UI.Page.DifferentPane;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

/**
 * Created by admin on 2016/12/25.
 */
//重载界面
public class LoadPane extends Pane {
   private ImageView imageView;
   private Button bt1, bt2, bt3,bt4;

    private ListView<String> saveList;
    public LoadPane(){
        super();
        imageView = new ImageView("pic/LoanPage.jpg");
        imageView.setFitHeight(760);
        imageView.setFitWidth(1280);

        getChildren().add(imageView);

        bt1 = new Button("返回主页面");
        bt1.setLayoutX(200);
        bt1.setLayoutY(700);
        bt2 = new Button("返回游戏");
        bt2.setLayoutX(400);
        bt2.setLayoutY(700);
        bt3 = new Button("载入");
        bt3.setLayoutX(600);
        bt3.setLayoutY(700);
        bt4 = new Button("刷新");
        bt4.setLayoutX(750);
        bt4.setLayoutY(700);
        bt4.setOnAction(e -> refresh());
        saveList = new ListView<>();

        refresh();

        getChildren().addAll(saveList,bt1,bt2,bt3,bt4);

        GaussianBlur blur = new GaussianBlur(20.0);
        imageView.setEffect(blur);
    }

    //提供方法刷新当前存档文件列表
    public void refresh(){
        saveList.getItems().clear();
        File d = new File("saves");
        File[] files = d.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].getName().matches("^save[0-9]+.dat$")){
                saveList.getItems().add(files[i].getName());
            }
        }
        if(saveList.getItems().size()>0){
            saveList.getSelectionModel().select(0);
            bt3.setDisable(false);
        }else {
            bt3.setDisable(true);
        }
    }
    public ImageView getImageView(){
        return imageView;
    }
    public Button getBt1(){
        return bt1;
    }
    public Button getBt2(){
        return bt2;
    }
    public Button getBt3(){
        return bt3;
    }
    public Button getBt4(){
        return bt4;
    }
    public String getCurrentSelected(){
        return saveList.getItems().get(saveList.getSelectionModel().getSelectedIndex());
    }
}
