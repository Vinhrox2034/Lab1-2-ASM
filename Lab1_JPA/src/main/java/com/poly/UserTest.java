package com.poly;

public class UserTest {

    public static void main(String[] args) {

        UserManager dao = new UserManager();

        System.out.println("=== Danh sach user ===");
        dao.findAll().forEach(u ->
                System.out.println(
                        u.getId() + " | " +
                                u.getFullname() + " | " +
                                u.getEmail() + " | " +
                                u.getAdmin()
                )
        );

        System.out.println("\n=== Xac dinh user va admin ===");
        dao.findFptUsersNotAdmin().forEach(u ->
                System.out.println(
                        u.getFullname() + " | " + u.getEmail()
                )
        );

        System.out.println("\n=== Page size ===");
        dao.findPage(2, 5).forEach(u ->
                System.out.println(
                        u.getId() + " | " +
                                u.getFullname() + " | " +
                                u.getEmail()
                )
        );
    }
}
