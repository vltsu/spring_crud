package jettyapp.mvc.model;


import javax.validation.constraints.Size;

public class User {

    private Long id;
    @Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
    private String name;
    private String email;
    private String image;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }


}
