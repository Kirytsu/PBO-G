
/**
 * @author Nathanael Valen Susilo
 * @version 0.1
 */

import java.util.HashSet;
import java.util.HashMap;

public class Responder
{
    private HashMap<String, String> responseMap;
    public Responder() {
        responseMap = new HashMap<String, String>();
        fillResponseMap();
    }   
    
    private void fillResponseMap() {
        responseMap.put("slow",
            "It seems like your system's performance is slow. \n" +
            "This might be related to hardware limitations. \n" +
            "Upgrading your processor or adding more RAM could help.");
        
        responseMap.put("bug",
            "It sounds like you're encountering a bug. \n" +
            "Our development team is constantly working on fixes. \n" +
            "Could you please provide more details so we can assist you further?");
        
        responseMap.put("expensive",
            "We understand that pricing can be a concern. \n" +
            "However, we believe our product offers great value. \n" +
            "Have you checked out all the features compared to competitors?");
        
        responseMap.put("file",
            "If you're having trouble opening files, they may be corrupted. \n" +
            "Try downloading or transferring the file again. \n" +
            "If the issue persists, ensure the file format is supported.");
    
        responseMap.put("hot",
            "Abnormal heat in your device could indicate a cooling issue. \n" +
            "It may help to clean out any dust or replace the thermal paste. \n" +
            "If the problem continues, we recommend visiting a technician.");
    
        responseMap.put("crash",
            "If the software keeps crashing, it could be due to a conflict with another program. \n" +
            "Try closing other applications and restarting the system. \n" +
            "If this doesn't help, please send us the crash logs.");
        
        responseMap.put("install",
            "Installation problems can often be resolved by running the installer as an administrator. \n" +
            "Make sure your system meets the minimum requirements. \n" +
            "Feel free to reach out if the issue continues.");
    
        responseMap.put("connect",
            "Connection issues could be due to network instability. \n" +
            "Ensure your internet connection is stable and restart your router if necessary. \n" +
            "Are you seeing any specific error messages?");
        
        responseMap.put("update",
            "If you're having trouble updating the software, try restarting your device and running the update again. \n" +
            "If the problem persists, check for any system permissions blocking the update.");
    }

    public String generateResponse(HashSet<String> words)
    {
        for(String word : words) {
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
        // None of the words from the input line was recognized
        return pickDefaultResponse();
    }
    
    public String pickDefaultResponse(){
        return ("Could you describe in more specific way?");
    }
}
