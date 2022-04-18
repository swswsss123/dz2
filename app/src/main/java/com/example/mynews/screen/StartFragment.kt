package com.example.mynews.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mynews.R
import com.example.mynews.api.RetofitInst
import com.example.mynews.databinding.FragmentStartBinding
import com.example.mynews.model.NewsJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse
import java.lang.Exception
import java.text.DateFormat


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch(Dispatchers.IO) {
            try {


                val response: Response<NewsJson> = RetofitInst.api.getNews().awaitResponse()
                if (response.isSuccessful) {
                    var data: NewsJson = response.body()!!
                    //заполнение даныvb Активити
                    withContext(Dispatchers.Main) {
                        binding.data1.text = data.news[0].date
                        binding.news1.text = data.news[0].description

                        binding.data2.text = data.news[1].date
                        binding.news2.text = data.news[1].description

                        binding.data3.text = data.news[2].date
                        binding.news3.text = data.news[2].description

                        binding.data4.text = data.news[3].date
                        binding.news4.text = data.news[3].description

                        binding.data5.text = data.news[4].date
                        binding.news5.text = data.news[4].description


                        binding.data6.text = data.news[5].date
                        binding.news6.text = data.news[5].description
                    }
                }
            } catch (e: Exception) {

            }
        }

    }

}
