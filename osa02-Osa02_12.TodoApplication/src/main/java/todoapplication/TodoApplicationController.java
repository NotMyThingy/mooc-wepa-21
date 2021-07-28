package todoapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoApplicationController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", this.todoRepository.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String getItem(Model model, @PathVariable Long id) {
        Todo todo = this.todoRepository.getOne(id);
        todo.setChecked(todo.getChecked() + 1);
        todo = todoRepository.save(todo);

        model.addAttribute("item", todo);
        return "todo";
    }

    @PostMapping("/")
    public String addItem(@RequestParam String name) {
        this.todoRepository.save(new Todo(name, 0));
        return "redirect:/";
    }
}
