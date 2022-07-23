package tacos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco
{
    private String name;

    private List<Ingredient> ingredients;

    private Long id;

    private Date createdAt = new Date();


}
