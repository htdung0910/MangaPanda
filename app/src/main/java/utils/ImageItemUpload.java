package utils;

public class ImageItemUpload {
    private int image;
    private String title;

    public ImageItemUpload() {
    }

    public ImageItemUpload(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
