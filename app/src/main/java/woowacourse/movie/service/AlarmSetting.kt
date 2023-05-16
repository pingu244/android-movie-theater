package woowacourse.movie.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import com.woowacourse.domain.movie.MovieBookingSeatInfo
import woowacourse.movie.model.toPresentation
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class AlarmSetting {

    fun setAlarm(context: Context, movieBookingSeatInfo: MovieBookingSeatInfo) {
        val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager
        val pendingIntent = makeIntent(context, movieBookingSeatInfo)
        val alarmTime = getMilliSecond(movieBookingSeatInfo)
        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            alarmTime,
            pendingIntent,
        )
    }

    private fun makeIntent(
        context: Context,
        movieBookingSeatInfo: MovieBookingSeatInfo,
    ): PendingIntent {
        val intent = Intent(context, MovieReminder::class.java)
        val notificationId = System.currentTimeMillis().toInt()
        intent.putExtra(
            MOVIE_BOOKING_SEAT_INFO_KEY,
            movieBookingSeatInfo.toPresentation(),
        )
        intent.putExtra(ALARM_NOTIFICATION_ID, notificationId)

        return PendingIntent.getBroadcast(
            context,
            notificationId,
            intent,
            PendingIntent.FLAG_IMMUTABLE,
        )
    }

    private fun getMilliSecond(movieBookingSeatInfo: MovieBookingSeatInfo): Long {
        val formatter = DateTimeFormatter.ofPattern(FORMATTER_PATTERN)
        val movieDateTime = LocalDateTime.parse(
            movieBookingSeatInfo.movieBookingInfo.formatAlarmDate(),
            formatter,
        )
        val triggerTime = movieDateTime.minusMinutes(MOVIE_RUN_BEFORE_TIME)
        val zone = triggerTime.atZone(ZoneId.systemDefault())
        return zone.toInstant().toEpochMilli()
    }

    companion object {
        private const val MOVIE_BOOKING_SEAT_INFO_KEY = "movieBookingSeatInfo"
        private const val ALARM_NOTIFICATION_ID = "notificationId"
        private const val FORMATTER_PATTERN = "yyyy-M-d HH:mm"
        private const val MOVIE_RUN_BEFORE_TIME = 30L
    }
}
