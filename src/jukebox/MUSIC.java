package jukebox;

import java.io.File;
import javazoom.jl.player.Player;
import javax.swing.JOptionPane;
//import java.io.*;


import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;


public class MUSIC extends jukebox{


private Player player;
private FileInputStream FIS;
private BufferedInputStream BIS;
private boolean canResume;
private String path;
private int total;
private int stopped;
private boolean valid;

public MUSIC(){
    player = null;
    FIS = null;
    valid = false;
    BIS = null;
    path = null;
    total = 0;
    stopped = 0;
    canResume = false;
    
}

public boolean canResume(){
    return canResume;
}

public void setPath(String path){
    this.path = path;
    
}

public void resume(){
    if(!canResume) return;
    if(play(total-stopped)) canResume = false;
}

public void pause(){
    
	try{
		if(canResume) resume();
		else{
			stopped = FIS.available();
			player.close();
			FIS = null;
			BIS = null;
			player = null;
			if(valid) canResume = true;
		}
	}
    catch(Exception e){	
    }
}



public boolean play(int pos){
	
    valid = true;
    canResume = false;
    try{
    FIS = new FileInputStream(path);
    total = FIS.available();
    if(pos > -1) FIS.skip(pos);
    BIS = new BufferedInputStream(FIS);
    player = new Player(BIS);
  
    new Thread(
            new Runnable(){
                public void run(){
                    try{
                    	
                    		player.play();
                    	
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
                        valid = false;
                    }
                }
            }
    ).start();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
        valid = false;
    }
    return valid;
}

public void end (int pos){
	canResume= false;
	player.close();
	
}

}