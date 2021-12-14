package com.example.newsupdate.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import nl.psdcompany.duonavigationdrawer.views.DuoOptionView




class MenuAdapter( options:ArrayList<String>):BaseAdapter()
{
    private var mOptions: ArrayList<String> = ArrayList()
    private val mOptionViews: ArrayList<DuoOptionView> = ArrayList()
    init {
        mOptions=options
    }

    fun setViewSelected( position:Int, selected:Boolean)
    {
       for(i in mOptionViews.indices)
       {
           if(i == position)
           {
               mOptionViews.get(i as Int).isSelected=selected
           }
           else{
               mOptionViews.get(i as Int).isSelected=!selected
           }

       }

    }
    fun unsetViewSelected(position:Int,selected:Boolean)
    {
        for(i in mOptionViews.indices)
        {
            if(i == position)
            {
                mOptionViews.get(i as Int).isSelected=!selected
            }
            else{
                mOptionViews.get(i as Int).isSelected=!selected
            }

        }




    }

    override fun getCount(): Int {
       return mOptions.size
    }

    override fun getItem(p0: Int): Any {
       return mOptions.get(p0)
    }

    override fun getItemId(p0: Int): Long {
       return p0 as Long
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
       val option:String=mOptions.get(p0)
       val optionView:DuoOptionView
       if(p1 == null)
       {
           optionView=DuoOptionView(p2?.context)


       }
        else{
            optionView= p1 as DuoOptionView
        }

        optionView.bind(option,null,null)
        mOptionViews.add(optionView)
        return optionView
    }

}