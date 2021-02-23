package nl.ing.api.cash.order.temp.jv.adn;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;


public class AdyenReconciler {

    Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, Stream<Stream<ProcessedTransaction>> processed) {
        if(processed == null) {
            return Stream.empty();
        }
        Supplier<Stream<ProcessedTransaction>> filteredProcessedTransactions = () -> processed
                .flatMap(p -> p)
                .filter(Objects::nonNull)
                .filter(p -> p.getStatus() != null && p.getStatus().isPresent() && "DONE".equals(p.getStatus().get()))
                .filter(p -> p.getId() != null && p.getId().length() > 0);

        if(pending == null ){
            return filteredProcessedTransactions.get().map(p-> new PendingTransaction(Long.valueOf(p.getId())));
        }
        Set<Long>  filteredProcessedId = filteredProcessedTransactions.get().map(p-> Long.valueOf(p.getId())).collect(Collectors.toSet());

        return pending.
                filter(p-> p!=null)
                .filter(p-> p.getId()!=null)
                .filter(p -> filteredProcessedId.stream().anyMatch(pr -> pr.equals(p.getId())));

        /*if(pending == null ){
            return processed
                    .flatMap(p -> p)
                    .filter(Objects::nonNull)
                    .filter(p -> p.getStatus() != null && p.getStatus().isPresent() && "DONE".equals(p.getStatus().get()))
                    .filter(p -> p.getId() != null && p.getId().length() > 0)
                    .map(p-> new PendingTransaction(Long.valueOf(p.getId())));
        }
        Set<Long>  filteredProcessedId = processed
                .flatMap(p -> p)
                .filter(Objects::nonNull)
                .filter(p -> p.getStatus() != null && p.getStatus().isPresent() && "DONE".equals(p.getStatus().get()))
                .filter(p -> p.getId() != null && p.getId().length() > 0)
                .map(p -> Long.parseLong(p.getId()))
                .collect(Collectors.toSet());

        return pending.
                filter(p-> p!=null)
                .filter(p-> p.getId()!=null)
                .filter(p -> filteredProcessedId.stream().anyMatch(pr -> pr.equals(p.getId())));*/

    }

    public static void main(String[] args){
        AdyenReconciler adyenReconciler = new AdyenReconciler();
        List<ProcessedTransaction> processedTransaction1= new ArrayList<ProcessedTransaction>();
        List<ProcessedTransaction> processedTransaction2= new ArrayList<ProcessedTransaction>();
        List<ProcessedTransaction> processedTransaction3= new ArrayList<ProcessedTransaction>();
        List<ProcessedTransaction> processedTransaction4= new ArrayList<ProcessedTransaction>();
        List<ProcessedTransaction> processedTransaction5= new ArrayList<ProcessedTransaction>();
        List<PendingTransaction> pendingTransactions = new ArrayList<PendingTransaction>();
        pendingTransactions.add(new PendingTransaction(11111L));
        pendingTransactions.add(new PendingTransaction(11111L));
        pendingTransactions.add(new PendingTransaction(2222L));
        pendingTransactions.add(new PendingTransaction(333333L));
        pendingTransactions.add(new PendingTransaction(44444L));
        pendingTransactions.add(new PendingTransaction(55555L));
        pendingTransactions.add(new PendingTransaction(66666L));
        pendingTransactions.add(new PendingTransaction(null));
        pendingTransactions.add(null);
        processedTransaction1.add(new ProcessedTransaction("11111", "DONE"));
        processedTransaction2.add(new ProcessedTransaction("2222", "DONE"));
        processedTransaction3.add(new ProcessedTransaction("333333", "DONE"));
        processedTransaction4.add(new ProcessedTransaction("44444", "DONE"));
        processedTransaction5.add(new ProcessedTransaction("11111", "DONE"));
        processedTransaction5.add(null);
        Stream<PendingTransaction> pending =  adyenReconciler.reconcile(pendingTransactions.stream(),
                Stream.of(
                        processedTransaction1.stream(),
                        processedTransaction2.stream(),
                        processedTransaction3.stream(),
                        processedTransaction4.stream(),
                        processedTransaction5.stream(),
                        null
                        ));
        pending.forEach(p-> System.out.println(p.getId()));
        System.out.println("===============================");
        pending = adyenReconciler.reconcile(null,null);
        pending.forEach(p-> System.out.println(p.getId()));
        System.out.println("===============================");
        pending = adyenReconciler.reconcile(pendingTransactions.stream(),null);
        pending.forEach(p-> System.out.println(p.getId()));
        System.out.println("===============================");
        pending = adyenReconciler.reconcile(null, Stream.of(
                processedTransaction1.stream(),
                processedTransaction2.stream(),
                processedTransaction3.stream(),
                processedTransaction4.stream(),
                processedTransaction5.stream(),
                null
        ));
        pending.forEach(p-> System.out.println(p.getId()));

    }



}