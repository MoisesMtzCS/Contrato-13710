package cs.med.mtz.moises.contrato13710.presentation.into_activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.presentation.main.MainActivity

class IntoActivity : AppIntro() {
    /** */


    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //onlyShowOnce()
        startIntro()
    }

    private fun startIntro() {
        //1
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.welcome),
                description = getString(R.string.reach_your_goals),
                R.drawable.ic_complete_finish,
                Color.GRAY
            )
        )
        //2
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.how_does_it_work),
                description = getString(R.string.explanation),
                R.drawable.ic_contract__3_,
                Color.GRAY
            )
        )
        //first day
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.first_contract),
                description = getString(R.string.read_text),
                R.drawable.ic_drinking_water,
                Color.GRAY
            )
        )
        //second day
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.second_day),
                description = getString(R.string.hidratations),
                R.drawable.ic_gout,
                Color.GRAY
            )
        )
        //fifth day
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.fifth_day),
                description = getString(R.string.hidratation_fifth_day),
                R.drawable.ic_bottle,
                Color.GRAY
            )
        )
        //twelfth day
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.twelfth_day),
                description = getString(R.string.hidratation_twelfth_day),
                R.drawable.ic_contract_goal,
                Color.GRAY
            )
        )
        //twelfth day
        addSlide(
            AppIntroFragment.newInstance(
                title = getString(R.string.final_day),
                description = getString(R.string.hidratation_final_day),
                R.drawable.ic_complete,
                Color.GRAY
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