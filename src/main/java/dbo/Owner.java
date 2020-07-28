package dbo;

import com.google.gson.JsonObject;
import com.sun.istack.NotNull;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "phone_number")
    @NotNull
    @Pattern(regexp = "^[+0-9]{12}", message = "wrong phoneNumber format")
    private String phoneNumber;

    public Owner() {
    }

    public Owner(long id, String email, String password, String name, @Pattern(regexp = "^[+0-9]{12}", message = "wrong phoneNumber format") String phoneNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return id == owner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("name", this.getName())
                .append("email", this.getEmail())
                .append("password", this.getPassword())
                .append("phoneNumber", this.phoneNumber).toString();
    }

    public JsonObject toJson() {
        JsonObject ownerJsonObject = new JsonObject();
        ownerJsonObject.addProperty("id", id);
        ownerJsonObject.addProperty("name", name);
        ownerJsonObject.addProperty("email", email);
        ownerJsonObject.addProperty("phoneNumber", phoneNumber);
        return ownerJsonObject;
    }
}
