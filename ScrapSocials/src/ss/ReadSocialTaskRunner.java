package ss;


import java.io.IOException;
import java.util.Arrays;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;

public class ReadSocialTaskRunner {

	public static void main(String[] args) {
		boolean refreshImages = false;
		if(Arrays.asList(args).contains("watchdog")) {
			new WatchdogTask().execute();
			return;
		}

		if(Arrays.asList(args).contains("refreshImages")) refreshImages = true;
		try {
			new SocialsRetriever().execute(new ExecutionContext().setRefreshImages(refreshImages));
			//new Watchdog().CheckNodes();
			//new InstagramRetriever("http://instagram.com/tenaristamsa", "4", "TenarisTamsa Instagram").execute(new ExecutionContext().setRefreshImages(refreshImages));
			// new TwitterRetriever("https://twitter.com/GPodskubka", "39", "@GPodskubka").execute(new ExecutionContext().setRefreshImages(refreshImages));
			// new FacebookRetriever("https://www.facebook.com/TenarisDalmine", "6", "TenarisDalmine").execute(new ExecutionContext().setRefreshImages(refreshImages));
			// new TenarisTodayRetriever("http://aggregator.tenaris.com/services/ObtenerNoticias.ashx?Email=pmirabella@tenaris.com&IdsVistas=2&ServiceUser=TsToday2014&ServicePassword=Y_s_T4120", "1", "TTGlobal").execute(new ExecutionContext().setRefreshImages(refreshImages));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
}
