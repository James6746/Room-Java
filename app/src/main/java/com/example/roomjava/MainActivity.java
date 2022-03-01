package com.example.roomjava;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomjava.database.UserRepository;
import com.example.roomjava.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView tv_db_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        button = findViewById(R.id.btn_press);
        tv_db_size = findViewById(R.id.tv_db_size);

        button.setOnClickListener(it -> {
            roomDatabase();
        });
    }

    private void roomDatabase() {
        UserRepository repository = new UserRepository(getApplication());
        User user = new User(1, "Sobirov Jamshid");
//        repository.saveUser(user);
        new UserAsyncTask(repository).execute(user);
    }

    class UserAsyncTask extends AsyncTask<User, Void, List<User>> {
        UserRepository repository;

        UserAsyncTask(UserRepository repository) {
            this.repository = repository;
        }

        @Override
        protected List<User> doInBackground(User... users) {
            repository.saveUser(users[0]);
            return repository.getUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            tv_db_size.setText("Room DB size is " + users.size());
        }
    }
}