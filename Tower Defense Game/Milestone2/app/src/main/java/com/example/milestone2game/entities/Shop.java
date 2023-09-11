package com.example.milestone2game.entities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.milestone2game.GameScreen;
import com.example.milestone2game.R;

public class Shop {
    private GameScreen gameScreen;
    private Player player;
    private Dialog dialog;

    public Shop(GameScreen gameScreen, Player player) {
        this.gameScreen = gameScreen;
        this.player = player;
        this.dialog = new Dialog(gameScreen);
    }

    public void displayBuyOptions(Tile tile, TextView moneyText) {
        dialog.setContentView(R.layout.activity_shop);
        dialog.show();

        Button buyGryffindor = dialog.findViewById(R.id.buyGryffindor);
        Button buyHufflepuff = dialog.findViewById(R.id.buyHufflepuff);
        Button buyRavenclaw = dialog.findViewById(R.id.buyRavenclaw);
        Button buySlytherin = dialog.findViewById(R.id.buySlytherin);

        int gryffindorPrice = setupBuyOption(buyGryffindor, "Gryffindor");
        int hufflepuffPrice = setupBuyOption(buyHufflepuff, "Hufflepuff");
        int ravenclawPrice = setupBuyOption(buyRavenclaw, "Ravenclaw");
        int slytherinPrice = setupBuyOption(buySlytherin, "Slytherin");

        TextView moneyAmt = dialog.findViewById(R.id.moneyAmount);
        moneyAmt.setText("Money: " + player.getMoney());

        Button back = dialog.findViewById(R.id.backShop);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tile.setClicked(false);
                dialog.dismiss();
            }
        });

        buyGryffindor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tower gryffindorTower = new Tower("Gryffindor", player.getDifficulty(), tile);
                onClickBuyButton(tile, gryffindorTower);
            };
        });

        buyHufflepuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tower hufflepuffTower = new Tower("Hufflepuff", player.getDifficulty(), tile);
                onClickBuyButton(tile, hufflepuffTower);
            };
        });

        buyRavenclaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tower ravenclawTower = new Tower("Ravenclaw", player.getDifficulty(), tile);
                onClickBuyButton(tile, ravenclawTower);
            };
        });

        buySlytherin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tower slytherinTower = new Tower("Slytherin", player.getDifficulty(), tile);
                onClickBuyButton(tile, slytherinTower);
            };
        });

    }


    public void displayUpgradeOptions(Tile tile, TextView moneyText) {
        Dialog dialog = new Dialog(gameScreen);
        dialog.setContentView(R.layout.activity_upgrade);
        dialog.show();

        Tower currTower = tile.getTower();

        // find UI elements
        TextView towerTitle = (TextView) dialog.findViewById(R.id.towerTitle);
        TextView towerLevel = (TextView) dialog.findViewById(R.id.towerLevel);
        ImageView towerIcon = (ImageView) dialog.findViewById(R.id.towerIcon);
        TextView attackStrength = (TextView) dialog.findViewById(R.id.strengthText);
        TextView attackRadius = (TextView) dialog.findViewById(R.id.radiusText);

        // set up tower description
        towerTitle.setText(currTower.getType() + " Tower");
        towerLevel.setText("Tower Level: " + currTower.getLevel());
        towerIcon.setBackgroundResource(currTower.getTowerIcon());
        attackStrength.setText("Attack Strength: " + currTower.getAttackStrength());
        attackRadius.setText("Attack Radius: " + currTower.getAttackRadius());

        int moneyAmount = player.getMoney();
        Button back = dialog.findViewById(R.id.back1);
        Button upgrade = dialog.findViewById(R.id.upgrade1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            };
        });

        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int upgradePrice = currTower.getUpgradePrice();
                if (moneyAmount >= upgradePrice) {
                    currTower.upgradeTower();
                    player.setMoney(moneyAmount - upgradePrice);
                    Player.setMoneySpent(Player.getMoneySpent() + upgradePrice);
                    moneyText.setText("Money: " + player.getMoney());

                    // update tower description
                    towerLevel.setText("Tower Level: " + currTower.getLevel());
                    attackStrength.setText("Attack Strength: " + currTower.getAttackStrength());
                    attackRadius.setText("Attack Radius: " + currTower.getAttackRadius());

                    dialog.dismiss();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(gameScreen);
                    builder.setCancelable(true);
                    builder.setMessage("You do not have enough coins to upgrade");
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


    private int setupBuyOption(Button buyButton, String type) {
        String difficulty = player.getDifficulty();
        int buyPrice = Tower.calculateTowerPrice(type, difficulty);
        buyButton.setText(buyPrice + " coins");
        return buyPrice;
    }

    private void onClickBuyButton(Tile tile, Tower tower) {
        String towerType = tower.getType();
        int buyPrice = tower.getBuyPrice();

//        Tower purchasedTower = null;

        if (player.getMoney() >= buyPrice) {
            player.setMoney(player.getMoney() - buyPrice);
            Player.setMoneySpent(Player.getMoneySpent() + buyPrice);
            player.setLastPurchased(towerType);

            TextView shopMoneyAmt = dialog.findViewById(R.id.moneyAmount);
            shopMoneyAmt.setText("Money: " + player.getMoney());

//            purchasedTower = new Tower(towerType, player.getDifficulty(), tile);
            Player.getTowers().add(tower);
            tile.setTower(tower);
            if (towerType.equals("Gryffindor")) {
                tile.getTileButton().setBackgroundResource(R.drawable.tower_gryffindor);
            } else if (towerType.equals("Hufflepuff")) {
                tile.getTileButton().setBackgroundResource(R.drawable.tower_hufflepuff);
            } else if (towerType.equals("Ravenclaw")) {
                tile.getTileButton().setBackgroundResource(R.drawable.tower_ravenclaw);
            } else {
                tile.getTileButton().setBackgroundResource(R.drawable.tower_slytherin);
            }

            TextView moneyText = (TextView) gameScreen.findViewById(R.id.money);
            moneyText.setText("Money:" + player.getMoney());
            dialog.dismiss();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(gameScreen);
            builder.setCancelable(true);
            builder.setMessage("You do not have enough coins to purchase tower");
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
