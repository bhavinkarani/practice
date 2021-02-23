package nl.ing.api.cash.order.temp.jv.adn;


public class PendingTransaction {
    //String status;
    public PendingTransaction(Long id){
        this.id = id;
    }
    private Long id;
    public Long getId(){
        return id;
    }
}
