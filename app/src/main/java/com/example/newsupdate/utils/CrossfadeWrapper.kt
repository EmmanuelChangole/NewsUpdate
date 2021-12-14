package com.example.newsupdate.utils

import com.mikepenz.materialdrawer.interfaces.ICrossfader
import com.mikepenz.crossfader.Crossfader
import com.mikepenz.crossfader.view.CrossFadeSlidingPaneLayout
import com.mikepenz.crossfader.view.ICrossFadeSlidingPaneLayout


class CrossfadeWrapper(val mCrossFader:Crossfader<*>) :ICrossfader
{
    override val isCrossfaded: Boolean
        get() =mCrossFader.isCrossFaded

    override fun crossfade()
    {
        mCrossFader.crossFade()
    }



}