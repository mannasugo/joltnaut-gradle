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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.joltnaut.Splash.APK_VER;

public class PollMug extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.poll_mug);

    TextView toPullin = findViewById(R.id.pullin);

    AppCompatButton PollMug = findViewById(R.id.pollMug);

    final EditText alias, mail, lock, relock;

    alias = findViewById(R.id.alias);

    mail = findViewById(R.id.mail);

    lock = findViewById(R.id.lock);

    relock = findViewById(R.id.relock);

    PollMug.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        if (alias.getText().length() > 2 && mail.getText().length() > 2 && lock.getText().length() > 2 && lock.getText() == relock.getText()) {

          String IOString = "[\""+ alias.getText() +"\", \""+ mail.getText() +"\", \""+ lock.getText() +"\"]";

          lock.setText("");

          new Call().execute(IOString);
        }
      }
    });

    toPullin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent instance = new Intent(PollMug.this, PullMug.class);

        startActivity(instance);
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

        String JSON = "{\"param\": " + param[0] + ",\"pull\": \"pollMug\", \"APK_VER\": \"" + APK_VER + "\"}";

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

        Intent intent = new Intent(PollMug.this, PullMug.class);

        startActivity(intent);

      }
    }
  }
}
