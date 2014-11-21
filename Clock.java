
package clock;


import java.awt.*;              
import java.io.File;
import java.util.*;             

public class Clock extends Frame implements Runnable
{

   Thread clockThread;
   
   int alarmh;                 
   int alarmm;                  
   boolean b = false;        
   Button qb, ab;               
   TextField tstr;              
   TextField astr;              
   static int ALARM_TICK = 1000;   
   static int CLOCK_TICK = 1000;  

   public static void main(String args[])
   {
       Clock clock = new Clock(); 
      
   }
   
   public Clock() {
      super("Java Clock");

      Panel imgpanel;
      int i;
     
      Font f = new Font("TimesNewRoman", Font.PLAIN, 12);
      setFont(f);                       
      setBackground(Color.lightGray);   
      
      
 

      
      setLayout(new BorderLayout());
      imgpanel = new Panel();
      qb = new Button("     Quit     ");       
      ab = new Button("Set Alarm");             
      tstr = new TextField("");         
      tstr.setEditable(false);         
      astr = new TextField("");         
      astr.setEditable(false);
      Panel q = new Panel();
      q.setLayout(new BorderLayout());
      q.add("North",tstr);
      q.add("South",astr);
      q.add("West",qb);
      q.add("East",ab);
      add("Center",imgpanel);
      add("South",q);
      
      imgpanel.resize(100,40);
      imgpanel.hide();                 
      pack();
      reshape(100,100,180,160);         
      show();                           
      stopAlarm();                      
      clockThread = new Thread(this);   
      clockThread.start();              
   }
  
   String twoDigits(int i) {
      String s;
      s = "" + (100 + i);       
      return (s.substring(1));
   }

   public void setAlarm(int h, int m) {
      
      astr.setText("   Alarm set for " + h + ":" + twoDigits(m) + " ");
      alarmh = h; alarmm = m;   
      b = false;            
   }

   public void soundAlarm(String t) {
       
      astr.setText(" " + t + " alarm ringing!");
      ab.setLabel("Stop Alarm");
      b = true;              
      
     
              
              }

   public void stopAlarm() {
      
      astr.setText("   Alarm not set");
      ab.setLabel("Set Alarm"); 
      alarmh = -1;              
      b = false;            
   }

  
   public boolean handleEvent(Event evt)
   {
      switch(evt.id) {
         case Event.WINDOW_DESTROY:     
            System.exit(0);
            return true;
         default:
            
            return super.handleEvent(evt);
      }
   }

   @Override
   public boolean action(Event e, Object o) {
      int nh, nm;
      if (qb == e.target) {    
         clockThread.stop();   
         clockThread = null;   
         System.exit(0);       
      } else if (ab == e.target) {      
         if (b) {            
            stopAlarm();        
         } else {               
            Date d = new Date();
            nh = d.getHours();
            nm = d.getMinutes() + 1;
            SetAlarmDialog ab = new SetAlarmDialog(this," " + nh + ":" + 
               twoDigits(nm) + " ");
            ab.show();
         }
      }
      return true;
   }

   public void run() {
      int nh, nm;
 
      while (clockThread != null) {
         // find out what time it is
         Date d = new Date();
         nh = d.getHours();
         nm = d.getMinutes();
         if (b == false && alarmh == nh && alarmm == nm) {
             // it's time to ring the alarm
             soundAlarm("" + alarmh + ":" + twoDigits(alarmm));
           }
     
         repaint();
   
         try {
          clockThread.sleep(b ? ALARM_TICK : CLOCK_TICK);
         } catch (InterruptedException e){
         }
       }
    }

   

    public void paint(Graphics g) {
        Date now = new Date();
      
        tstr.setText(now.getHours() + ":" + twoDigits(now.getMinutes()) + ":" + 
           twoDigits(now.getSeconds()));
        }

    private static class JavaSoundAudio {

        public JavaSoundAudio(FileInputStream fileInputStream) {
        }

        private void play() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
class SetAlarmDialog extends Dialog
{
   TextField at;
   Clock parent;

   public SetAlarmDialog(Clock par, String deftime)
   {
      
      super(par, "Set Alarm Clock", true);
   
      TextField t;
      parent = par;
      t = new TextField("Enter new alarm time:");
      t.setEditable(false);
      add("West",t);
      at = new TextField(deftime);
      add("East",at);
      Panel p = new Panel();
      p.add("West", new Button("Set Alarm"));
      p.add("East", new Button("Cancel"));
      add("South",p);
      pack();                           
      resize(preferredSize());
      move(200,200);
   }

   public boolean handleEvent(Event evt)
   {
      String s;
      int h, m;
      switch(evt.id) {
         case Event.WINDOW_DESTROY:    
            dispose();
            return true;
         case Event.ACTION_EVENT:
            if ("Set Alarm".equals(evt.arg)) {
              
               StringTokenizer st = new StringTokenizer(at.getText(),":/ ");
               try {
                  s = st.nextToken();
                  h = Integer.parseInt(s);
                  s = st.nextToken();
                  m = Integer.parseInt(s);
               } catch (Exception e) {
                  h = -1; m = -1;
               }
               if (h != -1)
                  parent.setAlarm(h,m);
               else
                  parent.stopAlarm();
            } else if ("Cancel".equals(evt.arg)) {
            }
            dispose();
            return true;
         default:
            return false;
      }
   }
}
}
