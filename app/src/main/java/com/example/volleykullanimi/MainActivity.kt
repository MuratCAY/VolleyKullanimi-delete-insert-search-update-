package com.example.volleykullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //kisiSil()
        //kisiEkle()
        //kisiGuncelle()
        //tumKisiler()
        kisiArama()
    }

    fun kisiSil(){

        val url = "http://kasimadalan.pe.hu/kisiler/delete_kisiler.php" // Hocamın web servisi

        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->

            Log.e("Silme İşlemi Cevap",cevap)

        },Response.ErrorListener { e -> e.printStackTrace() }){

            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()

                params["kisi_id"] = "535"

                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(istek)

    }


    fun kisiEkle(){
        val url = "http://kasimadalan.pe.hu/kisiler/insert_kisiler.php"

        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->

            Log.e("Ekleme İşlemi Cevap",cevap)

        },Response.ErrorListener { e -> e.printStackTrace() }){

            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()

                params["kisi_ad"] = "MURAT ÇAY"
                params["kisi_tel"] = "05555533333"

                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(istek)

    }

    fun kisiGuncelle(){
        val url = "http://kasimadalan.pe.hu/kisiler/update_kisiler.php"

        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->

            Log.e("Güncelleme İşlemi Cevap",cevap)

        },Response.ErrorListener { e -> e.printStackTrace() }){

            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()


                params["kisi_id"] = "486"
                params["kisi_ad"] = "KASIM ADALAN UDEMY EĞİTİM"
                params["kisi_tel"] = "111111133333"

                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(istek)

    }
    fun tumKisiler() {
        val url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler.php"

        val istek = StringRequest(Request.Method.GET, url, Response.Listener { cevap ->

            Log.e("Veri Okuma Cevap", cevap)

            try {

                val jsonObject = JSONObject(cevap)
                val kisilerListe = jsonObject.getJSONArray("kisiler")

                for (i in 0 until kisilerListe.length()){
                    val k = kisilerListe.getJSONObject(i)

                    val kisi_id = k.getInt("kisi_id")
                    val kisi_ad = k.getString("kisi_ad")
                    val kisi_tel = k.getString("kisi_tel")


                    Log.e("Kişi id", kisi_id.toString())
                    Log.e("Kisi ad", kisi_ad)
                    Log.e("Kisi tel", kisi_tel)
                    Log.e("*******", "*******")


                }

            } catch (e:JSONException) {
                e.printStackTrace()
            }

        }, Response.ErrorListener { e -> e.printStackTrace() })

        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun kisiArama(){
        val url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler_arama.php"

        val istek = object : StringRequest(Method.POST,url,Response.Listener { cevap ->

            Log.e("Arama Cevap",cevap)

            try {

                val jsonObject = JSONObject(cevap)
                val kisilerListe = jsonObject.getJSONArray("kisiler")

                for (i in 0 until kisilerListe.length()){
                    val k = kisilerListe.getJSONObject(i)

                    val kisi_id = k.getInt("kisi_id")
                    val kisi_ad = k.getString("kisi_ad")
                    val kisi_tel = k.getString("kisi_tel")


                    Log.e("Kişi id", kisi_id.toString())
                    Log.e("Kisi ad", kisi_ad)
                    Log.e("Kisi tel", kisi_tel)
                    Log.e("*******", "*******")


                }

            } catch (e:JSONException) {
                e.printStackTrace()
            }

        },Response.ErrorListener { e -> e.printStackTrace() }){

            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()


                params["kisi_ad"] = "a"

                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(istek)


    }
}