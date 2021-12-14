import com.example.newsupdate.model.Source
import java.io.Serializable

data class Articles(

	var source : Source?=null,
	var author : String="",
	var title : String="",
	var description : String="",
	var url : String="",
	var urlToImage : String="",
	var publishedAt : String="",
	var content : String=""
):Serializable