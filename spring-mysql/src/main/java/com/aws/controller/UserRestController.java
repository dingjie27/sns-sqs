package com.aws.controller;


import com.aws.po.User;
import com.aws.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    private static final String USER_LIST = "UserList";
    private static final String USER_LIST2 = "UserList2";
    private static final String USER_FORM = "UserForm";
    private static final String REDIRECT_TO_USER_LIST = "redirect:/user";
    /**
     * 获取用户列表
     * 通过"/user"GET请求获取
     * @param map
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public String showAll(ModelMap map) {
        map.addAttribute("UserList",userService.showAll());
        return USER_LIST;
    }
    /**
     *
     * @param name
     * @return
     */


    @RequestMapping(value="/selectByName/{name}",method=RequestMethod.GET)
    public String selectByUserName(@PathVariable String name, ModelMap map){

        if(userService.selectByName(name)==null) {
            return "传值未成功!";
        }
        else {
            map.addAttribute("UserList2",userService.selectByName(name));
            return USER_LIST2;
        }
    }
    @RequestMapping(value="/selectByID/{id}",method=RequestMethod.GET)
    public String selectByID(@PathVariable String id, ModelMap map){

        if(userService.selectByID(id)==null) {
            return "传值未成功!";
        }
        else {
            map.addAttribute("UserList2",userService.selectByID(id));
            return USER_LIST2;
        }
    }
    /**
     * 获取创建UserForm表单
     * @param map
     * @return
     */
    @RequestMapping(value="/addUser",method=RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new User());
        map.addAttribute("action", "addUser");
        return USER_FORM;
    }

    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        userService.addUser(user);

        return REDIRECT_TO_USER_LIST;
    }


    @RequestMapping(value="/updateByID/{id}",method=RequestMethod.GET)
    public String getByUserID(@PathVariable String id, ModelMap map) {
        if(userService.selectByID(id)==null) {
            return "传值未成功！";
        }
        else
        {	map.addAttribute("user",userService.selectByID(id));
            map.addAttribute("action","updateByID");
            return USER_FORM;
        }
    }
    @RequestMapping(value="/updateByID",method=RequestMethod.POST)
    public String putByUserID(@ModelAttribute User user) {
        userService.updateByUserID(user);
        return REDIRECT_TO_USER_LIST;
    }



    @RequestMapping(value="/deleteByID/{id}",method=RequestMethod.GET)
    public String deleteUserByID(@PathVariable String id) {
        userService.deleteByUserID(id);
        return REDIRECT_TO_USER_LIST;
    }

}