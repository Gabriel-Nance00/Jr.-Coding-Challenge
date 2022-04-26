import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner;


public class Coding_Challenge_Solution {

	public static double total  = 0;

	public static void main(String[] args) throws IOException, ParseException {
		

		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("input-coding challenge.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray ItemMenu = (JSONArray) jsonObject.get("items");
			JSONObject config = (JSONObject) jsonObject.get("config");
			long row = (long) config.get("rows");
			String columns = (String) config.get("columns");
			//System.out.println(config);
			//System.out.println(row);
			//System.out.println(columns);
			
			int col_num = Integer.parseInt(columns);
			int row_num = (int) row;

			item[][] array = new item[col_num][row_num];

			int i = 0;
			int p = 0;
			int z = 0;
			Iterator<JSONObject> iterator = ItemMenu.iterator();
				while (iterator.hasNext()) {
					
				System.out.println(iterator.next());
				
				//System.out.println(ItemMenu.get(i));
				
				JSONObject item = (JSONObject) ItemMenu.get(i);
				
				item temp = new item();
				
				temp.setName((String)item.get("name"));
				
				temp.setPrice((String)item.get("price"));
				
				temp.setAmount((Long)item.get("amount"));
				
				array[p][z] = temp;
				z++;
				if(z == row_num ) {
					p++;
					}
				if(z == row_num) {
					z = 0;
					}
				i++;
				}
				
				
				String listing = "";
				
			      for (i = 0; i < col_num; i++) {
			    	  switch(i) {
			    	  case 0:
			    		  listing = "A";
			    		  break;
			    	  case 1:
			    		  listing = "B";
			    		  break;
			    	  case 2:
			    		  listing = "C";
			    		  break;
			    	  case 3:
			    		  listing = "D";
			    		  break;
			    	  case 4:
			    		  listing = "E";
			    		  break;
			    	  case 5:
			    		  listing = "F";
			    		  break;
			    	  case 6:
			    		  listing = "G";
			    		  break;
			    	  case 7:
			    		  listing = "H";
			    		  break;
			    	  case 8:
			    		  listing = "I";
			    		  break;
			    	  default:
			    		  listing = "Z";
			    		  break;
			    	  }
			    	  for(int y = 1; y <= row_num; y++) {
			    		  if(array[i][y-1] != null){
			    			  
			    		  System.out.print(array[i][y-1].getName()+": ");
			    		  
			    		  array[i][y-1].setListing(listing + y);
			    		  
			    		  //System.out.print(array[i][y-1].getListing());
			    		  }
			    		  System.out.print(listing + y + " ");
			    		  
			    	  	}
			    	  System.out.println();
			    	  
			       }
			      boolean running = true;
			      System.out.print("Please input payment:");
			      Scanner s = new Scanner(System.in);
			      
		          String money = s.nextLine();
		          total = (double) Double.parseDouble(money);
			      while(running) {
			          
			          System.out.print("Please input the letter & number for the item you want or enter cancel:");
			          
			    	  String userselection = s.nextLine();
			    	  
			    	  if(userselection.equals("cancel")){
			    		  System.out.print("Transaction complete thank you!");
			    		  System.exit(0);
			    	  }
			    	  
			    	  for (int x = 0; x < col_num; x++) {
			    		  for (int z1 = 0; z1 < row_num; z1++) {
			    			  if(array[x][z1] != null) {
			    			   if(userselection.equals(array[x][z1].getListing())) {
			    				   
			    				  System.out.println("Thank you for selecting "+ array[x][z1].name + "!");
			    				  
			    				  String temp_price = array[x][z1].price;
			    				  
			    				  temp_price = temp_price.replace("$", " "); 
			    				  
			    				  double temptotal = Double.parseDouble(temp_price);
			    				  
			    				  total = total - temptotal;
			    				  
			    				  System.out.println("Your new total is: $" + total);
			    				  
			    				  if(total <= 0.0) {
			    					  System.out.println("Transaction complete thank you!");
			    					  System.exit(0);
			    				  }
			    				  
			    			   	  }
			    			   
			    			  }
			    			  
			    		  }
			    		  
			    	  }
			    	  
			      }
			      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}