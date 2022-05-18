package com.example.mad_p02_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user1 = new User("Isabelle Pak", "NP IT Year 2 Student", 1, false);

        Intent intent = getIntent();
        int randomInteger = intent.getIntExtra("randomInt", 0);

        TextView userName = findViewById(R.id.name);
        String userNameWithNum = user1.Name + " " + randomInteger;
        userName.setText(userNameWithNum);

        TextView userDescription = findViewById(R.id.description);
        userDescription.setText(user1.Description);

        Button userFollowed = findViewById(R.id.followed);

        if (user1.Followed = true){
            userFollowed.setText("Unfollow");
        }

        userFollowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.Followed){
                    userFollowed.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_LONG).show();
                    user1.Followed = false;
                }
                else {
                    userFollowed.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_LONG).show();
                    user1.Followed = true;
                }
            }
        });

        Button userMessage = findViewById(R.id.message);
        userMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent2);
            }
        });
    }
}
