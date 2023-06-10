package com.example.chatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profilePictureImageView;
        private TextView nameTextView;
        private TextView contentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            profilePictureImageView = itemView.findViewById(R.id.profilePictureImageView);
//            nameTextView = itemView.findViewById(R.id.nameTextView);
//            contentTextView = itemView.findViewById(R.id.contentTextView);
        }

        public void bind(Message message) {
            nameTextView.setText(message.getName());
            contentTextView.setText(message.getContent());

            if (message.isOwnMessage()) {
                // Set the profile picture for own messages
                Glide.with(itemView.getContext())
                        .load(message.getProfilePicture())
                        .into(profilePictureImageView);
            } else {
                // Set a default profile picture for other messages
//                profilePictureImageView.setImageResource(R.drawable.default_profile_picture);
            }
        }
    }
}

