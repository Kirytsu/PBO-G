import java.util.ArrayList;
import java.util.List;

class FoodOrder {
    private List<MenuItem> menuItems;
    private long totalPrice;
    private boolean isPaid;

    public FoodOrder() {
        this.menuItems = new ArrayList<>();
        this.totalPrice = 0;
        this.isPaid = false;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        totalPrice += item.getPrice();
        System.out.println("Menu "+ item.getName() + " Rp. " + item.getPrice() +" berhasil ditambahkan");
    }
    
    public void removeMenuItem(MenuItem item) {
        if (menuItems.remove(item)) { 
            totalPrice -= item.getPrice(); 
            System.out.println("Menu " + item.getName() + " berhasil dihapus");
        } else {
            System.out.println("Menu tidak ditemukan dalam pesanan");
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void payOrder() {
        isPaid = true;
        System.out.println("Pesanan telah dibayar");
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void displayOrder() {
        if (menuItems.isEmpty()) 
        {
            System.out.println("Pesanan anda masih kosong");
            return;
        }
        System.out.println("\nDetail Pesanan   :");
        for (MenuItem item : menuItems) {
            System.out.println("- " + item.getName() + " Rp. " + item.getPrice());
        }
        System.out.println("Total Harga      : Rp. " + totalPrice);
        System.out.println("Status           : " + (isPaid ? "Sudah dibayar" : "Belum dibayar"));
    }
}