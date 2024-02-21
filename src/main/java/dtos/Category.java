package dtos;

import lombok.Data;

import java.util.Date;

@Data
public class Category{
    public int id;
    public String name;
    public String image;
    public Date creationAt;
    public Date updatedAt;
}
