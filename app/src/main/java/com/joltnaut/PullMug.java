package com.joltnaut;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.joltnaut.Splash.APK_VER;
import static com.joltnaut.Splash.Journalise;

public class PullMug extends AppCompatActivity {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.pull_mug);

    TextView toPollin = findViewById(R.id.pollin);

    toPollin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(PullMug.this, PollMug.class);

        startActivity(to);
      }
    });

    AppCompatButton PullMug = findViewById(R.id.pullMug);

    final EditText lock, mail;

    lock = findViewById(R.id.lock);

    mail = findViewById(R.id.mail);

    PullMug.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        if (mail.getText().length() > 2 && lock.getText().length() > 2) {

          String IOString = "[\""+ mail.getText() +"\", \""+ lock.getText() +"\"]";

          lock.setText("");

          new Call().execute(IOString);
        }

      }
    });
  }

  private class Call extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... param) {

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

        String JSON = "{\"param\": " + param[0] + ",\"pull\": \"pullMug\", \"APK_VER\": \"" + APK_VER + "\"}";

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

      if (IOContent != null) {

        String ver;

        try {

          JSONObject PullMug = new JSONObject(IOContent);

          ver = PullMug.getString("APK_VER");

          if (ver.equals(APK_VER)) {

            if (PullMug.has("md")) {

              Journalise.putString("md", PullMug.getString("md"));

              Intent intent = new Intent(PullMug.this, Root.class);

              startActivity(intent);
            }
          }
        } catch (JSONException e) {e.printStackTrace();}
      }

      else {

        Intent intent = new Intent(PullMug.this, PollMug.class);

        startActivity(intent);

      }
    }
  }
}
