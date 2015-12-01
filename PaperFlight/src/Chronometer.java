import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Timer;

public class Chronometer {
	private byte seconds = 0;
    private byte minutes = 0;
    private short hours = 0;
    private int levelSeconds = 0;
	private int pastLevelSeconds = 0;

    private DecimalFormat timeFormatter;

    public static Timer timer;
    public static ActionListener al;
    
    private String clock;
    
	public String clock(){	
		
		timeFormatter = new DecimalFormat("00");
        timer = new Timer(1000, al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds < 59) {
                    seconds++;
                } else {
                    if (minutes < 59) {
                        minutes++;
                        seconds = 00;
                    } else if (hours < 60) {
                        hours++;
                        minutes = 00;
                        seconds = 00;
                    }
                }
                clock = hours + ":"
                        + timeFormatter.format(minutes) + ":"
                        + timeFormatter.format(seconds);
            }
           
        });
        
		clock = hours + ":" + timeFormatter.format(minutes) + ":" + timeFormatter.format(seconds);
		return clock;
	}
	
	public int getSeconds(){
		return (hours*3600) + (minutes * 60) + seconds;
	}
	
	public int getOnlySeconds(){
		return this.seconds;
	}
	
	public int getOnlyMinutes(){
		return this.minutes;
	}
	
	public int getOnlyHours(){
		return this.hours;
	}
	public int getSecondsScore(){
		levelSeconds = getSeconds() - pastLevelSeconds;
		pastLevelSeconds = getSeconds();
		return levelSeconds;
	}
	
	public void start(){
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}
	
	public void setClock(int h, int m, int s){
		this.seconds = (byte)s;
		this.minutes = (byte)m;
		this.hours = (byte)h;
	}
	
}
