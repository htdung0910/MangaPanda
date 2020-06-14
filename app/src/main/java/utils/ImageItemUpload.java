package utils;

public class ImageItemUpload {
    private String image;
    private String title;

    public ImageItemUpload() {
    }

    public ImageItemUpload(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
