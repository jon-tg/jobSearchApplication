import java.util.*;

public class Job {
	private HashMap <String, String> jobDetails = new HashMap<>();
	
	public Job(String job)
	{
	
		String[] detailPairs = job.split(",");
		String[][] valueKey = new String[detailPairs.length][2];
		
		

		for (int i = 0; i < detailPairs.length; i++) {
		    String[] pair = detailPairs[i].split(":");
		    
		    if (pair.length == 2) {
		        valueKey[i][0] = pair[0]; 
		        valueKey[i][1] = pair[1];
		    } else {
		        continue;
		    }
		}
		
		 for (int i = 0; i < valueKey.length; i++) {
	            if (valueKey[i][0] != null && valueKey[i][1] != null) {
	                jobDetails.put(valueKey[i][0], valueKey[i][1]);
	            }
	        }
	    }
	
	
	public void display()
	{
		for (Map.Entry<String, String> entry : jobDetails.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
      
		
	}

}
