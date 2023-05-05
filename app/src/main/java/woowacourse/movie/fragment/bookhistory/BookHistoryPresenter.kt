package woowacourse.movie.fragment.bookhistory

import com.woowacourse.domain.BookHistories
import woowacourse.movie.fragment.bookhistory.adapter.BookHistoryRecyclerViewAdapter

class BookHistoryPresenter(val view: BookHistoryContract.View) : BookHistoryContract.Presenter {

    override fun setMovieRecyclerView(onClickItem: (Int) -> Unit) {
        val bookHistoryRecyclerViewAdapter = BookHistoryRecyclerViewAdapter(
            BookHistories.items,
            onClickItem
        )
        view.setMovieRecyclerView(bookHistoryRecyclerViewAdapter)
    }
}
