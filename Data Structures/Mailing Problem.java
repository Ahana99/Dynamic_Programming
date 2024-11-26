/**
 * Dr. Doofenshmirtz is trying to make another big mischief.
 * To prevent this, Major Francis Monogram wants to send mail to Perry the Platypus to inform him about the mischief. 
 * He just needs to send a secret message ‘s’ to perry.He has a special keyboard “keyboard” in which all the letters are in a straight line but jumbled.
 * The time taken to move his finger from index ‘i’ to index ‘j’ is |j - i|. 
 * He wants to know how much time will it take to send the secret message to Perry.
 * Note :Initially, he is at the first letter of the keyboard.All letters are in lower-case English letters. 
 * For Example :
    * Let s = “perry”, keyboard = “qwertyuiopasdfghjklzxcvbnm”.
    * Now In this example, Francis will start from the first index and go to ‘p’, which will take 9 seconds, now from ‘p’ to ‘e’, the distance is of 7 indexes, from ‘e’ to ‘r’ the distance is 1, from ‘r’ to ‘r’ it will be zero, and from ‘r’ to ‘y’ the distance will be 2.
    * Hence the total time taken is 9 + 7 + 1 + 0 + 2 = 19.
    * Hence the answer is 19.
 */
import java.util.*;
public class Solution 
{
    public static int timeTakenToMail(String keyboard, String s)
    {
        HashMap<Character, Integer> keys = new HashMap<>();
        for(int i=0;i<keyboard.length();i++){
            keys.put(keyboard.charAt(i), i);
        }

        int timeTaken = 0;
        int index = 0;
        for(char c: s.toCharArray()){
            int targetIndex = keys.get(c);
            timeTaken += Math.abs(targetIndex - index);
            index = targetIndex;
        }
        return timeTaken;
    }
}