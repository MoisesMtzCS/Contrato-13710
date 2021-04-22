package cs.med.mtz.moises.contrato13710.presentation.into_activity

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.presentation.main.MainActivity

class IntoActivity : AppIntro() {
    /** */


    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startIntro()
    }

    private fun startIntro() {
        //first
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.welcome),
                description = getString(R.string.reach_your_goals),
                R.drawable.ic_complete_finish,
                backgroundColor = ContextCompat.getColor(this, R.color.teal_700)

            )
        )
        //second
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.how_does_it_work),
                description = getString(R.string.explanation),
                R.drawable.ic_contract__3_,
                backgroundColor = ContextCompat.getColor(this, R.color.teal_700)
            )
        )
        //third
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.between_contracts),
                description = getString(R.string.description),
                R.drawable.ic_settings,
                backgroundColor = ContextCompat.getColor(this, R.color.teal_700)
            )
        )

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }


    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }


}