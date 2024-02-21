package dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public Integer id;
    public String title;
    public Integer price;
    public String description;
    public List<String> images;
    public Date creationAt;
    public Date updatedAt;
    public Category category;
    public Integer categoryId;
}
