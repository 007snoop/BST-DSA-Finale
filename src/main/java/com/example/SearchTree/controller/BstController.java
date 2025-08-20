package com.example.SearchTree.controller;

import org.springframework.ui.Model;
import com.example.SearchTree.service.BstService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BstController {
    private final BstService service;
    public BstController(BstService s) {
        this.service=s;
    }

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public Object processNumbers(@RequestParam String numbers) throws Exception {
        int[] nums =
                java.util.Arrays.stream(numbers.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        BstService.Node root = service.buildBST(nums);
        return service.saveTree(numbers, root);

    }

    @GetMapping("previous-trees")
    public String previousTrees(Model model) {
        model.addAttribute("trees", service.getAllTree());
        return "previous-trees";
    }
}
