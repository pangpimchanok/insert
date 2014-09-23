package app.pimchanok.android_insert848;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

	private Button btnsave;
	private EditText edtname, edtbirthday, edttel, edtage, edtemail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		btnsave = (Button) findViewById(R.id.btnsave);
		btnsave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SaveData();

			}

		});
	}

	private void SaveData() {
		edtname = (EditText) findViewById(R.id.txtname);
		edtbirthday = (EditText) findViewById(R.id.txtbirthday);
		edttel = (EditText) findViewById(R.id.txttel);
		edtage = (EditText) findViewById(R.id.txtage);
		edtemail = (EditText) findViewById(R.id.txtemail);
		MyDBClass myDBClass = new MyDBClass(this);

		long savevstatus = myDBClass.InsertData(edtname.getText().toString(),
				edtbirthday.getText().toString(), edttel.getText().toString(),
				edtage.getText().toString(), edtemail.getText().toString());
		if (savevstatus <= 0) {
			Log.d("Error Save", "Error!");

		}
		Toast.makeText(getApplicationContext(), "Add Data Successfully",
				Toast.LENGTH_SHORT).show();
	}

}
