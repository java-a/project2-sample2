package UI.Page.DifferentPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by admin on 2017/1/3.
 */
//用于执行redo，undo, restart,load功能的小界面
public class FunctionPane extends Pane{
    private Button btRedo, btUndo, btSave, btRestart, btReturn;
    public FunctionPane(){
        super();
        btRedo = new Button("redo");
        btRedo.setPrefHeight(50);
        btRedo.setPrefWidth(100);
        btRedo.setLayoutX(10);
        btRedo.setLayoutY(10);
        getChildren().add(btRedo);

        btUndo = new Button("undo");
        btUndo.setPrefHeight(50);
        btUndo.setPrefWidth(100);
        btUndo.setLayoutX(10);
        btUndo.setLayoutY(110);
        getChildren().add(btUndo);

        btSave = new Button("save");
        btSave.setPrefHeight(50);
        btSave.setPrefWidth(100);
        btSave.setLayoutX(10);
        btSave.setLayoutY(210);
        getChildren().add(btSave);

        btRestart = new Button("restart");
        btRestart.setPrefHeight(50);
        btRestart.setPrefWidth(100);
        btRestart.setLayoutX(10);
        btRestart.setLayoutY(310);
        getChildren().add(btRestart);

        btReturn = new Button("返回主页面");
        btReturn.setPrefHeight(50);
        btReturn.setPrefWidth(100);
        btReturn.setLayoutX(10);
        btReturn.setLayoutY(410);
        getChildren().add(btReturn);
    }
    public Button getBtRedo(){
        return btRedo;
    }

    public Button getBtUndo(){
        return btUndo;
    }

    public Button getBtSave(){
        return btSave;
    }

    public Button getBtRestart(){
        return btRestart;
    }

    public Button getBtReturn(){
        return btReturn;
    }
}
