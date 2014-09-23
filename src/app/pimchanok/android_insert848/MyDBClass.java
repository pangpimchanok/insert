package app.pimchanok.android_insert848;

//import android.R.string;
import java.lang.reflect.Member;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBClass extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "pang";
	private static final String TABLE_MEMBER = "member";

	public MyDBClass(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ " (MemberID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " Name TEXT (100)," + " Birthday TEXT (100),"
				+ " Tel TEXT (100)," + " Age TEXT (100),"
				+ " EMail TEXT (100));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXIST " + TABLE_MEMBER);
		onCreate(db);

	}

	// Insert
	public long InsertData(String strName, String strBirthday, String strTel,
			String strAge, String strEMail) {
		try {

			SQLiteDatabase db;
			db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Birthday", strBirthday);
			values.put("Tel", strTel);
			values.put("Age", strAge);
			values.put("EMail", strEMail);

			long rows = db.insert(TABLE_MEMBER, null, values);

			db.close();
			return rows;
		} catch (Exception e) {
			return -1;

		}
	}

}
