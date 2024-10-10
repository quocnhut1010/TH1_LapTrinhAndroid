package com.example.th1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupMenu; // Import PopupMenu

public class MyListView extends Activity implements AdapterView.OnItemSelectedListener {
    ListView simpleList;
    Spinner spin;
    ImageView imageViewSelectedCountry; // ImageView để hiển thị hình ảnh
    TextView textViewSelectedCountryPosition; // TextView để hiển thị vị trí
    String countryList[] = {"VietNam", "China", "Malaysia", "Brazil", "Korea"};
    int flags[] = {R.drawable.vietnam, R.drawable.china, R.drawable.malaysia, R.drawable.brazil, R.drawable.korea};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_view);

        // Initialize ListView
        simpleList = findViewById(R.id.simpleListView);
        CustomAdapter adapter = new CustomAdapter(this, countryList, flags);
        simpleList.setAdapter(adapter);

        // Handle ListView click events
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Hiển thị vị trí và tên quốc gia trong Toast
                String message = "Country: " + countryList[position] + ", Position: " + position;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                // Cập nhật hình ảnh theo quốc gia được chọn từ ListView
                imageViewSelectedCountry.setImageResource(flags[position]);

                // Cập nhật vị trí vào TextView
                textViewSelectedCountryPosition.setText("Position: " + position);
            }
        });

        // Initialize Spinner and set adapter
        spin = findViewById(R.id.simpleSpinner);
        CustomAdapter spinnerAdapter = new CustomAdapter(this, countryList, flags);
        spin.setAdapter(spinnerAdapter);
        spin.setOnItemSelectedListener(this);

        // Initialize ImageView and TextView
        imageViewSelectedCountry = findViewById(R.id.imageViewSelectedCountry); // Thay đổi ID cho đúng
        textViewSelectedCountryPosition = findViewById(R.id.textViewSelectedCountryPosition); // Thay đổi ID cho đúng

// Initialize Button for Popup Menu
        Button buttonOpenMenu = findViewById(R.id.buttonOpenMenu);
        buttonOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(MyListView.this, buttonOpenMenu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                // Set menu item click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(android.view.MenuItem item) {
                        int id = item.getItemId();

                        // Use if-else instead of switch-case
                        if (id == R.id.menu_main) {
                            // Navigate to MainActivity
                            Intent intentMain = new Intent(MyListView.this, MainActivity.class);
                            startActivity(intentMain);
                            return true;
                        } else if (id == R.id.menu_gridview) {
                            // Navigate to GridView Activity
                            Intent intentGrid = new Intent(MyListView.this, MyGirdView.class);
                            startActivity(intentGrid);
                            return true;
                        } else if (id == R.id.menu_main1){
                            Intent intentCaculator = new Intent(MyListView.this, Main.class);
                            startActivity(intentCaculator);
                            return true;
                        }  else if (id == R.id.menu_temp){
                            Intent intentCaculatorTemp = new Intent(MyListView.this, DoiNhietDo.class);
                            startActivity(intentCaculatorTemp);
                            return true;
                        } else if (id == R.id.menu_login){
                            Intent intentLogin = new Intent(MyListView.this, Login.class);
                            startActivity(intentLogin);
                            return true;
                        } else if (id == R.id.menu_lich){
                            Intent intentLich = new Intent(MyListView.this, Lich.class);
                            startActivity(intentLich);
                            return true;
                        }else {
                            return false;
                        }
                    }
                });

                // Show the popup menu
                popupMenu.show();
            }
        });
    }

    // Spinner item selection handling
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Hiển thị vị trí và tên quốc gia trong Toast
        String message = "Country: " + countryList[position] + ", Position: " + position;
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        // Cập nhật hình ảnh theo quốc gia được chọn từ Spinner
        imageViewSelectedCountry.setImageResource(flags[position]);

        // Cập nhật vị trí vào TextView
        textViewSelectedCountryPosition.setText("Position: " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle the case where no item is selected
    }
}
