package be.vdab.koers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RennerNotFoundException extends RuntimeException{
    public RennerNotFoundException() {
        super("Renner niet gevonden");
    }
}
