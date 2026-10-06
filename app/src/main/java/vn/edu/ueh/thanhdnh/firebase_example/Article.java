package vn.edu.ueh.thanhdnh.firebase_example;

public class Article {
  private String title;
  private String content;
  private String img_cover;
  private int view;
  private String docId; // Lưu document ID từ Firestore

  public Article() {
  }

  public Article(String title, String content, String img_cover) {
    this.title = title;
    this.content = content;
    this.img_cover = img_cover;
    this.view = 0;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getImg_cover() {
    return img_cover;
  }

  public void setImg_cover(String img_cover) {
    this.img_cover = img_cover;
  }

  public int getView() {
    return view;
  }

  public void setView(int view) {
    this.view = view;
  }

  public String getDocId() {
    return docId;
  }

  public void setDocId(String docId) {
    this.docId = docId;
  }

  @Override
  public String toString() {
    return "Article{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", img_cover='" + img_cover + '\'' +
            ", view=" + view +
            '}';
  }
}
