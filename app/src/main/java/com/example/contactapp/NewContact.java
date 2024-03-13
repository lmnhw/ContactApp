package com.example.contactapp;

import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.contactapp.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class NewContact extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final  String TAG = "CONTACT_TAG";
    private static final int WRITE_CONTACT_PERMISSION_CODE = 100;
    private static final int IMAGE_PICK_GALLERY_CODE = 100;
    private String[] contactPermission;

    private Uri image_uri;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        contactPermission = new String[]{android.Manifest.permission.WRITE_CONTACTS};

  /*      binding.iv_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalleryIntent();
            }
        });

        binding.btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isWriteContactPermissionEnabled()){
                    saveContact();
                }
                else {
                    requestWriteContactPermission();
                }

            }
        });
    }

    private void saveContact() {
        String name = binding.name.getText().toString().trim();
        String phone = binding.phone.getText().toString().trim();
        String email = binding.email.getText().toString().trim();

        ArrayList<ContentProviderOperation> cpo = new ArrayList<>();

        int rawContactId = cpo.size();
        cpo.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                .build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, rawContactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,name).
                build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, rawContactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,phone).
                build());

        cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, rawContactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.DATA,email).
                build());

        byte[] imageBytes = imageUriToBytes();
        if (imageBytes != null){
            cpo.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, rawContactId)
                    .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.Photo.PHOTO,imageBytes).
                    build());

        }
        else {
                    }

        try{
            ContentProviderResult[] result = getContentResolver().applyBatch(ContactsContract.AUTHORITY, cpo);
            Log.d(TAG, "saveContact: Saved");

        } catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "saveContact: "+e.getMessage());
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private byte[] imageUriToBytes() {
        Bitmap bitmap;
        ByteArrayOutputStream baos = null;
        try{
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), image_uri);
            
            baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
            return baos.toByteArray();
        }
        catch (Exception e){
            Log.d(TAG, "imageUriToBytes: " +e.getMessage());
            return null;
        }
    }

    private void openGalleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE);

    }

    private boolean isWriteContactPermissionEnabled(){
        boolean result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_CONTACTS) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestWriteContactPermission(){
        ActivityCompat.requestPermissions(this, contactPermission,WRITE_CONTACT_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length > 0){
            if(requestCode == WRITE_CONTACT_PERMISSION_CODE){
                boolean haveWriteContactPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if(haveWriteContactPermission){
                    saveContact();
                }
                else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(resultCode == IMAGE_PICK_GALLERY_CODE){
                image_uri = data.getData();
                binding.iv_contact.setImageURI(image_uri);
            }
        }
        else{
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        }

    }

   */
    }


}
