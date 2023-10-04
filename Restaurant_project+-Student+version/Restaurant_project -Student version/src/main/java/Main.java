import java.time.LocalTime;

public class Main {
    public static void main(String[] args){


        RestaurantService restaurantService = new RestaurantService();
        restaurantService.addRestaurant("Asra Cafe","Hyderabad", LocalTime.parse("10:30:00"),LocalTime.parse("22:30:00"));
        restaurantService.addRestaurant("Cafe Niloufer","Goa", LocalTime.parse("10:30:00"),LocalTime.parse("22:30:00"));
        restaurantService.addRestaurant("Cafe Eclat","Mumbai", LocalTime.parse("10:30:00"),LocalTime.parse("22:30:00"));



    }
}
