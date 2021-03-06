package castle;

import java.util.HashMap;

public class Room {
    private String description;
    HashMap<String, Room> exits = new HashMap<String,Room>();

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(String dir,Room room) 
    {    
    	exits.put( dir, room );
    }
    
    

    @Override
    public String toString()
    {
        return description;
    }
    
    public String getExitDes(){
    	StringBuffer sb = new StringBuffer();
    	
    	for(String dir : exits.keySet()){
    		sb.append(dir);
    		sb.append(" ");
    	} 
            return sb.toString();
        
    }
    
    public Room goExit(String direction){
    	return exits.get(direction);
    }
}
