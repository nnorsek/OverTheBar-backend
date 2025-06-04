package springapi.overthebar_backend.model;

public class Image {
    private String imgSrc;
    private String alt;

    public Image(String imgSrc, String alt) {
        this.imgSrc = imgSrc;
        this.alt = alt;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    

    
}
