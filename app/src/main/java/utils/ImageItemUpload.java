package utils;

public class ImageItemUpload {
    private String image;
    private String title;
    private int genre_id;
    private String genre_name;
    private int test_img;

    public ImageItemUpload() {
    }

    public ImageItemUpload(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public ImageItemUpload(String title, int test_img) {
        this.title = title;
        this.test_img = test_img;
    }

    public ImageItemUpload(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }



    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public int getTest_img() {
        return test_img;
    }
}
