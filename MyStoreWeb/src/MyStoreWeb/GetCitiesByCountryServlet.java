package MyStoreWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mystore.bean.BeanManager;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 * Servlet implementation class GetCitiesByCountryServlet
 */
@WebServlet("/GetCitiesByCountryServlet")
public class GetCitiesByCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCitiesByCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*GlobalWeather globalWeather =new GlobalWeather();
		GlobalWeatherSoap gs= globalWeather.getGlobalWeatherSoap();
		String country= gs.getCitiesByCountry("India");
		response.getWriter().append(country);*/
		
		GlobalWeatherSoap gs =(GlobalWeatherSoap)BeanManager.getContext().getBean("client");
		String country= gs.getCitiesByCountry("India");
		response.getWriter().append(country);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
