package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Models.Champion;
import com.example.myapplication.Models.ChampionCompUse;

import java.io.InputStream;

public class ShowChampionDetail extends AppCompatActivity {

    TextView tvNameChamp,tvOrigin,tvSynergy,tvNangLuong,tvMau
            ,tvNLKhoiDau,tvTamDanh,tvSatThuong,
            tvTocDoDanh,tvGiap,tvDps,tvKhangPhep,tvSkillName,tvSkillDes;

    ImageView imgChamp, imgItem1,imgItem2,imgItem3,imgSkill;

    Champion champion;

    ChampionCompUse champComp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champion_detail);
        bindingView();
        Intent intent = getIntent();
        String nameChamp = intent.getStringExtra("champName");
        String capitalized = nameChamp.substring(0, 1).toUpperCase() + nameChamp.substring(1);
        tvNameChamp.setText(capitalized);
        String champOrigin = intent.getStringExtra("champOrigin");
        String capitalized1 = champOrigin.substring(5, 6).toUpperCase() + champOrigin.substring(6);
        tvOrigin.setText(capitalized1);
        String champMana = intent.getStringExtra("champMana");
        int champSynergySize = intent.getExtras().getInt("champSynergySize");
        String synergy ="";
        String capitalize ="";
        for(int i=0;i<champSynergySize;i++){
            synergy = intent.getStringExtra("champSynergy"+i);
            capitalize += synergy.substring(5, 6).toUpperCase() + synergy.substring(6)+"    ";
        }
        tvSynergy.setText(capitalize);
        int champItemSize = intent.getExtras().getInt("champItemSize");
        Log.d("champSize", champItemSize+"");
        for(int i=0;i<champItemSize;i++){
            String item = intent.getStringExtra("champItem"+i);
            Bitmap itemImage = GetItemById(item);

            if(i==0){
                imgItem1.setImageBitmap(itemImage);
            }
            if(i==1){
                imgItem2.setImageBitmap(itemImage);
            }
            if(i==2){
                imgItem3.setImageBitmap(itemImage);
            }
        }
          String champId = intent.getStringExtra("champId");
        String champInitMana = String.valueOf(intent.getExtras().getInt("champInitMana"));
        String champHealth = intent.getStringExtra("champHealth");
        String champAttackRange = String.valueOf(intent.getExtras().getInt("champAttackRange"));
        String champAttackDamage = intent.getStringExtra("champAttackDame");
        String champAttackSpeed = intent.getStringExtra("champAttackSpeed");
        String champArmor = String.valueOf(intent.getExtras().getInt("champArmor"));
        String champDps = intent.getStringExtra("champDps");
        String champMagicResist = String.valueOf(intent.getExtras().getInt("champMagicResist"));
        String champSkill = intent.getStringExtra("champSkill");
        String capitalized3 = champSkill.substring(0, 1).toUpperCase() + champSkill.substring(1);
        String champSkillDes = intent.getStringExtra("champSkillDes");
        String capitalized4 = champSkillDes.substring(0, 1).toUpperCase() + champSkillDes.substring(1);
        Log.d("ngu", "NL Khoi Dau-"+champInitMana+"Tam Danh-"+champAttackRange+"Giap-"+champArmor+"Khang Phep"+champMagicResist);
        tvNangLuong.setText(champMana);
        tvMau.setText(champHealth);
        tvNLKhoiDau.setText(champInitMana);
        tvTamDanh.setText(champAttackRange);
        tvSatThuong.setText(champAttackDamage);
        tvTocDoDanh.setText(champAttackSpeed);
        tvGiap.setText(champArmor);
        tvDps.setText(champDps);
        tvKhangPhep.setText(champMagicResist);
        tvSkillName.setText(capitalized3);
        tvSkillDes.setText(capitalized4);
        Bitmap champImage = GetChampionById(champId);
        imgChamp.setImageBitmap(champImage);
        Bitmap skillImage = GetSkillById(nameChamp);
        imgSkill.setImageBitmap(skillImage);

    }

    private Bitmap GetChampionById(String id) {
                String ChampImage = "champions/" + id + ".png";
                try {
                    InputStream inputStream = getAssets().open(ChampImage);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        return null;
    }

    private Bitmap GetItemById(String id) {
        String ItemImage = "items/" + id + ".png";
        try {
            InputStream inputStream = getAssets().open(ItemImage);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Bitmap GetSkillById(String name) {
        String ItemImage = "spells/tft8_" + name + ".png";
        try {
            InputStream inputStream = getAssets().open(ItemImage);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    private void bindingView(){
        tvNameChamp = findViewById(R.id.tvNameChamp);
        tvOrigin = findViewById(R.id.tvOrigin);
        tvSynergy = findViewById(R.id.tvSynergy);
        tvNangLuong = findViewById(R.id.tvNangLuong);
        tvMau = findViewById(R.id.tvMau);
        tvNLKhoiDau = findViewById(R.id.tvNLKhoiDau);
        tvTamDanh = findViewById(R.id.tvTamDanh);
        tvSatThuong = findViewById(R.id.tvSatThuong);
        tvTocDoDanh = findViewById(R.id.tvTocDoDanh);
        tvGiap = findViewById(R.id.tvGiap);
        tvDps = findViewById(R.id.tvDps);
        tvKhangPhep = findViewById(R.id.tvKhangPhep);
        tvSkillName = findViewById(R.id.tvSkillName);
        tvSkillDes = findViewById(R.id.tvSkillDes);
        imgChamp = findViewById(R.id.imgChampion);
        imgItem1 = findViewById(R.id.imgItem1);
        imgItem2 = findViewById(R.id.imgItem2);
        imgItem3 = findViewById(R.id.imgItem3);
        imgSkill = findViewById(R.id.imgSkill);
    }



}
