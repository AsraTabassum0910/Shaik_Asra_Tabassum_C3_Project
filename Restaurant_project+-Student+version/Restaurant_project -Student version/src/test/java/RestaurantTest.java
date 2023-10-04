import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RestaurantTest {
    LocalTime openingTime = LocalTime.parse("10:30:00");
    LocalTime closingTime = LocalTime.parse("22:00:00");
    Restaurant restaurant = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);

    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE

        //LocalTime mockTime = LocalTime.parse("10:40:00");
        //restaurant.getCurrentTime = () -> mockTime;
        Restaurant spyRestaurant = Mockito.spy(restaurant);
        LocalTime mockTime = LocalTime.of(12,20);
        when(spyRestaurant.getCurrentTime()).thenReturn(mockTime);
        //Mockito.verify(mockRestaurant).getCurrentTime();
        assertTrue(spyRestaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        //LocalTime mockTime = LocalTime.parse("10:40:00");
        //restaurant.getCurrentTime = () -> mockTime;
        Restaurant spyRestaurant = Mockito.spy(restaurant);
        LocalTime mockTime = LocalTime.of(9,20);
        when(spyRestaurant.getCurrentTime()).thenReturn(mockTime);
        //Mockito.verify(mockRestaurant).getCurrentTime();
        assertFalse(spyRestaurant.isRestaurantOpen());

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){

        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {

        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    /*@Test
    public void calculating_final_price_for_selected_items_should_display_correct_amount(){

        restaurant.addToMenu("Sweet Corn Soup",150);
        restaurant.addToMenu("Chicken Soup",220);
        restaurant.addToMenu("Mushroom Soup",153);
        restaurant.addToMenu("Tomato Soup",87);

        //selected items
        Item item1 = new Item("Mushroom Soup",153);
        restaurant.addItemListToMenu(item1);
        Item item2 = new Item("Tomato Soup",87);
        restaurant.addItemListToMenu(item2);

        int totalPrice = item1.getPrice() + item2.getPrice();
        Assertions.assertEquals(totalPrice,restaurant.findTotalPrice());
    }
    @Test
    public void calculating_final_price_for_selected_items_should_display_incorrect_amount(){

        restaurant.addToMenu("Sweet Corn Soup",150);
        restaurant.addToMenu("Chicken Soup",220);
        restaurant.addToMenu("Mushroom Soup",153);
        restaurant.addToMenu("Tomato Soup",87);

        //selected items
        Item item1 = new Item("Mushroom Soup",153);
        restaurant.addItemListToMenu(item1);
        Item item2 = new Item("Tomato Soup",87);
        restaurant.addItemListToMenu(item2);

        int totalPrice = 100; //test data
        Assertions.assertNotEquals(totalPrice,restaurant.findTotalPrice());
}*/
}