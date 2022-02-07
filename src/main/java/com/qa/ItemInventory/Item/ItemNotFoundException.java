package com.qa.ItemInventory.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.persistence.EntityNotFoundException;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Item not found")
public class ItemNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    public ItemNotFoundException() {
        super();

    }

    public ItemNotFoundException(String message) {
        super(message);

    }
    
}
