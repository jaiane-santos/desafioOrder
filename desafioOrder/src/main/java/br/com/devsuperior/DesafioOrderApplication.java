package br.com.devsuperior;
 
import br.com.devsuperior.entities.Order;
import br.com.devsuperior.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import java.util.Locale;
import java.util.Scanner;
 
@SpringBootApplication
public class DesafioOrderApplication implements CommandLineRunner {
 
    @Autowired
    private OrderService orderService;
 
    public static void main(String[] args) {
        SpringApplication.run(DesafioOrderApplication.class, args);
    }
 
    @Override
    public void run(String... args) {
 
        Locale.setDefault(Locale.US);
 
        Scanner sc = new Scanner(System.in);
 
        System.out.println("=== CÁLCULO DO PEDIDO ===");
 
        System.out.print("Digite o código do pedido: ");
        int code = sc.nextInt();
 
        System.out.print("Digite o valor básico do pedido: ");
        double basic = sc.nextDouble();
 
        System.out.print("Digite a porcentagem de desconto: ");
        double discount = sc.nextDouble();
 
        Order order = new Order(code, basic, discount);
 
        double total = orderService.total(order);
 
        System.out.println();
        System.out.println("=== RESULTADO ===");
        System.out.printf("Pedido código %d%n", order.getCode());
        System.out.printf("Valor total: R$ %.2f%n", total);
 
        sc.close();
    }
}