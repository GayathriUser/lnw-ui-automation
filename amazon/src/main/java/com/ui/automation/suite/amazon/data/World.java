package com.ui.automation.suite.amazon.data;

import java.util.HashMap;
import java.util.Map;

public class World {

	  private Map<String, Object> world;
	  
	  public World() {
	        world = new HashMap<>();
	    }
	    
	    public void put(String key, Object value) {
	    	world.put(key,  value);
	    }
	    
	    public Object get(String key) {
	        return world.get(key);
	    }
}
