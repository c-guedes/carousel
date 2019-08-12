package com.example.customrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.SnapHelper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


class MainActivity : AppCompatActivity() {
    private var disposableBalance: Disposable? = null
    private val compositeDisposable = CompositeDisposable()
    private var recyclerHistory: RecyclerView? = null
    private var centeredZoom: CenterZoomLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        centeredZoom = CenterZoomLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)

        recyclerHistory = teste
        recyclerHistory!!.layoutManager = centeredZoom
        recyclerHistory!!.adapter = MainHistorico(this) { aaa -> capturandoClick(aaa) }
        recyclerHistory!!.scrollToPosition(Integer.MAX_VALUE / 2)
        recyclerHistory!!.refreshDrawableState()
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerHistory)



    }


    private fun scrollToPosition(position: Int) {
        recyclerHistory!!.smoothScrollToPosition(position)
//        centeredZoom!!.scrollToPositionWithOffset(position, centeredZoom!!.width/2 - position/2)
    }

    private fun capturandoClick(aaa: Int) {
        scrollToPosition(aaa)
    }
}
