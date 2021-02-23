package nl.ing.api.cash.order.temp.jv.adn;

import java.util.Optional;

public class ProcessedTransaction {
     private String status;
     private String id;
    public ProcessedTransaction(String id, String status){
        this.id = id;
        this.status = status;
    }
    public Optional<String> getStatus() {
        return Optional.of(status);
    }
    public String getId() {
        return id;
    }
}
