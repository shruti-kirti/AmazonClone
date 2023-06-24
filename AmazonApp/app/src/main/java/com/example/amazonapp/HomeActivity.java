package com.example.amazonapp;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.amazonapp.MenuFiles.BaseActivity;
import com.example.amazonapp.MenuFiles.CartActivity;
import com.example.amazonapp.MenuFiles.SearchActivity;
import com.example.amazonapp.constant.Constant;
import com.example.amazonapp.model.Product;
import com.example.amazonapp.viewholder.ProductAdapter;
import com.example.amazonapp.viewholder.SliderAdapter;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.math.BigDecimal;

public class HomeActivity extends BaseActivity {

    Toolbar toolbar;
    SliderView sliderView;
    int[] images={R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};

    CardView shoes1,shoes2,shoes3,shoes4,shoes5;
    TextView oddshoename,oddshoeprice,evenshoename,evenshoeprice,viewALL;
    LinearLayout dynamicContent;
    LinearLayout bottonNavbar;

    public  ImageView home_cart;

    Intent intentcart;
    String getcartupdate;
    FirebaseStorage storage;
    StorageReference storageReference;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_home);

        dynamicContent=findViewById(R.id.dynamicContent);
        bottonNavbar=findViewById(R.id.bottomNavBar);
        View wizard=getLayoutInflater().inflate(R.layout.activity_home,null);
        dynamicContent.addView(wizard);

        RadioGroup rg=findViewById(R.id.radioGroup1);
        RadioButton rb=findViewById(R.id.bottom_home);

        rb.setBackgroundColor(R.color.item_selected);
        rb.setTextColor(Color.parseColor("#3F5185"));

        sliderView=findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundResource(R.drawable.bg_color);

        shoes1 = findViewById(R.id.shoes1);
        shoes2 = findViewById(R.id.shoes2);
        shoes3 = findViewById(R.id.shoes3);
        shoes4 = findViewById(R.id.shoes4);
        shoes5 = findViewById(R.id.shoes5);

        oddshoename = findViewById(R.id.oddshoename);
        oddshoeprice = findViewById(R.id.oddshoeprice);
        evenshoename = findViewById(R.id.evenshoename);
        evenshoeprice = findViewById(R.id.evenshoeprice);

        viewALL = findViewById(R.id.viewAllProducts);

        home_cart = findViewById(R.id.home_cart);

        intentcart=getIntent();
        if(intentcart.getStringExtra("cartadd")!=null && intentcart.getStringExtra("cartadd").equals("yes"))
        {
            home_cart.setImageResource(R.drawable.cart_notif);
        } else if (intentcart.getStringExtra("cartadd")!=null && intentcart.getStringExtra("cartadd").equals("no")) {
            home_cart.setImageResource(R.drawable.cart);
        }
        else {
            home_cart.setImageResource(R.drawable.cart);
        }
        storage = FirebaseStorage.getInstance();

        shoes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ProductDetails.class);
                i.putExtra("name", oddshoename.getText().toString());
                i.putExtra("category", "Men's Running Shoes");
                i.putExtra("price", oddshoeprice.getText().toString());
                i.putExtra("uniqueId", oddshoename.getText().toString());
                i.putExtra("id", 1);
                startActivity(i);
            }
        });

        shoes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ProductDetails.class);
                i.putExtra("name", evenshoename.getText().toString());
                i.putExtra("category", "Men's Shoes");
                i.putExtra("price", evenshoeprice.getText().toString());
                i.putExtra("uniqueId", evenshoename.getText().toString());
                i.putExtra("id", 2);
                startActivity(i);
            }
        });

        shoes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ProductDetails.class);
                i.putExtra("name", oddshoename.getText().toString());
                i.putExtra("category", "Men's Running Shoes");
                i.putExtra("price", oddshoeprice.getText().toString());
                i.putExtra("uniqueId", oddshoename.getText().toString());
                i.putExtra("id", 1);
                startActivity(i);
            }
        });

        shoes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ProductDetails.class);
                i.putExtra("name", evenshoename.getText().toString());
                i.putExtra("category", "Men's Shoes");
                i.putExtra("price", evenshoeprice.getText().toString());
                i.putExtra("uniqueId", evenshoename.getText().toString());
                i.putExtra("id", 2);
                startActivity(i);
            }
        });

        shoes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ProductDetails.class);
                i.putExtra("name", oddshoename.getText().toString());
                i.putExtra("category", "Men's Running Shoes");
                i.putExtra("price", oddshoeprice.getText().toString());
                i.putExtra("uniqueId", oddshoename.getText().toString());
                i.putExtra("id", 1);
                startActivity(i);
            }
        });

        ListView lvProducts = (ListView) findViewById(R.id.productslist);

        ProductAdapter productAdapter = new ProductAdapter(this);
        productAdapter.updateProducts(Constant.PRODUCT_LIST);

        lvProducts.setAdapter(productAdapter);

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Product product = Constant.PRODUCT_LIST.get(position);
                Intent intent = new Intent(HomeActivity.this, ProductDetails.class);
                intent.putExtra("id", 3);
                intent.putExtra("uniqueId", product.getpName());
                intent.putExtra("name", product.getpName());
                intent.putExtra("description", product.getpDescription());
                intent.putExtra("category", "Smartphone");
                intent.putExtra("pprice", Constant.CURRENCY + String.valueOf(product.getpPrice().setScale(0, BigDecimal.ROUND_HALF_UP)));
                intent.putExtra("imageName", product.getpImageName());
             //   Log.d("TAG", "View product: " + product.getName());
                startActivity(intent);
            }
        });
        home_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        viewALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }


}