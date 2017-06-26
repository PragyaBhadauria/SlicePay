package com.pacific.loadcontact;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static android.R.attr.name;
import static com.pacific.loadcontact.MainActivity.RequestPermissionCode;

public class ContactsActivity extends AppCompatActivity {

    ListView listView ;
    Cursor cursor ;
    String name, phonenumber ;
    ArrayList<String> storeContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        listView = (ListView)findViewById(R.id.listview1);
        storeContacts = new ArrayList<String>();
        EnableRuntimePermission();
        GetContactsIntoArrayList();
        Collections.sort(storeContacts);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                ContactsActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, storeContacts
        );

        listView.setAdapter(arrayAdapter);
    }

    public void GetContactsIntoArrayList(){

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            storeContacts.add(name + " "  + ":" + " " + phonenumber);
        }

        cursor.close();

    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                ContactsActivity.this,
                Manifest.permission.READ_CONTACTS))
        {

            Toast.makeText(ContactsActivity.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(ContactsActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(ContactsActivity.this,"Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(ContactsActivity.this,"Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}
