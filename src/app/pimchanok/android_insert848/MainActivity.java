package app.pimchanok.android_insert848;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btninsert;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//MyDBClass myDBClass = new MyDBClass(this);
		//myDBClass.getWritableDatabase();
		
		btninsert = (Button) findViewById(R.id.btninsert);
		btninsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			if(v==btninsert){
				Intent add = new Intent(MainActivity.this,AddActivity.class);
				startActivity(add);
			}
			}
		});
		
}
}