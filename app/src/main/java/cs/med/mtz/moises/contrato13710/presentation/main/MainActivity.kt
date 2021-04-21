package cs.med.mtz.moises.contrato13710.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cs.med.mtz.moises.contrato13710.databinding.ActivityMainBinding
import cs.med.mtz.moises.contrato13710.presentation.goal_items.GoalItemsActivity
import cs.med.mtz.moises.contrato13710.presentation.new_goal.NewGoalActivity
import cs.med.mtz.moises.contrato13710.presentation.tutorial.TutorialActivity


/** */
class MainActivity : AppCompatActivity() {
    /** */

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        execute()
    }



    /** */
    private fun execute() {
        goToCreateGoal()
        goToListGoals()
        goIntro()

    }

    private fun goToCreateGoal() {
        val intent = Intent(this, NewGoalActivity::class.java)
        binding.startCreate.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun goToListGoals() {
        val intent = Intent(this, GoalItemsActivity::class.java)
        binding.start.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun goIntro(){
        binding.help.setOnClickListener{
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }
    }

}