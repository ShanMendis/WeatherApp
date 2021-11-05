package com.example.weather_app20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather_app20.Retrofit.ApiClient;
import com.example.weather_app20.Retrofit.ApiInterface;
import com.example.weather_app20.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    ImageView searchbtn;
    Button searchBtn;
    TextView tempText, descText, humidityText,cityText,minTempText,maxTempText;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        searchbtn = findViewById(R.id.search);
        tempText = findViewById(R.id.tempText);
        cityText = findViewById(R.id.cityText);
        descText = findViewById(R.id.descText);
        humidityText = findViewById(R.id.humidityText);
        minTempText = findViewById(R.id.tempMinText);
        maxTempText = findViewById(R.id.tempMaxText);
        textField = findViewById(R.id.textField);
        searchBtn = findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String textInput = textField.getText().toString();
                    if (textInput.matches("")) {
                        Toast.makeText(MainActivity.this, "Enter City Name", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        getWeatherData(textField.getText().toString().trim());
//                        textField.setText("");
                    }
                }catch (NullPointerException e){
                    Toast.makeText(MainActivity.this, "Enter Valid City Name", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }



    private void getWeatherData(String name){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                String cel = "°C";
                Log.d("DATA", response.body().getMain().getTemp());
                cityText.setText(textField.getText().toString().toUpperCase());
                textField.setText("");
                tempText.setText(response.body().getMain().getTemp()+ cel);
                minTempText.setText("Min_Temp    : "+response.body().getMain().getTemp_min()+ cel);
                maxTempText.setText("Max_Temp   : "+response.body().getMain().getTemp_max()+ cel);
                descText.setText("Feels Like    : "+""+response.body().getMain().getFeels_like()+cel);
                humidityText.setText("Humidity      : "+""+response.body().getMain().getHumidity()+"%");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
            }
        });
    }
}