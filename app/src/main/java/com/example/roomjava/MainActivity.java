package com.example.roomjava;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomjava.database.UserRepository;
import com.example.roomjava.model.User;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        button = findViewById(R.id.btn_press);

        button.setOnClickListener(it -> {
            roomDatabase();
        });
    }

    private void roomDatabase() {
        UserRepository repository = new UserRepository(getApplication());
        User user = new User(1, "Sobirov Jamshid");
        repository.saveUser(user);
//        new UserASyncTask(repository).execute(user);
    }
}