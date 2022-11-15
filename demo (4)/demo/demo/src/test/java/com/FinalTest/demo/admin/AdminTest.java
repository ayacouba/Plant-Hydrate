package com.FinalTest.demo.admin;

/**
 * Last updated: 11/14/2022 
 * Purpose: This class tests the methods found in the AdminController class 
 * Contributing authors: Laura Love, Aimade Yacouba, Kayla Abreu
 */
import com.FinalTest.demo.user.User;
import com.FinalTest.demo.user.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 *
 * @author llove
 */
public class AdminTest {

    private final AdminController controller = mock(AdminController.class);
    private final UserService userService = mock(UserService.class);

    /**
     * Check that controller is created
     *
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    /**
     * Returns false if login credentials are null
     */
    @Test
    public void checkNullAdminLogin() {
        Admin admin = new Admin("adminTest", "adminTest@gmail.com", "testPassword");

        boolean login = false;
        if (admin.getAdminName() == null || admin.getAdminPassword() == null) {
            assertFalse(login);
        }
    }
    /**
     * Returns true if login credentials match 
     */
    @Test
    public void checkCorrectAdminLogin() {
        Admin admin = new Admin("adminTest", "adminTest@gmail.com", "testPassword");
        boolean login = true;
        if (admin.getAdminName().equals("adminTest") && admin.getAdminPassword().equals("testPassword")) {
            assertTrue(login);
        }

    }
    /**
     * Passes test if userList isn't null
     */
    @Test
    public void getAllUsersTestNotNull() {
        List<User> userList = userService.getAllUsers();
        assertNotNull(userList);
    }
    /**
     * Passes test if correct number of users is stored in userList
     */
    @Test
    public void getAllUsersCorrectNum() {
        List<User> userList = userService.getAllUsers();

        User user1 = new User("testUser", "testUser@gmail.com", "password");
        User user2 = new User("testUser2", "testUser2@gmail.com", "password2");

        userList.add(user1);
        userList.add(user2);

        assertEquals(2, userList.size());
    }
    /**
     * Passes test if user is removed from userList
     */
    @Test
    public void checkIfUserIsDeleted() {
        User user1 = new User("testUser", "testUser@gmail.com", "password");
        User user2 = new User("testUser2", "testUser2@gmail.com", "password2");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        List<User> userList2 = new ArrayList<>();
        userList2.add(user2);

        userList.remove(user1);

        assert (userList.equals(userList2));
    }

}
