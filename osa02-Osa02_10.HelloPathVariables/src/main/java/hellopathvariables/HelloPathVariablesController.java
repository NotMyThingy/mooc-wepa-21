package hellopathvariables;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloPathVariablesController {

    private Map<String, Item> items;

    public HelloPathVariablesController() {
        this.items = new TreeMap<>();
        this.items.put("default", new Item("Hat", "default"));
        this.items.put("ascot", new Item("Ascot cap", "hat"));
        this.items.put("balaclava", new Item("Balaclava", "hat"));
        this.items.put("bicorne", new Item("Bicorne", "hat"));
        this.items.put("busby", new Item("Busby", "hat"));
        this.items.put("capotain", new Item("Capotain", "hat"));
        this.items.put("homburg", new Item("Homburg", "hat"));
        this.items.put("montera", new Item("Montera", "hat"));
    }

    @GetMapping("/")
    public String home(Model model) {
        return getItem(model, "default");
    }

    @GetMapping("/{item}")
    public String getItem(Model model, @PathVariable String item) {
        if (!this.items.containsKey(item)) {
            item = "default";
        }

        model.addAttribute("item", this.items.get(item));
        return "index";
    }

}
