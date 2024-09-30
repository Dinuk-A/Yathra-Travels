package lk.yathra.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleDao dao;

    @GetMapping(value = "/role/alldata", produces = "application/json")
    public List<Role> getRoleAllData() {
        return dao.findAll();
    }

    @GetMapping(value = "/role/roleswoadmin", produces = "application/json")
    public List<Role> getRolesWOAdmin() {
        return dao.getRolesExceptAdmin();
    }
}
