package at.kaindorf.webintro.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

// @Value
// Keine Setter
// Alle instanzvariablen sind Final
// All ArgsConstructor
// Klasse ist final

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private  int id;
    private  String first_name;
    private  String last_name;
   // @JsonIgnore //wird ignoriert
    @JsonDeserialize(using = LocalDateDeSerializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

}
