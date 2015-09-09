package Feiyang.Godbless.RandomFace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       ImageView MainButton1=(ImageView)findViewById(R.id.imageView1);
       ImageView MainButton2=(ImageView)findViewById(R.id.imageView2);
       ImageView MainButton3=(ImageView)findViewById(R.id.imageView3);
       ImageView MainButton4=(ImageView)findViewById(R.id.imageView4);
       
       MainButton1.setOnClickListener(new MainButton1Listener());
       MainButton2.setOnClickListener(new MainButton2Listener());
       MainButton3.setOnClickListener(new MainButton3Listener());
       MainButton4.setOnClickListener(new MainButton4Listener());
       
    }

    class MainButton1Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		Toast.makeText(getApplicationContext(), "ImageView1", Toast.LENGTH_LONG).show();
    	}
    }
    
    class MainButton2Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		Toast.makeText(getApplicationContext(), "ImageView2", Toast.LENGTH_LONG).show();
    	}
    }
    
    class MainButton3Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		//Toast.makeText(getApplicationContext(), "ImageView3", Toast.LENGTH_LONG).show();
    		Intent TextDetectIntent = new Intent(MainActivity.this,TextDetectActivity.class);
    		startActivity(TextDetectIntent);
    	}
    }
    
    class MainButton4Listener implements View.OnClickListener
    {
    	@Override
    	public void onClick(View view)
    	{
    		Toast.makeText(getApplicationContext(), "ImageView4", Toast.LENGTH_LONG).show();
    	}
    }
}
