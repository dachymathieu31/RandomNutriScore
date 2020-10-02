package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import api.controller.IRandCaller;

public class RandCaller implements IRandCaller {

	private URL url;
	private String apiKey;

	public RandCaller(String url, String apiKey) {
		try {
			this.url = new URL(url);
			this.apiKey = apiKey;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int generateOneRndInt(int min, int max, boolean replacement) {
		try {
			HttpURLConnection con = (HttpURLConnection) this.url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);

			String jsonInputString = "{\r\n" + "    \"jsonrpc\": \"2.0\",\r\n"
					+ "    \"method\": \"generateIntegers\",\r\n" + "    \"params\": {\r\n" + "        \"apiKey\": \""
					+ this.apiKey + "\",\r\n" + "        \"n\": 1,\r\n" + "        \"min\": " + min + ",\r\n"
					+ "        \"max\": " + max + ",\r\n" + "        \"replacement\": " + replacement + "\r\n"
					+ "    },\r\n" + "    \"id\": 42\r\n" + "}";

			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			// Handle request response
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}

				// Parse Json response
				JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
				JsonElement data = jsonObject.get("result").getAsJsonObject().get("random").getAsJsonObject()
						.get("data");
				return data.getAsBigInteger().intValue();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 5;
	}
}
