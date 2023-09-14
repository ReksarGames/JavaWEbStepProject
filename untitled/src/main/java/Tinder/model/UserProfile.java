package Tinder.model;

public class UserProfile {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private int id;
    private String photoUrl;

    public UserProfile(int id, String name, String photoUrl){
        this.id = id;
        this.name=name;
        this.photoUrl= photoUrl;
    }
}
