package api.endpoints;
/*
* Swagger URI --> https://petstore.swagger.io/#
*
* Create user(Post) : https://petstore.swagger.io/#/user/createUser/user/{username}
* Get user : https://petstore.swagger.io/#/user/getUserByName/user/{username}
* Updated user : https://petstore.swagger.io/#/user/updateUser/user/{username}
* Delete user : https://petstore.swagger.io/#/user/deleteUser/user/{username}
* */
public class Routes {
    public static String base_url ="https://petstore.swagger.io/#" ;

    //User module

    public static String post_url = base_url+"/user/createUser/user/{username}" ;
    public static String get_url = base_url+"/user/getUserByName/user/{username}" ;
    public static String update_url = base_url+"/user/updateUser/user/{username}" ;
    public static String delete_url = base_url+"/user/deleteUser/user/{username}" ;
}
