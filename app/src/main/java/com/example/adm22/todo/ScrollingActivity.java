package com.example.adm22.todo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.FragmentManager;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.api.model.VKList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ScrollingActivity extends AppCompatActivity {
    static Button[] bt  = new Button[10];
    act[] mas = new act [10];
    Button [] btcat = new Button [4];
    FragmentManager fragmentManager = getFragmentManager();
    static public choosefrag fraaag = new choosefrag();
    static public choosefinil fragfn = new choosefinil();


    public void checkonline() {
        final VKApiUser[] user = new VKApiUser[1];
        VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "online")).executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                user[0] = ((VKList<VKApiUser>)response.parsedModel).get(0);
                Log.d("User name", user[0].first_name + " " + user[0].last_name);
                if ( user[0].online){
                    pushesvk();
                }
            }
        });
    }


    final Handler handler = new Handler();
    public void PushInTime(final int nomber) {
        //handler.removeCallbacks(pushes());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mas[nomber].dodid()) {
                            pusheswork();
                            PushInTime(nomber);
                        }
                    }
                });

            }
        }, 3000);
    }


    public void pusheshome(){

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("За работу!")
                .setContentText("работа в лес не убежит")
                .setAutoCancel(true)
                .setVibrate(new long[] { 1000, 500, 1000 })
                .setSound(defaultSoundUri);

        Notification notification = notificationBuilder.build();

        notificationManager.notify(1, notification);
    }

    public void pushesvk(){

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Не трать время на VK!")
                .setContentText("Вегетативный образ жизни приводит к смерти...")
                .setAutoCancel(true)
                .setVibrate(new long[] { 1000, 500, 1000 })
                .setSound(defaultSoundUri);
        //.setContentIntent(pendingIntent);

        Notification notification = notificationBuilder.build();

        notificationManager.notify(1, notification);
    }

    public void pusheswork(){

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("За работу!")
                .setContentText("работа в лес не убежит")
                .setAutoCancel(true)
                .setVibrate(new long[] { 1000, 500, 1000 })
                 .setSound(defaultSoundUri);
                //.setContentIntent(pendingIntent);

        Notification notification = notificationBuilder.build();

        notificationManager.notify(1, notification);

        checkonline();
    }
    static int a=0;

    public static void spf(){
        bt[a].setText("Спорт\n"+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));

    }
    public static void wrf(){
        bt[a].setText("Работа\n"+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
    }



    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        for(int y=0;y<10;y++){
            mas[y] = new act();
        }




        bt[0] = (Button) findViewById(R.id.button1);
        bt[1] = (Button) findViewById(R.id.button2);
        bt[2] = (Button) findViewById(R.id.button3);
        bt[3] = (Button) findViewById(R.id.button4);
        bt[4] = (Button) findViewById(R.id.button5);
        bt[5] = (Button) findViewById(R.id.button6);
        bt[6] = (Button) findViewById(R.id.button7);
        bt[7] = (Button) findViewById(R.id.button8);
        bt[8] = (Button) findViewById(R.id.button9);
        bt[9] = (Button) findViewById(R.id.button10);


        for (int n=0;n<10;n++){
            bt[n].setVisibility(View.GONE);
        }


        //Button sett = (Button) findViewById(R.id.)

        Button newtab = (Button) findViewById(R.id.CreateButton);

        newtab.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){

                if (i<9) {
                    fragmentManager.beginTransaction()
                           .add(R.id.fragment_container, fraaag,"frag")
                            .commit();

                    i++;
                    for (a=0;a<10;a++) {
                        if (!mas[a].dodid()) {
                            bt[a].setVisibility(View.VISIBLE);
                            mas[a].startact();
                            break;
                        }
                    }
                    PushInTime(a);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Сначала выполни предидущии задания", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        });



                //fragmentManager.beginTransaction()
                        //.remove(fraaag)
                        //.commit();


        bt[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[0].didit();
                bt[0].setVisibility(View.GONE);
                i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[1].didit();
                    bt[1].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[2].didit();
                    bt[2].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[3].didit();
                    bt[3].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[4].didit();
                    bt[4].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[5].didit();
                    bt[5].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[6].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[6].didit();
                    bt[6].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[7].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[7].didit();
                    bt[7].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });
        bt[8].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[8].didit();
                    bt[8].setVisibility(View.GONE);
                    i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();

            }
        });
        bt[9].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mas[9].didit();
                bt[9].setVisibility(View.GONE);
                i--;
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragfn,"fragg")
                        .commit();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
// Пользователь успешно авторизовался
            }
            @Override
            public void onError(VKError error) {
// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            VKSdk.login(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

