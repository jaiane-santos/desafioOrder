package br.com.devsuperior.services;

import org.springframework.stereotype.Service;

import br.com.devsuperior.entities.Order;

@Service
public class OrderService {
	 
    private ShippingService shippingService;
 
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }
 
    public double total(Order order) {
 
        double discountValue = order.getBasic() * order.getDiscount() / 100.0;
 
        double shipping = shippingService.shipment(order);
 
        return order.getBasic() - discountValue + shipping;
    }
}