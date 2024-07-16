import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		JobSearchService jobQuery = new JobSearchService();
		String query;
		
		
		do 
		{
			System.out.print("Enter job title and location (-1 to quit): ");
			query = scanner.nextLine();
			String responseString = jobQuery.searchJobs(query);
			String[] responseArray=responseString.split("==\",\"");
			for (int i=1; i<responseArray.length; i++)
			{
				Job job_i = new Job(responseArray[i]);
				job_i.display();
				System.out.println("___________________________________________");

	
			}
		} while (!query.equals("-1"));
	}
	

}
