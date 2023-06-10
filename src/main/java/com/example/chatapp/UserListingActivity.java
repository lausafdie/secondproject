package com.example.chatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserListingActivity extends AppCompatActivity {

    private TextView loggedInUserTextView;
    private RecyclerView userRecyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;

    private FirebaseFirestore firebaseFirestore;
    private CollectionReference userCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_listing);

        loggedInUserTextView = findViewById(R.id.loggedInUserTextView);
        userRecyclerView = findViewById(R.id.userListingRecyclerView);

        firebaseFirestore = FirebaseFirestore.getInstance();
        userCollection = firebaseFirestore.collection("users");

        userList = new ArrayList<>();
        userAdapter = new UserAdapter(userList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        userRecyclerView.setLayoutManager(layoutManager);
        userRecyclerView.setAdapter(userAdapter);

        // Set the name of the logged-in user
        // load the name of loggedin user
        String loggedInUserName = getIntent().getStringExtra("name");
        loggedInUserTextView.setText(loggedInUserName);

        ImageView logoutIcon = findViewById(R.id.logoutImageView);
        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });
        loadUsers();
    }

    private void loadUsers() {
        userCollection.get().addOnSuccessListener(queryDocumentSnapshots -> {
            userList.clear();
            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                User user = documentSnapshot.toObject(User.class);
                userList.add(user);
            }
            userAdapter.notifyDataSetChanged();
        });
    }
}
