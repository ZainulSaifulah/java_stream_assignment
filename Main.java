import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    
    static List<Invoice> init() {
        List<Invoice> invoices = new ArrayList<>();
        for (int n = 0; n < 10; n++) {
            invoices.add(new Invoice("Invoice#" + n, n * 10, n, Customer.ORACLE, LocalDateTime.now() ));
        }

        for (int n = 0; n < 10; n++) {
            invoices.add(new Invoice("Training#" + n, n * 10, n, Customer.ORACLE, LocalDateTime.now()));
        }
        return invoices;
    }
    
    public static void main(String[] args) {
        List<Invoice> invoices = init();

        //PBI 1 - Create Interface and using Lambda Expression
        System.out.println("-- PBI 1 --");
        printWithFilter(invoices, (invoice) -> invoice.getAmount() > 10);

        //PBI 2 - Method Reference
        //PBI 3 - Stream and Filtering
        //PBI 4 - Stream and Mapping
        System.out.println("-- PBI 2, 3, & 4 --");
        List<Integer> invoiceIds = invoices.stream()
                .filter(invoice -> invoice.getCustomer() == Customer.ORACLE && invoice.getTitle().contains("Training"))
                .sorted(Comparator.comparingDouble(Invoice::getAmount))
                .limit(5)
                .map(Invoice::getId)
                .collect(Collectors.toList());
        System.out.println(invoiceIds);

        // PBI 5 - Reduce
        System.out.println("-- PBI 5 --");
        Double i = invoices.stream()
            .map(inv -> inv.getAmount())
            .reduce(0.0, (amount1, amount2) ->  amount1 + amount2);
        System.out.println(i);
        
        //PBI 6 - Date Time API
        //PBI 7 - Use Period and Duration class 
        System.out.println("-- PBI 6 & 7 --");
        List<LocalDateTime> invoicePlus1Days30Seconds = invoices.stream()
                .map(invoice -> {
                    LocalDateTime date = invoice.getDateTime()
                        .plus(Period.ofDays(1))
                        .plus(Duration.ofSeconds(30));
                    return date;
                    })
                .collect(Collectors.toList());
        System.out.println(invoicePlus1Days30Seconds);
                
        //PBI 8 - Optional
        System.out.println("-- PBI 8 --");
        String firstTitle = Optional.ofNullable(invoices.get(0).getTitle()).orElseGet(() -> "Empty");
        System.out.println(firstTitle);
    }

    static void printWithFilter(List<Invoice> invoices, InvoiceCheck invoiceCheck) {
        for(Invoice invoice : invoices) {
            if(invoiceCheck.check(invoice)) {
                System.out.println(invoice.getTitle());
            }
        }
    }
}


