package com.joltnaut;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Splash extends AppCompatActivity {

  public static final String APK_VER = "202307201417";

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    this.setTheme(R.style.splash);

    setContentView(R.layout.splash);

    new Call().execute();
  }

  private class Call extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {

      HttpURLConnection Call = null;

      BufferedReader Reader = null;

      String IOContent = null;

      try {

        URL Remote = new URL("https://joltnaut.com/json/gradle/");

        Call = (HttpURLConnection) Remote.openConnection();

        Call.setRequestMethod("POST");

        Call.setRequestProperty("Content-Type", "application/json; utf-8");

        Call.setRequestProperty("Accept", "application/json");

        Call.setDoOutput(true);

        String JSON = "{\"pull\": \"app\", \"APK_VER\": \"" + APK_VER + "\"}";

        OutputStream OS = Call.getOutputStream();

        byte[] input = JSON.getBytes(StandardCharsets.UTF_8);

        OS.write(input, 0, input.length);

        Call.connect();

        InputStream CallString = Call.getInputStream();

        StringBuffer Alloc = new StringBuffer();

        if (CallString == null) {return null;}

        Reader = new BufferedReader(new InputStreamReader(CallString));

        String State;

        while ((State = Reader.readLine()) != null) {Alloc.append(State + "\n");}

        if (Alloc.length() == 0) {return null;}

        IOContent = Alloc.toString();

        return IOContent;
      }

      catch (IOException e) {}

      finally {

        if (Call != null) {Call.disconnect();}

        if (Reader != null) {

          try {Reader.close();}

          catch (final IOException e) {}
        }
      }

      return IOContent;
    }

    @Override
    protected void onPostExecute(String IOContent) {

      super.onPostExecute(IOContent);

      if (IOContent != null) {}

      else {

        Intent intent = new Intent(Splash.this, PullMug.class);

        startActivity(intent);

      }
    }
  }
}
