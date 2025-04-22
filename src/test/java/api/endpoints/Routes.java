package api.endpoints;

/* Swagger URL --> https://petstore.swagger.io


POST create user ---->https://petstore.swagger.io/v2/user
GET user ------->     https://petstore.swagger.io/user/{username}
PUT request update user----->https://petstore.swagger.io/v2/user/{username}
Delete user Delete Request --->https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {

public static String Base_URL = "https://petstore.swagger.io/v2";

//user Model
    public static String post_URL =Base_URL+"/user";
    public static String get_URL  = Base_URL+"/user/{username}";
    public static String put_URL  = Base_URL+"/v2/user/{username}";
    public static String delete_URL  = Base_URL+"/v2/user/{username}";





}
