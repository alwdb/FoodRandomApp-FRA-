package com.example.lastproject1_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button koreanButton, chineseButton, westernButton, japaneseButton;
    ImageView imageView;
    TextView textView;
    //음식 카테고리를 HashMap의 키로 설정하고 해당 카테고리의 음식 리스트는 ArrayList로 저장
    private HashMap<String, ArrayList<FoodItem>> foodMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        koreanButton = (Button) findViewById(R.id.koreanButton);
        chineseButton = (Button) findViewById(R.id.chineseButton);
        westernButton = (Button) findViewById(R.id.westernButton);
        japaneseButton = (Button) findViewById(R.id.japaneseButton);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        FoodData(); //음식 데이터 초기화

        //한식 버튼
        koreanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayRandomFood("koreanButton");
            }
        });
        //중식 버튼
        chineseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayRandomFood("chineseButton");
            }
        });
        //양식 버튼
        westernButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayRandomFood("westernButton");
            }
        });
        //일식 버튼
        japaneseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayRandomFood("japaneseButton");
            }
        });
    }
    public void FoodData() {
        foodMap = new HashMap<>();
        //한식 데이터
        ArrayList<FoodItem> koreanFoods = new ArrayList<>();
        koreanFoods.add(new FoodItem("비빔밥", R.drawable.korean1));
        koreanFoods.add(new FoodItem("김치찌개", R.drawable.korean2));
        koreanFoods.add(new FoodItem("된장찌개", R.drawable.korean3));
        koreanFoods.add(new FoodItem("삼겹살", R.drawable.korean4));
        koreanFoods.add(new FoodItem("떡볶이", R.drawable.korean5));
        foodMap.put("koreanButton", koreanFoods);
        //중식 데이터
        ArrayList<FoodItem> chineseFoods = new ArrayList<>();
        chineseFoods.add(new FoodItem("딤섬", R.drawable.chinese1));
        chineseFoods.add(new FoodItem("마라탕", R.drawable.chinese2));
        chineseFoods.add(new FoodItem("동파육", R.drawable.chinese3));
        chineseFoods.add(new FoodItem("마파두부", R.drawable.chinese4));
        chineseFoods.add(new FoodItem("훠궈", R.drawable.chinese5));
        foodMap.put("chineseButton", chineseFoods);
        //양식 데이터
        ArrayList<FoodItem> westernFoods = new ArrayList<>();
        westernFoods.add(new FoodItem("파스타", R.drawable.western1));
        westernFoods.add(new FoodItem("스테이크", R.drawable.western2));
        westernFoods.add(new FoodItem("햄버거", R.drawable.western3));
        westernFoods.add(new FoodItem("라자냐", R.drawable.western4));
        westernFoods.add(new FoodItem("피자", R.drawable.western5));
        foodMap.put("westernButton", westernFoods);
        //일식 데이터
        ArrayList<FoodItem> japaneseFoods = new ArrayList<>();
        japaneseFoods.add(new FoodItem("초밥", R.drawable.japanese1));
        japaneseFoods.add(new FoodItem("텐동", R.drawable.japanese2));
        japaneseFoods.add(new FoodItem("규카츠", R.drawable.japanese3));
        japaneseFoods.add(new FoodItem("라멘", R.drawable.japanese4));
        japaneseFoods.add(new FoodItem("오코노미야키", R.drawable.japanese5));
        foodMap.put("japaneseButton", japaneseFoods);
    }

    //카테고리 내의 음식 데이터를 랜덤으로 선택
    public void displayRandomFood(String category) {
        ArrayList<FoodItem> foods = foodMap.get(category);
        if(foods != null && !foods.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(foods.size());
            FoodItem randomFood = foods.get(index);
            imageView.setImageResource(randomFood.getImageId());
            textView.setText(randomFood.getName());
        }
    }

    //음식 이름과 이미지를 관리하는 클래스
    private static class FoodItem {
        private String name;
        private int getImageId;

        public FoodItem(String name, int getImageId) {
            this.name = name;
            this.getImageId = getImageId;
        }

        public String getName() {
            return name;
        }

        public int getImageId() {
            return getImageId;
        }
    }
}