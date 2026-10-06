package vn.edu.ueh.thanhdnh.firebase_example;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
  private TextView txtTitle, txtContent, txtView;
  private ImageView imgCover;
  private ArticleViewAdapter adapter;

  public ArticleViewHolder(@NonNull View itemView, ArticleViewAdapter adapter) {
    super(itemView);
    txtTitle = itemView.findViewById(R.id.txt_title);
    txtContent = itemView.findViewById(R.id.txt_content);
    txtView = itemView.findViewById(R.id.txt_view);
    imgCover = itemView.findViewById(R.id.img_cover);
    this.adapter = adapter;
    itemView.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    int position = getAdapterPosition();
    Article article = adapter.getArticles().get(position);
    Context context = adapter.getContext();

    Intent intent = new Intent(context, DetailActivity.class);
    intent.putExtra("title", article.getTitle());
    intent.putExtra("content", article.getContent());
    intent.putExtra("img_cover", article.getImg_cover());
    intent.putExtra("view", article.getView());
    intent.putExtra("docId", article.getDocId());
    context.startActivity(intent);
  }

  public TextView getTxtTitle() {
    return txtTitle;
  }

  public void setTxtTitle(TextView txtTitle) {
    this.txtTitle = txtTitle;
  }

  public TextView getTxtContent() {
    return txtContent;
  }

  public void setTxtContent(TextView txtContent) {
    this.txtContent = txtContent;
  }

  public TextView getTxtView() {
    return txtView;
  }

  public void setTxtView(TextView txtView) {
    this.txtView = txtView;
  }

  public ImageView getImgCover() {
    return imgCover;
  }

  public void setImgCover(ImageView imgCover) {
    this.imgCover = imgCover;
  }
}
