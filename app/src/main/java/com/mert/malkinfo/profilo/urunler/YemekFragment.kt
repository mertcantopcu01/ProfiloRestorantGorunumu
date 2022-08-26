package com.mert.malkinfo.profilo.urunler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mert.malkinfo.profilo.R
import com.mert.malkinfo.profilo.Siniflar.MyAdapter
import com.mert.malkinfo.profilo.Siniflar.Urunler
import com.mert.malkinfo.profilo.Siniflar.UrunlerAdapter
import com.mert.malkinfo.profilo.Siniflar.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: UrunlerAdapter
private lateinit var newRecylerview: RecyclerView
private lateinit var newArrayList: ArrayList<Urunler>
//private lateinit var tempArrayList: ArrayList<Urunler>
lateinit var imageId: Array<Int>
lateinit var heading: Array<String>
lateinit var ucret: Array<String>
/**
 * A simple [Fragment] subclass.
 * Use the [YemekFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class YemekFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: UrunlerAdapter
    private lateinit var newRecylerview: RecyclerView
    private lateinit var newArrayList: ArrayList<Urunler>
    private lateinit var tempArrayList: ArrayList<Urunler>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var ucret: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yemek, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment YemekFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            YemekFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialsize()
        val layoutManager = LinearLayoutManager(context)
        newRecylerview = view.findViewById(R.id.recyclerYemek)
        newRecylerview.layoutManager = layoutManager
        newRecylerview.setHasFixedSize(true)
        adapter = UrunlerAdapter(newArrayList)
        newRecylerview.adapter = adapter

    }

    private fun dataInitialsize(){
        newArrayList = arrayListOf<Urunler>()

        imageId = arrayOf(
            R.drawable.hamburger,
            R.drawable.patateskizartmasi,
            R.drawable.pizza,
            R.drawable.taukdoner,
            R.drawable.etdoner,
            R.drawable.tost,
            R.drawable.kruvasan,
            R.drawable.pogaca,
            R.drawable.simit,
            R.drawable.download,
        )

        heading = arrayOf(
            "Hamburger",
            "Patetes Kızartması",
            "Pizza",
            "Tavuk Döner",
            "Et Döner",
            "Tost",
            "Kruvasan",
            "Poğaça",
            "Simit",
            "Kurabiye"
        )

        ucret = arrayOf(
            "40 TL",
            "20 TL",
            "40 TL",
            "20 TL",
            "28 TL",
            "18 TL",
            "5 TL",
            "5 TL",
            "5 TL",
            "5 TL"
        )
        for (i in imageId.indices) {

            val news = Urunler(imageId[i], heading[i], ucret[i])
            newArrayList.add(news)
        }

    }
}