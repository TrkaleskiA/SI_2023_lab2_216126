import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
class SILab2Test {
    private static List<User> userlist;

    @BeforeAll
    static void addUser() {
        userlist = new ArrayList<>();
        userlist.add(new User("validen@email.com", "Jakpasvord1!", "validen@email.com"));
        userlist.add(new User("nekoj", "pasvordjakMn!", "sekojnekoj@gmail.com"));
    }
    @Test
    void EveryBranch() {
        RuntimeException except=assertThrows(RuntimeException.class, () -> SILab2.function(null,userlist));
        assertTrue(except.getMessage().contains("Mandatory information missing!"));

        User testuser;

        SILab2.function((testuser=new User (null, "Jakpasvord1!", "validen@email.com")),userlist);
        assertEquals(testuser.getEmail(), testuser.getUsername() );


        SILab2.function((testuser=new User ("Sodrzi", "Sodrzi123!", "nevalidenmail.da")),userlist);
        assertFalse(testuser.getEmail().contains("@") && testuser.getEmail().contains("."));
        assertTrue(testuser.getPassword().toLowerCase().contains((testuser.getUsername()).toLowerCase()));

        SILab2.function(testuser=new User ("Nepostoi" , "Pas mestovord", "nov@email.com"),userlist);
        assertTrue(testuser.getPassword().contains(" "));


        SILab2.function(testuser=new User ("Seedno" , "bezznakbez#!@#mesto", "seednonecinimail"),userlist);
        boolean checker=SILab2.function(testuser,null);
        assertFalse(checker);

        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        int specialChar=0;
        int count=0;
        while (count <specialCharacters.length() && specialChar==0){
            if (testuser.getPassword().contains(String.valueOf(specialCharacters.charAt(count)))) {
                specialChar++;
            }
            count++;
        }
        assertEquals(0, specialChar);
    }


    @Test
    void MultipleCondition(){
        RuntimeException except;
        // if (user==null || user.getPassword()==null || user.getEmail()==null){
        //T X X
        //F T X
        //F F T
        //F F F
        except = assertThrows(RuntimeException.class, () -> SILab2.function(null , userlist));
        assertTrue(except.getMessage().contains("Mandatory information missing!"));
        except = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Ime", null, "nekoj@mail.com"),userlist));
        assertTrue(except.getMessage().contains("Mandatory information missing!"));
        except = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Ime", "Pasvord123!", null),userlist));
        assertTrue(except.getMessage().contains("Mandatory information missing!"));
        boolean checker =SILab2.function(new User("Ime", "Prezime", "nekoj@mail.com"),userlist);
        assertFalse(checker);
    }
}