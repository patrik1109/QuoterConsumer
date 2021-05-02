package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Quote implements Serializable {
    int id;
    String text;
    Status status;

}
