
package tv.tipoff.services.pgep.dto;

import java.util.List;

public class Audio{
   	private List dolby;
   	private boolean multilingual;
   	private String sound;

 	public List getDolby(){
		return this.dolby;
	}
	public void setDolby(List dolby){
		this.dolby = dolby;
	}
 	public boolean getMultilingual(){
		return this.multilingual;
	}
	public void setMultilingual(boolean multilingual){
		this.multilingual = multilingual;
	}
 	public String getSound(){
		return this.sound;
	}
	public void setSound(String sound){
		this.sound = sound;
	}
}
