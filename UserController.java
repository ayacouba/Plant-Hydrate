@GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "user";
    }

    @GetMapping("/dashboard")
    public String showHomePage() {

        return "dashboard";
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }
