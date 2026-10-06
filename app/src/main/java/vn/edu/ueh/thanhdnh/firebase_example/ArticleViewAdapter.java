package vn.edu.ueh.thanhdnh.firebase_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ArticleViewAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
  private LayoutInflater mInflater;
  private List<Article> articles;
  private Context context;

  public ArticleViewAdapter(Context context, List<Article> articles) {
    this.mInflater = LayoutInflater.from(context);
    this.articles = articles;
    this.context = context;
  }

  public void update(List<Article> articles) {
    this.articles = articles;
  }

  @NonNull
  @Override
  public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View customView = mInflater.inflate(R.layout.article_list, parent, false);
    return new ArticleViewHolder(customView, this);
  }

  @Override
  public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
    Article currentArticle = articles.get(position);
    holder.getTxtTitle().setText(currentArticle.getTitle());

    // Rút gọn nội dung như Lab 07
    String shortContent = currentArticle.getContent();
    if (shortContent != null && shortContent.length() > 80) {
      shortContent = shortContent.substring(0, 80) + "...";
    }
    holder.getTxtContent().setText(shortContent);
    holder.getTxtView().setText("Views: " + currentArticle.getView());

    // Load ảnh bìa từ URL bằng Glide
    String imgUrl = currentArticle.getImg_cover();
    if (imgUrl != null && !imgUrl.isEmpty()) {
      Glide.with(context)
              .load(imgUrl)
              .placeholder(android.R.drawable.ic_menu_gallery)
              .error(android.R.drawable.ic_menu_close_clear_cancel)
              .centerCrop()
              .into(holder.getImgCover());
      holder.getImgCover().setVisibility(View.VISIBLE);
    } else {
      holder.getImgCover().setVisibility(View.GONE);
    }
  }

  @Override
  public int getItemCount() {
    return articles.size();
  }

  public List<Article> getArticles() {
    return articles;
  }

  public Context getContext() {
    return context;
  }
}
