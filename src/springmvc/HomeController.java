package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("/")

    public String showHomePage() {

        return "index";
    }

    @RequestMapping("/items")
    public String showItemsPage(){
        return "items";
    }

    @RequestMapping("/shoppingCart")
    public String showShoppingCart(){
        return "shoppingCart";
    }

    @RequestMapping("/itemDetails")
    public String showItemDetails(){
        return "itemDetails";
    }


}