package com.example.milestone2game;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.milestone2game.entities.Player;
public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Intent intent = getIntent();
        Player player1 = (Player) intent.getSerializableExtra("currentPlayer");

        TextView moneyAmt = (TextView) findViewById(R.id.moneyAmount);
        moneyAmt.setText("Money: " + player1.getMoney());

        Intent returnIntent = new Intent();

        Button buyGryffindor = (Button) findViewById(R.id.buyGryffindor);
        Button buyHufflepuff = (Button) findViewById(R.id.buyHufflepuff);
        Button buyRavenclaw = (Button) findViewById(R.id.buyRavenclaw);
        Button buySlytherin = (Button) findViewById(R.id.buySlytherin);

        buyGryffindor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (player1.getMoney() >= 20) {
                    player1.setMoney(player1.getMoney() - 20);
                    moneyAmt.setText("Money: " + player1.getMoney());
                    player1.setLastPurchased("Gryffindor");

                    Intent returnIntent = new Intent(view.getContext(), GameScreen.class);
                    returnIntent.putExtra("currentPlayer", player1);
                    //returnIntent.putExtra("towerType", "Gryffindor");
                    //setResult(2, returnIntent);
                    startActivity(returnIntent);
                    finish();

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ShopActivity.this);
                    builder.setCancelable(true);
                    builder.setMessage("You do not have enough coins to purchase tower");
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            };
        });

        buyHufflepuff.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (player1.getMoney() >= 15) {
                    player1.setMoney(player1.getMoney() - 15);
                    moneyAmt.setText("Money: " + player1.getMoney());
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ShopActivity.this);
                    builder.setCancelable(true);
                    builder.setMessage("You do not have enough coins to purchase tower");
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            };
        });

        buyRavenclaw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (player1.getMoney() >= 15) {
                    player1.setMoney(player1.getMoney() - 15);
                    moneyAmt.setText("Money: " + player1.getMoney());
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ShopActivity.this);
                    builder.setCancelable(true);
                    builder.setMessage("You do not have enough coins to purchase tower");
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            };
        });

        buySlytherin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (player1.getMoney() >= 10) {
                    player1.setMoney(player1.getMoney() - 10);
                    moneyAmt.setText("Money: " + player1.getMoney());
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ShopActivity.this);
                    builder.setCancelable(true);
                    builder.setMessage("You do not have enough coins to purchase tower");
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            };
        });


    }
}
