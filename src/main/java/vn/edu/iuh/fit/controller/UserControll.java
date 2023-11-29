package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.convert.UserForm;
import vn.edu.iuh.fit.dao.UserDao;
import vn.edu.iuh.fit.entity.User;

@Controller
public class UserControll {
    private final UserDao userDao;
    @Autowired
    public UserControll(UserDao userDao) {
        this.userDao = userDao;
    }
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Thực hiện kiểm tra đăng nhập ở đây, ví dụ:
        if (userDao.logIn(username, password)) {
            User user=userDao.getUserByMobile(username);
            model.addAttribute("UID", user.getUid());
            return "redirect:/mypost/" + user.getUid();
        } else {
            // Đăng nhập thất bại, gửi thông báo lỗi
            model.addAttribute("error", "Thông tin đăng nhập không đúng");
            return "login";
        }
    }
    @GetMapping("/register")
    public String showResigterForm() {
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UserForm userForm, Model model) {
        if (!userForm.getPass().equalsIgnoreCase(userForm.getPassAgain())){
            model.addAttribute("error", "Mật khẩu không khớp với mật khẩu nhập lại");
            return "register";
        }
        userDao.addUser(new User(userForm.getUserFName(), userForm.getUserMName(), userForm.getUserLName(), userForm.getMobile(), userForm.getEmail(), userForm.getPass()));
        return "login";
    }

}
