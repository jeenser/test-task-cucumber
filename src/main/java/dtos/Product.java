package dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Product {
    public int id;
    public String title;
    public int price;
    public String description;
    public List<String> images;
    public Date creationAt;
    public Date updatedAt;
    public Category category;
}
