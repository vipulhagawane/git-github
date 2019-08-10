package com.spring.mvc.demo.pojo;
 
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
 
import org.springframework.stereotype.Component;
 
@Component
public class User {
 
    @NotEmpty
    @Email
    private String email;
     
    @Size(min=6, max=10, message="Size.userform.password")
    private String password;
 
    public User() { }
 
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
