package at.kaindorf.webintro.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestbookEntry {
    private String nickname;
    private String email;
    private String comment;
}
