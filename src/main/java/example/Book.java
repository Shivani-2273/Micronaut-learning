package example;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Serdeable
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    private int pages;

}
