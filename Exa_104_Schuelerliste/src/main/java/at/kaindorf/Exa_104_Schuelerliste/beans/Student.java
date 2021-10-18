package at.kaindorf.Exa_104_Schuelerliste.beans;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
public class Student {
    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @NonNull
    private String name;
    @NonNull
    private String suname;
    @NonNull
    private String className;
    @NonNull
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;
    private int catNo;
    private String fullName = name + " " + suname;

    public Student(String line) {
        String[] tokens = line.split(";");
        this.name = tokens[2];
        this.suname = formatter(tokens[1]);
        this.className = tokens[0];
        this.birthDate = LocalDate.parse(tokens[3], DTF);
    }
    public String formatter(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %d", suname, name, className, birthDate, catNo);
    }
}
