package com.android.tonyvu.sc.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;
import com.android.tonyvu.sc.demo.constant.Constant;
import com.android.tonyvu.sc.demo.model.Product;
import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private static final String TAG = "ProductActivity";
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<String> booklist;
    ArrayList<Integer> alImage;
    TextView tvProductName;
    TextView tvProductDesc;
    ImageView ivProductImage;
    Spinner spQuantity;
    Button bOrder;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product);

        Bundle data = getIntent().getExtras();
        product = (Product) data.getSerializable("product");

        Log.d(TAG, "Product hashCode: " + product.hashCode());

        //Set Shopping Cart link
        setShoppingCartLink();

        //Retrieve views
        retrieveViews();

        //Set product properties
        setProductProperties();

        //Initialize quantity
        initializeQuantity();

        //On ordering of product
        onOrderProduct();
        String book = product.getName().toString();
        JSONObject obj = null;

        try {
            obj = new JSONObject(loadJSONFromAsset());
            String rec = obj.getString(book), mystring="";
            booklist = new ArrayList<> (Arrays.asList(rec.split("\\s*,\\s*")));
           // for(String i:booklist){
             //   mystring = mystring + i + "\n";
            //}
           //Intent intent = new Intent(ProductActivity.this, ProductActivity.class);
           //intent.putStringArrayListExtra("key", booklist);
           //startActivity(intent);
           //PrintRecommendations.setText(mystring);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //ArrayList<String> booklist = (ArrayList<String>) getIntent().getSerializableExtra("key");
        //alName = new ArrayList<>(Arrays.asList("Cheesy...", "Crispy... ", "Fizzy...", "Cool...", "Softy...", "Fruity...", "Fresh...", "Sticky..."));
        alImage = new ArrayList<>(Arrays.asList(R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7));

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HLVAdapter(ProductActivity.this, booklist, alImage);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setShoppingCartLink() {
        TextView tvViewShoppingCart = (TextView)findViewById(R.id.tvViewShoppingCart);
        SpannableString content = new SpannableString(getText(R.string.shopping_cart));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvViewShoppingCart.setText(content);
        tvViewShoppingCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void retrieveViews() {
        tvProductName = (TextView) findViewById(R.id.tvProductName);
        tvProductDesc = (TextView) findViewById(R.id.tvProductDesc);
        ivProductImage = (ImageView) findViewById(R.id.ivProductImage);
        spQuantity = (Spinner) findViewById(R.id.spQuantity);
        bOrder = (Button) findViewById(R.id.bOrder);
    }

    private void setProductProperties() {
        tvProductName.setText(product.getName());
        tvProductDesc.setText(product.getDescription());
        ivProductImage.setImageResource(this.getResources().getIdentifier(product.getImageName(), "drawable", this.getPackageName()));
    }

    private void initializeQuantity() {
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, Constant.QUANTITY_LIST);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuantity.setAdapter(dataAdapter);
    }

    private void onOrderProduct() {
        bOrder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart cart = CartHelper.getCart();
                Log.d(TAG, "Adding product: " + product.getName());
                cart.add(product, Integer.valueOf(spQuantity.getSelectedItem().toString()));
                Intent intent = new Intent(ProductActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("recommendations.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
