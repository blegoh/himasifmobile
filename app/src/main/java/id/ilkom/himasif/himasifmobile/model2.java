package id.ilkom.himasif.himasifmobile;

/**
 * Created by Brian R on 01/01/2018.
 */

public class model2 {
    private int id;
    private String title,image,isi,link,date;

    public model2(int id, String image, String title) {
        this.id = id;
        this.image = image;
        this.title = title;
    }
    public model2(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setIsi(String isi){

        this.isi=isi;
    }
    public String getIsi(){return isi;}

    public void setDate(String date) {
        this.date = date;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }
}
