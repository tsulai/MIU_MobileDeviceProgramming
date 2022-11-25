package com.miu.cvbuilderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.miu.cvbuilderapp.databinding.FragmentWorkBinding
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment() {
    private lateinit var binding: FragmentWorkBinding
    val exps = ArrayList<Work>()
    val adapter = WorkAdapter(exps)
    var undoOnClickListener : View.OnClickListener = View.OnClickListener { view ->
        exps.removeAt(exps.size - 1)
        adapter?.notifyDataSetChanged() //when undo have to update the data in adapater
        Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_work, container, false)
        binding = FragmentWorkBinding.bind(view)
        exps.add(Work("Web Developer","Logical Steps","2016-2018","Singapore","Served as key member of elite technical team developing enterprise software for in-house and external clients. ",R.drawable.logicalsteps))
        exps.add(Work("Web Developer","WhooshPro","2010-2014","Singapore","Developed and implemented CMS web applications for large-scale government and corporate clients. Developed front-end and back-end code. ",R.drawable.whooshpro))
        exps.add(Work("Web Designer/Developer","Asia Brightway","2007-2009","Myanmar","Developed and implemented CMS web applications for large-scale government and corporate clients. Developed front-end and back-end code. ",R.drawable.asiabrightway))

        binding.rv.layoutManager = LinearLayoutManager(context)
        binding.rv.adapter = adapter

        //Add Item
        binding.fab.setOnClickListener{ view ->
            addListItem()
            Snackbar.make(view, "Item added to list", Snackbar.LENGTH_LONG)
                .setAction("Undo", undoOnClickListener).show()

        }
        return view
    }
    private fun addListItem(){
        val newWork = Work("CFO", "Facebook","2020-2021", "USA","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean placerat tortor id ligula fringilla pharetra non vel diam.",R.drawable.logicalsteps)
        exps.add(newWork)
        adapter?.notifyDataSetChanged()
    }

}