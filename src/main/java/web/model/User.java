package web.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table( name = "users" )
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @NotEmpty( message = "Не пустое" )
    @Column(name = "surname")
    private String surName;

    @Min(value = 1, message = "1...100")
    @Max(value = 100 )
    @Column( name = "age")
    private int age;

    @Column( name = "email")
    private String eMail;

    public User() {
    }

    public User(int id, String name, String surName, int age, String eMail) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.eMail = eMail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
