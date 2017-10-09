import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WriteToFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			
		String repoName = args[0];
		String Type = args[1];
		@SuppressWarnings("unused")
		String filePath = args[2];
		
		File jsonFile = new File(filePath);
		String jsonString = FileUtils.readFileToString(jsonFile);
		
		JsonElement jelement = new JsonParser().parse(jsonString);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonObject objrepo = (JsonObject) jobject.get("REPOSITORIES_NAMES");
		JsonArray arr = objrepo.getAsJsonArray(Type);
		
		JsonObject obj = new JsonObject();
		obj.addProperty("name", Type+"-"+repoName);
		obj.addProperty("value", repoName);
		
		
		if(arr.contains(obj))
			System.out.println("Element already present!!");
		else
			arr.add(obj);
			
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String resultingJson = gson.toJson(jelement);
		
		FileUtils.writeStringToFile(jsonFile, resultingJson);
		
	
	
	}

}
