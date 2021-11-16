package seoul.globalAdManagerPlatformByMtak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyerController {

    @GetMapping("/")
    public String listOption(Model model) {
        model.addAttribute("user_name", "mtak");
        return "main";
    }
    @GetMapping("/ad")
    public String createAd(Model model) {
        model.addAttribute("user_name", "mtak");
        return "ad_form";
    }
    @GetMapping("/ad/lists")
    public String listMyAd(Model model)
    {
        model.addAttribute("user_name", "mtak");
        return "my_ad_list";
    }

    @GetMapping("modify_ad")
    public String modifyAD(Model model)
    {

    }

    @GetMapping("delete_ad")
    public String deleteAD(Model model)
    {
        return
    }

}
