package UI.Page.DifferentPane;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by admin on 2016/12/24.
 */

//帮助界面
public class HelpPane extends Pane{
    Label helpInformation;
    ImageView imageView;
    Button bt1;
    String s1;
    public HelpPane(){
        super();
        imageView = new ImageView("pic/HelpPage.jpg");
        imageView.setFitWidth(1280);
        imageView.setFitHeight(760);

        getChildren().add(imageView);
        bt1 = new Button(("返回主页面"));

        bt1.setLayoutX(600);
        bt1.setLayoutY(650);

        getChildren().add(bt1);

        s1 = "斗兽棋的棋盘 斗兽棋的棋盘横七列，纵九行，棋子放在格子中。双方底在线各有" + "\n"  +
                "三个陷阱（作品字排）和一个兽穴(于品字中间)。 棋牌中部有两片水域，称之为小河。" +"\n" + "\n" +
                "斗兽棋的棋子 斗兽棋棋子共十六个，分为红蓝双方，双方各有八只一样的棋子（下称为：" +"\n" +
                "兽 或 动物），按照战斗力强弱排列为：象>狮>虎>豹>狗>狼>猫>鼠。" + "\n" + "\n" +
                "斗兽棋的走法 游戏开始时，红方先走，然后轮流走棋。每次可走动一只兽，每只兽每次" + "\n" +
                "走一方格，除己方兽穴和小河以外，前后左右均可。但是，狮、虎、鼠还有不同走法：" + "\n" + "\n" +
                "狮虎跳河法：狮虎在小河边时，可以纵横对直跳过小河，且能把小河对岸的敌方较小的兽" + "\n" +
                "类吃掉，但是如果对方老鼠在河里，把跳的路线阻隔就不能跳，若对岸是对方比自己战斗力" + "\n" +
                "前的兽，也不可以跳过小河；" + "\n" + "\n" +
                "鼠游过河法：鼠是唯一可以走入小河的兽，走法同陆地上一样，每次走一格，上下左右均" + "\n" +
                "可，而且，陆地上的其他兽不可以吃小河中的鼠，小河中的鼠也不能吃陆地上的象，鼠类互" + "\n" +
                "吃不受小河影响。\n" + "\n" +
                "斗兽棋的吃法 斗兽棋吃法分普通吃法和特殊此法，普通吃法是按照兽的战斗力强弱，强者" + "\n" +
                "可以吃弱者。 特殊吃法如下： 1、鼠吃象法：八兽的吃法除按照战斗力强弱次序外，惟鼠" + "\n" +
                "能吃象，象不能吃鼠。 2、互吃法：凡同类相遇，可互相吃。 3、陷阱：棋盘设陷阱，专为" + "\n" +
                "限制敌兽的战斗力（自己的兽，不受限制），敌兽走入陷阱，即失去战斗力，本方的任意兽" + "\n" +
                "类都可以吃去陷阱里的兽类。 综合普通吃法和特殊吃法，将斗兽棋此法总结如下：\n" + "\n" +
                "鼠可以吃象、鼠 猫可以吃猫、鼠； 狼可以吃狼、猫、鼠； 狗可以吃狗、狼、猫、鼠； 豹可" + "\n" +
                "以吃豹、狗、狼、猫、鼠； 虎可以吃虎、豹、狗、狼、猫、鼠； 狮可以吃狮、虎、豹、狗、" + "\n" +
                "狼、猫、鼠； 象可以吃象、狮、虎、豹、狗、狼、猫；";

        helpInformation = new Label(s1);
        helpInformation.setPadding(new Insets(20,20,20,20));
        helpInformation.setLayoutX(100);
        helpInformation.setLayoutY(50);
        getChildren().add(helpInformation);
    }

    public ImageView getImageView(){
        return imageView;
    }
    public Button getBt1(){
        return bt1;
    }
    public  String getS1(){
        return  s1;
    }
}



