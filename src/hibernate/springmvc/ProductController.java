package hibernate.springmvc;
import hibernate.entity.Product;
import hibernate.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/items")
    public String showItemsPage(Model theModel){
        List<Product> products = productService.getProducts();

        theModel.addAttribute("products",products);

        return "items";
    }

    @GetMapping("/items/delete")
    public String deleteDonut(@RequestParam("itemId")int theId){
        productService.deleteProduct(theId);

        return "redirect:/items";
    }

    @RequestMapping("/items/details")
    public String productDetails(@RequestParam("item")int productId, Model theModel){
        Product product = productService.getProduct(productId);

        theModel.addAttribute("product", product);

        return "itemDetails";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {

        List<Product> theList = productService.getProductsByName(theSearchTerm);

        theModel.addAttribute("products", theList);

        return "items";
    }

    @GetMapping("/items/showAddProductForm")
    public String showAddProductForm(Model theModel){
        Product newProduct = new Product();

        theModel.addAttribute("aProduct", newProduct);

        return "add-product-form";
    }

    @PostMapping("/items/save")
    public String saveProduct(@RequestParam(name = "productImage")MultipartFile file,
                              @Valid @ModelAttribute(name = "aProduct") Product theProduct,
                                BindingResult bindingResult,
                              HttpServletRequest request){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);

            return "add-product-form";
        }
        productService.saveProduct(theProduct, file, request.getServletContext().getRealPath("/"));

        return "redirect:/items";
    }

    @RequestMapping("/shoppingCart")
    public String showShoppingCart(){
        return "shoppingCart";
    }
}
