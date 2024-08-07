package restaurant.utils;

import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import restaurant.dao.ProductDAO;
import restaurant.entity.OrderDetail;
import restaurant.entity.Product;

public class Ordered {

    /**
     * Xử lý các chi tiết đơn đặt hàng và lưu trữ vào bản đồ giá và số lượng sản
     * phẩm.
     *
     * @param orderDetails là danh sách các chi tiết đơn đặt hàng cần xử lý
     * @param productPriceMap là bản đồ để lưu trữ giá của từng sản phẩm
     * @param productQuantityMap là bản đồ để lưu trữ số lượng của từng sản phẩm
     */
    public static void processOrderedDetails(List<OrderDetail> orderDetails, Map<String, Long> productPriceMap, Map<String, Integer> productQuantityMap) {
        for (OrderDetail orderDetail : orderDetails) {
            // Get id and level
            String productId = orderDetail.getProductID();
            String productLevel = !orderDetail.getProductDesc().isEmpty() ? " (" + orderDetail.getProductDesc() + ")" : "";

            // Get name and level
            Product productEntity = new ProductDAO().getByID(productId);
            String productName = productEntity.getProductName();
            String productNameAndLevel = productName + productLevel;

            // Calculate the total quantity for each product name and level
            int quantity = orderDetail.getProductQuantity();
            if (productQuantityMap.containsKey(productNameAndLevel)) {
                quantity += productQuantityMap.get(productNameAndLevel);
            }
            
            long price = productEntity.getPrice();

            // Update the maps with the latest quantities and prices
            productQuantityMap.put(productNameAndLevel, quantity);
            productPriceMap.put(productNameAndLevel, productEntity.getPrice());
        }
    }

    /**
     * Hiển thị chi tiết đơn đặt hàng lên bảng.
     *
     * @param model là bảng để hiển thị món ăn
     * @param productPriceMap là bản đồ chứa giá của từng món ăn
     * @param productQuantityMap là bản đồ chứa số lượng của từng món ăn
     */
    public static void addOrderedToTable(DefaultTableModel model, Map<String, Long> productPriceMap, Map<String, Integer> productQuantityMap) {
        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
            // Get name and level -> ex: Mì cay (Cấp 7)
            String productNameAndLevel = entry.getKey();
            int totalQuantity = entry.getValue();

            // Get unit price and quantity it for display -> ex: 50.000₫ x 3
            long unitPrice = productPriceMap.get(productNameAndLevel);
            String convertUnitPrice = XTextField.addCommasToNumber(String.valueOf(unitPrice));

            // Calculate and format the total price for the quantit -> ex: 50.000 x 3 = 150.000
            long totalPrice = unitPrice * totalQuantity;
            String convertTotalPrice = XTextField.addCommasToNumber(String.valueOf(totalPrice));

            // Add a new row to the table model with product details
            model.addRow(new Object[]{
                productNameAndLevel,
                convertUnitPrice,
                totalQuantity,
                convertTotalPrice
            });
        }
    }
}
