import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.String;

public class post 
{
    int Id = 10;
    String Nome;
    String Cognome;
    String Email;
    String Telefono;
    post(int id1, String Nome1, String Cognome1, String Email1, String Telefono1)
    {
        this.Id = id1;
        this.Nome = Nome1;
        this.Cognome = Cognome1;
        this.Email= Email1;
        this.Telefono = Telefono1;
    }
    
	// http://localhost:8080/api/tutorial/1.0/employees
	public void post()
        {

	  try {

		URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = "{ \\ \n" +
                               "   \"employeeId\":" + this.Id +
                               "   \"firstName\":" + this.Nome +
                               "   \"lastName\":" + this.Cognome +
                               "   \"email\":" + this.Email +
                               "   \"phone\":" + this.Telefono +
                               " }";

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) 
                {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) 
                { System.out.println(output); }

		conn.disconnect();

            } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }

	}

}