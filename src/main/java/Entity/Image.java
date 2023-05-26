package Entity;

public class Image {
    private String idImage,url;

    public Image() {
    }

    public Image(String idImage, String url) {
        this.idImage = idImage;
        this.url = url;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idImage='" + idImage + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
