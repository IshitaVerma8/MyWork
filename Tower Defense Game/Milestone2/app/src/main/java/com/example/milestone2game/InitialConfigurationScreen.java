package com.example.milestone2game;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.milestone2game.entities.Player;

public class InitialConfigurationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initialconfigurationscreen);
        Player player = new Player();

        EditText name = (EditText) findViewById(R.id.playerName);
        name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    // code to hide the soft keyboard
                    name.clearFocus();
                    name.requestFocus(EditText.FOCUS_DOWN);

                    TextView nameSummary = (TextView) findViewById(R.id.chosenName);
                    player.setName(name.getText().toString().trim());
                    nameSummary.setText("Player Name: " + player.getName());
                }
                return false;
            }
        });

        Spinner difficulties = (Spinner) findViewById(R.id.difficulties);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.difficulties, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficulties.setAdapter(adapter);


        difficulties.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                Object test = difficulties.getSelectedItem();
                Toast.makeText(InitialConfigurationScreen.this, "The difficulty is "
                        + difficulties.getItemAtPosition(position).toString(),
                        Toast.LENGTH_LONG).show();
                TextView difficultySummary = (TextView) findViewById(R.id.chosenDifficulty);
                player.setDifficulty(difficulties.getSelectedItem().toString());
                difficultySummary.setText("Difficulty: "
                        + player.getDifficulty());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        Button continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name == null || TextUtils.isEmpty(name.getText().toString().trim())) {
                    name.setError("Invalid Name");
                } else if (difficulties.getSelectedItem().toString()
                        .equals("-- Select Difficulty --")) {
                    ((TextView) difficulties.getSelectedView()).setError("Error message");
                } else {
                    Intent intent = new Intent(InitialConfigurationScreen.this, GameScreen.class);
                    intent.putExtra("currentPlayer", player);
                    startActivity(intent);
                }
            }
        });

        Button quitButton = (Button) findViewById(R.id.quitbutton2);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(InitialConfigurationScreen.this);
                builder.setTitle("Quit");
                builder.setMessage("Do you want to quit now?");
                builder.setPositiveButton("Yes. Quit now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                });
                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}
