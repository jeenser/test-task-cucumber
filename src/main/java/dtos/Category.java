package dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category{
    public int id;
    public String name;
    public String image;
    public Date creationAt;
    public Date updatedAt;
}
