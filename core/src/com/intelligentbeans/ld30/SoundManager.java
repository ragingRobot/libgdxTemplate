package com.intelligentbeans.ld30;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
public class SoundManager {
	private static SoundManager _instance;
	private Music music;
	private Music sound;
	private Music gunsound;
	private String currentSound = "";
	private String currentSong = "";
	private Preferences prefs;
	private float musicVolume = .1f;
	private float soundVolume = .1f;
	private float musicVolumeOn = .1f;
	private float soundVolumeOn = .1f;
	public SoundManager(){
		prefs = Gdx.app.getPreferences("CommanderZ");
		
		if(prefs.getBoolean("soundOff")){
			soundOff();
		}
	}
	
	public void soundOn(){
		musicVolume = musicVolumeOn;
		soundVolume = soundVolumeOn;
		updateVolume();
		
		prefs.putBoolean("soundOff",false);
		prefs.flush();
	}
	
	public void soundOff(){
		musicVolume = 0;
		soundVolume = 0;
		updateVolume();

		prefs.putBoolean("soundOff",true);
		prefs.flush();
	}
	
	public void updateVolume(){
		if(music != null){
			music.setVolume(musicVolume);
		}
		if(gunsound != null){
			gunsound.setVolume(soundVolume);
		}
		if(sound != null){
			sound.setVolume(soundVolume);
		}
	}
	
	public void loadSong(String fileHandle){
		
		if(!currentSong.equals(fileHandle)){
			if(music != null || fileHandle == "" ){
				music.stop(); 
				music.dispose();
			}
			
			if(fileHandle != ""){
				music = Gdx.audio.newMusic(Gdx.files.internal(fileHandle));
				music.play(); 
				music.setLooping(true);
				music.setVolume(musicVolume);
			}
			currentSong = fileHandle;
		}
		
	}
	
public void playSound(String fileHandle){
		if(fileHandle == "gun.mp3"){
			if(gunsound == null){
				gunsound = Gdx.audio.newMusic(Gdx.files.internal(fileHandle));
				gunsound.setVolume(soundVolume);
			}
			gunsound.stop();
			gunsound.play(); 
		}else
		if(fileHandle != currentSound){
			if(sound != null || fileHandle == ""){
				sound.stop(); 
				sound.dispose();
				currentSound = "";
			}
			
			if(fileHandle != ""){
				sound = Gdx.audio.newMusic(Gdx.files.internal(fileHandle));
				currentSound = fileHandle;
				sound.setVolume(soundVolume);
				sound.play(); 
			 
			}
		}else{
			if(sound != null){
				sound.stop();
				sound.play(); 
			}
		}
			
		
		
	}
	
	public static SoundManager getInstance(){
		if(_instance == null){
			_instance = new SoundManager();
		}
		return _instance;
	}

}
