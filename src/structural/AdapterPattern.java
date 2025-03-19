package structural;

public class AdapterPattern {
    public static void main(String[] args) {
        // Use Razorpay
        PaymentGateway razorpay = new RazorpayAdapter("API_KEY", "API_SECRET");
        PaymentService service1 = new PaymentService(razorpay);
        service1.pay(1000); // ₹1000 via Razorpay

        // Use PayPal
        PaymentGateway paypal = new PayPalAdapter("CLIENT_ID", "CLIENT_SECRET");
        PaymentService service2 = new PaymentService(paypal);
        service2.pay(50); // $50 via PayPal

        // Use Stripe
        PaymentGateway stripe = new StripeAdapter("STRIPE_SECRET");
        PaymentService service3 = new PaymentService(stripe);
        service3.pay(75); // $75 via Stripe
    }
}

// Common interface for all payment gateways
interface PaymentGateway {
    void processPayment(double amount);
}
class RazorpayClient {
    public RazorpayClient(String apiKey, String apiSecret) {}
    public void makePayment(double amount) {
        System.out.println("Razorpay Payment of ₹" + amount + " Successful!");
    }
}

class PayPalClient {
    public PayPalClient(String clientId, String clientSecret) {}
    public void sendPayment(double amount) {
        System.out.println("PayPal Payment of $" + amount + " Successful!");
    }
}

class StripeClient {
    public StripeClient(String secretKey) {}
    public void charge(double amount) {
        System.out.println("Stripe Payment of $" + amount + " Successful!");
    }
}

// Razorpay Adapter
class RazorpayAdapter implements PaymentGateway {
    private RazorpayClient razorpayClient;

    public RazorpayAdapter(String apiKey, String apiSecret) {
        this.razorpayClient = new RazorpayClient(apiKey, apiSecret);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing ₹" + amount + " via Razorpay...");
        // razorpayClient.makePayment(amount); // Simulating API call
    }
}

// PayPal Adapter
class PayPalAdapter implements PaymentGateway {
    private PayPalClient payPalClient;

    public PayPalAdapter(String clientId, String clientSecret) {
        this.payPalClient = new PayPalClient(clientId, clientSecret);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via PayPal...");
        // payPalClient.sendPayment(amount); // Simulating API call
    }
}

// Stripe Adapter
class StripeAdapter implements PaymentGateway {
    private StripeClient stripeClient;

    public StripeAdapter(String secretKey) {
        this.stripeClient = new StripeClient(secretKey);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Stripe...");
        // stripeClient.charge(amount); // Simulating API call
    }
}

class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void pay(double amount) {
        paymentGateway.processPayment(amount);
    }
}

