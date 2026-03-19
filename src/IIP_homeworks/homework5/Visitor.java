package IIP_homeworks.homework5;
import java.util.Objects;

public class Visitor {
    protected String name;
    protected String passId;

    public Visitor(String name, String passId){
        this.name = name;
        this.passId = passId;
    }

    public String getName() {
        return name;
    }

    public String getPassId() {
        return passId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Visitor visitor = (Visitor) o;
        return Objects.equals(passId, visitor.passId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passId);
    }

    @Override
    public String toString() {
        return "Visitor{name='" + name + "', passId='" + passId + "'}";
    }
}
