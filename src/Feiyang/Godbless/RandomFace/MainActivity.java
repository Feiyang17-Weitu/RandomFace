package Feiyang.Godbless.RandomFace;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       ImageView MainButton1=(ImageView)findViewById(R.id.imageView1);
       ImageView MainButton2=(ImageView)findViewById(R.id.imageView2);
       ImageView MainButton3=(ImageView)findViewById(R.id.imageView3);
       ImageView MainButton4=(ImageView)findViewById(R.id.imageView4);
       
       MainButton3.setOnClickListener(new MainButton3Listener());
       
    }

    class MainButton1Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		
    	}
    }
    
    class MainButton2Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		
    	}
    }
    
    class MainButton3Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		
    	}
    }
    
    class MainButton4Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		
    	}
    }
}
