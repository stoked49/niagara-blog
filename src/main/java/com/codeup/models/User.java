package com.codeup.models;

        import org.hibernate.validator.constraints.Email;
        import org.hibernate.validator.constraints.NotBlank;

        import javax.persistence.*;
        import javax.validation.constraints.Size;
        import java.util.List;

/**
 * Created by Irb on 2/10/17.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Enter a username")
    @Size(min = 4, message = "username must be at least 4 characters long")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Enter an email address")
    @Email(message = "Enter a valid email address")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "your password cannon be empty")
    @Size(min = 8, message = "your password should have at least 8 characters")
    private String password;

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "user") // defined at the object level
            List<Post> posts;  // these are all the posts created by this user

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // pattern
    // copy constructor -> an alternative to clone
    public User(User user) {
        id = user.id;
        username = user.username;
        password = user.password;
        email = user.email;
        posts = user.posts;
    }

    public User() {
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}