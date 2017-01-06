package Animal;

import GameRule.GameHistory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by admin on 2017/1/3.
 */
public class SoundControl {
    String[] soundName;
    Media[] sounds;
    Media music;
    MediaPlayer mediaPlayer, musicPlayer;
    public SoundControl(){
        soundName = new String[8];
        soundName[0] = "Mouse.mp3";
        soundName[1] = "Cat.mp3";
        soundName[2] = "Wolf.mp3";
        soundName[3] = "Dog.mp3";
        soundName[4] = "Leopard.mp3";
        soundName[5] = "Tiger.mp3";
        soundName[6] = "Lion.mp3";
        soundName[7] = "Elephant.mp3";
        sounds = new Media[soundName.length];
        for(int i=0;i<soundName.length;i++){
            sounds[i] = new Media(SoundControl.class.getResource("/" + soundName[i]).toString());
        }
        music = new Media(SoundControl.class.getResource("/bgm.mp3").toString());

    }

    //判断当前是否播放音效，之后进行播放
    public void play(int index){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(sounds[index]);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.play();
    }
    public void music(){
        musicPlayer = new MediaPlayer(music);
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        musicPlayer.play();

    }
}
