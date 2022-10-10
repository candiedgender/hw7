import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author nate
 * @version 2
 */

//This has been updated to handle the throwing of a NullPointerException in the
//add method, the addAll method, the remove method, the contains method, and
//the contains all method

//READ BEFORE YOU TRY TO RUN THIS!!!!!!
//this wont work unless you have written the whole teamSet file
// In order to use this file you must write a toString() method for the TeamSet // and for the Player class.
// I suggest making a String called message, then iterating over the
// backingArray and adding each element to the message and then printing out
// the message. Use   for (int i = 0; i < backingArray.length; i++) for the loop
// check each element to see if it is null. If it is null then add the word
// "null" to the message. And if it is not null then add the player to the
// message using the player's toString method.
// The toString method for the Player class should be something like the bellow
// public String toString(){return("A player named "+name+" at position "+pos);}
public class Driver {
    public static void main(String[] args) {
        System.out.println("START OF TEST \n");
        System.out.println("creating two players");
        Player one = new Player("ONE", "goalie");
        System.out.println(one);// true
        Player two = new Player("TWO", "coach");
        System.out.println(two);// true
        TeamSet teamSet = new TeamSet();
        System.out.println("adding player one:"+teamSet.add(one));//true
        System.out.println("checkig the size after adding: "+teamSet.size());//1
        System.out.println("the contents of the teamSet after adding: "
            +teamSet); //A teamSet with players: A player
        //named ONE whose position is goalie
        System.out.println("adding player two: "+teamSet.add(two)); // true
        System.out.println("checking size after adding:"+teamSet.size()); // 2
        System.out.println(teamSet); // A teamSet with players: A player
        //named ONE whose position is goalie, A player named TWO whose
        //position is coach
        System.out.println("trying to add an element that is already in the teamSet: " + teamSet.add(one)); //false

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("THREE","bench warmer"));
        players.add(new Player("FOUR","water boi"));
        System.out.println("attempting the add all method: "+teamSet.addAll(players));//true
        System.out.println("the size after add all: "+teamSet.size());//4
        System.out.println("contents after add all: "+teamSet);//[A player named ONE at position goalie, A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, null, null, null, null, null, null]

        System.out.println("");
        System.out.println("TESTING CONTAINS");
        System.out.println("contains an element that is in it:"+ teamSet.contains(one));//true
        System.out.println("containsAll: "+teamSet.containsAll(players));//true
        System.out.println("remove an element: "+ teamSet.remove(one));//true

        System.out.println("the team after removing: "+teamSet);//[A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, null, null, null, null, null, null, null]
        System.out.println("adding one back to the teamSet at the end: "+teamSet.add(one));//true
        System.out.println("the teamSet after adding one back in:"+teamSet);//[A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, A player named ONE at position goalie, null, null, null, null, null, null]

        //////////////
        //the following is enough players to fill the backing array
        Player five = new Player("FIVE", "referee");
        Player six = new Player("SIX", "ball kicker");
        Player seven = new Player("SEVEN", "linebacker");
        Player eight = new Player("EIGHT", "wide receiver");
        Player nine = new Player("NINE", "assistant coach");
        Player ten = new Player("TEN", "substitute player");
        teamSet.add(five); teamSet.add(six);
        teamSet.add(seven);
        teamSet.add(eight);
        teamSet.add(nine);
        teamSet.add(ten);
        ///////////////
        System.out.println("the teamSet after adding all the new players to fill the teamSet: "+teamSet);//[A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, A player named ONE at position goalie, A player named FIVE at position referee, A player named SIX at position ball kicker, A player named SEVEN at position linebacker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player]
        System.out.println("removing player seven from the teamSet: "+teamSet.remove(seven));//true
        System.out.println("the teamSet after removing player seven: "
            +teamSet);//[A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, A player named ONE at position goalie, A player named FIVE at position referee, A player named SIX at position ball kicker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player, null]
        System.out.println("////////////////////");
        System.out.println("////////////////////");
        System.out.println("////////////////////");
        System.out.println("check for equals method where true");
        Player a1 = new Player("a1", "position"); //a new player
        TeamSet eq1 = new TeamSet(); //a new teamSet
        eq1.add(a1);// adding the new player to the new teamSet
        TeamSet eq2 = new TeamSet();// a second new teamSet
        eq2.add(a1);// adding the same new player to the second teamSet
        System.out.println("checking to see if the two new teamSets are equal to each other if they both contain just one element that is the same: "
            +eq1.equals(eq2));// true
        System.out.println("checking to see if the two new teamSets are equal to each other if they both contain just one element that is the same but the order of calling the equals method backwards: "
            +eq2.equals(eq1));// true
        System.out.println("check for equals method where  dif size");
        System.out.println("comparing the teamSet containing player a1 to the teamSet that was first created: "+eq1.equals(teamSet));//false
        System.out.println("check for equals same size dif entries");
        TeamSet eq3 = new TeamSet();
        eq3.add(one);
        System.out.println("the contents of teamSet eq3 that contains palyer one: "
            +eq3);//[A player named ONE at position goalie, null, null, null, null, null, null, null, null, null]
        System.out.println("checking for equality of teamSets with the same size but different contents: "
            +eq3.equals(eq1));//false
        System.out.println("checking for equality of teamSets with the same size but different contents but the order of calling the equals metho is flipped: "+eq1.equals(eq3));//flase
        System.out.println("/////////////");
        //System.out.println("check for equals not instanceof set");
        Object obj = new Object();
        System.out.println("check for equals not instanceof set: "
            +eq1.equals(obj));//false
        System.out.println("///////////");
        //System.out.println("check for equals same entries dif orders");
        TeamSet eq4 = new TeamSet();
        eq4.add(one);
        eq4.add(two);
        TeamSet eq5 = new TeamSet();
        eq5.add(two);
        eq5.add(one);
        System.out.println("the teamSet eq4:"+eq4);
        System.out.println("the teamSet eq5: "+eq5);
        System.out.println("check for equals same entries dif orders: "
            +eq4.equals(eq5));//true
        System.out.println("check for equals same entries dif orders calling equals in different orders"+eq5.equals(eq4));//true
        System.out.println("//////////////");
        System.out.println("toArray() test bellow looping through the array");
        Object tempPrime = eq4.toArray();
        for (Object a : (Object[]) tempPrime) {
            System.out.println(a);
        }
        System.out.println("/////////////");
        System.out.println("isEmpty() tests");
        System.out.println("checking a non empty set: "+eq1.isEmpty());// false
        TeamSet empt = new TeamSet();
        System.out.println("checking an empty set: "+empt.isEmpty());//true

        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("contains check");
        System.out.println("checking to see if a teamSet contains an element : "+teamSet.contains(two));//true
        System.out.println("testing the contains method using an int: "+ teamSet.contains(3));//false
        System.out.println("testing the contains method using an Object: "+teamSet.contains(new Object()));//false

        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("//////////////");
        System.out.println("the following is testing the add method for whether or not is resizes the backing array to its length * 2");
        //System.out.println(teamSet.toString());
        System.out.println(teamSet.add(seven));
        System.out.println("the teamSet that should be full: "+teamSet.toString());
        System.out.println("the teamSet size before adding in the element that forces resizing: "+teamSet.size());//[A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, A player named ONE at position goalie, A player named FIVE at position referee, A player named SIX at position ball kicker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player, A player named SEVEN at position linebacker]
        System.out.println("adding an 11th element to the teamSet: "+teamSet.add(a1));//true
        System.out.println("the contents of the backingArray of the teamSet inclluding the nulls: "+teamSet.toString());//[A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, A player named ONE at position goalie, A player named FIVE at position referee, A player named SIX at position ball kicker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player, A player named SEVEN at position linebacker, A player named a1 at position position, null, null, null, null, null, null, null, null, null]
        System.out.println("the LENGTH of the backingArray: "
            +teamSet.getBackingArray().length);//20
        System.out.println("the size of the teamSet after adding the 11th element: " + teamSet.size());//11
        System.out.println("Removing an element from the teamSet that is size11: "+teamSet.remove(a1));//true
        System.out.println("the backingArray of the teamSet after removing the 11th element: "+teamSet.toString());//[A player named TWO at position coach, A player named THREE at position bench warmer, A player named FOUR at position water boi, A player named ONE at position goalie, A player named FIVE at position referee, A player named SIX at position ball kicker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player, A player named SEVEN at position linebacker, null, null, null, null, null, null, null, null, null, null]

        System.out.println("/////////////");
        System.out.println("/////////////");
        System.out.println("/////////////");
        System.out.println("/////////////");
        TeamSet yeee = new TeamSet();
        yeee.add(one);
        yeee.add(two);
        yeee.add(five); teamSet.add(six);
        yeee.add(seven);
        yeee.add(eight);
        yeee.add(nine);
        yeee.add(ten);
        yeee.add(new Player("huuu","XXXPosition"));
        yeee.add(new Player("Messy","soccer boiiii"));
        Player yoikes = new Player("Soccer ball","football");
        yeee.add(yoikes);
        System.out.println("the new yeee teamSet that has size 10: "+yeee);// [A player named ONE at position goalie, A player named TWO at position coach, A player named FIVE at position referee, A player named SEVEN at position linebacker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player, A player named huuu at position XXXPosition, A player named Messy at position soccer boiiii, A player named Soccer ball at position football]
        System.out.println("removing the last element in yeee: "+yeee.remove(yoikes));//true
        System.out.println("the teamSet yeee after removing the last element: "+yeee);//[A player named ONE at position goalie, A player named TWO at position coach, A player named FIVE at position referee, A player named SEVEN at position linebacker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player, A player named huuu at position XXXPosition, A player named Messy at position soccer boiiii, null]

        System.out.println("//////////");
        System.out.println("testing the clear method");
        System.out.println("the teamSet yeee before clearing"+yeee);//[A player named ONE at position goalie, A player named TWO at position coach, A player named FIVE at position referee, A player named SEVEN at position linebacker, A player named EIGHT at position wide receiver, A player named NINE at position assistant coach, A player named TEN at position substitute player, A player named huuu at position XXXPosition, A player named Messy at position soccer boiiii, null]
        System.out.println("clearing the teamSet yeee");
        yeee.clear();//true
        System.out.println("the teamSet yeee ater clearing it: "+ yeee);//[null, null, null, null, null, null, null, null, null, null]

        System.out.println("///////////////");
        System.out.println("///////////////");
        System.out.println("BELLOW IS THE TESTING OF NULL WITH METHODS \n");

        System.out.println("bellow is tryign to add a null using the add() method");

        try {
            teamSet.add(null);
                System.out.println("You did not properly throw a NullPointerException");

        } catch (NullPointerException e) {
            System.out.println("You properly threw a NullPointerException in the add method");
        }
        System.out.println("//////////////////");
        System.out.println("bellow is tyring to add a null using the addAll() method with a Colleciton that contains a null");
        ArrayList<Player> aNullSet = new ArrayList<Player>(); //cerating a temp array
        aNullSet.add(null);//adding a null element to the aNullSet
        try{
            if (teamSet.addAll(aNullSet)) {
                System.out.println("You did not throw a NullPointerException in the addAll method");
            }
        } catch(NullPointerException e) {
            System.out.println("You properly threw a NullPointerException in the addAll method");
        }

        System.out.println("///////////////");
        System.out.println("below is the testing for contains(null)");
        try {
            if (!teamSet.contains(null) || teamSet.contains(null)) {
                System.out.println("You did not properly throw a NullPointerException in the contains method");
                throw new NullPointerException();
            }
            } catch (NullPointerException e) {
                System.out.println("You properly threw a NullPointerException in the contains method");
            }

        System.out.println("////////////////");
        System.out.println("below is the testing method for containsAll(null)");
        try {
            teamSet.containsAll(null);
                System.out.println("you did not properly throw a NullPointerException in the containsAll() method");

            } catch(NullPointerException e) {
                System.out.println("you properly threw a NullPointerException in the containsAll method");
            }
        System.out.println("////////////////");
        System.out.println("bellow is the testing for the containsAll() method when passing in a collection that contains a null");
        aNullSet.add(one);
        aNullSet.remove(null);
        aNullSet.add(null);
        System.out.println("the set that is being passed in to containsAll(0 is: "+aNullSet);//[A player named ONE at position goalie, null]
        try {
            teamSet.containsAll(aNullSet);
            System.out.println("you did not properly handle the case where addAll method is called with a set that contains a null");
        } catch (NullPointerException e) {
            System.out.println("you properly handled the case where addAll method is called with a set that contains a null");
        }

        System.out.println("////////////////");
        System.out.println("below is the testing of the remove() method with a null");
        try {
            teamSet.remove(null);
            System.out.println("you did not throw a NullPointerException in the remove method");
        } catch (NullPointerException e) {
            System.out.println("You properly threw a NullPointerException in the remove method");
        }

    }

}
