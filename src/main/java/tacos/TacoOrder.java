package tacos;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import lombok.Data;

@Data
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private Long id;
    private Date placedAt;

    //what is the point of the serial version UID?
    private static final long serialVersionUID = 1L;
    private List<Taco> tacos = new ArrayList<>();

    //added for data persistance

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}