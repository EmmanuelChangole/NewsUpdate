
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsupdate.R
import com.squareup.picasso.Picasso


class ChildAdapter(val children : List<Articles>,var context:Context)
    : RecyclerView.Adapter<ChildAdapter.ViewHolder>(){
    private var onItemClickListener: ItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context)
                      .inflate(R.layout.child_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]
        Picasso.get().load(child.urlToImage).fit().into(holder.imageView)
        holder.textView.text = child.title
        holder.imageView.setOnClickListener{

            onItemClickListener!!.onItemClick(child)

        }
    }

    interface ItemClickListener {
        fun onItemClick(articles: Articles)
    }
   public fun setItemClickListener(clickListener: ItemClickListener) {
        onItemClickListener = clickListener
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textView : TextView = itemView.findViewById(R.id.child_textView)
        val imageView: ImageView = itemView.findViewById(R.id.child_imageView)

    }




}