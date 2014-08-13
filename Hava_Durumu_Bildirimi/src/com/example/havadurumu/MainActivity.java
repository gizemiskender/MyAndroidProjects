package com.example.havadurumu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.AsynchronousCloseException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	ProgressDialog pDialog;
	byte[] inenDosya;
	ListView listView;

	final AsyncHttpClient client = new AsyncHttpClient();
	final RequestParams params = new RequestParams();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView1);

		pDialog = new ProgressDialog(this);
		pDialog.setIndeterminate(false);
		pDialog.setCancelable(true);

		String[] iller = { "Adana", "Adiyaman", "Afyonkarahisar", "Agri",
				"Amasya", "Ankara", "Antalya", "Artvin", "Aydin", "Balikesir",
				"Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur", "Bursa",
				"Çanakkale", "Çankiri", "Çorum", "Denizli", "Diyarbakir",
				"Edirne", "Elazig", "Erzincan", "Erzurum", "Eskisehir",
				"Gaziantep", "Giresun", "Gumushane", "Hakkari", "Hatay",
				"Isparta", "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu",
				"Kayseri", "Kirklareli", "Kirsehir", "Kocaeli", "Konya",
				"Kutahya", "Malatya", "Manisa", "Kahramanmaras", "Mardin",
				"Mugla", "Mus", "Nevsehir", "Nigde", "Ordu", "Rize", "Sakarya",
				"Samsun", "Siirt", "Sinop", "Sivas", "Tekirdag", "Tokat",
				"Trabzon", "Tunceli", "Sanliurfa", "Usak", "Van", "Yozgat",
				"Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kirikkale",
				"Batman", "sirnak", "Bartin", "Ardahan", "Igdir", "Yalova",
				"Karabuk", "Kilis", "Osmaniye", "Duzce" };

		final ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < iller.length; ++i) {
			list.add(iller[i]);
		}

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				final String item = (String) parent.getItemAtPosition(position);
				params.put("merkez", item.toString());

				pDialog.setMessage("Bilgi alınıyor lütfen bekleyin...");
				pDialog.show();

				client.get(
						"http://androidevreni.com/api/android/havadurumu.php",
						params, new JsonHttpResponseHandler() {
							public void onSuccess(JSONObject jsonData) {

								JSONObject firstEvent = null;

								String data = null;
								try {
									pDialog.dismiss();

									mesajGoster("İl :" + item.toString()
											+ "\nZaman :"
											+ jsonData.getString("zaman")
											+ "\nSıcaklık: "
											+ jsonData.getString("sicaklik")
											+ "\nNem: "
											+ jsonData.getString("nem")
											+ "\nRüzgar: "
											+ jsonData.getString("ruzgar")
											+ "\nBasınç: "
											+ jsonData.getString("basinc"));

								} catch (JSONException e) {
									e.printStackTrace();
								}
							}

							public void onFailure(int statusCode, Throwable e,
									JSONObject errorResponse) {
								super.onFailure(statusCode,
										getRequestHeaders(), e, errorResponse);
								pDialog.dismiss();
								mesajGoster("Karşıdan sonuç alınamadı, \nbir hata oluştu, \nlütfen tekrar deneyin");
							}
						});
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void mesajGoster(String mesaj) {
		Toast.makeText(getApplicationContext(), mesaj, Toast.LENGTH_LONG)
				.show();
	}

	public String getJsonFromUrl(String strUrl) {
		DefaultHttpClient httpclient = new DefaultHttpClient(
				new BasicHttpParams());
		HttpPost httppost = new HttpPost(strUrl);
		// Depends on your web service
		httppost.setHeader("Content-type", "application/json");

		InputStream inputStream = null;
		String result = null;
		try {
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();

			inputStream = entity.getContent();
			// json is UTF-8 by default
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"), 8);
			StringBuilder sb = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			result = sb.toString();
		} catch (Exception e) {
			// Oops
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (Exception squish) {
			}
		}
		return result;

	}
}