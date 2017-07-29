package co.com.sistemavuelos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonlagos
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @NotNull
    @Size(min = 4, max = 20)
    private String login;

    @NotNull
    @Size(min = 2, max = 20)
    private String nombre;

    @Size(min = 4, max = 20)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rol_usuario", joinColumns = @JoinColumn(name = "usuario_login", referencedColumnName = "login"), inverseJoinColumns = @JoinColumn(name = "rol_nombre", referencedColumnName = "nombre"))
    private List<Rol> roles = new ArrayList<Rol>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.login == null && other.login != null)
                || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.sistemavuelos.model.Usuario[ login=" + login
                + " ]";
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
