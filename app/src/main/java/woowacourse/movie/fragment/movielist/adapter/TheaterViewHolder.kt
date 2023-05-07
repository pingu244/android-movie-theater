package woowacourse.movie.fragment.movielist.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.woowacourse.domain.Theater
import woowacourse.movie.R

class TheaterViewHolder(
    private val view: View,
    private val theaterOnClickListener: (Int) -> Unit,
) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.tv_theater_name)
    private val numberOfScreeningTime: TextView = view.findViewById(R.id.tv_theater_time_num)

    init {
        view.setOnClickListener {
            theaterOnClickListener(bindingAdapterPosition)
        }
    }

    fun bind(theaterData: Theater) {
        name.text = theaterData.name
        numberOfScreeningTime.text =
            FORMATTER_NUMBER_OF_SCREENING_TIME.format(theaterData.schedules.size + 1)
    }

    companion object {
        private const val FORMATTER_NUMBER_OF_SCREENING_TIME = "%d개의 상영 시간"
    }
}