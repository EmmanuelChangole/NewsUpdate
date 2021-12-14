import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsupdate.R



class ParentAdapter(private val parents : List<Articles>,private val title:String,private val listener:ChildAdapter.ItemClickListener) : RecyclerView.Adapter<ParentAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = title
        var adapters= holder.recyclerView?.context?.let { ChildAdapter(parents, it) }
        if (adapters != null) {
            adapters.setItemClickListener(listener)
        }
        holder.recyclerView?.apply {
            layoutManager =
                LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
            adapter = adapters

        }
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView? = itemView.findViewById(R.id.rv_child)
        val textView:TextView = itemView.findViewById(R.id.textView)
    }
}