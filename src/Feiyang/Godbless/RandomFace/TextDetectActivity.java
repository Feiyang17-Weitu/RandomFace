package Feiyang.Godbless.RandomFace;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class TextDetectActivity extends Activity
{

	private int flag=0;
	private int begin=0;
	private final String[] names=new String[33];
	Timer timer;
	
	private final String[] areas = new String[]{"≤Ã»", "–Ï”¿∫∆", "∑∂Ω∂À", "Õı‘¥", "¿Ó”¢√˜", "¡ı”Ó—Ù","ƒÙ√˜—◊","’≈∆Ù’"
			,"—Ó÷æÀ¨","¬Ì”Ò—◊","–œ»´Œ∞","’≤–ÒË°","¡ıΩÚ–Ò","≥¬¡’","≥¬ø≠","–ª≥Â","Õı≥Ω"," Ê’","¡ıº·«ø","…Ú“¿√˙","≈∑—Ù÷™”Í","Õı≥ø","¬∑…Ÿˆ©","Õı¿Ÿ","π˘√´","ÀŒ√€"
			,"¡ıË°","»Œ√Œ”©","–Ï—˛","“∂««”","∂≠¿÷","√œ†N"
			};  
	private final boolean[] areaState=new boolean[]{ false, false, false, false, false,false,false,false,false,false,false,false,false,
			                                  false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,
			                                  false,false,false,false};  
	private ListView areaCheckListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_detect);
		
		
		final TextView Edit=(TextView) findViewById(R.id.EditBallot);
		final Button StartBn=(Button) findViewById(R.id.BnStart);
		final Button StopBn=(Button) findViewById(R.id.BnStop);
		final Button ChooseBn=(Button) findViewById(R.id.BnChoose);
		
		final Handler handler = new Handler() 
		{   
            @Override  
            public void handleMessage(Message msg) 
            {  
            	if( msg.what == 0x1122 )
            	{
         		        Edit.setText( names[flag]);
            	}
            	
            		super.handleMessage(msg);
                  
           }  
               
        };   
		
		 StartBn.setOnClickListener(new OnClickListener() 
		 {
			@Override
			public void onClick(View arg0) {
				if(timer==null)
				 {timer=new Timer();}
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						
						 flag++; 
                         if(flag > begin)
                         {
                        	 flag=0;
                         }
                         
           
                         
                         Message m=new Message();
                         m.what=0x1122;
                         handler.sendMessage(m);
					}
				}, 0, 100);
				StartBn.setClickable(false);
				StopBn.setClickable(true);
			}
		  });
		 
		 
		 StopBn.setOnClickListener(new OnClickListener() 
		 {
			@Override
			public void onClick(View arg0) {
				
				timer.cancel();
				timer=null;
				StartBn.setClickable(true);
				StopBn.setClickable(false);
			}
		});
		 
	    ChooseBn.setOnClickListener( new CheckBoxClickListener() );
		
	}
	
	 class CheckBoxClickListener implements OnClickListener{  
		  @Override  
		  public void onClick(View v) {
		   begin=0;
		   AlertDialog ad = new AlertDialog.Builder(TextDetectActivity.this)  
		   .setTitle("≥È«©’ﬂ–’√˚")  
		   .setMultiChoiceItems(areas,areaState,new DialogInterface.OnMultiChoiceClickListener(){  
		      @Override
			public void onClick(DialogInterface dialog,int whichButton, boolean isChecked){  
		      }  
		     }).setPositiveButton("»∑∂®",new DialogInterface.OnClickListener(){  
		      @Override
			public void onClick(DialogInterface dialog,int whichButton){  
		    
		       String s = "ƒ˙—°‘Ò¡À:";  
		       for (int i = 0; i < areas.length; i++){  
		        if (areaCheckListView.getCheckedItemPositions().get(i)){  
		         s += (i+1) + ":"+ areaCheckListView.getAdapter().getItem(i)+ "  ";
		         names[begin] = areaCheckListView.getAdapter().getItem(i).toString();
		         begin++;
		        }else{  
		         areaCheckListView.getCheckedItemPositions().get(i,false);  
		        }  
		       }  
		       if (areaCheckListView.getCheckedItemPositions().size() > 0){  
		        Toast.makeText(TextDetectActivity.this, s, Toast.LENGTH_LONG).show();  
		       }else{  
		         //√ª”–—°‘Ò  
		       }  
		       dialog.dismiss();  
		      }  
		     }).setNegativeButton("»°œ˚", null).create();  
		   areaCheckListView = ad.getListView();  
		   ad.show();  
		  }  
		    }  
		      
	

}
