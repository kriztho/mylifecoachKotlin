package com.cristhopper.mylifecoach.ui.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.View
import com.cristhopper.mylifecoach.R
import com.cristhopper.mylifecoach.model.Goal
import com.cristhopper.mylifecoach.ui.GoalActivity
import com.cristhopper.mylifecoach.utils.inflate
import kotlinx.android.synthetic.main.item_row_main.view.*

class MainAdapter(private val items : ArrayList<Goal>) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount() = items.size

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Inflate the view using
        val inflatedView = parent.inflate(R.layout.item_row_main, false)
        return ViewHolder(inflatedView)
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val goal = items[position]
        holder.bindGoal(goal)
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val TAG = "ViewHolder"

    // Holds the TextView that will add each animal to
    private var view: View = view
    private var goal: Goal? = null

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "[onClick]: " + goal?.name)

        val context = itemView.context
        val showPhotoIntent = Intent(context, GoalActivity::class.java)
        showPhotoIntent.putExtra(GOAL_KEY, goal)
        context.startActivity(showPhotoIntent)
    }

    companion object {
        private val GOAL_KEY = "GOAL"
    }

    fun bindGoal(goal: Goal) {

        // The item
        this.goal = goal

        // The views
        view.item_title.setText(goal.name)
    }
}