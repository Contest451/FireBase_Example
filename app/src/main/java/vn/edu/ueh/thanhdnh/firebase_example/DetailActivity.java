package vn.edu.ueh.thanhdnh.firebase_example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailActivity extends AppCompatActivity {

    TextView ttitle, tcontent, tview;
    ImageView timgcover;
    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ttitle = findViewById(R.id.ttitle);
        tcontent = findViewById(R.id.tcontent);
        tview = findViewById(R.id.tview);
        timgcover = findViewById(R.id.timgcover);
        btBack = findViewById(R.id.btBack);

        // Nhận dữ liệu từ Intent
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        String imgCover = getIntent().getStringExtra("img_cover");
        int view = getIntent().getIntExtra("view", 0);
        String docId = getIntent().getStringExtra("docId");

        // Tăng lượt view lên 1
        view = view + 1;

        // Hiển thị dữ liệu
        ttitle.setText(title);
        tcontent.setText(content);
        tview.setText("Views: " + view);

        // Load ảnh bìa từ URL bằng Glide
        if (imgCover != null && !imgCover.isEmpty()) {
            Glide.with(this)
                    .load(imgCover)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_close_clear_cancel)
                    .centerCrop()
                    .into(timgcover);
        }

        // Cập nhật lượt view lên Firebase
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        if (docId != null) {
            db.collection("articles").document(docId)
                    .update("view", view);
        }

        // Nút Back
        btBack.setOnClickListener(v -> {
            finish();
        });
    }
}
